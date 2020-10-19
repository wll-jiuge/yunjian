package com.yunjian.entity;

import java.io.Serializable;

public class PicResponse implements Serializable {

    /**
     * code : 0
     * data : {"img_src":"data:image/png;base64,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","token":"VI_8e3bb686-7d14-4485-ba9a-a6d1a7fff982"}
     * msg : 操作成功
     */

    private int code;
    private Picentity data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Picentity getData() {
        return data;
    }

    public void setData(Picentity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
