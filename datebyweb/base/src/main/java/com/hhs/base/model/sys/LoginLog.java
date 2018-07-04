package com.hhs.base.model.sys;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hhs.base.model.Model;
import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.FieldType;

@M("登录日志")
@Entity(name = "loginLog")
@Table(name = "t_login_log")
public class LoginLog extends Model {
	@FormField(type = FieldType.IGNORE, label = "管理员")
	private User user;
	@FormField(type = FieldType.IGNORE, label = "登录ip")
	private String loginIp;

	public LoginLog() {

	}

	public LoginLog(User u, String ip) {
		this.user = u;
		this.loginIp = ip;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

}
