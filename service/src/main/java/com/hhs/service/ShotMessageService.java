package com.hhs.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hhs.base.consts.Const;
import com.hhs.base.dto.ShotMessageDate;
import com.hhs.base.dto.ShotMessageParameter;
import com.hhs.utils.Md5Util;

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
