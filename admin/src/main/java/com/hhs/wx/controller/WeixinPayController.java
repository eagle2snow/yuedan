package com.hhs.wx.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import com.hhs.service.PayBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hhs.api.pay.exception.BestPayException;
import com.hhs.api.pay.model.PayResponse;
import com.hhs.api.wx.WeixinPayApi;
import com.hhs.base.consts.Const;
import com.hhs.base.model.Member;
import com.hhs.base.model.PayBill;
import com.hhs.service.OrderService;

import static com.hhs.controllerUtil.WeiXin.getDBMember;
import static com.hhs.controllerUtil.WeiXin.getDomain;

/**
 * Description: 微信支付入口
 */
@RequestMapping("/wx/pay/")
@Controller
public class WeixinPayController {

    private static final Logger logger = LoggerFactory.getLogger(WeixinPayApi.class);

    @Resource
    private PayBillService payBillService;

    /**
     * @param orderNo
     * @param orderName
     * @param amount    订单金额
     * @Description: 订单支付前    应该添加个备注字段
     */
    @RequestMapping("/prePayOrder")
    @ResponseBody
    public Map<String, Object> prePay(String orderNo, String orderName, BigDecimal amount)
    {
        logger.info("prepay:The pay start,ages is orderNo={},orderName={},amount={}", orderNo, orderName, amount);
        amount = amount.multiply(BigDecimal.valueOf(0.01));
        logger.info("--------------prePay:amount * 0.08 * 0.01 ={}-----------------", JSON.toJSON(amount));
        Member member = getDBMember();

        PayBill payBill = payBillService.getOne("orderNo", orderNo);

        if (null == payBill) {
            payBill = new PayBill();
            payBill.setOrderNo(orderNo);
            payBill.setOpenid(member.getOpenid());
            payBill.setType(2);
            payBill.setPay(1);
            payBill.setPreFee(amount);
            payBillService.save(payBill);
        }
        logger.info("setMeal is setMeal={}", member.getSetMeal());

        Map<String, Object> map = new HashMap<>();
        try {

            PayResponse res = WeixinPayApi.pay(orderNo, orderName, amount, member.getOpenid(), getDomain());
            map.put("s", 1);
            map.put("data", res);

        } catch (BestPayException e) {
            e.printStackTrace();
            if (e.getCode().equals(17)) {
                map.put("s", "订单已经支付");
            } else {
                map.put("s", "系统有误，请稍候再试");
            }
        }
        return map;
    }

    /**
     * @Description: 套餐支付前
     */
    @RequestMapping("/prePayCombo")
    @ResponseBody
    public Map<String, Object> prePayCombo()
    {
        Map<String, Object> map = new HashMap<>();

        Member member = getDBMember();
        if (member == null) {
            logger.error("member == null");
            map.put("s", "系统有误，请稍候再试！");
            return map;
        }

        PayBill payBill = new PayBill();
        payBill.setOrderNo(OrderService.genOrderNo());
        payBill.setType(1);
        payBill.setPay(1);
        payBill.setOpenid(member.getOpenid());
        payBill.setPreFee(Const.MEMBER_AMOUNT);
        payBillService.save(payBill);

        try {
            if (member.getSetMeal() == 1) {
                PayResponse res = WeixinPayApi.pay(payBill.getOrderNo(), "购买套餐", Const.MEMBER_AMOUNT, member.getOpenid(),
                        getDomain());
                map.put("s", 1);
                map.put("data", res);

            } else {
                map.put("s", "您已购买，请勿重新购买套餐!");

            }
        } catch (BestPayException e) {
            e.printStackTrace();
            if (e.getCode().equals(17)) {
                map.put("s", "订单已经支付");
            } else {
                map.put("s", "系统有误，请稍候再试");
            }
        }
        logger.info("prePayCombo:the Map map={}", JSON.toJSON(map));

        return map;
    }

    private final Lock lock = new ReentrantLock();
    private final ConcurrentLinkedQueue<PayBill> success = new ConcurrentLinkedQueue<>();
    private final Condition condition = lock.newCondition();

    @PostConstruct
    public void init()
    {
        new Thread(() -> {
            for (; ; ) {
                try {
                    if (success.isEmpty()) {
                        try {
                            lock.lock();
                            condition.await();
                        } catch (Exception e) {
                            logger.error("condition.await()", e);
                        } finally {
                            lock.unlock();
                        }
                    }
                    if (success.isEmpty())
                        continue;
                    PayBill payBill = success.poll();
                    payBillService.paySuccess(payBill);
                } catch (Exception e) {
                    logger.error("paysuccess thread", e);
                }
            }
        }).start();
    }


    // 成功支付
    // produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；
    @PostMapping(value = "/paySuccess", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String WeixinParentNotifyPage(HttpServletRequest request) throws Exception
    {
        ServletInputStream instream = request.getInputStream();
        StringBuffer sb = new StringBuffer();
        int len = -1;
        byte[] buffer = new byte[1024];

        while ((len = instream.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len));
        }
        instream.close();

        PayResponse response = WeixinPayApi.getBestPayServiceImpl(getDomain()).asyncNotify(sb.toString());

        String orderId = response.getOrderId();
        Double amount = response.getOrderAmount();
        String outTradeNo = response.getOutTradeNo();

        PayBill payBill = payBillService.getOne("orderNo", orderId);
        if (payBill != null) {
            payBill.setPay(2);
            payBill.setReaFee(BigDecimal.valueOf(amount));
            payBill.setTransactionId(outTradeNo);
            payBillService.update(payBill);
            success.add(payBill);
            try {
                lock.lock();
                condition.signalAll();
            } catch (Exception e) {
                logger.error("condition.signalAll", e);
            } finally {
                lock.unlock();
            }
        }
        return "";
    }

}
