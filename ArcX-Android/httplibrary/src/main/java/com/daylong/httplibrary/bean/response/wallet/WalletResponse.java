package com.daylong.httplibrary.bean.response.wallet;

public class WalletResponse {
    private String url;

    public WalletResponse(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
