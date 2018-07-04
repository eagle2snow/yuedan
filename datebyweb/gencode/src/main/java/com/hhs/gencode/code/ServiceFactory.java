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

public class ServiceFactory {

    public ServiceFactory(Class<?> cl)
    {
        this.cl = cl;
    }

    private Class<?> cl;
    private String tplName = "Service.ftl";

    public void buildCode() throws IOException, TemplateException
    {
        Map<String, Object> map = new HashMap<>();
        String entityPackage = cl.getName();
        String className = cl.getSimpleName();
        String servicePackage = entityPackage.replaceAll("model", "service").replaceAll(className, "");
        servicePackage = servicePackage.substring(0, servicePackage.length() - 1);
        String daoPackage = servicePackage.replaceAll("impl", className + "Dao").replaceAll("service", "dao");

        map.put("package", servicePackage.replace(".base", ""));
        map.put("daoPackage", daoPackage);
        map.put("entityPackage", entityPackage);
        map.put("className", className);                                          // 这里要根据svn路径看是否加hhs-base
        String projectJavaDir = System.getProperty("user.dir") + File.separator + "hhs-base\\src" + File.separator + "main"
                + File.separator + "java" + File.separator;
        String outPath = (projectJavaDir + servicePackage.replaceAll("\\.", "\\\\")) + File.separator;
        outPath.replace("base", "");
        File tplFile = new File(projectJavaDir.replace("hhs-base", "hhs-gencode") + "com\\gm\\gencode\\tpl\\");

        TemplateLoader templateLoader = new FileTemplateLoader(tplFile);
        @SuppressWarnings("deprecation")
        Configuration cfg = new Configuration();
        cfg.setTemplateLoader(templateLoader);
        outPath = outPath.replaceAll("\\\\hhs-base\\\\", "\\\\hhs-service\\\\");
        outPath = outPath.replace("\\base", "");
        File file = new File(outPath);
        IOStreamUtil.mkDir(file);

        String fileName = outPath + className + "Service.java";
        Template temp = cfg.getTemplate(this.tplName);
        StringWriter out = new StringWriter();
        temp.process(map, out);

        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter pwriter = new PrintWriter(fos);
        pwriter.write(out.toString());
        pwriter.close();
        fos.close();
    }

}
