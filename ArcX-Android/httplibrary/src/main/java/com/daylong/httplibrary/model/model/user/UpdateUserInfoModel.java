package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.request.user.UpdateUserInfoRequest;
import com.daylong.httplibrary.model.contract.user.UpdateUserInfoContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class UpdateUserInfoModel implements UpdateUserInfoContract.UpdateUserInfoModel, IBaseModel {
    public static UpdateUserInfoModel newInstance() {
        return new UpdateUserInfoModel();
    }



    @Override
    public Observable<BaseResponse<Object>> updateUserInfo(UpdateUserInfoRequest updateUserInfoRequest) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).updateUserInfo(updateUserInfoRequest);
    }
}
