package com.daylong.httplibrary.bean.request;

/**

 */
public class GameInfoRequest {
    private int eqmId;

    public GameInfoRequest(int productId) {
        this.eqmId = productId;
    }

    public int getProductId() {
        return eqmId;
    }
}
