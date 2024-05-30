package com.daylong.httplibrary.api;

import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.request.wallet.ToExternalRequest;
import com.daylong.httplibrary.bean.request.wallet.WithdrawalRequest;
import com.daylong.httplibrary.bean.response.AppInfoResponse;
import com.daylong.httplibrary.bean.response.defaults.HomeBannerResponse;
import com.daylong.httplibrary.bean.response.wallet.WalletConfigureResponse;
import com.daylong.httplibrary.bean.response.wallet.WalletInfoResponse;
import com.daylong.httplibrary.bean.response.wallet.WalletResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WalletApi {


    @GET("chn_wl")
    Observable<BaseResponse<WalletInfoResponse>> getWalletInfo();

    @POST("wl_wtd")
    Observable<BaseResponse<Object>> getWithdrawal(@Body WithdrawalRequest withdrawalRequest);

    @POST("tsf_tks")
    Observable<BaseResponse<WalletResponse>> postToExternal(@Body ToExternalRequest toExternalRequest);

    @POST("wl_rcg")
    Observable<BaseResponse<WalletResponse>> postToSpending(@Body WithdrawalRequest withdrawalRequest);

    @GET("wl_spd")
    Observable<BaseResponse<WalletInfoResponse>> getGameWalletInfo();


    @GET("wl_cfg")
    Observable<BaseResponse<WalletConfigureResponse>> getWalletConfigureInfo();

}
