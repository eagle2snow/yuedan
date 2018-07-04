package com.hhs.base.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.DataNature;
import com.hhs.gencode.util.FieldType;

@M("商品次数对应购买者表")
@SuppressWarnings("serial")
@Entity(name = "tenReturnOne")
@Table(name = "t_tenReturnOne")
public class TenReturnOne extends Model {

	@FormField(type = FieldType.SELECT, label = "本次购买物", dataNature = DataNature.MODEL, ds = Commodity.class)
	private Commodity thisTimeCommodity;

	@FormField(type = FieldType.SELECT, label = "本次购买者", dataNature = DataNature.MODEL, ds = Member.class)
	private Member thisTimeMember;

	@FormField(label = "次数", type = FieldType.NUMBER)
	private Integer time = 0;

	@ManyToOne
	public Commodity getThisTimeCommodity() {
		return thisTimeCommodity;
	}

	public void setThisTimeCommodity(Commodity thisTimeCommodity) {
		this.thisTimeCommodity = thisTimeCommodity;
	}

	@ManyToOne
	public Member getThisTimeMember() {
		return thisTimeMember;
	}

	public void setThisTimeMember(Member thisTimeMember) {
		this.thisTimeMember = thisTimeMember;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

}
