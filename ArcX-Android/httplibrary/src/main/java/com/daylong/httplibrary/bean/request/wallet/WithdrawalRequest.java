package com.daylong.httplibrary.bean.request.wallet;

import java.io.Serializable;

public class WithdrawalRequest implements Serializable {


    private Integer tkTp;
    private int amt;

    public WithdrawalRequest(Integer tkTp, double amt) {
        this.tkTp = tkTp;
        this.amt = (int)amt;
    }

    public Integer getTkTp() {
        return tkTp;
    }

    public void setTkTp(Integer tkTp) {
        this.tkTp = tkTp;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }
}
