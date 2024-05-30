package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.response.user.RechargeResponse;
import com.daylong.httplibrary.model.contract.user.RechargeContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class RechargeModel implements RechargeContract.RechargeModel, IBaseModel {
    public static RechargeModel newInstance() {
        return new RechargeModel();
    }

    @Override
    public Observable<BaseResponse<RechargeResponse>> getRechargeInfo() {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getRechargeInfo();
    }
}
