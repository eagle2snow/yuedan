package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.CartDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hhs.base.model.Cart;

@Transactional
@Service
public class CartService extends BaseService<Cart, Integer> {
    @Resource
    private CartDao dao;

    @Override
    public CartDao getDao()
    {
        return dao;
    }

    public boolean existCommodity(Integer memberId, Integer commodityId)
    {
        return dao.existCommodity(memberId, commodityId);
    }

    public Cart checkCommodityInCart(Integer memberId, Integer commodityId)
    {
        return dao.get(memberId, commodityId);
    }
}