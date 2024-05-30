package com.daylong.httplibrary.bean.request;

import java.io.Serializable;

public class MsgRequest implements Serializable {
    private String ctMsg;

    public MsgRequest(String ctMsg) {
        this.ctMsg = ctMsg;
    }

    public String getCtMsg() {
        return ctMsg;
    }

    public void setCtMsg(String ctMsg) {
        this.ctMsg = ctMsg;
    }
}
