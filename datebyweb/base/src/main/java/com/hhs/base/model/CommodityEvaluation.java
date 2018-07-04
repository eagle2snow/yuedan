package com.hhs.base.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.hhs.base.model.sys.User;
import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.DataNature;
import com.hhs.gencode.util.FieldType;

/**
 * @auth eagle
 * @date 2018年4月25日
 * @desc
 */
@M("商品评价")
@SuppressWarnings("serial")
@Entity(name = "commodityEvaluation")
@Table(name = "t_commodity_Evaluation")
public class CommodityEvaluation extends Model {

	@FormField(type = FieldType.SELECT, label = "会员名字", dataNature = DataNature.MODEL, ds = Member.class)
	private Member member;

	@FormField(type = FieldType.SELECT, label = "商品名称", dataNature = DataNature.MODEL, ds = Commodity.class)
	private Commodity commodity;

	@FormField(type = FieldType.SELECT, label = "订单项", dataNature = DataNature.MODEL, ds = OrderItem.class)
	private OrderItem orderItem;

	@FormField(type = FieldType.SELECT, label = "管理员名", dataNature = DataNature.MODEL, ds = User.class)
	private User user;

	@FormField(type = FieldType.SELECT, label = "会员评价", dataNature = DataNature.MODEL, ds = CommodityAppraise.class)
	private CommodityAppraise commodityAppraise;

	@FormField(type = FieldType.NUMBER, label = "评价等级", data = "1|好评,2|一般,3|差评")
	private Integer level;

	@FormField(type = FieldType.TEXTINPUT, label = "商品评价详情")
	private String evaluationDetails;

	@FormField(type = FieldType.TIME, label = "商品评价时间")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss", label = "商品评价时间")
	private Date evaluationTime;

	@FormField(type = FieldType.TEXTINPUT, label = "管理员回复详情")
	private String replydetails;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss", label = "管理员回复时间")
	@FormField(type = FieldType.TIME, label = "管理员回复时间")
	private Date replyTime;

	@FormField(type = FieldType.NUMBER, label = "审核状态", data = "1|已审核,2|待审核")
	private Integer audit;

	@FormField(type = FieldType.NUMBER, label = "回复状态", data = "1|已回复,2|待回复")
	private Integer reply;

	@FormField(type = FieldType.NUMBER, label = "浏览")
	private Integer browse;

	@FormField(type = FieldType.NUMBER, label = "评论")
	private Integer comment;

	@FormField(type = FieldType.NUMBER, label = "赞")
	private Integer praise;

	public CommodityEvaluation() {
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

	@ManyToOne
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@ManyToOne
	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	public CommodityAppraise getCommodityAppraise() {
		return commodityAppraise;
	}

	public void setCommodityAppraise(CommodityAppraise commodityAppraise) {
		this.commodityAppraise = commodityAppraise;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getEvaluationDetails() {
		return evaluationDetails;
	}

	public void setEvaluationDetails(String evaluationDetails) {
		this.evaluationDetails = evaluationDetails;
	}

	public Date getEvaluationTime() {
		return evaluationTime;
	}

	public void setEvaluationTime(Date evaluationTime) {
		this.evaluationTime = evaluationTime;
	}

	public String getReplydetails() {
		return replydetails;
	}

	public void setReplydetails(String replydetails) {
		this.replydetails = replydetails;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public Integer getReply() {
		return reply;
	}

	public void setReply(Integer reply) {
		this.reply = reply;
	}

	public Integer getBrowse() {
		return browse;
	}

	public void setBrowse(Integer browse) {
		this.browse = browse;
	}

	public Integer getComment() {
		return comment;
	}

	public void setComment(Integer comment) {
		this.comment = comment;
	}

	public Integer getPraise() {
		return praise;
	}

	public void setPraise(Integer praise) {
		this.praise = praise;
	}

	@Override
	public String toString() {
		return "CommodityEvaluation [member=" + member + ", commodity=" + commodity + ", orderItem=" + orderItem
				+ ", user=" + user + ", commodityAppraise=" + commodityAppraise + ", level=" + level
				+ ", evaluationDetails=" + evaluationDetails + ", evaluationTime=" + evaluationTime + ", replydetails="
				+ replydetails + ", replyTime=" + replyTime + ", audit=" + audit + ", reply=" + reply + ", browse="
				+ browse + ", comment=" + comment + ", praise=" + praise + "]";
	}

}
