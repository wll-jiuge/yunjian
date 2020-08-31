package com.yunjian.entity;

import java.io.Serializable;
import java.util.List;

public class Personentity implements Serializable {

    /**
     * msg : ok
     * code : 0
     * name : 不知名的路人甲
     * sex : 男
     * company : 中国建筑第六工程局
     * role : 炮灰QAQ
     * department : 部门A
     * project : 项目A
     * programs : ["项目A","项目B","项目C"]
     */

    private String msg;
    private int code;
    private String name;
    private String sex;
    private String company;
    private String role;
    private String department;
    private String project;
    private List<String> programs;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public List<String> getPrograms() {
        return programs;
    }

    public void setPrograms(List<String> programs) {
        this.programs = programs;
    }
}
