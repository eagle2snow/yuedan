package com.gm.base.model.sys;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.gm.base.model.Model;
import com.gm.gencode.annotation.FormField;
import com.gm.gencode.annotation.M;
import com.gm.gencode.annotation.Verification;
import com.gm.gencode.util.FieldType;
import com.gm.utils.StringUtil;

@M("用户")
@Entity(name = "user")
@Table(name = "t_user")
public class User extends Model {

	@FormField(label = "用户名", type = FieldType.TEXTINPUT)
	private String username;
	@FormField(label = "密码", type = FieldType.TEXTINPUT)
	private String password;

	private String salt;// 加密盐

	@Verification(datatype = "m")
	@FormField(label = "手机号", type = FieldType.TEXTINPUT)
	private String mobile;

	private Integer passErrorTimes = 0;

	private Integer loginCount = 0;
	private LocalDateTime lastLoginDate;
	private String lastLoginIp;
	private String avatar;
	private Integer sex = 0;

	private String sign;// 个性签名

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPassErrorTimes() {
		return passErrorTimes;
	}

	public void setPassErrorTimes(Integer passErrorTimes) {
		this.passErrorTimes = passErrorTimes;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getAvatar() {
		if (StringUtil.nullOrEmpty(avatar)) {
			return "/static/admin/img/user8-128x128.jpg";
		}
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
