package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Dynamic;
import com.hhs.base.dao.DynamicDao;

@Transactional
@Service
public class DynamicService extends BaseService<Dynamic, Integer> {
	@Resource
	private DynamicDao dao;

	@Override
	public DynamicDao getDao() {
		return dao;
	}
}