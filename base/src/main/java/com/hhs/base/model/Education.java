package com.hhs.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.FieldType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @Auther: Eagle
 * @Date: 2018/7/9 17:34
 * @Description: 会员中心-教育经历
 */
@Data
@M("教育")
@Entity(name = "education")
@Table(name = "t_education")
public class Education extends Model{

    //学校、开始时间、毕业时间、学历层次

    @FormField(type = FieldType.RADIO, label = "学历层次", data = "0|初中,1|高中,2|中专,3|大专,4|本科,5|硕士,6|博士")
    private Integer level;

    @FormField(type = FieldType.TIME, label = "开学时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @FormField(type = FieldType.TIME, label = "结束时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

}
