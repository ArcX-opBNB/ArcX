package com.daylong.userlibrary.view.login;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.userlibrary.enums.LoginType;
import com.daylong.userlibrary.listener.WxLoginListener;
import com.daylong.userlibrary.mrg.WXMrg;


public abstract class IWechatLoginButton extends ILoginBtn implements WxLoginListener {
    public IWechatLoginButton(@NonNull Context context) {
        super(context);
        WXMrg.getInstance().setListeners(this);
    }

    @Override
    protected void clickLogin() {
        WXMrg.getInstance().loing(getContext());


    }

    @Override
    public LoginType loginType() {
        return LoginType.WECHAT;
    }

    @Override
    public void loginSuc(String code) {
        loginPresenter.login(LoginType.WECHAT.createWechat(code));
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WXMrg.getInstance().setListeners(null);

    }
}
