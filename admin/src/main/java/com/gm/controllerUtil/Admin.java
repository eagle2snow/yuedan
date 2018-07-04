package com.gm.controllerUtil;

import com.gm.base.consts.Const;
import com.gm.base.model.sys.User;

import static com.gm.controllerUtil.Common.getRequest;

public class Admin {
    public static User getCurUser()
    {
        return (User) getRequest().getSession().getAttribute(Const.CUR_USER);
    }
}
