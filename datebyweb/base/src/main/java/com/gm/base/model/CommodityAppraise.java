package com.gm.base.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.gm.base.model.sys.User;
import com.gm.gencode.annotation.FormField;
import com.gm.gencode.annotation.M;
import com.gm.gencode.annotation.Verification;
import com.gm.gencode.util.FieldType;

@M("会员评价")
@SuppressWarnings("serial")
@Entity(name = "commodityAppraise")
@Table(name = "t_commodity_appraise")
public class CommodityAppraise extends Model {
	
	private CommodityEvaluation commodityEvaluation;
	
	private OrderItem orderItem;
	
	private Member member;
	
	private Commodity commodity;
	
	private User user;
	
	@FormField(label = "管理员是否回复", type = FieldType.TEXTINPUT)
	private String state;//1，已回复 
	
	@FormField(label = "星级", type = FieldType.TEXTINPUT)
	private String starLevel;
	 
	@FormField(label = "管理员回复", sort = 100, type = FieldType.EDITOR)
	@Verification()
	private String replyDeails;
	
	//@JSONField(format = "yyyy-MM-dd HH:mm:ss",label = "管理员回复时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date replyTime ;// 管理员回复时间
	
	public String getReplyDeails() {
		return replyDeails;
	}
	public void setReplyDeails(String replyDeails) {
		this.replyDeails = replyDeails;
	}
	
	/**
	 * @return the replyTime
	 */
	public Date getReplyTime() {
		return replyTime;
	}
	/**
	 * @param replyTime the replyTime to set
	 */
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	@ManyToOne
	public CommodityEvaluation getCommodityEvaluation() {
		return commodityEvaluation;
	}
	public void setCommodityEvaluation(CommodityEvaluation commodityEvaluation) {
		this.commodityEvaluation = commodityEvaluation;
	}
	@ManyToOne
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}


	/**
	 * @return the starLevel
	 */
	public String getStarLevel() {
		return starLevel;
	}
	/**
	 * @return the orderItem
	 */
	@ManyToOne
	public OrderItem getOrderItem() {
		return orderItem;
	}
	/**
	 * @param orderItem the orderItem to set
	 */
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	/**
	 * @param starLevel the starLevel to set
	 */
	public void setStarLevel(String starLevel) {
		this.starLevel = starLevel;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the commodity
	 */
	@ManyToOne
	public Commodity getCommodity() {
		return commodity;
	}
	/**
	 * @param commodity the commodity to set
	 */
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	/**
	 * @return the user
	 */
	@ManyToOne
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	

	

}
