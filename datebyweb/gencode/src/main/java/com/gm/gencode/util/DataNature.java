package com.gm.gencode.util;

/**
 * 动态或者静态
 *
 * @author Administrator
 */
public enum DataNature {
    ARRAY("array"), MODEL("model");

    DataNature(String value)
    {
        this.value = value;
    }

    private String value;

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
