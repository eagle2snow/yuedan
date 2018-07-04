package com.hhs.base.dao;

import com.hhs.base.enums.MsgCatEnum;
import org.springframework.stereotype.Repository;
import com.hhs.base.model.Msg;

import java.util.List;

@Repository
public class MsgDao extends BaseDao<Msg, Integer> {
    public List<Msg> getMsg(Integer userId, Integer memberId)
    {
        return listByHQL(" from msg b where ( b.fromId=" + userId + " and b.toId=" + memberId + ") or ( b.fromId="
                + memberId + " and b.toId=" + userId + ") order by id asc");
    }

    public List<Msg> getMsg(Integer memberId)
    {
        return listByHQL(" from msg b where ( b.toId=" + memberId + ") or ( b.fromId=" + memberId + ") order by id asc");
    }

    public List<Msg> getMsg()
    {
        return listByHQL(" from msg m where m.cat='" + MsgCatEnum.MEMBER_TO_KF + "' and m.readed=1");
    }
}