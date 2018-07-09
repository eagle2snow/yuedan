package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Recharge;
import com.hhs.base.dao.RechargeDao;

@Transactional
@Service
public class RechargeService extends BaseService<Recharge, Integer> {
	@Resource
	private RechargeDao dao;

	@Override
	public RechargeDao getDao() {
		return dao;
	}
}