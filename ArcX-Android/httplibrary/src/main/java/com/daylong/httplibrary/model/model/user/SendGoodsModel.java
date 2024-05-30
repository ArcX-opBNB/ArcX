package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;
import com.daylong.httplibrary.model.contract.user.SendGoodsContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class SendGoodsModel implements SendGoodsContract.SendGoodsModel, IBaseModel {
    public static SendGoodsModel newInstance() {
        return new SendGoodsModel();
    }



    @Override
    public Observable<BasePageResponse<MyGoodsResponse>> getSendGoodsList(int page) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getSendGoodsList(page,IBaseModel.MAX_PAGE_SIZE);
    }
}
