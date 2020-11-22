package com.yunjian.entity;

import java.io.Serializable;
import java.util.List;
public class TaskItemResponse implements Serializable {

    /**
     * code : 0
     * data : [{"inspItemId":0,"taskId":0,"taskName":"string","taskNote":"string","taskPlanDate":"2020-10-21T12:27:35.305Z","taskTypeName":"string","userId":0}]
     * msg : string
     */

    private int code;
    private String msg;
    private List<TaskItemEntity> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<TaskItemEntity> getData() {
        return data;
    }

    public void setData(List<TaskItemEntity> data) {
        this.data = data;
    }

    public List<TaskItemEntity> getList() {
        return data;
    }
}
