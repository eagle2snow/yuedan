package com.hhs.base.model;

import java.time.LocalDateTime;

import com.alibaba.fastjson.annotation.JSONField;
import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.util.FieldType;

public class TestTime {

	@FormField(type = FieldType.TEXTINPUT, label = "订单备注")
	private String orderRemarks;// 订单所留备注

	@FormField(type = FieldType.TIME, label = "付款时间")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime paymentTime;// 订单付款时间

	public String getOrderRemarks() {
		return orderRemarks;
	}

	public void setOrderRemarks(String orderRemarks) {
		this.orderRemarks = orderRemarks;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}

}
