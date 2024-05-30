package com.daylong.httplibrary.bean.response.user;

public class InvitationInfoResponse {

    private String invoteCode;
    private Integer bindFlag; 
    private String shareUrl; 
    private String shareTitle; 
    private String shareDesc; 

    public String getInvoteCode() {
        return "ID：" + invoteCode;
    }

    public void setInvoteCode(String invoteCode) {
        this.invoteCode = invoteCode;
    }

    public Integer getBindFlag() {
        return bindFlag;
    }

    public boolean isBind() {
        return bindFlag == 1;
    }

    public void setBindFlag(Integer bindFlag) {
        this.bindFlag = bindFlag;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareDesc() {
        return shareDesc;
    }

    public void setShareDesc(String shareDesc) {
        this.shareDesc = shareDesc;
    }
}
