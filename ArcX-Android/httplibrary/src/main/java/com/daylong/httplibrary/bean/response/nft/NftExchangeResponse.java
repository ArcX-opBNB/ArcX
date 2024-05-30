package com.daylong.httplibrary.bean.response.nft;

import net.daylong.baselibrary.utils.StringUtils;

public class NftExchangeResponse {

    private Long gdAmt; 

    public NftExchangeResponse() {
    }

    public NftExchangeResponse(Long gdAmt) {
        this.gdAmt = gdAmt;
    }

    public Long getGdAmt() {
        return gdAmt;
    }

    public void setGdAmt(Long gdAmt) {
        this.gdAmt = gdAmt;
    }
}
