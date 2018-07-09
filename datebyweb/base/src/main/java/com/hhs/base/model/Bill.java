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
 * @Date: 2018/7/5 16:19
 * @Description: 财务管理-客户账单实体类
 */
@Data
@M("客户账单")
@Entity(name = "bill")
@Table(name = "t_bill")
public class Bill extends Model{

    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;

    @FormField(type = FieldType.TEXTINPUT, label = "余额")
    private BigDecimal balance = BigDecimal.ZERO;

    @FormField(type = FieldType.TEXTINPUT, label = "我的充值")
    private BigDecimal pay = BigDecimal.ZERO;

    @FormField(type = FieldType.RADIO, label = "货币形式", data = "1|金币,2|砖石")
    private Integer form = 1;

    @FormField(type = FieldType.RADIO, label = "充值方式", data = "1|支付宝,2|微信,3|约单")
    private Integer payPathway;

    @FormField(type = FieldType.TEXTINPUT, label = "收入金额")
    private BigDecimal income = BigDecimal.ZERO;

    @FormField(type = FieldType.NUMBER, label = "收入来源")
    private Integer incomePathway;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss", label = "收入时间")
    @FormField(type = FieldType.TIME, label = "收入时间")
    private LocalDateTime incomeTime;

    @FormField(type = FieldType.TEXTINPUT, label = "支出金额")
    private BigDecimal expenditure = BigDecimal.ZERO;

    @FormField(type = FieldType.NUMBER, label = "支出途径")
    private Integer expenditurePathway;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss", label = "支出时间")
    @FormField(type = FieldType.TIME, label = "支出时间")
    private LocalDateTime expenditureTime;

    @FormField(type = FieldType.RADIO, label = "支付状态")
    private Integer statusPay;

    @FormField(type = FieldType.TEXTINPUT, label = "交易详情")
    private String details;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
