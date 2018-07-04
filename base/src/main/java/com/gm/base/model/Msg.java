package com.gm.base.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.gm.base.enums.MsgCatEnum;
import com.gm.base.enums.MsgTypeEnum;
import com.gm.gencode.annotation.M;

@M("消息")
@Entity(name = "msg")
@Table(name = "t_msg")
@SuppressWarnings("serial")
public class Msg extends Model {
	private Integer fromId;
	private Integer toId;
	private MsgCatEnum cat;
	private MsgTypeEnum type;
	private Integer readed = 1;// 1未读，2已读

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	@Enumerated(EnumType.STRING)
	public MsgCatEnum getCat() {
		return cat;
	}

	public void setCat(MsgCatEnum cat) {
		this.cat = cat;
	}

	@Enumerated(EnumType.STRING)
	public MsgTypeEnum getType() {
		return type;
	}

	public void setType(MsgTypeEnum type) {
		this.type = type;
	}

	public Integer getReaded() {
		return readed;
	}

	public void setReaded(Integer readed) {
		this.readed = readed;
	}

}
