package com.yunjian.entity;

public class BasicResponse {

    /**
     * code : 0
     * data : {"prjName":"guest","roleName":"角色","userName":"guest"}
     */

    private int code;
    private BasicEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BasicEntity getData() {
        return data;
    }

    public void setData(BasicEntity data) {
        this.data = data;
    }
}
