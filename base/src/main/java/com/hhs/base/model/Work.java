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
 * @Date: 2018/7/9 17:35
 * @Description: 会员中心-工作经历
 */
@Data
@M("工作")
@Entity(name = "work")
@Table(name = "t_work")
public class Work extends Model{
    //公司名称、开始时间、结束时间、公司类型、职位
    @FormField(type = FieldType.TEXTINPUT, label = "职位")
    private String position;

    @FormField(type = FieldType.RADIO, label = "公司类型", data = "1|国有企业,2|私人企业,3|个人经营,4|创业")
    private Integer level;

    @FormField(type = FieldType.TIME, label = "开始时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @FormField(type = FieldType.TIME, label = "结束时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
}
