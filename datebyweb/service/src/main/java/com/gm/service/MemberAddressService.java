package com.gm.service;

import javax.annotation.Resource;

import com.gm.base.dao.MemberAddressDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gm.base.model.MemberAddress;

@Transactional
@Service
public class MemberAddressService extends BaseService<MemberAddress, Integer> {
    @Resource
    private MemberAddressDao dao;

    @Override
    public MemberAddressDao getDao()
    {
        return dao;
    }

    public MemberAddress getMemberAddress(Integer memberId)
    {
        return dao.get(memberId);
    }

    public boolean updateAddressId(Integer memberId)
    {
        return dao.updateAddressId(memberId);
    }

    public void setDefault(Integer memberId)
    {
        dao.setDefault(memberId);
    }

    public boolean setAddress(Integer addressId)
    {
        return dao.setAddress(addressId);
    }
}