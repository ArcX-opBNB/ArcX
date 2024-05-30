package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.user.EmailLoginRequest;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import java.util.List;

import io.reactivex.Observable;

public interface EmailLoginContract {
    interface EmailLoginModel extends IViewBaseModel {


        Observable<BaseResponse<LoginResponse>> emailLogin(EmailLoginRequest emailLoginRequest);
        Observable<BaseResponse<LoginUserInfoResponse>> getLoginUserInfo();

        Observable<BaseResponse<Object>> getEmailCode(String email);


    }

    interface EmailLoginView extends IBaseView {

        void onLoginSuc(LoginResponse loginResponse);
        void onUserInfoSuc(UserInfoResponse userInfoResponse);
        void onEmailCodeSuc(Object userInfoResponse);
        void onFail(String str);


    }

    abstract class EmailLoginPresenter extends BasePresenter<EmailLoginModel, EmailLoginView> {


        public abstract void emailLogin(EmailLoginRequest emailLoginRequest);

        public abstract void getEmailCode(String email);
        public abstract void getLoginUserInfo( long id);


    }
}
