package com.hhs.base.model;

import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.DataNature;
import com.hhs.gencode.util.FieldType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@M("分类表")
@SuppressWarnings("serial")
@Entity(name = "classify")
@Table(name = "t_classify")
public class Classify extends Model {

	@FormField(type = FieldType.SELECT, label = "父级别", dataNature = DataNature.MODEL, ds = Classify.class)
	private Classify parent;

	@ManyToOne
	public Classify getParent() {
		return parent;
	}

	public void setParent(Classify parent) {
		this.parent = parent;
	}

}
