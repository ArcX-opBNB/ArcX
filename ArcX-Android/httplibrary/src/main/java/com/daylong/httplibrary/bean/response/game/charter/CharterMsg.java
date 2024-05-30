package com.daylong.httplibrary.bean.response.game.charter;

import java.io.Serializable;

public class CharterMsg implements Serializable {

    private String chBl; 
    private String resQt; 
    private String tolQt; 

    public String getBackNum() {
        return chBl;
    }

    public void setBackNum(String backNum) {
        this.chBl = backNum;
    }

    public String getBalance() {
        return resQt;
    }

    public void setBalance(String balance) {
        this.resQt = balance;
    }



    public String getSumNum() {
        return tolQt;
    }

    public void setSumNum(String sumNum) {
        this.tolQt = sumNum;
    }
}
