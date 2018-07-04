package com.gm.base.model.sys;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gm.base.model.Model;
import com.gm.gencode.annotation.FormField;
import com.gm.gencode.annotation.M;
import com.gm.gencode.util.FieldType;

import net.sf.ehcache.store.TierableStore;

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
