package com.daylong.musiclibrary.bean;
public class DeviceMusicBean {
    private Integer productId; 
    private Integer isStart; 
    private Integer isEndSwitch; 
    private Integer productType;
    private Integer voiceType; 

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public Integer getIsEndSwitch() {
        return isEndSwitch;
    }

    public void setIsEndSwitch(Integer isEndSwitch) {
        this.isEndSwitch = isEndSwitch;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getVoiceType() {
        return voiceType;
    }

    public void setVoiceType(Integer voiceType) {
        this.voiceType = voiceType;
    }


    /**

     *
     * @return
     */
    public boolean isPlay() {
        return isEndSwitch == 0 || isStart == 1;
    }

    public boolean isStop() {
        return isStart == 0;
    }
}
