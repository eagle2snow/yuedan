package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Order;
import com.hhs.base.dao.OrderDao;

@Transactional
@Service
public class OrderService extends BaseService<Order, Integer> {
	@Resource
	private OrderDao dao;

	@Override
	public OrderDao getDao() {
		return dao;
	}
}