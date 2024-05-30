package com.daylong.arcx.user;

import android.animation.ObjectAnimator;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.home.HomeActivity;
import com.daylong.arcx.view.check.PrivacyCheckBox;
import com.daylong.arcx.view.user.btn.login.TouristLoginButton;
import com.daylong.arcx.view.user.btn.login.WechatLoginButton;
import com.daylong.httplibrary.bean.request.user.EmailLoginRequest;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;
import com.daylong.httplibrary.model.contract.user.EmailLoginContract;
import com.daylong.httplibrary.model.model.user.EmailLoginModel;
import com.daylong.httplibrary.model.presenter.user.EmailLoginPresenter;
import com.daylong.userlibrary.act.IUserLoginActivity;
import com.daylong.userlibrary.cache.UserCache;
import com.daylong.userlibrary.view.login.ILoginBtn;

import net.daylong.baselibrary.utils.AnimUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.btn.MyImgBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class EmailActivity extends BaseMvpActivity<EmailLoginPresenter, EmailLoginModel> implements EmailLoginContract.EmailLoginView {

    private MyImageView titleIcon;
    private PrivacyCheckBox checkBox;
    private MyTextView tvToast;
    private boolean isPassword = false;
    private MyBtn btnLogin;

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);

        rootView.setBackgroundResource(R.drawable.img_email_login_bg);
        ConstraintLayout contentView = new ConstraintBuilder(167, 230).center().build(this);
        contentView.setBackgroundResource(R.drawable.img_email_login_content_bg);
        addView(contentView);


        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().topMargin(12).topCenterH());
        myTextView.initText("Welcome to", 9, R.color.color_white, true);


        titleIcon = MyImageView.create(contentView, new ConstraintBuilder(40, 33).topCenterH().topMargin(25), R.drawable.img_email_login_title_coin);


        createEmailEt(contentView);
        createCode(contentView);
        createCheck(contentView);


        btnLogin = MyBtn.create(contentView, new ConstraintBuilder(80, 28).
                topToBottom(checkBox).centerH().topMargin(7), R.drawable.img_btn_email_login, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {


                if (!checkBox.isCheck()) {
                    tvToast.setText("Please check and agree to ArcX Terms of use and Privacy Palicy.");
                    return;
                }
                String email = getText(etEmail);


                if (isNotNull(email)) {
                    if (isPassword) {
                        String password = getText(etPassword);
                        mPresenter.emailLogin(new EmailLoginRequest(email, null, password));

                    } else {
                        String code = getText(etCode);
                        mPresenter.emailLogin(new EmailLoginRequest(email, code, null));
                    }
                } else {


                }


            }
        });
        btnLogin.initBtn("Login/sign up", 9, net.daylong.daylongbase.R.color.color_333, true);
        btnLogin.setGravity(Gravity.CENTER_HORIZONTAL);
        btnLogin.setPadding(0, AppUtil.getSize(7), 0, 0);


        MyBtn myBtn1 = MyBtn.create(contentView, new ConstraintBuilder().ww().bottomCenterH().bottomMargin(8), R.drawable.shape_tr, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                if (isPassword) {
                    AnimUtils.start3DRotateAnimator(etPassword, etPassword, etCode);

                } else {
                    AnimUtils.start3DRotateAnimator(etCode, etCode, etPassword);
                }
                isPassword = !isPassword;
                btnSendMsg.setVisibility(isPassword ? View.GONE : View.VISIBLE);
                btnLogin.setText(isPassword ? "Login" : "Login/sign up");



            }
        });

        myBtn1.initBtn("Verification login", 7, net.daylong.daylongbase.R.color.color_bcacf5);


    }

    private void createCheck(ConstraintLayout contentView) {


        checkBox = new PrivacyCheckBox(this);

        checkBox.setLayoutParams(new ConstraintBuilder().ww().left(etCode).right(etCode).topToBottom(etCode).topMargin(31).buildPayoutParams());


        contentView.addView(checkBox);


    }

    private EditText etEmail, etCode, etPassword;
    private MyBtn btnSendMsg;

    private void createEmailEt(ConstraintLayout contentView) {
        etEmail = createEditText(contentView, new ConstraintBuilder().ww().topToBottom(titleIcon).topMargin(15), "Enter your email");
//        etEmail.setText("chenzhenron@126.com");
    }

    private void createCode(ConstraintLayout contentView) {
        etCode = createEditText(contentView, new ConstraintBuilder().ww().topToBottom(etEmail).topMargin(15), "Email verification code");
        etCode.setInputType(InputType.TYPE_CLASS_NUMBER);
        etPassword = createEditText(contentView, new ConstraintBuilder().ww().topToBottom(etEmail).topMargin(15), "Password");
        etPassword.setVisibility(View.GONE);
        etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        tvToast = MyTextView.create(contentView, new ConstraintBuilder().ww().w(0).topToBottom(etCode).left(etCode).right(etCode).topMargin(2));
        tvToast.setGravity(Gravity.LEFT);
        tvToast.initText(6, R.color.color_ff9a9a, true);


        btnSendMsg = MyBtn.create(contentView, new ConstraintBuilder().ww().centerV(etCode).right(etCode).rightMargin(4), R.drawable.shape_tr, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {

                String strEmail = etEmail.getText().toString().trim();


                if (!TextUtils.isEmpty(strEmail)) {
                    mPresenter.getEmailCode(strEmail);
                }
            }
        });

        btnSendMsg.initBtn("Send", 7, R.color.color_78351c, true);


    }

    private EditText createEditText(ConstraintLayout contentView, ConstraintBuilder constraintBuilder, String hint) {

        EditText editText = new EditText(this);
        editText.setLayoutParams(constraintBuilder.width(140).height(22).centerH().buildPayoutParams());
        editText.setBackgroundResource(R.drawable.shape_email_et_bg);
        editText.getPaint().setTextSize(getSize(7));
        editText.setHint(hint);
        editText.setMaxLines(1);
        editText.setSingleLine();
        editText.setTextColor(getColor(net.daylong.daylongbase.R.color.color_333));
        editText.setHighlightColor(getColor(R.color.color_a99cda));
        editText.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        editText.setPadding(getSize(4), 0, getSize(4), 0);
        editText.setId(View.generateViewId());
        contentView.addView(editText);
        return editText;


    }

    @Override
    protected void initData() {
        UserCache.getInstance().exitLogin();
        super.initData();


    }


    @Override
    public void onLoginSuc(LoginResponse loginResponse) {
        UserCache.getInstance().setToken(loginResponse.getAccessToken(), loginResponse.getRefreshToken());
        mPresenter.getLoginUserInfo(loginResponse.getUserId());

    }

    @Override
    public void onUserInfoSuc(UserInfoResponse userInfoResponse) {
        UserCache.getInstance().setUserInfo(userInfoResponse);
        start(this, HomeActivity.class);
        finish();
    }


    private int time;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            time--;

            if (time > 0) {
                btnSendMsg.setText(String.valueOf(--time));
                AppUtil.getMainHandler().postDelayed(this, 1000);
            } else {
                btnSendMsg.setText("Send");
                btnSendMsg.setClickable(true);
                btnSendMsg.setEnabled(true);

            }


        }
    };

    @Override
    public void onEmailCodeSuc(Object userInfoResponse) {
        btnSendMsg.setClickable(false);
        btnSendMsg.setEnabled(false);
        time = 60;
        AppUtil.getMainHandler().removeCallbacks(runnable, null);
        AppUtil.getMainHandler().postDelayed(runnable, 0);


    }

    @Override
    public void onFail(String str) {
        tvToast.setText(str);

    }

    @NonNull
    @Override
    protected EmailLoginPresenter initPresenter() {
        return EmailLoginPresenter.newInstance();
    }
}




