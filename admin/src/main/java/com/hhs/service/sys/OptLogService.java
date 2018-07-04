package com.hhs.service.sys;

import javax.annotation.Resource;

import com.hhs.base.dao.sys.OptLogDao;
import com.hhs.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.sys.OptLog;

@Transactional
@Service
public class OptLogService extends BaseService<OptLog, Integer> {
    @Resource
    private OptLogDao dao;

    @Override
    public OptLogDao getDao()
    {
        return dao;
    }
}