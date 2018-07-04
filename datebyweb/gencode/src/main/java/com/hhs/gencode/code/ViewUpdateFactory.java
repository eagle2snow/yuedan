package com.hhs.gencode.code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hhs.gencode.util.FieldAnnotation;
import com.hhs.gencode.util.FieldAnnotationUtil;
import com.hhs.utils.IOStreamUtil;
import com.hhs.utils.StringUtil;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ViewUpdateFactory {

    public ViewUpdateFactory(Class<?> cl)
    {
        this.cl = cl;
    }

    private Class<?> cl;
    private String tplName = "update.ftl";

    public Class<?> getCl()
    {
        return cl;
    }

    public void setCl(Class<?> cl)
    {
        this.cl = cl;
    }

    public void buildCode() throws IOException, TemplateException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        String entityPackage = this.getCl().getName();
        String entitySimpleName = this.getCl().getSimpleName();

        String viewPath = entityPackage;
        String tempView = viewPath.substring(viewPath.lastIndexOf("."), viewPath.length());
        viewPath = viewPath.replace(tempView, "");
        String tempView2 = viewPath.substring(viewPath.lastIndexOf("."), viewPath.length());
        viewPath = (tempView2 + StringUtil.firstLetterToLowercase(tempView)).replaceFirst("\\.", "").replace(".", "\\");

        List<FieldAnnotation> list = FieldAnnotationUtil.list(getCl());

        map.put("list", list);
        map.put("package", entityPackage.replaceAll("model", "dao").replaceAll("." + entitySimpleName, ""));
        map.put("entityPackage", entityPackage);
        map.put("entitySimpleName", entitySimpleName);                             //这里要根据svn路径看是否加hhs-base
        String projectJavaDir = System.getProperty("user.dir") + File.separator + "hhs-base\\src" + File.separator + "main"
                + File.separator + "webapp" + File.separator + "WEB-INF" + File.separator + "views" + File.separator;
        String outPath = projectJavaDir + "admin\\" + viewPath;             //这里要根据svn路径看是否加hhs-base
        String tplPath = System.getProperty("user.dir") + File.separator + "hhs-base\\src" + File.separator + "main"
                + File.separator + "java" + File.separator + "com\\gm\\gencode\\tpl\\";
        tplPath = tplPath.replace("hhs-base", "hhs-gencode");
        File tplFile = new File(tplPath);
        TemplateLoader templateLoader = new FileTemplateLoader(tplFile);
        @SuppressWarnings("deprecation")
        Configuration cfg = new Configuration();
        cfg.setTemplateLoader(templateLoader);
        outPath = outPath.replace("hhs-base", "hhs-main");
        File file = new File(outPath.toLowerCase());


        IOStreamUtil.mkDir(file);
        String fileName = outPath + File.separator + "update.jsp";
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
