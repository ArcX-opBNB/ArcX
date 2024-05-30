package com.daylong.httplibrary.bean.response.wallet;

import java.io.Serializable;

public class WalletInfoResponse implements Serializable {


    private String wlAds;
    private double usdt;
    private double axc;
    private double sol;

    public String getWlAds() {
        return wlAds;
    }

    public void setWlAds(String wlAds) {
        this.wlAds = wlAds;
    }

    public double getUsdt() {
        return usdt;
    }

    public void setUsdt(double usdt) {
        this.usdt = usdt;
    }

    public double getAxc() {
        return axc;
    }

    public void setAxc(double axc) {
        this.axc = axc;
    }

    public double getSol() {
        return sol;
    }

    public void setSol(double sol) {
        this.sol = sol;
    }


    public String getCount() {
        return "$ " + (usdt + axc + sol);
    }

}
