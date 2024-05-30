package com.daylong.httplibrary.bean.request.user;

import java.io.Serializable;

public class EmailCodeRequest implements Serializable {
    private String email;

    public EmailCodeRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
