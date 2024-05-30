package com.daylong.httplibrary.bean.request.user;

public class FeedbackRequest {
    private String opinionMsg;

    public String getContent() {
        return opinionMsg;
    }

    public void setContent(String content) {
        this.opinionMsg = content;
    }



    public FeedbackRequest(String content) {
        this.opinionMsg = content;
    }
}
