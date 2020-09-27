package com.yunjian.entity;

import java.io.Serializable;

/**
 * @author 吴立柳
 * @package com.yunjian.entity
 * @date on 2020/9/27
 * @describe 巡检当前任务列表实体
 */
public class CurrentXunjianItemEntity implements Serializable{
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
