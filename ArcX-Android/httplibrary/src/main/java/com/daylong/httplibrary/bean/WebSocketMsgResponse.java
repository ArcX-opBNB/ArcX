package com.daylong.httplibrary.bean;

import java.io.Serializable;

public class WebSocketMsgResponse implements Serializable {

    private String ip; //ip
    private String port; 
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }


    public String getURL(){
        return "ws://" + getIp() + ":" + getPort() + "/websocket";

    }
}
