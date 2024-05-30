package com.daylong.httplibrary.bean.request.user;

import java.io.Serializable;

/**

 */
public class LoginRequest implements Serializable {

    private int lgWt;
    private String wechatToken;

    public LoginRequest(int loginWayType, String wechatToken) {
        this.lgWt = loginWayType;
        this.wechatToken = wechatToken;
    }

    public int getLoginWayType() {
        return lgWt;
    }

    public void setLoginWayType(int loginWayType) {
        this.lgWt = loginWayType;
    }

    public String getWechatToken() {
        return wechatToken;
    }

    public void setWechatToken(String wechatToken) {
        this.wechatToken = wechatToken;
    }
}
