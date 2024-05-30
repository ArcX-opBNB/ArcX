package com.daylong.httplibrary.api;

import com.daylong.httplibrary.bean.request.WebRtcRequest;
import com.daylong.httplibrary.bean.response.WebRtcSdpResponse;
import com.daylong.httplibrary.bean.response.user.LoginResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.base.BaseRtcResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WebRtcApi {
    /**

     *
     * @param loginRequest
     * @return
     */
    @POST("webrtc/v1/pullstream")
    Observable<BaseRtcResponse<WebRtcSdpResponse>> getRTCDp(@Body WebRtcRequest loginRequest);


}
