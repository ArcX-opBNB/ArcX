package com.daylong.httplibrary.model.model.setting;

import com.daylong.httplibrary.api.MsgAPI;
import com.daylong.httplibrary.bean.request.DefaultRequest;
import com.daylong.httplibrary.bean.request.MsgRequest;
import com.daylong.httplibrary.bean.response.ServiceMsgResponse;
import com.daylong.httplibrary.model.contract.setting.ServiceIMContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import io.reactivex.Observable;


public class ServiceImModel implements ServiceIMContract.ServiceImModel {
    public static ServiceImModel newInstance() {
        return new ServiceImModel();
    }

    @Override
    public Observable<BasePageResponse<ServiceMsgResponse>> getServiceMsg(long ctId) {
        return RetrofitFactory.getInstance().createApi(MsgAPI.class).getServiceMsg(ctId,MAX_PAGE_SIZE);
    }

    @Override
    public Observable<BaseResponse<ServiceMsgResponse>> sendMsg(String msg) {
        return RetrofitFactory.getInstance().createApi(MsgAPI.class).sendMsg(new MsgRequest(msg));
    }

    @Override
    public Observable<BaseResponse<Object>> msgRead() {
        return RetrofitFactory.getInstance().createApi(MsgAPI.class).msgRead(new DefaultRequest());
    }
}
