package com.hhs.base.model;

import com.hhs.gencode.annotation.M;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Auther: Eagle
 * @Date: 2018/7/11 10:21
 * @Description: 支付账单
 */
@Data
@M("支付")
@Entity(name = "payBill")
@Table(name = "t_payBill")
public class PayBill extends Model{

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 微信用户开发Id
     */
    private String openid;

    /**
     * 预付款金额，單位（元）
     */
    private BigDecimal preFee = BigDecimal.ZERO;

    /**
     * 实际付款金额，單位（元）
     */
    private BigDecimal reaFee = BigDecimal.ZERO;

    /**
     * 微信交易號
     */
    private String transactionId;

    /**
     * 1未支付，2已支付
     */
    private Integer pay;

    /**
     * 1:微信支付，2:支付宝支付
     */
    private Integer type;

    /**
     * 完成支付时间
     */
    private LocalDateTime payTime = LocalDateTime.now();

}
