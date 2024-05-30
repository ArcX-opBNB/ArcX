package com.daylong.httplibrary.bean.response.game;

import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import java.io.Serializable;
import java.util.List;

public class GameItemInfoResponse implements Serializable {

    private Integer devId; 
    private String devNm; 
    private String devPct;
    private Integer csAmt; 

    private List<UserInfoResponse> plyTbln;


    public Integer getProductId() {
        return devId;
    }

    public void setProductId(Integer productId) {
        this.devId = productId;
    }



    public String getProductName() {
        return devNm;
    }

    public void setProductName(String productName) {
        this.devNm = productName;
    }

    public String getProductImgUrl() {
        return devPct;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.devPct = productImgUrl;
    }


    public Integer getCostNum() {
        return csAmt;
    }

    public void setCostNum(Integer costNum) {
        this.csAmt = costNum;
    }

    public List<UserInfoResponse> getGamingList() {
        return plyTbln;
    }

    public void setGamingList(List<UserInfoResponse> gamingList) {
        this.plyTbln = gamingList;
    }






}
