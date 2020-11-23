package com.yunjian.entity.finishxunjian;

import java.io.Serializable;
import java.util.List;

/**
 * @author 吴立柳
 * @package com.yunjian.entity.finishxunjian
 * @date on 2020/11/19
 * @describe 已完成任务请求相应
 */
public class FinishXunjianResponse implements Serializable {

    /**
     * code : 0
     * data : [{"taskId":11,"taskName":"任务名称2","taskNote":"任务内容","taskTypeName":"任务类型名称"}]
     */

    private int code;
    private List<FinishXunjianEntity> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<FinishXunjianEntity> getData() {
        return data;
    }

    public void setData(List<FinishXunjianEntity> data) {
        this.data = data;
    }
}
