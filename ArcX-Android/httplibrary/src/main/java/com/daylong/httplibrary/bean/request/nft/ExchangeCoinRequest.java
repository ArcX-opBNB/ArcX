package com.daylong.httplibrary.bean.request.nft;

import java.io.Serializable;

public class ExchangeCoinRequest implements Serializable {

    private String nftCd;
    private long usdtAmt;
    private long usdtExc;

    public ExchangeCoinRequest(String nftCd, long usdtAmt, long usdtExc) {
        this.nftCd = nftCd;
        this.usdtAmt = usdtAmt;
        this.usdtExc = usdtExc;
    }

    public String getNftCd() {
        return nftCd;
    }

    public void setNftCd(String nftCd) {
        this.nftCd = nftCd;
    }

    public long getUsdtAmt() {
        return usdtAmt;
    }

    public void setUsdtAmt(long usdtAmt) {
        this.usdtAmt = usdtAmt;
    }

    public long getUsdtExc() {
        return usdtExc;
    }

    public void setUsdtExc(long usdtExc) {
        this.usdtExc = usdtExc;
    }
}
