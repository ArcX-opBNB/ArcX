package com.daylong.httplibrary.bean;

public class WalletItemBean {

    private int type;
    private int coinRegId;

    private String name;
    private double nun;


    public WalletItemBean(int type, int coinRegId, String name, double nun) {
        this.type = type;
        this.coinRegId = coinRegId;
        this.name = name;
        this.nun = nun;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCoinRegId() {
        return coinRegId;
    }

    public void setCoinRegId(int coinRegId) {
        this.coinRegId = coinRegId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNun() {
        return nun;
    }

    public void setNun(double nun) {
        this.nun = nun;
    }
}
