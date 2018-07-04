package com.gm.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gm.base.consts.Const;
import com.gm.base.dto.ShotMessageDate;
import com.gm.base.dto.ShotMessageParameter;
import com.gm.utils.DateUtil;
import com.gm.utils.Md5Util;

public class ShotMessageService {

    public ShotMessageDate sendShotMessage(String mobile)
    {
        ShotMessageParameter messageParameter = new ShotMessageParameter();

        messageParameter.setUserid(Const.userId);

        String sign = Const.userName + Const.password + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String md5 = Md5Util.getMD5(sign);

        messageParameter.setSign(sign);

        return null;
    }

}
