package com.daylong.httplibrary.bean.request.user;

import java.io.Serializable;

public class EmailLoginRequest implements Serializable {

    private Integer lgWt =3;
    private String email; 
    private String vfyCd; 
    private String pwd; 

    public EmailLoginRequest(String email, String vfyCd, String pwd) {
        this.email = email;
        this.vfyCd = vfyCd;
        this.pwd = pwd;
    }

    public Integer getLgWt() {
        return lgWt;
    }

    public void setLgWt(Integer lgWt) {
        this.lgWt = lgWt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVfyCd() {
        return vfyCd;
    }

    public void setVfyCd(String vfyCd) {
        this.vfyCd = vfyCd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
