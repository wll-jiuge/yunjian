package com.yunjian.entity.currentxunjian;

import java.io.Serializable;

/**
 * @author 吴立柳
 * @package com.yunjian.entity
 * @date on 2020/9/27
 * @describe 巡检当前任务列表实体
 */
public class CurrentXunjianItemEntity implements Serializable{
    /**
     * taskId : 10
     * taskName : 任务名称1
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
