package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.CommodityClassDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.CommodityClass;

@Transactional
@Service
public class CommodityClassService extends BaseService<CommodityClass, Integer> {
    @Resource
    private CommodityClassDao dao;

    @Override
    public CommodityClassDao getDao()
    {
        return dao;
    }
}