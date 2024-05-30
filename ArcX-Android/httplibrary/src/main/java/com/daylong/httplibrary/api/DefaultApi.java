package com.daylong.httplibrary.api;

import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.response.AppInfoResponse;
import com.daylong.httplibrary.bean.response.defaults.HomeBannerResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DefaultApi {


    @POST("ag_ifo")
    Observable<BaseResponse<AppInfoResponse>> getAppInfoResponse(@Body DefaultRequest defaultRequest);

    @GET("carousel_info")
    Observable<BasePageResponse<HomeBannerResponse>> getHomeBanner();
}
