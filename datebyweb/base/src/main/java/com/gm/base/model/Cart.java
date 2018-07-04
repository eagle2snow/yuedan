package com.gm.base.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gm.gencode.annotation.FormField;
import com.gm.gencode.annotation.M;
import com.gm.gencode.util.FieldType;

@M("购物车")
@Entity(name = "cart")
@Table(name = "t_cart")
@SuppressWarnings("serial")
public class Cart extends Model {

	private Member member;// 关联会员id

	private Commodity commodity;// 关联商品id

	@FormField(type = FieldType.NUMBER, label = "数量")
	private Integer buyCount;

	@ManyToOne
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Integer getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}

	@ManyToOne
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

}
