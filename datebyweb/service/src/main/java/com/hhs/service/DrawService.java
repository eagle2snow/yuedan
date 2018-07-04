package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.DrawDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.Draw;

@Transactional
@Service
public class DrawService extends BaseService<Draw, Integer> {
    @Resource
    private DrawDao dao;

    @Override
    public DrawDao getDao()
    {
        return dao;
    }
}