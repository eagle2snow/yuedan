package com.gm.service;

import javax.annotation.Resource;

import com.gm.base.dao.TenReturnOneDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.TenReturnOne;

@Transactional
@Service
public class TenReturnOneService extends BaseService<TenReturnOne, Integer> {
	@Resource
	private TenReturnOneDao dao;
	@Override
	public TenReturnOneDao getDao()
	{
		return dao;
	}
}