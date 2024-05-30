package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.response.user.MyAddressResponse;
import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;
import com.daylong.httplibrary.model.contract.user.MyAddressContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class MyAddressModel implements MyAddressContract.MyAddressModel, IBaseModel {
    public static MyAddressModel newInstance() {
        return new MyAddressModel();
    }



    @Override
    public Observable<BasePageResponse<MyAddressResponse>> getMyAddressList() {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getMyAddressList();
    }
}
