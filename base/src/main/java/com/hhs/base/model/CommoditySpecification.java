package com.hhs.base.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.DataNature;
import com.hhs.gencode.util.FieldType;

@M("商品规格表")
@SuppressWarnings("serial")
@Entity(name = "commoditySpecification")
@Table(name = "t_commodity_specification")
public class CommoditySpecification extends Model {

	@FormField(type = FieldType.SELECT, label = "商品名称",dataNature = DataNature.MODEL, ds = Commodity.class)
	private Commodity commodity;//关联商品id
	
	@FormField(type = FieldType.NUMBER, label = "价格")
	private BigDecimal prices;
	
	@FormField(type = FieldType.NUMBER, label = "重量")
	private Double weights;
	
	@FormField(type = FieldType.NUMBER, label = "体积")
	private Double bulks;
	
	@FormField(type = FieldType.TEXTINPUT, label = "描述")
	private String describes;
	
	
	@ManyToOne
	public Commodity getCommodity() {
		return commodity;
	}

	public BigDecimal getPrices() {
		return prices;
	}

	public void setPrices(BigDecimal prices) {
		this.prices = prices;
	}

	public Double getWeights() {
		return weights;
	}

	public void setWeights(Double weights) {
		this.weights = weights;
	}

	public Double getBulks() {
		return bulks;
	}

	public void setBulks(Double bulks) {
		this.bulks = bulks;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	

	
	

}
