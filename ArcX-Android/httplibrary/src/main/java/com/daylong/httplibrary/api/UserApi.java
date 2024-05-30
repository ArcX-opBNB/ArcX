package com.daylong.httplibrary.api;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.request.user.EmailCodeRequest;
import com.daylong.httplibrary.bean.request.user.EmailLoginRequest;
import com.daylong.httplibrary.bean.request.user.FeedbackRequest;
import com.daylong.httplibrary.bean.request.user.InvitationRequest;
import com.daylong.httplibrary.bean.request.user.LoginRequest;
import com.daylong.httplibrary.bean.request.user.OrderRequest;
import com.daylong.httplibrary.bean.request.user.TaskReceiveRequest;
import com.daylong.httplibrary.bean.request.user.UpdateLevelRequest;
import com.daylong.httplibrary.bean.request.user.UpdatePasswordRequest;
import com.daylong.httplibrary.bean.request.user.UpdateUserInfoRequest;
import com.daylong.httplibrary.bean.response.user.CheckInInfoResponse;
import com.daylong.httplibrary.bean.response.user.InvitationInfoResponse;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.bean.response.user.MyAddressResponse;
import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;
import com.daylong.httplibrary.bean.response.user.RechargeResponse;
import com.daylong.httplibrary.bean.response.user.TaskInfoResponse;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApi {
    /**

     *
     * @param loginRequest
     * @return
     */
    @POST("ply_log_on")
    Observable<BaseResponse<LoginResponse>> login(@Body LoginRequest loginRequest);

    @GET("user_msg_search")
    Observable<BaseResponse<UserInfoResponse>> getUserInfoById(@Query("searchUserId") Long userId);
    @GET("ply_ifo")
    Observable<BaseResponse<LoginUserInfoResponse>> getLoginUserInfo();

    @GET("sign_msg")
    Observable<BaseResponse<CheckInInfoResponse>> getUserCheckInInfo();

    @POST("receive_sign_award")
    Observable<BasePageResponse<AwardBean>> checkIn(@Body DefaultRequest defaultRequest);

    @GET("daily_task_msg")
    Observable<BasePageResponse<TaskInfoResponse>> getTaskList();

    @POST("receive_daily_task_award")
    Observable<BasePageResponse<AwardBean>> receive(@Body TaskReceiveRequest request);

    @GET("user_invite_msg")
    Observable<BaseResponse<InvitationInfoResponse>> getInvitationInfo();

    @POST("bind_invite_code")
    Observable<BaseResponse<Object>> bindInvitation(@Body InvitationRequest request);

    @GET("recharge_list")
    Observable<BaseResponse<RechargeResponse>> getRechargeInfo();

    @GET("physical_goods_no_tacking")
    Observable<BasePageResponse<MyGoodsResponse>> getMyPendingItemsList(@Query("pageNum") int page, @Query("pageSize") int maxPageSize);

    @GET("user_address_msg")
    Observable<BasePageResponse<MyAddressResponse>> getMyAddressList();

    @POST("deal_user_address_msg")
    Observable<BasePageResponse<Object>> update(@Body MyAddressResponse addressResponse);

    @POST("physical_take_goods")
    Observable<BaseResponse<Object>> postOrder(@Body OrderRequest orderRequest);
    @GET("physical_goods_send")
    Observable<BasePageResponse<MyGoodsResponse>> getSendGoodsList(@Query("pageNum") int page, @Query("pageSize") int maxPageSize);

    @POST("user_opinion")
    Observable<BaseResponse<Object>> postFeedback(@Body FeedbackRequest feedbackRequest);
    @POST("ud_ply_ifo")
    Observable<BaseResponse<Object>> updateUserInfo(@Body UpdateUserInfoRequest updateUserInfoRequest);
    @POST("upg_atb")
    Observable<BaseResponse<Object>> updateLevel(@Body UpdateLevelRequest updateLevelRequest);
    @POST("ply_log_on")
    Observable<BaseResponse<LoginResponse>> emailLogin(@Body EmailLoginRequest emailLoginRequest);
    @POST("em_vrf_cd")
    Observable<BaseResponse<Object>> getEmailCode(@Body EmailCodeRequest emailCodeRequest);
    @POST("ud_ply_pwd")
    Observable<BaseResponse<Object>> updatePassword(@Body UpdatePasswordRequest updatePasswordRequest);
}
