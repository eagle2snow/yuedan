package com.gm.gencode;

import java.io.IOException;
import java.util.List;

import com.gm.gencode.code.ControllerFactory;
import com.gm.gencode.code.DaoFactory;
import com.gm.gencode.code.ServiceFactory;
import com.gm.gencode.code.ViewAdderFactory;
import com.gm.gencode.code.ViewManagerFactory;
import com.gm.gencode.code.ViewUpdateFactory;
import com.gm.utils.StringUtil;

import freemarker.template.TemplateException;

public class Build {
    public static void buildCode(Class cl, String buiders) throws IOException, TemplateException
    {
        if (buiders == null) {
            new ControllerFactory(cl).buildCode();
            new DaoFactory(cl).buildCode();
            new ServiceFactory(cl).buildCode();
            new ViewAdderFactory(cl).buildCode();
            new ViewUpdateFactory(cl).buildCode();
            new ViewManagerFactory(cl).buildCode();
        } else {
            List<String> lists = StringUtil.toStringList(buiders, ",");
            if (lists.contains("c"))
                new ControllerFactory(cl).buildCode();
            if (lists.contains("dao"))
                new DaoFactory(cl).buildCode();
            if (lists.contains("s"))
                new ServiceFactory(cl).buildCode();
            if (lists.contains("add"))
                new ViewAdderFactory(cl).buildCode();
            if (lists.contains("update"))
                new ViewUpdateFactory(cl).buildCode();
            if (lists.contains("list"))
                new ViewManagerFactory(cl).buildCode();
        }
    }

}
