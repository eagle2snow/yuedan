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
 * @Date: 2018/7/5 17:03
 * @Description: 取现
 */
@Data
@M("提现")
@Table(name = "t_cash")
@Entity(name = "cash")
public class Cash extends Model {

    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;

    @FormField(type = FieldType.TEXTINPUT, label = "持卡人")
    private String cardUser;

    @FormField(type = FieldType.TEXTINPUT, label = "银行卡账号")
    private String cardNo;

    @FormField(type = FieldType.TEXTINPUT, label = "银行名称")
    private String cardName;

    @FormField(type = FieldType.TEXTINPUT, label = "提现金额")
    private BigDecimal amount = BigDecimal.ZERO;

    @FormField(type = FieldType.TEXTINPUT, label = "服务费")
    private BigDecimal serviceCharge = BigDecimal.ZERO;

    @FormField(type = FieldType.RADIO, label = "状态", data = "1|待审核,2|拒绝提现,3|待打款,4|已打款,5|已作废")
    private Integer status;

    @FormField(type = FieldType.TEXTINPUT, label = "银行流水号")
    private String flowNo;

    @FormField(type = FieldType.TEXTAREA, label = "操作者")
    private String operator;

    @FormField(type = FieldType.TIME, label = "处理时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dealTime;

    @FormField(type = FieldType.TEXTAREA, label = "备注")
    private String remark;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setMember(Client client) {
        this.client = client;
    }

}
