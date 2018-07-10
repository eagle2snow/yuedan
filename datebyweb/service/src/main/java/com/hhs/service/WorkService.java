package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Work;
import com.hhs.base.dao.WorkDao;

@Transactional
@Service
public class WorkService extends BaseService<Work, Integer> {
	@Resource
	private WorkDao dao;

	@Override
	public WorkDao getDao() {
		return dao;
	}
}