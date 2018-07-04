package com.gm.base.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gm.gencode.annotation.FormField;
import com.gm.gencode.annotation.M;
import com.gm.gencode.util.FieldType;

@M("会员信息")
@Entity(name = "member")
@Table(name = "t_member")
@SuppressWarnings("serial")
public class Member extends Model {

	@FormField(type = FieldType.TEXTINPUT, label = "openid")
	private String openid;

	@FormField(type = FieldType.TEXTINPUT, label = "推广ID")
	private String generalizeId;

	@FormField(type = FieldType.TEXTINPUT, label = "昵称")
	private String nickname;

	@FormField(type = FieldType.PASSWORD, label = "密码")
	private String password;

	@FormField(type = FieldType.PICTURE, label = "头像地址")
	private String iocUrl;

	@FormField(type = FieldType.TEXTINPUT, label = "手机号")
	private String mobile;

	@FormField(type = FieldType.NUMBER, label = "等级")
	private Integer level = 1; // 1：竹语游客 2：普通会员 3：业务经理 4：城市经理 5：合作伙伴

	@FormField(type = FieldType.RADIO, label = "性别", data = "1|男,2|女,0|不详")
	private Integer gender = 0;

	@FormField(type = FieldType.NUMBER, label = "可用积分")
	private Integer integral = 0;

	@FormField(type = FieldType.TEXTINPUT, label = "国家")
	private String country;

	@FormField(type = FieldType.TEXTINPUT, label = "省份")
	private String province;

	@FormField(type = FieldType.TEXTINPUT, label = "城市")
	private String city;

	@FormField(type = FieldType.TEXTINPUT, label = "所在区域")
	private String area;

	@FormField(type = FieldType.IGNORE, label = "最后登录时间")
	private Date loginTime;

	@FormField(type = FieldType.TEXTINPUT, label = "推荐人推广ID")
	private String referrerGeneralizeId;

	@FormField(type = FieldType.TEXTINPUT, label = "推荐人昵称")
	private String referrerNickname;

	@FormField(type = FieldType.TEXTINPUT, label = "代理推广ID")
	private String agencyId;

	@FormField(type = FieldType.TEXTINPUT, label = "代理昵称")
	private String agencyNickname;

	@FormField(type = FieldType.TEXTINPUT, label = "营业额")
	private BigDecimal totalRevenue = BigDecimal.ZERO;

	@FormField(type = FieldType.TEXTINPUT, label = "消费额")
	private BigDecimal consume = BigDecimal.ZERO;

	@FormField(type = FieldType.NUMBER, label = "爱心扶贫")
	private Integer love = 0; // 每购买一件商品 爱心扶贫一元 购买套餐视为一件商品

	@FormField(type = FieldType.TEXTINPUT, label = "推广费")
	private BigDecimal generalizeCost = BigDecimal.ZERO;

	@FormField(type = FieldType.TEXTINPUT, label = "可提现金额")
	private BigDecimal balance = BigDecimal.ZERO;

	private String qrCode;// 推广二维码

	private Integer changReferrer = 0;// 是否更改过推荐人 ：0 未更改, 1 已更改

	private Integer setMeal = 1;// 套餐类型 ：1 未购买, 2 已购买, 3 返套餐金额

	@FormField(type = FieldType.TEXTINPUT, label = "十返一")
	private BigDecimal tenReturnOne = BigDecimal.ZERO;

	private LocalDateTime lastUpdateQrCode;// 最后更新二维码时间

	public BigDecimal getTenReturnOne() {
		return tenReturnOne;
	}

	public void setTenReturnOne(BigDecimal tenReturnOne) {
		this.tenReturnOne = tenReturnOne;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyNickname() {
		return agencyNickname;
	}

	public void setAgencyNickname(String agencyNickname) {
		this.agencyNickname = agencyNickname;
	}

	public Integer getSetMeal() {
		return setMeal;
	}

	public void setSetMeal(Integer setMeal) {
		this.setMeal = setMeal;
	}

	public String getReferrerGeneralizeId() {
		return referrerGeneralizeId;
	}

	public void setReferrerGeneralizeId(String referrerGeneralizeId) {
		this.referrerGeneralizeId = referrerGeneralizeId;
	}

	public Integer getChangReferrer() {
		return changReferrer;
	}

	public void setChangReferrer(Integer changReferrer) {
		this.changReferrer = changReferrer;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getGeneralizeId() {
		return generalizeId;
	}

	public void setGeneralizeId(String generalizeId) {
		this.generalizeId = generalizeId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIocUrl() {
		return iocUrl;
	}

	public void setIocUrl(String iocUrl) {
		this.iocUrl = iocUrl;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getReferrerNickname() {
		return referrerNickname;
	}

	public void setReferrerNickname(String referrerNickname) {
		this.referrerNickname = referrerNickname;
	}

	public BigDecimal getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public BigDecimal getConsume() {
		return consume;
	}

	public void setConsume(BigDecimal consume) {
		this.consume = consume;
	}

	public Integer getLove() {
		return love;
	}

	public void setLove(Integer love) {
		this.love = love;
	}

	public BigDecimal getGeneralizeCost() {
		return generalizeCost;
	}

	public void setGeneralizeCost(BigDecimal generalizeCost) {
		this.generalizeCost = generalizeCost;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Column(columnDefinition = "TEXT")
	public String getQrCode() {
		return qrCode;
	}
 
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public LocalDateTime getLastUpdateQrCode() {
		return lastUpdateQrCode;
	}

	public void setLastUpdateQrCode(LocalDateTime lastUpdateQrCode) {
		this.lastUpdateQrCode = lastUpdateQrCode;
	}

}
