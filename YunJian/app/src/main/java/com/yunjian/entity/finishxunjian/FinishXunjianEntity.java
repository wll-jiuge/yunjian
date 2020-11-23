package com.yunjian.entity.finishxunjian;

import java.io.Serializable;

/**
 * @author 吴立柳
 * @package com.yunjian.entity.finishxunjian
 * @date on 2020/11/19
 * @describe 已完成任务响应实体
 */
public class FinishXunjianEntity implements Serializable {
    /**
     * taskId : 11
     * taskName : 任务名称2
     * taskNote : 任务内容
     * taskTypeName : 任务类型名称
     */

    private int taskId;
    private String taskName;
    private String taskNote;
    private String taskTypeName;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskNote() {
        return taskNote;
    }

    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }
}
