package com.hhs.controllerUtil;

import com.hhs.base.consts.Const;
import com.hhs.base.model.sys.User;

import static com.hhs.controllerUtil.Common.getRequest;

public class Admin {
    public static User getCurUser()
    {
        return (User) getRequest().getSession().getAttribute(Const.CUR_USER);
    }
}
