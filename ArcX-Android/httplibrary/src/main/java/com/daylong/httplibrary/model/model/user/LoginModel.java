package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.DefaultApi;
import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.request.user.LoginRequest;
import com.daylong.httplibrary.bean.response.AppInfoResponse;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;
import com.daylong.httplibrary.model.contract.user.LoginContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class LoginModel implements LoginContract.LoginModel, IBaseModel {
    public static LoginModel newInstance() {
        return new LoginModel();
    }



    @Override
    public Observable<BaseResponse<LoginResponse>> login(LoginRequest loginRequest) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).login(loginRequest);
    }

    @Override
    public Observable<BaseResponse<LoginUserInfoResponse>> getLoginUserInfo() {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getLoginUserInfo();
    }

    @Override
    public Observable<BaseResponse<AppInfoResponse>> getAppInfoResponse() {
        return RetrofitFactory.getInstance().createApi(DefaultApi.class).getAppInfoResponse(new DefaultRequest());
    }



}
