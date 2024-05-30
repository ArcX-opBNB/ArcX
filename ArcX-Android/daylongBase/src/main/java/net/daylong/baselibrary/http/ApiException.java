package net.daylong.baselibrary.http;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONObject;

public class ApiException extends RuntimeException {
    private int status;
    private String errorMsg;
    private JSONObject data;


    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ApiException(int status, String errorMsg) {
        this.status = status;
        this.errorMsg = errorMsg;
    }

    public ApiException(int status, String errorMsg, JSONObject data) {
        this.status = status;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public ApiException(String message, int status, String errorMsg) {
        super(message);
        this.status = status;
        this.errorMsg = errorMsg;

    }

    public ApiException(String message, Throwable cause, int status, String errorMsg) {
        super(message, cause);
        this.status = status;
        this.errorMsg = errorMsg;
    }

    public ApiException(Throwable cause, int status, String errorMsg, JSONObject data) {
        super(cause);
        this.status = status;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int status, String errorMsg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
        this.errorMsg = errorMsg;
    }

    
    public boolean isTokenError() {
        return status == 1006 || status == 1007 || status == 1008 || status == 1009;
    }

    public boolean isExitApp() {
        return status == 1061;
    }

    
    public boolean isNotMoney() {
        return status == 1019;
    }

    
    public boolean isSignError() {
        return status == 1176;
    }
}
