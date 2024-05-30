package com.daylong.httplibrary.bean.request.game;

import com.daylong.httplibrary.bean.request.BasePageRequest;

public class GameProductRequest extends BasePageRequest {
    private int  productType; 

    public GameProductRequest(int productType,Integer pageNum, Integer pageSize) {
        super(pageNum, pageSize);
        this.productType = productType;
    }

    public GameProductRequest(int productType) {
        this.productType = productType;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }
}
