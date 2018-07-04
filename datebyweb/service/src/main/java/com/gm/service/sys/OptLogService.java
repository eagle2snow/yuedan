package com.gm.service.sys;

import javax.annotation.Resource;

import com.gm.base.dao.sys.OptLogDao;
import com.gm.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.sys.OptLog;

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