package com.gm.base.model.sys;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gm.base.model.Model;

@Entity(name = "userRes")
@Table(name = "t_user_res")
public class UserRes extends Model {
	private User user;
	private Res res;

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	public Res getRes() {
		return res;
	}

	public void setRes(Res res) {
		this.res = res;
	}

}