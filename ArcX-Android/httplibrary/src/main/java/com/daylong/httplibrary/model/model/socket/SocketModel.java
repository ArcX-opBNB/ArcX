 package com.daylong.httplibrary.model.model.socket;

 import com.daylong.httplibrary.api.DefaultApi;
 import com.daylong.httplibrary.bean.request.DefaultRequest;
 import com.daylong.httplibrary.bean.response.AppInfoResponse;
 import com.daylong.httplibrary.model.contract.socket.SocketContract;

 import net.daylong.baselibrary.http.DefaultRetrofitFactory;
 import net.daylong.baselibrary.http.base.BaseResponse;
 import net.daylong.baselibrary.http.response.IBaseModel;

 import io.reactivex.Observable;

public class SocketModel implements SocketContract.SocketModel, IBaseModel {
    public static SocketModel newInstance() {
        return new SocketModel();
    }
    @Override
    public Observable<BaseResponse<AppInfoResponse>> getAppInfoResponse() {
        return DefaultRetrofitFactory.getInstance().createApi(DefaultApi.class).getAppInfoResponse(new DefaultRequest());
    }



}
