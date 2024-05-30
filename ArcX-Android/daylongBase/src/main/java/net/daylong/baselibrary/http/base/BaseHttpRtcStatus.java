package net.daylong.baselibrary.http.base;

import org.json.JSONObject;

import java.io.Serializable;

public class BaseHttpRtcStatus implements Serializable {

    private static final int CODE_SUCCESS = 0;
    private int errcode;
    private String errmsg;

    public BaseHttpRtcStatus(int errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    /**

     *

     */
    public boolean isOk() {
        return CODE_SUCCESS == 0;
    }
}
