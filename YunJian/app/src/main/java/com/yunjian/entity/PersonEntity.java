package com.yunjian.entity;

import java.io.Serializable;
import java.util.List;

public  class PersonEntity implements Serializable {
    /**
     * companyName : 公司名称1
     * deptName : 部门名称
     * prjName : ["guest","guest2"]
     * roleName : 角色
     * userName : guest
     * userSex : 男
     */

    private String companyName;
    private String deptName;
    private String roleName;
    private String userName;
    private String userSex;
    private List<String> prjName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public List<String> getPrjName() {
        return prjName;
    }

    public void setPrjName(List<String> prjName) {
        this.prjName = prjName;
    }
}
