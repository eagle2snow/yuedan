package com.gm.base.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gm.gencode.annotation.M;

@M("自动回复分类")
@SuppressWarnings("serial")
@Entity(name = "autoMsgType")
@Table(name = "t_auto_msg_type")
public class AutoMsgType extends Model {

}
