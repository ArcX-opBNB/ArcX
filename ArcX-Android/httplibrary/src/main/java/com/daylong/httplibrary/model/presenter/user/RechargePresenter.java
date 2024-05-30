package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.response.user.RechargeResponse;
import com.daylong.httplibrary.model.contract.user.RechargeContract;
import com.daylong.httplibrary.model.model.user.RechargeModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class RechargePresenter extends RechargeContract.RechargePresenter {

    public static RechargePresenter newInstance() {
        return new RechargePresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public RechargeModel getModel() {
        return RechargeModel.newInstance();
    }


    @Override
    public void getRechargeInfo() {
        if (mIModel != null) {
            mIModel.getRechargeInfo()
                    .compose(RxScheduler.<BaseResponse<RechargeResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<RechargeResponse>>bindToLife())
                    .subscribe(new BaseObserver<RechargeResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(RechargeResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onRechargeInfo(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

