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
 * @Date: 2018/7/10 09:31
 * @Description: 会员中心-我的动态
 */
@Data
@M("我的动态")
@Entity(name = "dynamic")
@Table(name = "t_dynamic")
public class Dynamic extends Model{

    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;

    @FormField(type = FieldType.PICTURE, label = "动态相册")
    private String dynamicImagesUrl;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
