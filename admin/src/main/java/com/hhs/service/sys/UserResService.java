package com.hhs.service.sys;

import javax.annotation.Resource;

import com.hhs.base.dao.sys.UserResDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.sys.UserRes;
import com.hhs.service.BaseService;

@Transactional
@Service
public class UserResService extends BaseService<UserRes, Integer> {
    @Resource
    private UserResDao dao;

    @Override
    public UserResDao getDao()
    {
        return dao;
    }
}