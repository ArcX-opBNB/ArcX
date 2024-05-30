package com.daylong.httplibrary.bean.response.defaults;

import java.io.Serializable;

/**

 */
public class HomeBannerResponse implements Serializable {


    private String title; 
    private Integer redirectType;
    private String imgUrl; 
    private String dynamicImgUrl; 
    private String description; 
    /**


     */
    private String contactMsg;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(Integer redirectType) {
        this.redirectType = redirectType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDynamicImgUrl() {
        return dynamicImgUrl;
    }

    public void setDynamicImgUrl(String dynamicImgUrl) {
        this.dynamicImgUrl = dynamicImgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactMsg() {
        return contactMsg;
    }

    public void setContactMsg(String contactMsg) {
        this.contactMsg = contactMsg;
    }
}
