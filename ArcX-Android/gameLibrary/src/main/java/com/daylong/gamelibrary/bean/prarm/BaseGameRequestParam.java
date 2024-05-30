package com.daylong.gamelibrary.bean.prarm;

import com.daylong.basecache.GameCache;

import net.daylong.gamesocket.request.base.BaseParam;

public class BaseGameRequestParam extends BaseParam {

    private Integer devId;
    private Integer hdlTp;
    private Integer gdMul;


    public Integer getGdMul() {
        return gdMul;
    }

    public void setGdMul(Integer gdMul) {
        this.gdMul = gdMul;
    }

    public BaseGameRequestParam(Integer productId, Integer operateType) {
        this.devId = productId;
        this.hdlTp = operateType;
    }

    public BaseGameRequestParam(Integer productId) {
        this.devId = productId;
    }

    public BaseGameRequestParam() {

        int gameRoomId = GameCache.getGameRoomId();

        if (gameRoomId > 0) {
            this.devId = gameRoomId;
        }
    }

    public Integer getOperateType() {
        return hdlTp;
    }

    public void setOperateType(Integer operateType) {
        this.hdlTp = operateType;
    }

    public Integer getProductId() {
        return devId;
    }

    public void setProductId(Integer productId) {
        this.devId = productId;
    }
}
