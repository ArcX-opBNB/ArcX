package com.daylong.httplibrary.bean.response.user;

import java.io.Serializable;

public class LoginResponse implements Serializable {


    private String aesTkn; 
    private Long aesOt;
    private String refTkn; 
    private Long refOt; 
    private Long arcxUid;

    public String getAccessToken() {
        return aesTkn;
    }

    public void setAccessToken(String accessToken) {
        this.aesTkn = accessToken;
    }

    public Long getAccessTokenOutTime() {
        return aesOt;
    }

    public void setAccessTokenOutTime(Long accessTokenOutTime) {
        this.aesOt = accessTokenOutTime;
    }

    public String getRefreshToken() {
        return refTkn;
    }

    public void setRefreshToken(String refreshToken) {
        this.refTkn = refreshToken;
    }

    public Long getRefreshTokenOutTime() {
        return refOt;
    }

    public void setRefreshTokenOutTime(Long refreshTokenOutTime) {
        this.refOt = refreshTokenOutTime;
    }

    public Long getUserId() {
        return arcxUid;
    }

    public void setUserId(Long userId) {
        this.arcxUid = userId;
    }
}
