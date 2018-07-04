package com.hhs.base.dao.sys;

import org.springframework.stereotype.Repository;

import com.hhs.base.model.sys.User;
import com.hhs.base.dao.BaseDao;

@Repository
public class UserDao extends BaseDao<User, Integer> {
    public User get(String username, String password)
    {
        return getOne("from user u where u.deleted=1 and u.username='" + username + " 'and u.password='" + password + "'");
    }
}