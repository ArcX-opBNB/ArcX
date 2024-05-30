package com.daylong.httplibrary.model.model.game;


import com.daylong.httplibrary.api.GameApi;
import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;
import com.daylong.httplibrary.bean.response.game.charter.UserCharterInfoResponse;
import com.daylong.httplibrary.model.contract.game.CharterContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class CharterModel implements CharterContract.CharterModel, IBaseModel {
    public static CharterModel newInstance() {
        return new CharterModel();
    }



    @Override
    public Observable<BaseResponse<CharterDescResponse>> getGameCharterDesc(int productId) {
        return RetrofitFactory.getInstance().createApi(GameApi.class).getGameCharterDesc(productId);
    }

    @Override
    public Observable<BaseResponse<UserCharterInfoResponse>> getUserCharterInfo() {
        return RetrofitFactory.getInstance().createApi(GameApi.class).getUserCharterInfo();
    }


}
