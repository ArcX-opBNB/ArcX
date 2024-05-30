package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.request.user.LoginRequest;
import com.daylong.httplibrary.bean.response.AppInfoResponse;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import io.reactivex.Observable;

public interface LoginContract {
    interface LoginModel extends IViewBaseModel {


        Observable<BaseResponse<LoginResponse>> login(LoginRequest loginRequest);

        Observable<BaseResponse<LoginUserInfoResponse>> getLoginUserInfo();

        Observable<BaseResponse<AppInfoResponse>> getAppInfoResponse();
    }

    interface LoginView extends IBaseView {

        void onWebSocketMsg(AppInfoResponse webSocketMsgResponse);

        void onUserInfoSuc(UserInfoResponse userInfoResponse);
        void onLoginSuc(LoginResponse loginResponse);


    }

    abstract class LoginPresenter extends BasePresenter<LoginModel, LoginView> {


        public abstract void loginWechat();

        public abstract void loginTourist(LoginRequest loginRequest);

        public abstract void getLoginUserInfo( long id);

        public abstract void getAppInfoResponse();
        

    }
}
