package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.PayBill;
import com.hhs.base.dao.PayBillDao;

@Transactional
@Service
public class PayBillService extends BaseService<PayBill, Integer> {
	@Resource
	private PayBillDao dao;

	@Override
	public PayBillDao getDao() {
		return dao;
	}

	public void paySuccess(PayBill payBill)
	{
		if (payBill == null)
			return;
		if (payBill.getType() == 1) { // 购买套餐
			//memberService.payMemberSuccess(payBill.getOpenid(), payBill);
			//ogger.info("paySuccess: ================套餐================");
		} else if (payBill.getType() == 2) {// 购买商品
			//orderService.payOrderSuccess(payBill.getOrderNo(), payBill);
			//logger.info("paySuccess: ================商品================");
		}
	}
}