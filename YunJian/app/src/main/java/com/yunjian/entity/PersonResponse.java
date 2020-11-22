package com.yunjian.entity;

import java.io.Serializable;
import java.util.List;

public class PersonResponse implements Serializable {

    /**
     * code : 0
     * data : {"companyName":"公司名称1","deptName":"部门名称","prjName":["guest","guest2"],"roleName":"角色","userName":"guest","userSex":"男"}
     */

    private int code;
    private PersonEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public PersonEntity getData() {
        return data;
    }

    public void setData(PersonEntity data) {
        this.data = data;
    }

}
