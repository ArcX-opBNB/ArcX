package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.response.user.MyAddressResponse;
import com.daylong.httplibrary.model.contract.user.MyAddressEditContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class MyAddressEditModel implements MyAddressEditContract.MyAddressEditModel, IBaseModel {
    public static MyAddressEditModel newInstance() {
        return new MyAddressEditModel();
    }


    @Override
    public Observable<BasePageResponse<Object>> update(MyAddressResponse addressResponse) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).update(addressResponse);
    }
}
