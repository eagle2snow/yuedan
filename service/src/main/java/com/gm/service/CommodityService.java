package com.gm.service;

import javax.annotation.Resource;

import com.gm.base.dao.CommodityDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.Commodity;

@Transactional
@Service
public class CommodityService extends BaseService<Commodity, Integer> {
    @Resource
    private CommodityDao dao;

    @Override
    public CommodityDao getDao()
    {
        return dao;
    }
}