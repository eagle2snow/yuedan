package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.AutoMsgTypeDao;
import com.hhs.base.dao.BaseDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.AutoMsgType;

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