package com.hhs.base;

import com.hhs.base.model.*;
import com.hhs.gencode.Build;

public class CreateCode {
    public static void main(String[] args) {
        /*
         * 生成选项 dao,s,c,add,update,list ，null则全部生成
         * ======================================================
         **/

        // Build.buildCode(Notice.class, "dao,s,c,add,update,list");
        // Build.buildCode(AutoMsgType.class, null);
        // Build.buildCode(TestTime.class, "update");
        try {
//			Build.buildCode(Dynamic.class, null);
//			Build.buildCode(Client.class, null);
//			Build.buildCode(Authentication.class, null);
//			Build.buildCode(Bill.class, null);
//			Build.buildCode(Cash.class, null);
//			Build.buildCode(Order.class, null);
//			Build.buildCode(Recharge.class, null);
//			Build.buildCode(Skill.class, null);
//			Build.buildCode(Education.class, null);
//			Build.buildCode(Work.class, null);
//            Build.buildCode(Authentication.class, "list");
//			Build.buildCode(Bill.class, "list");
//			Build.buildCode(Cash.class, "list");
//			Build.buildCode(Order.class, "list");
//			Build.buildCode(Recharge.class, "list");
//			Build.buildCode(Skill.class, "list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
