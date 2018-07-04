package com.gm.service;

import javax.annotation.Resource;

import com.gm.base.dao.OrderItemDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.OrderItem;

@Transactional
@Service
public class OrderItemService extends BaseService<OrderItem, Integer> {
    @Resource
    private OrderItemDao dao;

    @Override
    public OrderItemDao getDao()
    {
        return dao;
    }
}