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
 * @Date: 2018/7/6 10:10
 * @Description: 客户认证
 */
@Data
@M("客户认证")
@Entity(name = "authentication")
@Table(name = "t_ authentication")
public class Authentication extends Model {

    @FormField(type = FieldType.SELECT, label = "会员", dataNature = DataNature.MODEL, ds = Client.class)
    private Client client;

    @FormField(type = FieldType.TEXTINPUT, label = "手机号")
    private String phoneNo;

    @FormField(type = FieldType.RADIO, label = "身份证明", data = "1|身份证,2|护照,3|港澳通行证")
    private String identityType;

    @FormField(type = FieldType.TEXTINPUT, label = "身份证号")
    private String identityNo;

    @FormField(type = FieldType.TEXTINPUT, label = "支付宝账号")
    private String AlipayNo;

    @FormField(type = FieldType.TEXTINPUT, label = "微信号")
    private String wechatNo;

    @FormField(type = FieldType.TEXTINPUT, label = "微博账号")
    private String microblogNo;

    @FormField(type = FieldType.TEXTINPUT, label = "芝麻信用")
    private String sesameNo;

    @FormField(type = FieldType.TEXTINPUT, label = "技能编号")
    private String skillNo;

    @FormField(type = FieldType.PICTURE, label = "手持身份证图片地址")
    private String identityHandImagesUrl;

    @FormField(type = FieldType.PICTURE, label = "身份证正面图片地址")
    private String identityFrontImagesUrl;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
