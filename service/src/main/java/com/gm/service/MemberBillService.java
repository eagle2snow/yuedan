package com.gm.service;

import javax.annotation.Resource;

import com.gm.base.dao.BaseDao;
import com.gm.base.dao.MemberBillDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.MemberBill;

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