package com.daylong.httplibrary.api;

import com.daylong.httplibrary.PayOrderBean;
import com.daylong.httplibrary.bean.request.PayRequest;

import net.daylong.baselibrary.http.base.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PayApi {



    /**

     *
     * @param payRequest
     * @return
     */
    @POST("ali_pay")
    Observable<BaseResponse<PayOrderBean>> aliPay(@Body PayRequest payRequest);


}
