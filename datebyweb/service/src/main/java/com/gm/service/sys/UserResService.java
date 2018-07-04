package com.gm.service.sys;

import javax.annotation.Resource;

import com.gm.base.dao.sys.UserResDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.sys.UserRes;
import com.gm.service.BaseService;

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