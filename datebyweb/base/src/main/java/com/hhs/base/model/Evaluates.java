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
 * @Date: 2018/7/10 14:10
 * @Description: 评价管理-评价列表
 */
@Data
@M("评价")
@Entity(name = "evaluates")
@Table(name = "t_evaluates")
public class Evaluates extends Model{
    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;



    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
