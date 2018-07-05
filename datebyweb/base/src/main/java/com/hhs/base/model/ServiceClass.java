package com.hhs.base.model;

import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.annotation.Verification;
import com.hhs.gencode.util.DataNature;
import com.hhs.gencode.util.FieldType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@M("服务分类表")
@SuppressWarnings("serial")
@Entity(name = "servicesClass")
@Table(name = "t_services_class")
public class ServiceClass extends Model {

	@FormField(type = FieldType.SELECT, label = "分类",dataNature=DataNature.MODEL,ds=Classify.class)
	private Classify classify;

	@FormField(label = "服务类型", type = FieldType.TEXTINPUT)
	private Integer serve;//1-线下服务 2-电话咨询 3-视频咨询 4-线上服务

	@FormField(label = "价格", type = FieldType.NUMBER)
	private BigDecimal showPrice = BigDecimal.ZERO;

	@FormField(type = FieldType.PICTURE, label = "显示图片")
	private String imgerPath;

	@FormField(type = FieldType.PICTURELIST, label = "图片列表")
	private String imgeListShow;

	@FormField(label = "备注", type = FieldType.TEXTINPUT)
	private String remarks;

	@FormField(label = "排序", type = FieldType.NUMBER)
	private Integer sort;

	@ManyToOne
	public Classify getClassify() {
		return classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	public Integer getServe() {
		return serve;
	}

	public void setServe(Integer serve) {
		this.serve = serve;
	}

	public BigDecimal getShowPrice() {
		return showPrice;
	}

	public void setShowPrice(BigDecimal showPrice) {
		this.showPrice = showPrice;
	}

	public String getImgerPath() {
		return imgerPath;
	}

	public void setImgerPath(String imgerPath) {
		this.imgerPath = imgerPath;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getImgeListShow() {
		return imgeListShow;
	}

	public void setImgeListShow(String imgeListShow) {
		this.imgeListShow = imgeListShow;
	}
}
