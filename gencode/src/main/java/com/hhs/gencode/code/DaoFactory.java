package com.hhs.gencode.code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.hhs.utils.IOStreamUtil;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DaoFactory {

    public DaoFactory(Class<?> cl)
    {
        this.cl = cl;
    }

    private Class<?> cl;
    private String tplName = "Dao.ftl";

    public void buildCode() throws IOException, TemplateException
    {
        Map<String, Object> map = new HashMap<>();
        String className = cl.getSimpleName();
        String daoPackage = cl.getPackage().getName().replaceAll("model", "dao");

        map.put("package", daoPackage);
        map.put("entityPackage", cl.getName());
        map.put("className", className);
        String projectJavaDir = System.getProperty("user.dir") + File.separator + "base\\src" + File.separator + "main"
                + File.separator + "java" + File.separator;
        String outPath = (projectJavaDir + daoPackage.replaceAll("\\.", "\\\\")) + File.separator;
        outPath.replace("base", "");
        File tplFile = new File(projectJavaDir.replace("base", "gencode") + "com\\hhs\\gencode\\tpl\\");

        TemplateLoader templateLoader = new FileTemplateLoader(tplFile);

        Configuration cfg = new Configuration();
        cfg.setTemplateLoader(templateLoader);
        File file = new File(outPath);
        IOStreamUtil.mkDir(file);

        String fileName = outPath + className + "Dao.java";
        Template temp = cfg.getTemplate(tplName);
        StringWriter out = new StringWriter();
        temp.process(map, out);

        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pwriter = new PrintWriter(fos);
        pwriter.write(out.toString());
        pwriter.close();
        fos.close();
    }
}
