package com.hhs.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.FieldType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Auther: Eagle
 * @Date: 2018/7/5 09:49
 * @Description: 订单实体类
 */
@Data
@M("订单表")
@Entity(name = "order")
@Table(name = "t_order")
@SuppressWarnings("serial")
public class Order extends Model {

    @FormField(type = FieldType.TEXTINPUT, label = "id")
    private Client client;// 关联会员id


    @FormField(type = FieldType.NUMBER, label = "订单总额")
    private BigDecimal totalMoney = BigDecimal.ZERO;// 订单总额


    @FormField(type = FieldType.NUMBER, label = "订单状态", data = "1|待付款,2|待发货,3|待收货,10|订单已完成,11|加急")
    private String status;// 订单状态

    @FormField(type = FieldType.TEXTINPUT, label = "订单备注")
    private String orderRemarks;// 订单所留备注

    @FormField(type = FieldType.TIME, label = "付款时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paymentTime;// 订单付款时间

    @FormField(type = FieldType.TIME, label = "发货时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shipmentsTime;// 订单发货时间

    @FormField(type = FieldType.TIME, label = "收货时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime receivingTime;// 订单收货时间

    @FormField(type = FieldType.TIME, label = "退货申请时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applyForTime;// 订单退货申请时间

    @FormField(type = FieldType.TIME, label = "退货审核时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkTime;// 订单退换货审核时间

    @FormField(type = FieldType.TIME, label = "退货发货时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime buyerDshipmentsTime;// 订单退换货买家发货时间

    @FormField(type = FieldType.TIME, label = "退款时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime refundTime;// 订单退款时间

    @FormField(type = FieldType.TIME, label = "订单完成时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime finishTime;// 订单完成时间

    @FormField(type = FieldType.TEXTINPUT, label = "发货快递")
    private String expressName;// 快递名称

    @FormField(type = FieldType.NUMBER, label = "退款金额")
    private BigDecimal orderRefundTime = BigDecimal.ZERO;// 退款金额

    @FormField(type = FieldType.TEXTINPUT, label = "发货快递单号")
    private String expressNo;// 快递单号

    @FormField(type = FieldType.TEXTINPUT, label = "退款理由")
    private String refundReason;// 退款理由

    @FormField(type = FieldType.TEXTINPUT, label = "退货上传图片")
    private String imageUrl;// 退货上传图片

    @FormField(type = FieldType.TEXTINPUT, label = "拒绝退款")
    private String rejectReason;// 拒绝退款理由

    @FormField(type = FieldType.TEXTINPUT, label = "退货快递")
    private String refundExpressName;// 退货快递名称

    @FormField(type = FieldType.TEXTINPUT, label = "退货快递单号")
    private String refundExpressNo;// 退货快递单号

    @FormField(type = FieldType.NUMBER, label = "一级分销提成")
    private BigDecimal firstLevelBrokerage = BigDecimal.ZERO;// 一级分销提成

    @FormField(type = FieldType.NUMBER, label = "二级分销提成")
    private BigDecimal secondLevelBrokerage = BigDecimal.ZERO;// 二级分销提成

    @FormField(type = FieldType.NUMBER, label = "支付方式", data = "0|余额支付,1|微信支付,2|支付宝支付")
    private Integer payPathway;// 支付方式

    @FormField(type = FieldType.NUMBER, label = "是否已评价", data = "0|未评价,1|已评价")
    private Integer appraise = 0;// 是否已评价

    @FormField(type = FieldType.TIME, label = "评价时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date appraiseTime;// 评价时间

    @FormField(type = FieldType.TEXTINPUT, label = "商家备注")
    private String businessRemarks;// 商家备注

    @FormField(type = FieldType.TEXTINPUT, label = "退款备注")
    private String refundRemarks;// 退款备注

    @FormField(type = FieldType.TEXTINPUT, label = "支付宝交易号")
    private String alipayNumber;// 支付宝单号

    @FormField(type = FieldType.TEXTINPUT, label = "微信交易号")
    private String wxNumber;// 微信单号

    private String orderNo;// 订单号

    private String exchange = "0";//0未兑换  1已兑换


    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setMember(Client client) {
        this.client = client;
    }
}
