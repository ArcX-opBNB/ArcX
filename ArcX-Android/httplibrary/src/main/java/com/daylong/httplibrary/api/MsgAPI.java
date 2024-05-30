package com.daylong.httplibrary.api;



import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.request.MsgRequest;
import com.daylong.httplibrary.bean.response.ServiceMsgResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MsgAPI {
    @GET("chat_msg")
    Observable<BasePageResponse<ServiceMsgResponse>> getServiceMsg(@Query("ctId") long ctId, @Query("pgSz") int maxPageSize);
    @POST("send_chat")
    Observable<BaseResponse<ServiceMsgResponse>> sendMsg(@Body MsgRequest msgRequest);
    @POST("chat_msg_read")
    Observable<BaseResponse<Object>> msgRead(@Body DefaultRequest defaultRequest);

}
