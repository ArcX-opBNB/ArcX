package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.request.user.UpdateLevelRequest;
import com.daylong.httplibrary.bean.request.user.UpdatePasswordRequest;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.model.contract.user.UserInfoContract;
import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class UserInfoModel implements UserInfoContract.UserInfoModel, IBaseModel {
    public static UserInfoModel newInstance() {
        return new UserInfoModel();
    }




    @Override
    public Observable<BaseResponse<LoginUserInfoResponse>> getUserInfoUserInfo() {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getLoginUserInfo();
    }

    @Override
    public Observable<BaseResponse<Object>> updatePassword(String email, String password, String code) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).updatePassword(new UpdatePasswordRequest(email,code,password));
    }

    @Override
    public Observable<BaseResponse<Object>> updateLevel(int atbTp) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).updateLevel(new UpdateLevelRequest(atbTp));
    }


}
