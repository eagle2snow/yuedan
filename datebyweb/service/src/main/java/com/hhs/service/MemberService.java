package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.BaseDao;
import com.hhs.base.dao.MemberDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.Member;

@Transactional
@Service
public class MemberService extends BaseService<Member, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Resource
    private MemberDao dao;


    @Override
    public BaseDao<Member, Integer> getDao()
    {
        return dao;
    }
}