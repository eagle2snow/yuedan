package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.TenReturnOneDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.TenReturnOne;

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