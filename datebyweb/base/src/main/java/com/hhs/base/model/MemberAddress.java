package com.hhs.base.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.DataNature;
import com.hhs.gencode.util.FieldType;

@M("会员收货地址")
@SuppressWarnings("serial")
@Entity(name = "memberAddress")
@Table(name = "t_member_address")
public class MemberAddress extends Model {

	@FormField(type = FieldType.SELECT, label = "会员名字", dataNature = DataNature.MODEL, ds = Member.class)
	private Member member;

	@FormField(type = FieldType.TEXTINPUT, label = "手机号")
	private String mobile;

	@FormField(type = FieldType.TEXTINPUT, label = "固话")
	private String phone;

	@FormField(type = FieldType.TEXTINPUT, label = "邮编")
	private String postcode;

	@FormField(type = FieldType.TEXTINPUT, label = "省份")
	private String province;

	@FormField(type = FieldType.TEXTINPUT, label = "城市")
	private String city;

	@FormField(type = FieldType.TEXTINPUT, label = "区域")
	private String area;

	@FormField(type = FieldType.TEXTINPUT, label = "详细地址")
	private String address;

	@FormField(type = FieldType.RADIO, label = "默认地址", data = "1|默认,2|非默认")
	private Integer defaultAddress;

	private String pca;// 省市县

	public MemberAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(Integer defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public String getPca() {
		return pca;
	}

	public void setPca(String pca) {
		this.pca = pca;
	}

}
