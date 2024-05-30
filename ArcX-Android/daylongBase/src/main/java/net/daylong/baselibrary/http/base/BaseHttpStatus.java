package net.daylong.baselibrary.http.base;

import org.json.JSONObject;

import java.io.Serializable;

public class BaseHttpStatus implements Serializable {

    private String errorCode;
    private String errorDesc;
    private JSONObject serverMsg;


    public JSONObject getData() {
        return serverMsg;
    }

    public void setData(JSONObject data) {
        this.serverMsg = data;
    }

    public static String getCodeSuccess() {
        return CODE_SUCCESS;
    }

    private static final String CODE_SUCCESS = "1";

    public String getCode() {
        return errorCode;
    }

    public void setCode(String code) {
        this.errorCode = code;
    }

    public String getMsg() {
        return errorDesc;
    }

    public void setMsg(String msg) {
        this.errorDesc = msg;
    }

    /**

     *

     */
    public boolean isOk() {
        return CODE_SUCCESS.equals(getCode());
    }
}
