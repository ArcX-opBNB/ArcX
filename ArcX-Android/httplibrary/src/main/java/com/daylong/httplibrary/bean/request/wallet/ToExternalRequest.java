package com.daylong.httplibrary.bean.request.wallet;

import java.io.Serializable;

public class ToExternalRequest implements Serializable {


    private Integer tkTp;
    private Integer amt;
    private String ads;

    public ToExternalRequest(Integer tkTp, Integer amt, String ads) {
        this.tkTp = tkTp;
        this.amt = amt;
        this.ads = ads;
    }

    public String getAds() {
        return ads;
    }

    public void setAds(String ads) {
        this.ads = ads;
    }

    public Integer getTkTp() {
        return tkTp;
    }

    public void setTkTp(Integer tkTp) {
        this.tkTp = tkTp;
    }

    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }
}
