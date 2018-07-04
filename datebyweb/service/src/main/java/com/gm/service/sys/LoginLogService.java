package com.gm.service.sys;

import javax.annotation.Resource;

import com.gm.base.dao.sys.LoginLogDao;
import com.gm.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.sys.LoginLog;

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