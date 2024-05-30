package com.daylong.httplibrary.bean.response.game.charter;



public class UserCharterInfoResponse {

    private Integer halfCharterTime; 
    private Integer oneCharterTime;
    private Integer halfDayTime;
    private Integer oneDayTime;

    public UserCharterInfoResponse(Integer halfCharterTime, Integer oneCharterTime, Integer halfDayTime, Integer oneDayTime) {
        this.halfCharterTime = halfCharterTime;
        this.oneCharterTime = oneCharterTime;
        this.halfDayTime = halfDayTime;
        this.oneDayTime = oneDayTime;
    }

    public UserCharterInfoResponse() {
    }

    public Integer getHalfCharterTime() {
        return halfCharterTime;
    }

    public void setHalfCharterTime(Integer halfCharterTime) {
        this.halfCharterTime = halfCharterTime;
    }

    public Integer getOneCharterTime() {
        return oneCharterTime;
    }

    public void setOneCharterTime(Integer oneCharterTime) {
        this.oneCharterTime = oneCharterTime;
    }

    public Integer getHalfDayTime() {
        return halfDayTime;
    }

    public void setHalfDayTime(Integer halfDayTime) {
        this.halfDayTime = halfDayTime;
    }

    public Integer getOneDayTime() {
        return oneDayTime;
    }

    public void setOneDayTime(Integer oneDayTime) {
        this.oneDayTime = oneDayTime;
    }

    public Boolean isStartCharter(Integer id) {
        if (id != 2) {
            return halfCharterTime > 0;
        } else {
            return oneCharterTime > 0;
        }
    }
//
//    /**

//     *
//     * @return
//     */
//    public Boolean isNotPayNum(Integer id ) {
//        if (id != CharterType.CHARTER_618) {
//            return hfDyDt >= onLmDt;
//        } else {
//            return onDyDt >= onLmDt;
//        }
//    }

//    public RechargeInfoResponse.RechargeItemBean createRechargeItemBean(CharterType charterType) {
//        RechargeInfoResponse.RechargeItemBean itemBean = new RechargeInfoResponse.RechargeItemBean();
//        itemBean.setPayCommodityTypeId(5);
//        itemBean.setCommodityId(charterType.getId());
//        itemBean.setPrice(charterType.getPrice());
//        return itemBean;
//    }
}
