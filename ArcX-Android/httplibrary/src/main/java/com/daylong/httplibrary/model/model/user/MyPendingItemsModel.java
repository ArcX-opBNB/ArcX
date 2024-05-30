package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;
import com.daylong.httplibrary.model.contract.user.MyPendingItemsContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class MyPendingItemsModel implements MyPendingItemsContract.MyPendingItemsModel, IBaseModel {
    public static MyPendingItemsModel newInstance() {
        return new MyPendingItemsModel();
    }



    @Override
    public Observable<BasePageResponse<MyGoodsResponse>> getMyPendingItemsList(int page) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getMyPendingItemsList(page,IBaseModel.MAX_PAGE_SIZE);
    }
}
