package com.hhs.base.model.sys;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hhs.base.model.Model;
import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.util.FieldType;

@M("操作日志")
@Entity(name = "optLog")
@Table(name = "t_opt_log")
public class OptLog extends Model {
	@FormField(type = FieldType.IGNORE, label = "管理员")
	private User user;
	@FormField(type = FieldType.IGNORE, label = "操作ip")
	private String optIp;
	@FormField(type = FieldType.IGNORE, label = "操作资源")
	private String optUri;

	public OptLog() {
	}

	public OptLog(User u, String ip, String uri) {
		this.user = u;
		this.optIp = ip;
		this.optUri = uri;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOptIp() {
		return optIp;
	}

	public void setOptIp(String optIp) {
		this.optIp = optIp;
	}

	public String getOptUri() {
		return optUri;
	}

	public void setOptUri(String optUri) {
		this.optUri = optUri;
	}

}
