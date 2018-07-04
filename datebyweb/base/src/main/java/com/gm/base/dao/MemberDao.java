package com.gm.base.dao;

import org.springframework.stereotype.Repository;
import com.gm.base.model.Member;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MemberDao extends BaseDao<Member, Integer> {
    public void updateBalance(BigDecimal amount, Integer memberId)
    {
        updateByHql("update member m set m.balance=m.balance+" + amount + " where m.id=" + memberId);
    }

    public List<Member> notVip(String gId)
    {
        return listByHQL(String.format("from member m where m.deleted=1 and m.referrerGeneralizeId='%s' and m.setMeal=1", gId));
    }

    public List<Member> vip(String gId)
    {
        return listByHQL(String.format("from member m where m.deleted=1 and m.referrerGeneralizeId='%s' and (m.setMeal=2 or m.setMeal=3)", gId));
    }
}