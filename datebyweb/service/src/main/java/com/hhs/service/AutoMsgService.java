package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.AutoMsgDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.AutoMsg;

@Transactional
@Service
public class AutoMsgService extends BaseService<AutoMsg, Integer> {
    @Resource
    private AutoMsgDao dao;

    @Override
    public AutoMsgDao getDao()
    {
        return dao;
    }
}