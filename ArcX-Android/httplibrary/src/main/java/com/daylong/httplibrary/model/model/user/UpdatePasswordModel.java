package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.request.user.EmailCodeRequest;
import com.daylong.httplibrary.bean.request.user.UpdatePasswordRequest;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.model.contract.user.UpdatePasswordContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class UpdatePasswordModel implements UpdatePasswordContract.UpdatePasswordModel, IBaseModel {
    public static UpdatePasswordModel newInstance() {
        return new UpdatePasswordModel();
    }



    @Override
    public Observable<BaseResponse<Object>> updatePassword(UpdatePasswordRequest UpdatePasswordRequest) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).updatePassword(UpdatePasswordRequest);
    }





    @Override
    public Observable<BaseResponse<Object>> getEmailCode(String email) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getEmailCode(new EmailCodeRequest(email));
    }

}
