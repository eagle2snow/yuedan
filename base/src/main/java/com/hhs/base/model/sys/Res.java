package com.hhs.base.model.sys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.hhs.base.model.Model;
import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.DataNature;
import com.hhs.gencode.util.FieldType;

@M("后台资源")
@Entity(name = "res")
@Table(name = "t_res")
public class Res extends Model {

	@FormField(type = FieldType.TEXTINPUT, label = "权限值")
	private String code;
	@FormField(type = FieldType.RADIO, label = "类型", data = "1|菜单,2|按钮")
	private Integer type;
	@FormField(type = FieldType.TEXTINPUT, label = "url")
	private String url;
	@FormField(type = FieldType.IGNORE, label = "级别")
	private Integer level = 0;
	@FormField(type = FieldType.SELECT, label = "上级",dataNature=DataNature.MODEL,ds=Res.class)
	private Res parent;

	@FormField(type = FieldType.IGNORE)
	private List<Res> sons = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@ManyToOne
	public Res getParent() {
		return parent;
	}

	public void setParent(Res parent) {
		this.parent = parent;
	}

	@Transient
	public List<Res> getSons() {
		return sons;
	}

	public void setSons(List<Res> sons) {
		this.sons = sons;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
