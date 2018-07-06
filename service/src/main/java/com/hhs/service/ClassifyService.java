package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Classify;
import com.hhs.base.dao.ClassifyDao;

@Transactional
@Service
public class ClassifyService extends BaseService<Classify, Integer> {
	@Resource
	private ClassifyDao dao;

	@Override
	public ClassifyDao getDao() {
		return dao;
	}
}