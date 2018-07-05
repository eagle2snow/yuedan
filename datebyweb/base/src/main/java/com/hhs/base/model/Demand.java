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

/**
 * @Auther: Eagle
 * @Date: 2018/7/5 11:20
 * @Description: 客户需求表
 */
@Data
@M("订单表")
@Entity(name = "demand")
@Table(name = "t_demand")
@SuppressWarnings("serial")
public class Demand extends Model{

    @FormField(type = FieldType.NUMBER, label = "品类ID")
    private Integer categoryId;

    @FormField(type = FieldType.TEXTINPUT, label = "会员")
    private Client client;

    @FormField(type = FieldType.RADIO, label = "需求状态", data = "1|待应邀,2|已应邀,3|已成交,4|已过期")
    private Integer statusDemand;

    @FormField(type = FieldType.RADIO, label = "支付状态", data = "1|未付款,2|已付定金,3|已确认定金,4|待确认全款,5|已申请退款,6|已驳回退款,5|已同意退款")
    private Integer statusPay;

    @FormField(type = FieldType.RADIO, label = "派单状态", data = "1|接受派单,2|不接派单")
    private Integer statusSendOrder;

    @FormField(type = FieldType.RADIO, label = "审核状态", data = "1|审核中,2|已驳回,3|已通过")
    private Integer statusCheck;

    /**
     * 1:线下服务 2:线上服务 3:电话咨询 4:视频咨询
     */
    @FormField(type = FieldType.NUMBER, label = "服务类型")
    private Integer type;

    @FormField(type = FieldType.NUMBER, label = "服务价格")
    private BigDecimal serviceMoney = BigDecimal.ZERO;

    /**
     * 单位:分钟
     */
    @FormField(type = FieldType.NUMBER, label = "服务时间")
    private Integer serviceTime;


    @FormField(type = FieldType.NUMBER, label = "诚意金")
    private BigDecimal earnestMoney = BigDecimal.ZERO;

    @FormField(type = FieldType.NUMBER, label = "全款")
    private BigDecimal totalMoney = BigDecimal.ZERO;

    @FormField(type = FieldType.TIME, label = "预约时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentTime;

    @FormField(type = FieldType.TIME, label = "结束时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    @FormField(type = FieldType.RADIO, label = "性别要求", data = "1|男,2|女")
    private Integer gender;

    @FormField(type = FieldType.NUMBER, label = "距离")
    private Integer distance;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setMember(Client client) {
        this.client = client;
    }





}
