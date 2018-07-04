package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.CommoditySpecificationDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.CommoditySpecification;

@Transactional
@Service
public class CommoditySpecificationService extends BaseService<CommoditySpecification, Integer> {
    @Resource
    private CommoditySpecificationDao dao;

    @Override
    public CommoditySpecificationDao getDao()
    {
        return dao;
    }
}