package com.daylong.httplibrary.bean.request;

import com.google.gson.annotations.SerializedName;

public class WebRtcRequest {

    private String streamurl;
    private LocalsdpDTO localsdp;

    public String getStreamurl() {
        return streamurl;
    }

    public void setStreamurl(String streamurl) {
        this.streamurl = streamurl;
    }

    public LocalsdpDTO getLocalsdp() {
        return localsdp;
    }

    public void setLocalsdp(LocalsdpDTO localsdp) {
        this.localsdp = localsdp;
    }

    public static class LocalsdpDTO {
        private String type = "offer";
        private String sdp;

        public LocalsdpDTO(String sdp) {
            this.sdp = sdp;
        }

        public LocalsdpDTO() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSdp() {
            return sdp;
        }

        public void setSdp(String sdp) {
            this.sdp = sdp;
        }
    }
}
