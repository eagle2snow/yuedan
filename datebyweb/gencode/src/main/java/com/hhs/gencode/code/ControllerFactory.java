package com.hhs.gencode.code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hhs.gencode.util.FieldAnnotation;
import com.hhs.gencode.util.FieldAnnotationUtil;
import com.hhs.utils.IOStreamUtil;
import com.hhs.utils.StringUtil;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ControllerFactory {

    public ControllerFactory(Class<?> cl)
    {
        this.cl = cl;
    }

    private Class<?> cl;
    private String tplName = "Controller.ftl";

    public void buildCode() throws IOException, TemplateException
    {
        Map<String, Object> map = new HashMap<>();
        String packageName = cl.getPackage().getName().replace("base", "admin").replace("model", "controller");
        String servicePackage = packageName.replace("admin", "service").replace(".controller", "");
        String path = cl.getName().replace("base", "admin").replaceAll("com.hhs.", "").replaceAll("model.", "").toLowerCase()
                .replaceAll("\\.", "\\/") + "/";
        String view = "app/" + path;

        String perm = cl.getName().replaceAll("com.hhs.", "").replaceAll("model.", "").toLowerCase().replaceAll("\\.", ":");
        perm = perm.replaceAll("base", "admin");
        String addPerm = perm + ":add";
        String showPerm = perm + ":show";
        String updatePerm = perm + ":update";
        String deletePerm = perm + ":delete";

        map.put("addPerm", addPerm);
        map.put("showPerm", showPerm);
        map.put("updatePerm", updatePerm);
        map.put("deletePerm", deletePerm);
        map.put("path", path);
        map.put("view", view);
        map.put("controllerName", cl.getSimpleName());

        map.put("package", packageName);
        map.put("servicePackage", servicePackage);

        map.put("entityPackage", cl.getName());
        map.put("entitySimpleName", cl.getSimpleName());
        map.put("entityName", StringUtil.firstLetterToLowercase(cl.getSimpleName()));

        List<FieldAnnotation> list = FieldAnnotationUtil.list(cl);

        Map<Class, String> models = new HashMap<>();
        for (FieldAnnotation fa : list) {
            if (null != fa.getDs())
                models.put(fa.getDs(), fa.getFieldName());
        }

        String addMap = "";
        String services = "";
        for (Entry<Class, String> e : models.entrySet()) {
            String s = "map.put(\"" + e.getValue() + "List\"," + e.getValue() + "Service" + ".list());";
            addMap += s;
            String service = "@Resource\n    private " + e.getKey().getSimpleName() + "Service " + e.getValue() + "Service;\n";
            services += service;
        }

        map.put("addMap", addMap);
        map.put("services", services);

        String workspace = System.getProperty("user.dir").replaceAll("base", "");
        String projectJavaDir = workspace + File.separator + "admin" + File.separator + "src" + File.separator + "main"
                + File.separator + "java" + File.separator;
        String outPath = (packageName.replaceAll("\\.", "\\\\")) + File.separator;
        outPath = projectJavaDir + outPath;

        projectJavaDir = projectJavaDir.replace("admin", "gencode");
        File tplFile = new File(projectJavaDir + "com\\hhs\\gencode\\tpl\\");

        TemplateLoader templateLoader = new FileTemplateLoader(tplFile);

        Configuration cfg = new Configuration();
        cfg.setTemplateLoader(templateLoader);
        File file = new File(outPath);
        IOStreamUtil.mkDir(file);
        String fileName = outPath + cl.getSimpleName() + "Controller.java";
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
