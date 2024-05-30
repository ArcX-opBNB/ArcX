package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.request.user.EmailCodeRequest;
import com.daylong.httplibrary.bean.request.user.EmailLoginRequest;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.model.contract.user.EmailLoginContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class EmailLoginModel implements EmailLoginContract.EmailLoginModel, IBaseModel {
    public static EmailLoginModel newInstance() {
        return new EmailLoginModel();
    }



    @Override
    public Observable<BaseResponse<LoginResponse>> emailLogin(EmailLoginRequest emailLoginRequest) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).emailLogin(emailLoginRequest);
    }

    @Override
    public Observable<BaseResponse<LoginUserInfoResponse>> getLoginUserInfo() {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getLoginUserInfo();
    }

    @Override
    public Observable<BaseResponse<Object>> getEmailCode(String email) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getEmailCode(new EmailCodeRequest(email));
    }

}
