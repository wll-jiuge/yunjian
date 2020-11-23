package com.yunjian.entity.finishxunjian;

import java.io.Serializable;

/**
 * @author 吴立柳
 * @package com.yunjian.entity.finishxunjian
 * @date on 2020/11/20
 * @describe 巡检已完成实体
 */
public class FinishXunjianDetailEntity implements Serializable {
    /**
     * taskName : 任务名称1
     * taskResultDesc : 任务描述
     */

    private String taskName;
    private String taskResultDesc;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskResultDesc() {
        return taskResultDesc;
    }

    public void setTaskResultDesc(String taskResultDesc) {
        this.taskResultDesc = taskResultDesc;
    }
}
