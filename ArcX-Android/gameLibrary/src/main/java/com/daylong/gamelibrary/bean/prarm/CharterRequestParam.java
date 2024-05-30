package com.daylong.gamelibrary.bean.prarm;

import com.daylong.basecache.GameCache;

import net.daylong.gamesocket.request.base.BaseParam;

/**

 */
public class CharterRequestParam extends BaseParam {

    private Integer productId;
    private Integer commodityId;

    public CharterRequestParam( Integer commodityId) {
        this.productId = GameCache.getGameRoomId();
        this.commodityId = commodityId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }
}
