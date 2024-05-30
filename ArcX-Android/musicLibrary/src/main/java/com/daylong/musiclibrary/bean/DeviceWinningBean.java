package com.daylong.musiclibrary.bean;


import com.daylong.musiclibrary.emums.DeviceWinningType;

/**

 */
public class DeviceWinningBean {
    private Integer devId; 
    private Integer devAwdTp; 
    private Integer awdAmt; 
    private Integer stFlg; 
    private Integer awardMulti; 

    public Integer getAwardMulti() {
        return awardMulti;
    }

    public void setAwardMulti(Integer awardMulti) {
        this.awardMulti = awardMulti;
    }

    public Integer getProductId() {
        return devId;
    }

    public void setProductId(Integer productId) {
        this.devId = productId;
    }

    public Integer getProductAwardType() {
        return devAwdTp;
    }

    public void setProductAwardType(Integer productAwardType) {
        this.devAwdTp = productAwardType;
    }

    public Integer getAwardNum() {
        return awdAmt;
    }

    public void setAwardNum(Integer awardNum) {
        this.awdAmt = awardNum;
    }

    public Integer getIsStart() {
        return stFlg;
    }

    public boolean isStart() {
        return stFlg == 1;
    }

    public void setIsStart(Integer isStart) {
        this.stFlg = isStart;
    }


    public boolean isOrdinary() {
        return getProductAwardType() != null && getProductAwardType() == 7;
    }

    /**

     *
     * @return
     */
    public boolean isDragonBall() {
        if (devAwdTp == null) {
            return false;
        }
        return devAwdTp == DeviceWinningType.DRAGON_BALL.getCode();
    }


    public boolean isPay() {
        return devAwdTp < 13 || devAwdTp > 17;
    }
}
