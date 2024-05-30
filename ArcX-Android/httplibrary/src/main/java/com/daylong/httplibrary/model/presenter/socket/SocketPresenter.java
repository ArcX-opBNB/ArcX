package com.daylong.httplibrary.model.presenter.socket;

import com.daylong.httplibrary.bean.response.AppInfoResponse;
import com.daylong.httplibrary.model.contract.socket.SocketContract;
import com.daylong.httplibrary.model.model.socket.SocketModel;

import com.daylong.basecache.AppCache;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;

public class SocketPresenter extends SocketContract.SocketPresenter {

    public static SocketPresenter newInstance() {
        return new SocketPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public SocketModel getModel() {
        return SocketModel.newInstance();
    }



    @Override
    public void getWebSocketInfo() {
        if (mIModel != null) {
            mIModel.getAppInfoResponse()
                    .compose(RxScheduler.<BaseResponse<AppInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<AppInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<AppInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(AppInfoResponse data) throws Exception {
                            String svDm = data.getSvDm();
                            AppCache.setBaseUrl(svDm);
                            mIView.onWebSocketMsg(data);

                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }





}

