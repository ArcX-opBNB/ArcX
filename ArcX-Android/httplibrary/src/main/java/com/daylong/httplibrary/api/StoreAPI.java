package com.daylong.httplibrary.api;



import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.BasePageRequest;
import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.request.MsgRequest;
import com.daylong.httplibrary.bean.request.UsdTPayRequest;
import com.daylong.httplibrary.bean.response.ServiceMsgResponse;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface StoreAPI {
    @GET("shp_mal")
    Observable<BaseResponse<StoreInfoResponse>> getStoreInfo();

    @POST("rf_mal_ppy")
    Observable<BaseResponse<Object>> reProp(@Body DefaultRequest defaultRequest);
    @POST("cmd_dr_puc")
    Observable<BasePageResponse<AwardBean>> payUsd(@Body UsdTPayRequest usdTPayRequest);
}
