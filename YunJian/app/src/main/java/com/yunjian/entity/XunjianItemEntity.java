package com.yunjian.entity;

import java.io.Serializable;

public class XunjianItemEntity implements Serializable {
    /**
     * name : aaa
     * method : 测试方法1
     * standard : 测试标准一
     * items : aaa数据项内容
     */

    private String name;
    private String method;
    private String standard;
    private String items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
