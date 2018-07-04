package com.gm.base.dao;

import org.springframework.stereotype.Repository;
import com.gm.base.model.Cart;

@Repository
public class CartDao extends BaseDao<Cart, Integer> {
    public boolean existCommodity(Integer memberId, Integer commodityId)
    {
        Long i = countByHQL(" from cart c where c.member.id=" + memberId + " and c.commodity.id=" + commodityId);
        return i > 0;
    }

    public Cart get(Integer memberId, Integer commodityId)
    {
        return getOne(" from cart c where c.member.id=" + memberId + " and c.commodity.id=" + commodityId);
    }
}