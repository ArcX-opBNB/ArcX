package com.daylong.httplibrary.model.contract.setting;


import com.daylong.httplibrary.bean.response.ServiceMsgResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;
import net.daylong.baselibrary.http.response.IBaseView;

import java.util.List;

import io.reactivex.Observable;

public interface ServiceIMContract {
    interface ServiceImModel extends IBaseModel {
        Observable<BasePageResponse<ServiceMsgResponse>> getServiceMsg(long ctId);
        Observable<BaseResponse<ServiceMsgResponse>> sendMsg(String ctId);
        Observable<BaseResponse<Object>> msgRead();


    }

    interface ServiceImView extends IBaseView {

        void onServiceMsg(List<ServiceMsgResponse> ServiceMsgResponses);
        void onMsg(ServiceMsgResponse msgBean);



    }

    abstract class ServiceImPresenter extends BasePresenter<ServiceImModel, ServiceImView> {
        public abstract void getServiceMsg(long ctId);
        public abstract void sendMsg(String msg);
        public abstract void msgRead();



    }
}
