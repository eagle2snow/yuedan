package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.CommodityAppraiseDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.CommodityAppraise;

@Transactional
@Service
public class CommodityAppraiseService extends BaseService<CommodityAppraise, Integer> {
	@Resource
	private CommodityAppraiseDao dao;

	@Override
	public CommodityAppraiseDao getDao()
	{
		return dao;
	}
}