package com.yunjian.entity;

public class LoginResponse {

    /**
     * msg : succeed
     * code : 0
     * expire : 608455
     * token : JgiGlovgwDBGvaplieaqkvrtBGbAbga
     */

    private String msg;
    private int code;
    private int expire;
    private String token;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
