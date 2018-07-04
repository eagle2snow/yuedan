package com.hhs.base.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.hhs.gencode.annotation.M;

@M("支付")
@Entity(name = "payBill")
@Table(name = "t_payBill")
@SuppressWarnings("serial")
public class PayBill extends Model {

	private String orderNo;
	private String openid;
	private BigDecimal preFee = BigDecimal.ZERO;// 预付款金额，單位（元）
	private BigDecimal reaFee = BigDecimal.ZERO;// 实际付款金额，單位（元）
	private String transactionId;// 微信交易號
	private Integer type;// 1购买套餐，2购买产品
	private Integer pay;// 1未支付，2已支付
	private LocalDateTime payTime = LocalDateTime.now();// 完成支付时间

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPay() {
		return pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}

	public BigDecimal getPreFee() {
		return preFee;
	}

	public void setPreFee(BigDecimal preFee) {
		this.preFee = preFee;
	}

	public BigDecimal getReaFee() {
		return reaFee;
	}

	public void setReaFee(BigDecimal reaFee) {
		this.reaFee = reaFee;
	}

	public LocalDateTime getPayTime() {
		return payTime;
	}

	public void setPayTime(LocalDateTime payTime) {
		this.payTime = payTime;
	}

}
