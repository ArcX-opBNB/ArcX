package com.daylong.httplibrary.model.presenter.setting;

import com.daylong.httplibrary.bean.response.ServiceMsgResponse;
import com.daylong.httplibrary.model.contract.setting.ServiceIMContract;
import com.daylong.httplibrary.model.model.setting.ServiceImModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;


import java.util.List;

public class ServiceImPresenter extends ServiceIMContract.ServiceImPresenter {
    public static ServiceImPresenter newInstance() {
        return new ServiceImPresenter();
    }

    @Override
    public void onStart() {

    }

    @Override
    public ServiceImModel getModel() {
        return ServiceImModel.newInstance();
    }


    @Override
    public void getServiceMsg(long ctId) {

        if (mIModel != null) {
            mIModel.getServiceMsg(ctId)
                    .compose(RxScheduler.<BasePageResponse<ServiceMsgResponse>>rxSchedulerTransform())
                    .compose(mIView.<BasePageResponse<ServiceMsgResponse>>bindToLife())
                    .subscribe(new BasePageObserver<ServiceMsgResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(List<ServiceMsgResponse> data, BasePageResponse<ServiceMsgResponse> basePageResponse) throws Exception {
                            if (mIView != null) {
                                mIView.onServiceMsg(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void sendMsg(String msg) {
        if (mIModel != null) {
            mIModel.sendMsg(msg)
                    .compose(RxScheduler.<BaseResponse<ServiceMsgResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<ServiceMsgResponse>>bindToLife())
                    .subscribe(new BaseObserver<ServiceMsgResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(ServiceMsgResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onMsg(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void msgRead() {
        if (mIModel != null) {
            mIModel.msgRead()
                    .compose(RxScheduler.<BaseResponse<Object>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<Object>>bindToLife())
                    .subscribe(new BaseObserver<Object>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(Object data) throws Exception {

                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

