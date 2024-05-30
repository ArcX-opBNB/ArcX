package com.daylong.httplibrary.api;

import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.request.nft.ExchangeCoinRequest;
import com.daylong.httplibrary.bean.response.AppInfoResponse;
import com.daylong.httplibrary.bean.response.defaults.HomeBannerResponse;
import com.daylong.httplibrary.bean.response.nft.NftExchangeResponse;
import com.daylong.httplibrary.bean.response.nft.NftSalesCoinInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NftApi {
    @GET("opr_sel_gd_mch")
    Observable<BaseResponse<NftSalesCoinInfoResponse>> getNftSalesCoinInfo();

    @POST("exc_nft_gd")
    Observable<BaseResponse<NftExchangeResponse>> ExchangeCoinRequest(@Body ExchangeCoinRequest nftExchangeResponse);

}


