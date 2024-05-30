package com.daylong.httplibrary.bean.request.user;

import java.io.Serializable;

/**

 */
public class TaskReceiveRequest implements Serializable {

    private int taskId;

    public TaskReceiveRequest(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
