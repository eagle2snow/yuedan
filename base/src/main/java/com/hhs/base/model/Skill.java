package com.hhs.base.model;

import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.FieldType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @Auther: Eagle
 * @Date: 2018/7/5 11:20
 * @Description: 客户技能实体类
 */
@Data
@M("技能表")
@Entity(name = "skill")
@Table(name = "t_skill")
public class Skill extends Model {

    @FormField(type = FieldType.TEXTINPUT, label = "会员")
    private Client client;

    @FormField(type = FieldType.NUMBER, label = "分类")
    private Integer classesId;

    @FormField(type = FieldType.NUMBER, label = "咨询类型(品类)")
    private Integer categoryId;

    @FormField(type = FieldType.PICTURE, label = "技能相册")
    private String skillImagesUrl;

    @FormField(type = FieldType.RADIO, label = "咨询对象", data = "1|单方需要咨询,2|双方需要咨询")
    private Integer statusAdvisory;

    /**
     * 1:线下服务 2:线上服务 3:电话咨询 4:视频咨询
     */
    @FormField(type = FieldType.TEXTINPUT, label = "服务类型")
    private String type;

    @FormField(type = FieldType.NUMBER, label = "服务价格")
    private BigDecimal serviceMoney = BigDecimal.ZERO;

    @FormField(type = FieldType.RADIO, label = "派单状态", data = "1|接受派单,2|不接派单")
    private Integer statusSendOrder;

    @FormField(type = FieldType.RADIO, label = "应邀数")
    private Integer totalInvitation;

    @FormField(type = FieldType.RADIO, label = "审核状态", data = "1|待完善，2|审核中,3|已驳回,4|已通过")
    private Integer statusCheck;

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
