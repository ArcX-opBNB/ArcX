package com.daylong.httplibrary.model.presenter.wallet;


import com.daylong.httplibrary.model.contract.wallet.WithdrawalContract;
import com.daylong.httplibrary.model.model.wallet.WithdrawalModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class WithdrawalPresenter extends WithdrawalContract.WithdrawalPresenter {
    public static WithdrawalPresenter newInstance() {
        return new WithdrawalPresenter();
    }

    @Override
    public void onStart() {

    }

    @Override
    public WithdrawalModel getModel() {
        return WithdrawalModel.newInstance();
    }


    @Override
    public void postWithdrawal(int tkTp, double amt) {
        if (mIModel != null) {
            mIModel.postWithdrawal(tkTp, amt)
                    .compose(RxScheduler.<BaseResponse<Object>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<Object>>bindToLife())
                    .subscribe(new BaseObserver<Object>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(Object data) throws Exception {
                            if (mIView != null) {
                                mIView.onWithdrawalSuc();
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

