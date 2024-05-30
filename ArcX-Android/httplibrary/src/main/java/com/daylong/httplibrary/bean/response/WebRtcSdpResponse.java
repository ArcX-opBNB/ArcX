package com.daylong.httplibrary.bean.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WebRtcSdpResponse implements Serializable {
    private String sdp;
    private String type;

    public String getSdp() {
        return sdp;
    }

    public void setSdp(String sdp) {
        this.sdp = sdp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
