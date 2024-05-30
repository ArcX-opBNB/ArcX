package com.daylong.httplibrary.bean;

import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import java.io.Serializable;

/**

 */
public class ArcadePositionBean implements Serializable {
    private int productId;
    private UserInfoResponse gamingUserMsg;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public UserInfoResponse getUserInfoResponse() {
        return gamingUserMsg;
    }

    public void setUserInfoResponse(UserInfoResponse userInfoResponse) {
        this.gamingUserMsg = userInfoResponse;
    }
}
