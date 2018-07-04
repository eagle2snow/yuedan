package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.PayBillDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.PayBill;

@Transactional
@Service
public class PayBillService extends BaseService<PayBill, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(PayBillService.class);

    @Resource
    private PayBillDao dao;

    @Override
    public PayBillDao getDao()
    {
        return dao;
    }

    @Resource
    private MemberService memberService;
    @Resource
    private OrderService orderService;

    public void paySuccess(PayBill payBill)
    {
        if (payBill == null)
            return;
        if (payBill.getType() == 1) { // 购买套餐
            memberService.payMemberSuccess(payBill.getOpenid());
            logger.info("paySuccess: ================套餐========================");
        } else if (payBill.getType() == 2) {// 购买商品
            orderService.payOrderSuccess(payBill.getOrderNo(), payBill);
            logger.info("paySuccess: ================商品========================");
        }
    }
}