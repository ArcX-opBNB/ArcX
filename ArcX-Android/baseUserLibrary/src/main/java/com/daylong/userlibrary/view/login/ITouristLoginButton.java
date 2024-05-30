package com.daylong.userlibrary.view.login;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.userlibrary.enums.LoginType;


public abstract class ITouristLoginButton extends ILoginBtn {
    public ITouristLoginButton(@NonNull Context context) {
        super(context);
    }

    @Override
    public LoginType loginType() {
        return LoginType.TOURIST;
    }

    @Override
    protected void clickLogin() {
        loginPresenter.loginTourist(loginType().createTourist());
    }
}
