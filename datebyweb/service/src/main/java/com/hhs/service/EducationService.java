package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Education;
import com.hhs.base.dao.EducationDao;

@Transactional
@Service
public class EducationService extends BaseService<Education, Integer> {
	@Resource
	private EducationDao dao;

	@Override
	public EducationDao getDao() {
		return dao;
	}
}