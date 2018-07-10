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
 * @Date: 2018/7/10 10:27
 * @Description: 会员中心-我的通知
 */
@Data
@M("我的通知")
@Entity(name = "informs")
@Table(name = "t_informs")
public class Informs extends Model{
    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;

    @FormField(type = FieldType.RADIO, label = "通知类型", data = "1|系统通知,2|约单推荐,3|红包信息,4|评价互动")
    private Integer type;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
