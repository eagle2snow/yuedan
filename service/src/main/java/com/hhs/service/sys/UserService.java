package com.hhs.service.sys;

import javax.annotation.Resource;
import com.hhs.base.dao.sys.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.base.model.sys.User;
import com.hhs.service.BaseService;

@Transactional
@Service
public class UserService extends BaseService<User, Integer> {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserDao dao;

    @Override
    public UserDao getDao()
    {
        return dao;
    }

    public User login(String username, String password)
    {
        return dao.get(username, password);
    }

}