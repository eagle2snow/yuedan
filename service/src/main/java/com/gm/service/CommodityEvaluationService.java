package com.gm.service;

import javax.annotation.Resource;

import com.gm.base.dao.CommodityEvaluationDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.CommodityEvaluation;

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