package com.daylong.userlibrary.act;

import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.daylong.httplibrary.bean.response.AppInfoResponse;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.model.contract.user.LoginContract;
import com.daylong.httplibrary.model.model.user.LoginModel;
import com.daylong.httplibrary.model.presenter.user.LoginPresenter;
import com.daylong.userlibrary.cache.UserCache;
import com.daylong.userlibrary.view.login.ILoginBtn;

import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public abstract class IUserLoginActivity extends BaseMvpActivity<LoginPresenter, LoginModel> implements LoginContract.LoginView {


    @NonNull
    @Override
    protected LoginPresenter initPresenter() {
        return LoginPresenter.newInstance();
    }


    private ILoginBtn wechatLoginBtn;
    private ILoginBtn touristLoginBtn;

    private CheckBox checkBox;

    protected ILoginBtn createWechatLoginBtn() {

        return null;
    }

    protected ILoginBtn createTouristLoginBtn() {

        return null;
    }

    public CheckBox createCheckBox() {

        CheckBox checkBox = new CheckBox(this);
        checkBox.setLayoutParams(new ConstraintBuilder().ww().bottomCenterH().bottomMargin(22).buildPayoutParams());
        return checkBox;
    }

    protected void initLoginBtn() {
        checkBox = createCheckBox();
        checkBox .setChecked(true);
        addView(checkBox);
        wechatLoginBtn = createWechatLoginBtn();
        touristLoginBtn = createTouristLoginBtn();
        if (wechatLoginBtn != null) {
            wechatLoginBtn.setLoginPresenter(mPresenter, checkBox);
        }

        if (touristLoginBtn != null) {
            touristLoginBtn.setLoginPresenter(mPresenter, checkBox);
        }
    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);
        initLoginBtn();
    }


    @Override
    public void onWebSocketMsg(AppInfoResponse webSocketMsgResponse) {

    }


    @Override
    public void onLoginSuc(LoginResponse loginResponse) {
        UserCache.getInstance().setToken(loginResponse.getAccessToken(),loginResponse.getRefreshToken());
        mPresenter.getLoginUserInfo(loginResponse.getUserId());
    }
}
