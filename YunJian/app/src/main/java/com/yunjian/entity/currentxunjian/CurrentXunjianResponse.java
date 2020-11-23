package com.yunjian.entity.currentxunjian;

import java.io.Serializable;
import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.entity
 * @date on 2020/9/27
 * @describe  巡检当前任务响应
 */
public class CurrentXunjianResponse implements Serializable {


    /**
     * code : 0
     * data : [{"taskId":10,"taskName":"任务名称1","taskNote":"任务内容","taskTypeName":"任务类型名称"},{"taskId":18,"taskName":"测试任务名称4","taskNote":"测试日常任务的内容","taskTypeName":"任务类型名称"}]
     */

    private int code;
    private List<CurrentXunjianItemEntity> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<CurrentXunjianItemEntity> getData() {
        return data;
    }

    public void setData(List<CurrentXunjianItemEntity> data) {
        this.data = data;
    }
}
