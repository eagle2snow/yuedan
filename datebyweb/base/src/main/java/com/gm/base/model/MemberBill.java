package com.gm.base.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.gm.gencode.annotation.FormField;
import com.gm.gencode.annotation.M;
import com.gm.gencode.util.DataNature;
import com.gm.gencode.util.FieldType;

@M("会员账单")
@SuppressWarnings("serial")
@Entity(name = "memberBill")
@Table(name = "t_commodity_Bill")
public class MemberBill extends Model {

	@FormField(type = FieldType.SELECT, label = "会员名字", dataNature = DataNature.MODEL, ds = Member.class)
	private Member member;

	@FormField(type = FieldType.TEXTINPUT, label = "余额")
	private BigDecimal balance;

	@FormField(type = FieldType.NUMBER, label = "余额来源", data = "1|一级分销提成,2|二级分销提成,3|充值,4|退还")
	private Integer pathway;

	@FormField(type = FieldType.TEXTINPUT, label = "获利总额")
	private BigDecimal totalMoney;

	@FormField(type = FieldType.TEXTINPUT, label = "账单总额")
	private BigDecimal recordMoney;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss", label = "获利时间")
	@FormField(type = FieldType.TIME, label = "获利时间")
	private Date gainTime;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss", label = "交易时间")
	@FormField(type = FieldType.TIME, label = "交易时间")
	private Date dealTime;

	@FormField(type = FieldType.TEXTINPUT, label = "交易详情")
	private String details;

	public MemberBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Integer getPathway() {
		return pathway;
	}

	public void setPathway(Integer pathway) {
		this.pathway = pathway;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getRecordMoney() {
		return recordMoney;
	}

	public void setRecordMoney(BigDecimal recordMoney) {
		this.recordMoney = recordMoney;
	}

	public Date getGainTime() {
		return gainTime;
	}

	public void setGainTime(Date gainTime) {
		this.gainTime = gainTime;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "MemberBill [member=" + member + ", balance=" + balance + ", pathway=" + pathway + ", totalMoney="
				+ totalMoney + ", recordMoney=" + recordMoney + ", gainTime=" + gainTime + ", dealTime=" + dealTime
				+ ", details=" + details + "]";
	}

}
