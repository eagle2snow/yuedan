package com.hhs.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.DataNature;
import com.hhs.gencode.util.FieldType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Auther: Eagle
 * @Date: 2018/7/5 09:49
 * @Description: 订单管理-订单实体类
 */
@Data
@M("订单表")
@Entity(name = "order")
@Table(name = "t_order")
public class Order extends Model {

    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;

    @FormField(type = FieldType.NUMBER, label = "咨询类型(品类)")
    private Integer categoryId;

    @FormField(type = FieldType.RADIO, label = "订单状态", data = "1|待应邀,2|已应邀,3|已成交,4|已过期,5|订单进行中")
    private Integer statusOrder;

    @FormField(type = FieldType.RADIO, label = "支付状态", data = "1|未付款,2|已付定金,3|已确认定金,4|待确认全款,5|已申请退款,6|已驳回退款,5|已同意退款")
    private Integer statusPay;

    @FormField(type = FieldType.RADIO, label = "性别要求", data = "1|男,2|女")
    private Integer gender;

    @FormField(type = FieldType.NUMBER, label = "距离")
    private Integer distance;

    @FormField(type = FieldType.TEXTINPUT, label = "订单号")
    private String orderNo;

    /**
     * 1:线下服务 2:线上服务 3:电话咨询 4:视频咨询
     */
    @FormField(type = FieldType.TEXTINPUT, label = "服务类型")
    private String type;

    /**
     * 单位:分钟
     */
    @FormField(type = FieldType.NUMBER, label = "服务时间")
    private Integer serviceTime;

    @FormField(type = FieldType.NUMBER, label = "诚意金")
    private BigDecimal earnestMoney = BigDecimal.ZERO;

    @FormField(type = FieldType.NUMBER, label = "订单总价")
    private BigDecimal totalMoney = BigDecimal.ZERO;

    @FormField(type = FieldType.NUMBER, label = "支付方式", data = "1|余额支付,2|微信支付,3|支付宝支付")
    private Integer payPathway;

    @FormField(type = FieldType.TEXTINPUT, label = "支付宝交易号")
    private String alipayNo;

    @FormField(type = FieldType.TEXTINPUT, label = "微信交易号")
    private String wechatNo;

    @FormField(type = FieldType.TIME, label = "支付时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime payTime;

    @FormField(type = FieldType.TIME, label = "预约时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentTime;

    @FormField(type = FieldType.TIME, label = "应邀时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime onInvitationTime;

    @FormField(type = FieldType.TIME, label = "结束时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    @FormField(type = FieldType.TEXTINPUT, label = "应邀优势")
    private String advantage;

    @FormField(type = FieldType.TIME, label = "付款时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paymentTime;

    @FormField(type = FieldType.TIME, label = "订单完成时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime finishTime;

    @FormField(type = FieldType.NUMBER, label = "是否已评价", data = "0|未评价,1|已评价")
    private Integer appraise = 0;

    @FormField(type = FieldType.TIME, label = "评价时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appraiseTime;

    @FormField(type = FieldType.NUMBER, label = "退款金额")
    private BigDecimal orderRefundTime = BigDecimal.ZERO;

    @FormField(type = FieldType.TEXTINPUT, label = "退款理由")
    private String refundReason;

    @FormField(type = FieldType.TIME, label = "退款时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime refundTime;

    @FormField(type = FieldType.TEXTINPUT, label = "拒绝退款")
    private String rejectReason;

    @FormField(type = FieldType.TIME, label = "拒退时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime rejectTime;

    @FormField(type = FieldType.TEXTINPUT, label = "备注")
    private String remarks;


    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
