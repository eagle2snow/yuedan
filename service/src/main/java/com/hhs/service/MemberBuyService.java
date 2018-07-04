package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.MemberBuyDao;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.MemberBuy;

@Transactional
public class MemberBuyService extends BaseService<MemberBuy, Integer> {
    @Resource
    private MemberBuyDao dao;

    @Override
    public MemberBuyDao getDao()
    {
        return dao;
    }
}