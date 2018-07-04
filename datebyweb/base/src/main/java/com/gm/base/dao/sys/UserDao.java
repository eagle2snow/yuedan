package com.gm.base.dao.sys;

import org.springframework.stereotype.Repository;

import com.gm.base.model.sys.User;
import com.gm.base.dao.BaseDao;

@Repository
public class UserDao extends BaseDao<User, Integer> {
    public User get(String username, String password)
    {
        return getOne("from user u where u.deleted=1 and u.username='" + username + " 'and u.password='" + password + "'");
    }
}