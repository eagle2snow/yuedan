package com.hhs.base.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.FieldType;

/**
 * 
 * 
 * <p>
 * Title: OrderItem
 * </p>
 * 
 * <p>
 * Description: 订单项
 * </p>
 * 
 * @author 灰灰
 * 
 * @date 2018年4月24日
 */
@M("订单项")
@Table(name = "t_order_item")
@Entity(name = "orderItem")
@SuppressWarnings("serial")
public class OrderItem extends Model {
	
	private Order order;
	
	private Commodity commodity;
	
	private Integer buyCount;

	@FormField(label = "商品主页显示价格", type = FieldType.NUMBER)
	private BigDecimal showPrice = BigDecimal.ZERO;

	@FormField(label = "商品主页显示折扣价", type = FieldType.NUMBER)
	private BigDecimal showDiscount = BigDecimal.ZERO;

	@FormField(label = "商品主页显示原价", type = FieldType.NUMBER)
	private BigDecimal originalPrice = BigDecimal.ZERO;

	@FormField(label = "商品邮费", type = FieldType.NUMBER)
	private BigDecimal freight = BigDecimal.ZERO;

	@FormField(label = "商品备注", type = FieldType.TEXTINPUT)
	private String remarks;

	@FormField(label = "商品总库存", type = FieldType.NUMBER)
	private Integer totalStock;

	@FormField(type = FieldType.PICTURE, label = "商品主页显示图片")
	private String imgerPath;

	@FormField(type = FieldType.PICTURELIST, label = "商品图片列表")
	private String imgeListShow;

	@FormField(label = "是否是活动商品", type = FieldType.RADIO, data = "1|是,2|否")
	private String activity;

	@FormField(label = "商品销量", type = FieldType.NUMBER)
	private Integer salesVolume;

	@FormField(label = "商品多少件包邮", type = FieldType.NUMBER)
	private Integer freePostage;

	@FormField(label = "商品成本", type = FieldType.NUMBER)
	private BigDecimal cost = BigDecimal.ZERO;

	@FormField(label = "评价数量", type = FieldType.NUMBER)
	private Integer appraiseCount;

	@FormField(label = "商品前台显示备注", type = FieldType.TEXTINPUT)
	private String showRemarks;

	@FormField(label = "默认重量", type = FieldType.TEXTINPUT)
	private String defaultWeight;

	@FormField(label = "默认体积", type = FieldType.TEXTINPUT)
	private String defaultBulk;

	@FormField(label = "规格", type = FieldType.TEXTINPUT)
	private String specifications;

	@FormField(label = "是否已评价", type = FieldType.TEXTINPUT)//1是已评价
	private String appraise;

	@ManyToOne
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
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

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}


	public String getAppraise() {
		return appraise;
	}


	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}

	public OrderItem() {
	};

	public OrderItem(Order order, Integer buyCount, Commodity commodity) {
		this.setName(commodity.getName());
		this.setContent(commodity.getContent());
		this.order = order;
		this.activity = commodity.getActivity();
		this.appraiseCount = commodity.getAppraiseCount();
		this.buyCount = buyCount;
		this.setCommodity(commodity);
		this.cost = commodity.getCost();
		this.defaultBulk = commodity.getDefaultBulk();
		this.defaultWeight = commodity.getDefaultWeight();
		this.freePostage = commodity.getFreePostage();
		this.freight = commodity.getFreight();
		this.imgeListShow = commodity.getImgeListShow();
		this.imgerPath = commodity.getImgerPath();
		this.originalPrice = commodity.getOriginalPrice();
		this.remarks = commodity.getRemarks();
		this.salesVolume = commodity.getSalesVolume();
		this.showDiscount = commodity.getShowDiscount();
		this.showPrice = commodity.getShowPrice();
		this.showRemarks = commodity.getShowRemarks();
		this.specifications = commodity.getSpecifications();
		this.totalStock = commodity.getTotalStock();
	}

	@ManyToOne
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	};

}
