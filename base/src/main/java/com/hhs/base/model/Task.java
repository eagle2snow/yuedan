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
 * @Date: 2018/7/10 09:52
 * @Description: 会员中心-我的任务
 */
@Data
@M("我的任务")
@Entity(name = "task")
@Table(name = "t_task")
public class Task extends Model{

    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;

    @FormField(type = FieldType.RADIO, label = "任务类型", data = "1|今日任务,2|常规任务")
    private Integer statusTask;

    @FormField(type = FieldType.RADIO, label = "应邀订单", data = "1|已完成,2|未完成")
    private Integer statusOrder;

    @FormField(type = FieldType.NUMBER, label = "应邀订单数")
    private Integer orderNumber;

    @FormField(type = FieldType.RADIO, label = "发布动态", data = "1|已完成,2|未完成")
    private Integer statusDynamic;

    @FormField(type = FieldType.RADIO, label = "成为服务者", data = "1|已完成,2|未完成")
    private Integer statusServer;

    @FormField(type = FieldType.RADIO, label = "身份认证", data = "1|已完成,2|未完成")
    private Integer statusIdentity;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
