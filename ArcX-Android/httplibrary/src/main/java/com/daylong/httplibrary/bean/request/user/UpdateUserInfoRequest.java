package com.daylong.httplibrary.bean.request.user;

import java.io.Serializable;

public class UpdateUserInfoRequest implements Serializable {

    private String plyNm; 
    private Integer sex;

    public UpdateUserInfoRequest(String plyNm, Integer sex) {
        this.plyNm = plyNm;
        this.sex = sex;
    }

    public String getPlyNm() {
        return plyNm;
    }

    public void setPlyNm(String plyNm) {
        this.plyNm = plyNm;
    }

    public Integer getSex() {
        return sex;
    }

    private boolean isMale() {
        return sex == 1;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
