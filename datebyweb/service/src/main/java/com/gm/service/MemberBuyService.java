package com.gm.service;

import javax.annotation.Resource;

import com.gm.base.dao.MemberBuyDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.MemberBuy;

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