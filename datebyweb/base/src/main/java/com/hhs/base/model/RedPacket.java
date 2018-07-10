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
 * @Date: 2018/7/10 10:12
 * @Description: 财务管理-我的红包
 */
@Data
@M("我的红包")
@Entity(name = "redPacket")
@Table(name = "t_redPacket")
public class RedPacket extends Model{

    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;

    @FormField(type = FieldType.NUMBER, label = "红包金额")
    private BigDecimal money = BigDecimal.ZERO;

    @FormField(type = FieldType.RADIO, label = "红包状态", data = "1|过期,2|在线支付可用")
    private Integer statusRedPacket;

    @FormField(type = FieldType.TIME, label = "有效时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime valid ;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
