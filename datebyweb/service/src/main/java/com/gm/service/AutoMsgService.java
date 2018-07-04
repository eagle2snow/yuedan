package com.gm.service;

import javax.annotation.Resource;

import com.gm.base.dao.AutoMsgDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.AutoMsg;

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