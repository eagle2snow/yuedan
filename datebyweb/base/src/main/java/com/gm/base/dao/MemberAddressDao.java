package com.gm.base.dao;

import org.springframework.stereotype.Repository;
import com.gm.base.model.MemberAddress;


@Repository
public class MemberAddressDao extends BaseDao<MemberAddress, Integer> {
    public MemberAddress get(Integer memberId)
    {
        return getOne("from memberAddress m where m.member.id=" + memberId + " and m.deleted=1 and m.enable=1 and m.defaultAddress=1");
    }

    public boolean updateAddressId(Integer memberId)
    {
        return updateByHql("update memberAddress a set a.defaultAddress=2 where a.member.id=" + memberId);
    }

    public void setDefault(Integer memberId)
    {
        updateByHql("update memberAddress addr set addr.defaultAddress = 2 where addr.member.id = " + memberId);
    }

    public boolean setAddress(Integer addressId)
    {
        return updateByHql("update memberAddress addr set addr.defaultAddress = 1 where addr.id = " + addressId);
    }
}