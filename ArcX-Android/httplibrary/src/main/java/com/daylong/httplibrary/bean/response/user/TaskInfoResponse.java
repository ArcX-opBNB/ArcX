package com.daylong.httplibrary.bean.response.user;

public class TaskInfoResponse {

    private Integer taskId; 
    private String taskImgUrl; 
    private String taskDesc; 
    private Integer completeNum; 
    private Integer totalNum; 
    private Integer completeFlag; 
    private Integer receiveFlag;

    public boolean isCompleteFlag() {
        return completeFlag == 1;
    }

    public boolean isReceiveFlag() {
        return receiveFlag == 1;
    }

    
    public boolean isComplete() {
        return isCompleteFlag() && isReceiveFlag();
    }

    public boolean isReceive() {
        return isCompleteFlag() && !isReceiveFlag();
    }

    public String getPdStr() {
        return completeNum + "/" + totalNum;
    }

    public int getDP() {
        return completeNum / totalNum * 100;

    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskImgUrl() {
        return taskImgUrl;
    }

    public void setTaskImgUrl(String taskImgUrl) {
        this.taskImgUrl = taskImgUrl;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public Integer getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(Integer completeNum) {
        this.completeNum = completeNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(Integer completeFlag) {
        this.completeFlag = completeFlag;
    }

    public Integer getReceiveFlag() {
        return receiveFlag;
    }

    public void setReceiveFlag(Integer receiveFlag) {
        this.receiveFlag = receiveFlag;
    }

    public String getBtnText() {
        if (isComplete()) {

        } else {
            if (isCompleteFlag()) {


            } else {

            }
        }
    }
}
