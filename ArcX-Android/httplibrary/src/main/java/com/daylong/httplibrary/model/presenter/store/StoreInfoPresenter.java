package com.daylong.httplibrary.model.presenter.store;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.UsdTPayRequest;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;
import com.daylong.httplibrary.model.contract.store.StoreInfoContract;
import com.daylong.httplibrary.model.model.store.StoreInfoModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;
import java.util.Objects;

public class StoreInfoPresenter extends StoreInfoContract.StoreInfoBannerPresenter {

    public static StoreInfoPresenter newInstance() {
        return new StoreInfoPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public StoreInfoModel getModel() {
        return StoreInfoModel.newInstance();
    }


    @Override
    public void getStoreInfo() {
        if (mIModel != null) {
            mIModel.getStoreInfo()
                    .compose(RxScheduler.<BaseResponse<StoreInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<StoreInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<StoreInfoResponse>() {
                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(StoreInfoResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onStoreInfoSuc(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void reProp() {
        if (mIModel != null) {
            mIModel.reProp()
                    .compose(RxScheduler.<BaseResponse<Object>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<Object>>bindToLife())
                    .subscribe(new BaseObserver<Object>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(Object data) throws Exception {
                            if (mIView != null) {
                                mIView.onRePropSuc();
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void pay(UsdTPayRequest usdTPayRequest) {
        if (mIModel != null) {
            mIModel.pay(usdTPayRequest)
                    .compose(RxScheduler.<BasePageResponse<AwardBean>>rxSchedulerTransform())
                    .compose(mIView.<BasePageResponse<AwardBean>>bindToLife())
                    .subscribe(new BasePageObserver<AwardBean>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(List<AwardBean> data, BasePageResponse<AwardBean> basePageResponse) throws Exception {
                            if (data != null&&data.size()>0) {
                                mIView.onPaySuc(data.get(0));
                            }

                        }


                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

