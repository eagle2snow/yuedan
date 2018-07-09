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
import java.time.LocalDateTime;

/**
 * @Auther: Eagle
 * @Date: 2018/7/9 09:18
 * @Description: 充值实体类
 */
@Data
@M("充值")
@Table(name = "t_recharge")
@Entity(name = "recharge")
public class Recharge extends Model{

    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;

    @FormField(type = FieldType.NUMBER, label = "充值方式", data = "1|金币,2|砖石")
    private Integer rechargePathway;

    @FormField(type = FieldType.NUMBER, label = "支付方式", data = "1|余额支付,2|微信支付,3|支付宝支付")
    private Integer payPathway;

    @FormField(type = FieldType.TIME, label = "充值时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime rechargeTime;

    @FormField(type = FieldType.RADIO, label = "支付状态", data = "1|支付成功,2|支付失败,3|待支付")
    private Integer statusPay;



    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
