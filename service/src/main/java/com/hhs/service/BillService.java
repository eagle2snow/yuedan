package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Bill;
import com.hhs.base.dao.BillDao;

@Transactional
@Service
public class BillService extends BaseService<Bill, Integer> {
	@Resource
	private BillDao dao;

	@Override
	public BillDao getDao() {
		return dao;
	}
}