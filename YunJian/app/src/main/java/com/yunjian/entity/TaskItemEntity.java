package com.yunjian.entity;

import java.io.Serializable;

public class TaskItemEntity implements Serializable {
    /**
     * inspItemId : 0
     * taskId : 0
     * taskName : string
     * taskNote : string
     * taskPlanDate : 2020-10-21T12:27:35.305Z
     * taskTypeName : string
     * userId : 0
     */

    private int inspItemId;
    private int taskId;
    private String taskName;
    private String taskNote;
    private String taskPlanDate;
    private String taskTypeName;
    private int userId;

    public int getInspItemId() {
        return inspItemId;
    }

    public void setInspItemId(int inspItemId) {
        this.inspItemId = inspItemId;
    }

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

    public String getTaskPlanDate() {
        return taskPlanDate;
    }

    public void setTaskPlanDate(String taskPlanDate) {
        this.taskPlanDate = taskPlanDate;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
