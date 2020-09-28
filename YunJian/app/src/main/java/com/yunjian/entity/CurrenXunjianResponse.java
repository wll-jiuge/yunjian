package com.yunjian.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.entity
 * @date on 2020/9/27
 * @describe  巡检当前任务响应
 */
/**
 * msg : ok
 * listCounts : 5
 * code : 0
 * list : [{"name":"aaa","method":"测试方法1","standard":"测试标准一","items":"aaa数据项内容"},{"name":"bbb","method":"测试方法2","standard":"测试标准二","items":"bbb数据项内容"},{"name":"ccc","method":"测试方法3","standard":"测试标准三","items":"ccc数据项内容"},{"name":"ddd","method":"测试方法4","standard":"测试标准四","items":"ddd数据项内容"},{"name":"eee","method":"测试方法5","standard":"测试标准五","items":"eee数据项内容"}]
 */
public class CurrenXunjianResponse implements Serializable {
    private String msg;
    private int listCounts;
    private int code;
    private List<CurrentXunjianItemEntity> list;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getListCounts() {
        return listCounts;
    }

    public void setListCounts(int listCounts) {
        this.listCounts = listCounts;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<CurrentXunjianItemEntity> getList() {
        return list;
    }

    public void setList(List<CurrentXunjianItemEntity> list) {
        this.list = list;
    }

}
