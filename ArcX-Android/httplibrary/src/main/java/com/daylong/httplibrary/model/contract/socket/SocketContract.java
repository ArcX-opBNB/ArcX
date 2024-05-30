package com.daylong.httplibrary.model.contract.socket;

import com.daylong.httplibrary.bean.response.AppInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import io.reactivex.Observable;

public interface SocketContract {
    interface SocketModel extends IViewBaseModel {


        Observable<BaseResponse<AppInfoResponse>> getAppInfoResponse();
    }

    interface SocketView extends IBaseView {

        void onWebSocketMsg(AppInfoResponse socketMsgResponse);


    }

    abstract class SocketPresenter extends BasePresenter<SocketModel, SocketView> {

        public abstract void getWebSocketInfo();
        

    }
}
