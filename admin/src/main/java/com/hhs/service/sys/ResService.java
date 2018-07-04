package com.hhs.service.sys;

import javax.annotation.Resource;

import com.hhs.base.dao.sys.ResDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.sys.Res;
import com.hhs.service.BaseService;

@Transactional
@Service
public class ResService extends BaseService<Res, Integer> {
	@Resource
	private ResDao dao;

	@Override
	public ResDao getDao()
	{
		return dao;
	}
}