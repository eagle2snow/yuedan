package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.ServiceClass;
import com.hhs.base.dao.ServiceClassDao;

@Transactional
@Service
public class ServiceClassService extends BaseService<ServiceClass, Integer> {
	@Resource
	private ServiceClassDao dao;

	@Override
	public ServiceClassDao getDao() {
		return dao;
	}
}