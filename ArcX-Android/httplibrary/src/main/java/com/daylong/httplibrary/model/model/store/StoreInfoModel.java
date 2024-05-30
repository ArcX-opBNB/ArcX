package com.daylong.httplibrary.model.model.store;

import com.daylong.httplibrary.api.DefaultApi;
import com.daylong.httplibrary.api.StoreAPI;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.BasePageRequest;
import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.request.UsdTPayRequest;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;
import com.daylong.httplibrary.model.contract.store.StoreInfoContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import java.util.Objects;

import io.reactivex.Observable;


public class StoreInfoModel implements StoreInfoContract.StoreInfoModel {
    public static StoreInfoModel newInstance() {
        return new StoreInfoModel();
    }


    @Override
    public Observable<BaseResponse<StoreInfoResponse>> getStoreInfo() {
        return RetrofitFactory.getInstance().createApi(StoreAPI.class).getStoreInfo();
    }

    @Override
    public Observable<BaseResponse<Object>> reProp() {
        return RetrofitFactory.getInstance().createApi(StoreAPI.class).reProp(new DefaultRequest());
    }

    @Override
    public Observable<BasePageResponse<AwardBean>> pay(UsdTPayRequest usdTPayRequest) {
        return RetrofitFactory.getInstance().createApi(StoreAPI.class).payUsd(usdTPayRequest);
    }


}
