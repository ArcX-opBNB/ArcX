package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.response.user.CheckInInfoResponse;
import com.daylong.httplibrary.model.contract.user.CheckInContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class CheckInModel implements CheckInContract.CheckInModel, IBaseModel {
    public static CheckInModel newInstance() {
        return new CheckInModel();
    }

    @Override
    public Observable<BasePageResponse<AwardBean>> checkIn() {
        return RetrofitFactory.getInstance().createApi(UserApi.class).checkIn(new DefaultRequest());
    }

    @Override
    public Observable<BaseResponse<CheckInInfoResponse>> getCheckInfo() {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getUserCheckInInfo();
    }
}
