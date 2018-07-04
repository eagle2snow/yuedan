package com.gm.service;

import javax.annotation.Resource;

import com.gm.base.dao.AutoMsgTypeDao;
import com.gm.base.dao.BaseDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.AutoMsgType;

@Transactional
@Service
public class AutoMsgTypeService extends BaseService<AutoMsgType, Integer> {
    @Resource
    private AutoMsgTypeDao dao;

    @Override
    public BaseDao<AutoMsgType, Integer> getDao()
    {
        return dao;
    }
}