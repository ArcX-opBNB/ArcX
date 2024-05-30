package com.daylong.userlibrary.view.login;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.daylong.httplibrary.model.presenter.user.LoginPresenter;
import com.daylong.userlibrary.enums.LoginType;

import net.daylong.baselibrary.listener.OnClickTouchListener;
import net.daylong.baselibrary.view.btn.BaseButton;

public abstract class ILoginBtn extends BaseButton implements OnClickTouchListener.OnClickListener {


    public abstract int bgRegId();

    public abstract LoginType loginType();

    public ILoginBtn(@NonNull Context context) {
        super(context);

        setBackgroundResource(bgRegId());

        setOnTouchListener(new OnClickTouchListener(this));


    }

    protected LoginPresenter loginPresenter;
    private CheckBox checkBox;

    public void setLoginPresenter(LoginPresenter loginPresenter, CheckBox checkBox) {
        this.loginPresenter = loginPresenter;
        this.checkBox = checkBox;
    }

    @Override
    public void click(View view) {
        if (checkBox != null && checkBox.isChecked()) {
            clickLogin();
        } else {
            if (onShowAgreementListener != null) {
                onShowAgreementListener.showAgreement();
            }
        }
    }



    protected  abstract  void clickLogin();


    private OnShowAgreementListener onShowAgreementListener;

    public void setOnShowAgreementListener(OnShowAgreementListener onShowAgreementListener) {
        this.onShowAgreementListener = onShowAgreementListener;
    }

    public interface OnShowAgreementListener {

        public void showAgreement();
    }


}
