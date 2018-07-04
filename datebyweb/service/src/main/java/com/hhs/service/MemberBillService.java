package com.hhs.service;

import javax.annotation.Resource;

import com.hhs.base.dao.BaseDao;
import com.hhs.base.dao.MemberBillDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.MemberBill;

@Transactional
@Service
public class MemberBillService extends BaseService<MemberBill, Integer> {
    @Resource
    private MemberBillDao dao;

    @Override
    public BaseDao<MemberBill, Integer> getDao()
    {
        return dao;
    }
}