package com.daylong.arcx.user;

import com.daylong.httplibrary.bean.response.user.UserInfoResponse;
import com.daylong.userlibrary.act.IUserLoginActivity;
import com.daylong.userlibrary.cache.UserCache;
import com.daylong.userlibrary.view.login.ILoginBtn;
import com.daylong.arcx.home.HomeActivity;
import com.daylong.arcx.view.user.btn.login.TouristLoginButton;
import com.daylong.arcx.view.user.btn.login.WechatLoginButton;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class LoginActivity extends IUserLoginActivity {


    @Override
    protected void initData() {
        UserCache.getInstance().exitLogin();
        super.initData();


    }

    @Override
    protected ILoginBtn createTouristLoginBtn() {
        return TouristLoginButton.create(rootView, new ConstraintBuilder(108, 28).topCenterH().topMargin(194));
    }

    @Override
    protected ILoginBtn createWechatLoginBtn() {
        return WechatLoginButton.create(rootView, new ConstraintBuilder(108, 28).topCenterH().topMargin(155));
    }

    @Override
    protected void initLoginBtn() {
        super.initLoginBtn();
    }

    @Override
    public void onUserInfoSuc(UserInfoResponse userInfoResponse) {
        UserCache.getInstance().setUserInfo(userInfoResponse);
        start(this, HomeActivity.class);
        finish();
    }
}




