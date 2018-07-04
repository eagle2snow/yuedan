package com.gm.base.dao;

import org.springframework.stereotype.Repository;
import com.gm.base.model.Order;

import java.util.List;


@Repository
public class OrderDao extends BaseDao<Order, Integer> {
    public void update(Integer addressId, Integer orderId)
    {
        updateByHql(String.format("update order o set o.memberAddress.id = %d where o.id = %d", addressId, orderId));
    }

    public List<Order> getOrder(Integer status, Integer memberId)
    {
        String hql = "from order o where o.member.id=" + memberId + " and o.deleted=1";
        if (status != 0)
            hql += " and o.status=" + status;
        return listByHQL(hql);
    }
}