package com.gm.base.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gm.gencode.annotation.FormField;
import com.gm.gencode.annotation.M;
import com.gm.gencode.util.DataNature;
import com.gm.gencode.util.FieldType;

@M("商品分类表")
@SuppressWarnings("serial")
@Entity(name = "commodityClass")
@Table(name = "t_commodity_class")
public class CommodityClass extends Model {

	@FormField(type = FieldType.SELECT, label = "父级别", dataNature = DataNature.MODEL, ds = CommodityClass.class)
	private CommodityClass parent;

	@ManyToOne
	public CommodityClass getParent() {
		return parent;
	}

	public void setParent(CommodityClass parent) {
		this.parent = parent;
	}

}
