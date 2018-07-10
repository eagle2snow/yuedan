package com.hhs.base.model;

import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.DataNature;
import com.hhs.gencode.util.FieldType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Auther: Eagle
 * @Date: 2018/7/10 10:21
 * @Description: 会员中心-我的消息
 */
@Data
@M("我的消息")
@Entity(name = "messages")
@Table(name = "t_messages")
public class Messages extends Model{
    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;

    @FormField(type = FieldType.SELECT, label = "订单", dataNature = DataNature.MODEL, ds = Order.class)
    private Order order;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
