package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.CommodityEvaluationDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.CommodityEvaluation;

@Transactional
@Service
public class CommodityEvaluationService extends BaseService<CommodityEvaluation, Integer> {
    @Resource
    private CommodityEvaluationDao dao;

    @Override
    public CommodityEvaluationDao getDao()
    {
        return dao;
    }
}