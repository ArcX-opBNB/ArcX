package com.daylong.httplibrary.bean.response;

import com.daylong.httplibrary.bean.WebSocketMsgResponse;

import java.util.List;

public class AppInfoResponse {


    private List<WebSocketMsgResponse> wsTbln;
    private String svDm;

    public List<WebSocketMsgResponse> getWsTbln() {
        return wsTbln;
    }

    public void setWsTbln(List<WebSocketMsgResponse> wsTbln) {
        this.wsTbln = wsTbln;
    }

    public String getSvDm() {
        return svDm+"/arcx_http/";
    }

    public void setSvDm(String svDm) {
        this.svDm = svDm;
    }


}
