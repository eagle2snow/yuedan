package com.gm.gencode.util;

public enum FieldType {

    /**
     * 开关类型
     */
    ONOFF("onoff"),
    /**
     * text 类型
     */
    TEXTINPUT("textinput"),

    /**
     * 图片类型
     */
    PICTURE("picture"),

    /**
     * 图片集合类型
     */
    PICTURELIST("picturelist"),

    /**
     * 数字
     */
    NUMBER("munber"),

    /**
     * 编辑器
     */

    EDITOR("editor"),

    /**
     * 文本输入框
     */
    TEXTAREA("textarea"),

    /**
     * 复选框
     */
    CHECKBOX("checkbox"),

    /**
     * 文件
     */
    FILE("file"),

    /**
     * 隐藏域
     */
    HIDDEN("hidden"),
    /**
     * 单选框
     */
    RADIO("radio"),

    /**
     * 密码
     */
    PASSWORD("password"),
    /**
     * 时间
     */
    TIME("time"),

    /**
     * 选择框
     */
    SELECT("select"),

    /**
     * 树
     */
    TREE("tree"),

    /**
     * 忽略
     */
    IGNORE("ignore");

    private String value;

    private FieldType(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
