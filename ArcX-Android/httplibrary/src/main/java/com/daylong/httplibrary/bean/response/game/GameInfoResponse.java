package com.daylong.httplibrary.bean.response.game;

import com.daylong.httplibrary.bean.menus.GameChillType;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

/**

 */
public class GameInfoResponse extends GameItemInfoResponse {

    private Integer devTp; 
    private Integer sndTp; 
    private Integer devIdx; 
    private String lvAds; 
    private int cmdTp; 
    private int devSts; 
    private String devDtPct;

    private UserInfoResponse gmPly;
    private GameMultiplier ptyMul;

    public GameMultiplier getMulTbln() {
        return ptyMul;
    }

    public void setMulTbln(GameMultiplier mulTbln) {
        this.ptyMul = mulTbln;
    }

    public String getLiveUrl() {
        return lvAds;
    }

    public void setLiveUrl(String liveUrl) {
        this.lvAds = liveUrl;
    }

    public String getProductDetailUrl() {
        return devDtPct;
    }

    public void setProductDetailUrl(String productDetailUrl) {
        this.devDtPct = productDetailUrl;
    }

    public UserInfoResponse getGamingUserMsg() {
        return gmPly;
    }

    public void setGamingUserMsg(UserInfoResponse gamingUserMsg) {
        this.gmPly = gamingUserMsg;
    }


    public boolean isShowCharter() {
        return false;
    }


    public void setProductType(Integer productType) {
        this.devTp = productType;
    }

    public Integer getProductType() {
        return devTp;
    }

    public void setSecondType(Integer secondType) {
        this.sndTp = secondType;
    }

    public int getSecondType() {
        return this.sndTp;
    }

    public Integer getDevIdx() {
        return devIdx;
    }

    public void setDevIdx(Integer devIdx) {
        this.devIdx = devIdx;
    }

    public int getCmdTp() {
        return cmdTp;
    }

    public void setCmdTp(int cmdTp) {
        this.cmdTp = cmdTp;
    }

    public int getDevSts() {
        return devSts;
    }

    public void setDevSts(int devSts) {
        this.devSts = devSts;
    }

    public String getMusicPrefix() {

        return GameChillType.getGameChillType(sndTp).getDesc();
    }
}
