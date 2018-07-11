package com.hhs.controllers;

import com.alibaba.fastjson.JSON;
import com.hhs.api.pay.exception.BestPayException;
import com.hhs.api.pay.model.PayResponse;
import com.hhs.api.wx.WeixinPayApi;
import com.hhs.base.model.Client;
import com.hhs.base.model.PayBill;
import com.hhs.pojo.WXHelper;
import com.hhs.service.PayBillService;
import com.hhs.utils.weixin.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: Eagle
 * @Date: 2018/7/11 10:20
 * @Description: 微信支付控制器
 */
@Slf4j
@Controller
@RequestMapping("/wx/pay/")
public class WeixinPayController extends WeixinBaseController {

    private final Lock lock = new ReentrantLock();
    private final ConcurrentLinkedQueue<PayBill> success = new ConcurrentLinkedQueue<>();
    private final Condition condition = lock.newCondition();

    @Resource
    private PayBillService payBillService;

    /**
     * 订单支付前
     *
     * @param orderNo   订单号
     * @param orderName 订单名称
     * @param amount    订单总额
     * @return
     */
    @ResponseBody
    @RequestMapping("/prePayOrder")
    public Map<String, Object> prePay(String orderNo, String orderName, BigDecimal amount) {
        log.info("prepay:The pay start,ages is orderNo={},orderName={},amount={}", orderNo, orderName, amount);

//		amount = amount.multiply(BigDecimal.valueOf(0.01));
        log.info("prePay:The order parice is amount = {}", JSON.toJSON(amount));
        Client client = WXHelper.getClient(getCurrentClient());

        PayBill payBill = payBillService.getOne("orderNo", orderNo);

        if (null == payBill) {
            payBill = new PayBill();
            payBill.setOrderNo(orderNo);
            payBill.setOpenid(client.getOpenid());
            payBill.setPay(1);
            payBill.setPreFee(amount);
            payBillService.save(payBill);
        }

        Map<String, Object> map = getMap();
        try {

            PayResponse res = WeixinPayApi.pay(orderNo, orderName, amount, getCurrentClient().getOpenid(), getDomain());
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

    @RequestMapping("/prePayCombo")
    @ResponseBody
    public Map<String, Object> prePayCombo(Integer choosed)
    {
        Map<String, Object> map = getMap();

        Client client= WXHelper.getClient(getCurrentClient());
        if (client == null) {
            log.error("member == null");
            map.put("s", "系统有误，请稍候再试！");
            return map;
        }



        PayBill payBill = new PayBill();
        payBill.setPay(1);
        payBill.setOpenid(client.getOpenid());
        payBillService.save(payBill);

        try {
            PayResponse res = WeixinPayApi.pay(payBill.getOrderNo(), "购买套餐", Const.MEMBER_AMOUNT, client.getOpenid(),
                    getDomain());
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

        log.info("prePayCombo:the Map map={}", JSON.toJSON(map));

        return map;
    }

    @PostConstruct
    public void init()
    {
        new Thread(() -> {
            for (;;) {
                try {
                    if (success.isEmpty()) {
                        try {
                            lock.lock();
                            condition.await();
                        } catch (Exception e) {
                            log.error("condition.await()", e);
                        } finally {
                            lock.unlock();
                        }
                    }
                    if (success.isEmpty())
                        continue;
                    PayBill payBill = success.poll();
                    payBillService.paySuccess(payBill);
                } catch (Exception e) {
                    log.error("paysuccess thread", e);
                }
            }
        }).start();
    }


    @PostMapping(value = "/paySuccess", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String WeixinParentNotifyPage(HttpServletRequest request) throws Exception {

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
            log.info("WeixinParentNotifyPage:The orderId = {} and TransactionId = {}",orderId,outTradeNo);
            success.add(payBill);
            try {
                lock.lock();
                condition.signalAll();
            } catch (Exception e) {
                log.error("condition.signalAll", e);
            } finally {
                lock.unlock();
            }
        }
        return "";
    }

}
