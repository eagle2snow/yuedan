package com.gm.base.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gm.gencode.annotation.FormField;
import com.gm.gencode.annotation.M;
import com.gm.gencode.annotation.Verification;
import com.gm.gencode.util.DataNature;
import com.gm.gencode.util.FieldType;

@M("商品表")
@SuppressWarnings("serial")
@Entity(name = "commodity")
@Table(name = "t_commodity")
public class Commodity extends Model {

	@FormField(type = FieldType.SELECT, label = "分类",dataNature=DataNature.MODEL,ds=CommodityClass.class)
	private CommodityClass commodityClass;
	
	@FormField(label = "商品主页显示价格", type = FieldType.NUMBER)
	private BigDecimal showPrice = BigDecimal.ZERO;
	
	@FormField(label = "商品主页显示折扣价", type = FieldType.NUMBER)
	private BigDecimal showDiscount =BigDecimal.ZERO;
	
	@FormField(label = "商品主页显示原价", type = FieldType.NUMBER)
	private BigDecimal originalPrice = BigDecimal.ZERO;
	
	@FormField(label = "商品邮费", type = FieldType.NUMBER)
	private BigDecimal freight = BigDecimal.ZERO;
	
	@FormField(label = "商品备注", type = FieldType.TEXTINPUT)
	private String remarks;
	
	@FormField(label = "编码", type = FieldType.TEXTINPUT)
	@Verification(datatype = "*", errormsg = "请选择")
	private String code;//1.酒  2.纸 
	
	@FormField(label = "商品总库存", type = FieldType.NUMBER)
	private Integer totalStock = 0;
	
	@FormField(type = FieldType.PICTURE, label = "商品主页显示图片")
	private String imgerPath;
	
	@FormField(type = FieldType.PICTURELIST, label = "商品图片列表")
	private String imgeListShow;
	
	@FormField(label = "是否是活动商品", type = FieldType.RADIO,data = "1|是,2|否")
	private String activity;
	
	@FormField(label = "商品销量", type = FieldType.NUMBER)
	private Integer salesVolume = 0;
	
	@FormField(label = "商品多少件包邮", type = FieldType.NUMBER)
	private Integer freePostage = 0;
	
	@FormField(label = "商品成本", type = FieldType.NUMBER)
	private BigDecimal cost = BigDecimal.ZERO;
	
	@FormField(label = "评价数量", type = FieldType.NUMBER)
	private Integer appraiseCount = 0;
	
	@FormField(type = FieldType.NUMBER, label = "浏览")
	private Integer browse = 0;

	@FormField(type = FieldType.NUMBER, label = "评论")
	private Integer comment = 0;

	@FormField(type = FieldType.NUMBER, label = "赞")
	private Integer praise = 0;
	
	@FormField(label = "商品前台显示备注", type = FieldType.TEXTINPUT)
	private String showRemarks;
	
	@FormField(label = "默认重量", type = FieldType.TEXTINPUT)
	private String defaultWeight;
	
	@FormField(label = "默认体积", type = FieldType.TEXTINPUT)
	private String defaultBulk;
	
	@FormField(label = "排序", type = FieldType.NUMBER)
	private Integer sort;
	
	@FormField(label = "规格", type = FieldType.TEXTINPUT)
	private String specifications;
	
	
	@ManyToOne
	public CommodityClass getCommodityClass() {
		return commodityClass;
	}
	
	public void setCommodityClass(CommodityClass commodityClass) {
		this.commodityClass = commodityClass;
	}
	
	
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public Integer getBrowse() {
		return browse;
	}

	public void setBrowse(Integer browse) {
		this.browse = browse;
	}

	public Integer getComment() {
		return comment;
	}

	public void setComment(Integer comment) {
		this.comment = comment;
	}

	public Integer getPraise() {
		return praise;
	}

	public void setPraise(Integer praise) {
		this.praise = praise;
	}

	public BigDecimal getShowPrice() {
		return showPrice;
	}
	
	public void setShowPrice(BigDecimal showPrice) {
		this.showPrice = showPrice;
	}
	
	public BigDecimal getShowDiscount() {
		return showDiscount;
	}
	
	public void setShowDiscount(BigDecimal showDiscount) {
		this.showDiscount = showDiscount;
	}
	
	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}
	
	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	public BigDecimal getFreight() {
		return freight;
	}
	
	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Integer getTotalStock() {
		return totalStock;
	}
	
	public void setTotalStock(Integer totalStock) {
		this.totalStock = totalStock;
	}
	
	public String getImgerPath() {
		return imgerPath;
	}
	
	public void setImgerPath(String imgerPath) {
		this.imgerPath = imgerPath;
	}
	
	public String getImgeListShow() {
		return imgeListShow;
	}
	
	public void setImgeListShow(String imgeListShow) {
		this.imgeListShow = imgeListShow;
	}
	
	public String getActivity() {
		return activity;
	}
	
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public Integer getSalesVolume() {
		return salesVolume;
	}
	
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}
	
	public Integer getFreePostage() {
		return freePostage;
	}
	
	public void setFreePostage(Integer freePostage) {
		this.freePostage = freePostage;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	public Integer getAppraiseCount() {
		return appraiseCount;
	}
	
	public void setAppraiseCount(Integer appraiseCount) {
		this.appraiseCount = appraiseCount;
	}
	
	public String getShowRemarks() {
		return showRemarks;
	}
	
	public void setShowRemarks(String showRemarks) {
		this.showRemarks = showRemarks;
	}
	
	

	/**
	 * @return the defaultWeight
	 */
	public String getDefaultWeight() {
		return defaultWeight;
	}

	/**
	 * @param defaultWeight the defaultWeight to set
	 */
	public void setDefaultWeight(String defaultWeight) {
		this.defaultWeight = defaultWeight;
	}

	/**
	 * @return the defaultBulk
	 */
	public String getDefaultBulk() {
		return defaultBulk;
	}

	/**
	 * @param defaultBulk the defaultBulk to set
	 */
	public void setDefaultBulk(String defaultBulk) {
		this.defaultBulk = defaultBulk;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	
	

}
