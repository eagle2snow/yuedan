package com.gm.service;

import javax.annotation.Resource;

import com.gm.base.dao.CommoditySpecificationDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.CommoditySpecification;

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