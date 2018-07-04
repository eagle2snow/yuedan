package com.gm.gencode.util;

import java.util.Map;

public class FieldAnnotation {
    private String name;
    private Integer sort;
    private String lable;
    private FieldType type;
    private String datatype;
    private String errormsg;
    private String fieldName;
    private boolean show;
    private String recheck;
    private String ajaxurl;
    private String sucmsg;
    private String nullmsg;
    private String ignore;
    private String tip;
    private String altercss;
    private String plugin;
    private DataNature dataNature;
    private String data;
    private Class ds;
    private String json;
    private String m;

    private Map<String, String> dataArray;

    public Map<String, String> getDataArray()
    {
        return dataArray;
    }

    public void setDataArray(Map<String, String> dataArray)
    {
        this.dataArray = dataArray;
    }

    public String getRecheck()
    {
        return recheck;
    }

    public void setRecheck(String recheck)
    {
        this.recheck = recheck;
    }

    public String getAjaxurl()
    {
        return ajaxurl;
    }

    public void setAjaxurl(String ajaxurl)
    {
        this.ajaxurl = ajaxurl;
    }

    public String getSucmsg()
    {
        return sucmsg;
    }

    public void setSucmsg(String sucmsg)
    {
        this.sucmsg = sucmsg;
    }

    public String getNullmsg()
    {
        return nullmsg;
    }

    public void setNullmsg(String nullmsg)
    {
        this.nullmsg = nullmsg;
    }

    public String getIgnore()
    {
        return ignore;
    }

    public void setIgnore(String ignore)
    {
        this.ignore = ignore;
    }

    public String getTip()
    {
        return tip;
    }

    public void setTip(String tip)
    {
        this.tip = tip;
    }

    public String getAltercss()
    {
        return altercss;
    }

    public void setAltercss(String altercss)
    {
        this.altercss = altercss;
    }

    public String getPlugin()
    {
        return plugin;
    }

    public void setPlugin(String plugin)
    {
        this.plugin = plugin;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getSort()
    {
        return sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public String getLable()
    {
        return lable;
    }

    public void setLable(String lable)
    {
        this.lable = lable;
    }

    public FieldType getType()
    {
        return type;
    }

    public void setType(FieldType type)
    {
        this.type = type;
    }

    public String getDatatype()
    {
        return datatype;
    }

    public void setDatatype(String datatype)
    {
        this.datatype = datatype;
    }

    public String getErrormsg()
    {
        return errormsg;
    }

    public void setErrormsg(String errormsg)
    {
        this.errormsg = errormsg;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public DataNature getDataNature()
    {
        return dataNature;
    }

    public void setDataNature(DataNature dataNature)
    {
        this.dataNature = dataNature;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public Class getDs()
    {
        return this.ds;
    }

    public void setDs(Class ds)
    {
        this.ds = ds;
    }

    @Override
    public String toString()
    {
        return "FieldAnnotation [name=" + name + ", sort=" + sort + ", lable=" + lable + ", type=" + type
                + ", datatype=" + datatype + ", errormsg=" + errormsg + ", fieldName=" + fieldName + ", show=" + show
                + "]";
    }

    public boolean isShow()
    {
        return this.show;
    }

    public void setShow(boolean show)
    {
        this.show = show;
    }

    public String getJson()
    {
        return json;
    }

    public void setJson(String json)
    {
        this.json = json;
    }

    public String getM()
    {
        return m;
    }

    public void setM(String m)
    {
        this.m = m;
    }


}
