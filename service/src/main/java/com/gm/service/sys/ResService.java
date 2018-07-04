package com.gm.service.sys;

import javax.annotation.Resource;

import com.gm.base.dao.sys.ResDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.sys.Res;
import com.gm.service.BaseService;

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