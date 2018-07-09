package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Cash;
import com.hhs.base.dao.CashDao;

@Transactional
@Service
public class CashService extends BaseService<Cash, Integer> {
	@Resource
	private CashDao dao;

	@Override
	public CashDao getDao() {
		return dao;
	}
}