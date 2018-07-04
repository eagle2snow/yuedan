package com.hhs.service.sys;

import javax.annotation.Resource;

import com.hhs.base.dao.sys.LoginLogDao;
import com.hhs.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.sys.LoginLog;

@Transactional
@Service
public class LoginLogService extends BaseService<LoginLog, Integer> {
    @Resource
    private LoginLogDao dao;

    @Override
    public LoginLogDao getDao()
    {
        return dao;
    }
}