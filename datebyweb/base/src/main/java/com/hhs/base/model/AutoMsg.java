package com.hhs.base.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.DataNature;
import com.hhs.gencode.util.FieldType;
import com.hhs.utils.StringUtil;

@M("自动回复")
@Entity(name = "autoMsg")
@Table(name = "t_auto_msg")
@SuppressWarnings("serial")
public class AutoMsg extends Model {

	@FormField(type = FieldType.SELECT, label = "分类", dataNature = DataNature.MODEL, ds = AutoMsgType.class)
	private AutoMsgType type;

	@FormField(type = FieldType.TEXTINPUT, label = "关键字")
	private String keyz;// 关键字，多个用逗号隔开

	@FormField(type = FieldType.IGNORE, label = "提问次数")
	private Integer askCount = 0;

	public String getKeyz() {
		if (!StringUtil.strNullOrEmpty(keyz)) {
			return keyz.replaceAll(",", "，");
		}
		return keyz;
	}

	public void setKeyz(String keyz) {
		this.keyz = keyz;
	}

	public Integer getAskCount() {
		return askCount;
	}

	public void setAskCount(Integer askCount) {
		this.askCount = askCount;
	}

	@ManyToOne
	public AutoMsgType getType() {
		return type;
	}

	public void setType(AutoMsgType type) {
		this.type = type;
	}

}
