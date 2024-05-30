package com.daylong.httplibrary.bean.request.user;

import java.io.Serializable;

public class UpdateLevelRequest implements Serializable {

    private int atbTp;

    public UpdateLevelRequest(int atbTp) {
        this.atbTp = atbTp;
    }

    public int getAtbTp() {
        return atbTp;
    }

    public void setAtbTp(int atbTp) {
        this.atbTp = atbTp;
    }
}
