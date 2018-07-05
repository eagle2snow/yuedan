package com.hhs.base.model;

import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.FieldType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Auther: Eagle
 * @Date: 2018/7/4 14:52
 * @Description: 客户信息实体类
 */
@Data
@M("客户信息")
@Entity(name = "client")
@Table(name = "t_client")
public class Client extends Model{

    @FormField(type = FieldType.PICTURE, label = "头像地址")
    private String iocUrl;

    @FormField(type = FieldType.PASSWORD, label = "密码")
    private String password;

    @FormField(type = FieldType.RADIO, label = "性别", data = "1|男,2|女,0|不详")
    private Integer gender = 0;

    /**
     * 初级:1  11:初级1 12:初级2 13:初级3 14:初级4 15:初级5
     * 中级:2  21:中级1 22:中级2 23:中级3 24:中级4 25:中级5
     * 高级:3  31:高级1 32:高级2 33:高级3 34:高级4 35:高级5
     * 大师:4  41:大师1 42:大师2 43:大师3 44:大师4 45:大师5
     */
    @FormField(type = FieldType.NUMBER, label = "等级")
    private Integer level = 11;

    @FormField(type = FieldType.NUMBER, label = "积分")
    private Integer integral = 0;

    @FormField(type = FieldType.NUMBER, label = "经度")
    private Integer longitude = 0;

    @FormField(type = FieldType.NUMBER, label = "纬度")
    private Integer latitude = 0;

    @FormField(type = FieldType.TEXTINPUT, label = "手机号")
    private String mobile;

    @FormField(type = FieldType.TEXTINPUT, label = "微信号")
    private String wechat;

    @FormField(type = FieldType.TEXTINPUT, label = "微博号")
    private String microblog;

    /**
     * 1:不展示 2:展示
     */
    @FormField(type = FieldType.NUMBER, label = "是否展示微博号")
    private Integer statusMicroblog = 1;

    @FormField(type = FieldType.TEXTINPUT, label = "简介")
    private String profile;

    @FormField(type = FieldType.NUMBER, label = "赞")
    private Integer praise = 0;

    @FormField(type = FieldType.NUMBER, label = "访客")
    private Integer visitor = 0;

    /**
     * 1:一般 2:还行 3:很高
     */
    @FormField(type = FieldType.NUMBER, label = "活跃度")
    private Integer liveness = 1;


    /**
     * 1:微信 2:QQ 3:微博  4:手机
     */
    @FormField(type = FieldType.NUMBER, label = "授权")
    private Integer auth ;

    /**
     * 1:手机认证 2:身份证认证 3:支付宝认证 4:微信认证 5:微博认证 6:技能认证
     */
    @FormField(type = FieldType.NUMBER, label = "认证")
    private Integer authentication;

}
