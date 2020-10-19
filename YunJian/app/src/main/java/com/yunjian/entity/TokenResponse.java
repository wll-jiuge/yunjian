package com.yunjian.entity;

public class TokenResponse {

    /**
     * code : 0
     * data : {"token":"login_token_63702529-4fb5-44b5-9cd7-8385279b32b2"}
     * msg : 操作成功
     */

    private int code;
    private TokenEntity data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TokenEntity getData() {
        return data;
    }

    public void setData(TokenEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
