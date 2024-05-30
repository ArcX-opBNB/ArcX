package com.daylong.arcx.enums;
public enum CharterType {

    CHARTER_348(1,"348")
    ,CHARTER_618(2,"618")
    ;
    private int id;
    private String price;

    CharterType(int id, String price) {
        this.id = id;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    CharterType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
