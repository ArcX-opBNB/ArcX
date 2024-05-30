package com.daylong.httplibrary.bean.request;

import com.daylong.basecache.GameCache;

import java.io.Serializable;

public class UsdTPayRequest implements Serializable {


    private Integer rcgCmdTp; 
    private Integer cmdId; 
    private Integer devId;
    private Long price;
    private Long num;
    private String img;

    public UsdTPayRequest(Integer rcgCmdTp, Integer cmdId,  Long price, Long num, String img) {
        this.rcgCmdTp = rcgCmdTp;
        this.cmdId = cmdId;
        this.price = price;
        this.num = num;
        this.img = img;
        int gameRoomId = GameCache.getGameRoomId();

        if (gameRoomId > 0) {
            this.devId = gameRoomId;
        }
    }

    public UsdTPayRequest(Integer rcgCmdTp, Integer cmdId, long price, long num) {
        this.rcgCmdTp = rcgCmdTp;
        this.cmdId = cmdId;
        this.price = price;
        this.num = num;
        int gameRoomId = GameCache.getGameRoomId();

        if (gameRoomId > 0) {
            this.devId = gameRoomId;
        }
    }


    public String getPriceStr() {
        String payType = "USDT";
        if (getRcgCmdTp() == 3) {
            payType = "AXC";

        }
        return getPrice() + payType;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {


        if (rcgCmdTp == 1) {
            return "to buy super player.";
        } else if (rcgCmdTp == 2) {
            return "to buy " + num + " Coins";
        }

        return "";
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getRcgCmdTp() {
        return rcgCmdTp;
    }

    public void setRcgCmdTp(Integer rcgCmdTp) {
        this.rcgCmdTp = rcgCmdTp;
    }

    public Integer getCmdId() {
        return cmdId;
    }

    public void setCmdId(Integer cmdId) {
        this.cmdId = cmdId;
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }
}
