package com.hhs.gencode.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.hhs.gencode.annotation.FormField;
import com.hhs.gencode.annotation.M;
import com.hhs.gencode.annotation.Verification;

public class FieldAnnotationUtil {

    public static List<FieldAnnotation> list(Class cl)
    {
        List<FieldAnnotation> list = new ArrayList<>();
        Field[] ffs = cl.getSuperclass().getDeclaredFields();
        Field[] fs = cl.getDeclaredFields();
        List<Field> li = new ArrayList<Field>(Arrays.asList(ffs));
        li.addAll(Arrays.asList(fs));
        M m = (M) cl.getAnnotation(M.class);

        for (Field f : li) {
            FormField ffd = f.getAnnotation(FormField.class);
            Verification vft = f.getAnnotation(Verification.class);

            if (ffd != null || vft != null) {

                FieldAnnotation fat = new FieldAnnotation();
                fat.setFieldName(f.getName());

                System.out.println(f.getName() + "-----------");

                if (ffd != null) {
                    fat.setName(ffd.name());
                    fat.setSort(ffd.sort());
                    fat.setType(ffd.type());
                    fat.setLable(ffd.label());
                    fat.setData(ffd.data());
                    fat.setDataNature(ffd.dataNature());
                    fat.setShow(ffd.show());

                    if (ffd.dataNature().equals(DataNature.ARRAY)) {
                        Map<String, String> map = strToMap(ffd.data());
                        fat.setDataArray(map);
                        fat.setJson(JSON.toJSONString(map));
                    } else if (ffd.dataNature().equals(DataNature.MODEL)) {
                        fat.setDs(ffd.ds());
                    }

                }
                if (vft != null) {
                    fat.setDatatype(vft.datatype());
                    fat.setErrormsg(vft.errormsg());
                    fat.setRecheck(vft.recheck());
                    fat.setAjaxurl(vft.ajaxurl());
                    fat.setSucmsg(vft.sucmsg());
                    fat.setNullmsg(vft.nullmsg());
                    fat.setIgnore(vft.ignore());
                    fat.setTip(vft.tip());
                    fat.setAltercss(vft.altercss());
                    fat.setPlugin(vft.plugin());
                }
                fat.setM(m.value());
                list.add(fat);
            }
        }

        Collections.sort(list, (a1, a2) -> a1.getSort().compareTo(a2.getSort()));

        return list;
    }

    public static Map<String, String> strToMap(String str)
    {
        if (str == null || str.equals("")) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        String[] strArray = str.split(",");
        for (String string : strArray) {
            String[] sArray = string.split("\\|");
            map.put(sArray[0], sArray[1]);
        }
        return map;
    }

}
