package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.request.user.OrderRequest;
import com.daylong.httplibrary.model.contract.user.OrderPostContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class OrderPostModel implements OrderPostContract.OrderPostModel, IBaseModel {
    public static OrderPostModel newInstance() {
        return new OrderPostModel();
    }


    @Override
    public Observable<BaseResponse<Object>> postOrder(OrderRequest orderRequest) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).postOrder(orderRequest);
    }
}
