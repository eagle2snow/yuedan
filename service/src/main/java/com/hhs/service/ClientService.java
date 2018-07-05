package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Client;
import com.hhs.base.dao.ClientDao;

@Transactional
@Service
public class ClientService extends BaseService<Client, Integer> {
	@Resource
	private ClientDao dao;

	@Override
	public ClientDao getDao() {
		return dao;
	}
}