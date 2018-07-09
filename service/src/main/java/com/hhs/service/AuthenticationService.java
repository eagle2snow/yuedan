package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Authentication;
import com.hhs.base.dao.AuthenticationDao;

@Transactional
@Service
public class AuthenticationService extends BaseService<Authentication, Integer> {
	@Resource
	private AuthenticationDao dao;

	@Override
	public AuthenticationDao getDao() {
		return dao;
	}
}