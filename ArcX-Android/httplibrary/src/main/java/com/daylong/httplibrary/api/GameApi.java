package com.daylong.httplibrary.api;

import com.daylong.httplibrary.bean.request.GameInfoRequest;
import com.daylong.httplibrary.bean.response.game.GameInfoResponse;
import com.daylong.httplibrary.bean.response.game.GameItemInfoResponse;
import com.daylong.httplibrary.bean.response.game.QuickNameResponse;
import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;
import com.daylong.httplibrary.bean.response.game.charter.UserCharterInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GameApi {


    @GET("dev_tbln")
    Observable<BasePageResponse<GameItemInfoResponse>> getGameProductBanner(@Query("devTp") int productType,
                                                                            @Query("pgNm") int pageNum,
                                                                            @Query("pgAmt") int pageSize);

    @GET("gm_dev")
    Observable<BaseResponse<GameItemInfoResponse>> getUserGame();

    @GET("dev_ifo")
    Observable<BaseResponse<GameInfoResponse>> getGameInfo(@Query("devId") int productId);

    /**

     * @param productId
     * @return
     */
    @GET("charter_desc")
    Observable<BaseResponse<CharterDescResponse>> getGameCharterDesc(@Query("productId") int productId);

    /**

     * @return
     */
    @GET("user_charter_msg")
    Observable<BaseResponse<UserCharterInfoResponse>> getUserCharterInfo();

    @POST
    Observable<BaseResponse<Object>> postRepairReport(@Body GameInfoRequest gameInfoRequest);
    @GET("fs_jn_dev")
    Observable<BaseResponse<QuickNameResponse>> getQuickGame(@Query("devTp")int devTp);

}
