package com.daylong.httplibrary.model.presenter.wallet;


import com.daylong.httplibrary.bean.response.wallet.WalletResponse;
import com.daylong.httplibrary.model.contract.wallet.ToExternalContract;
import com.daylong.httplibrary.model.model.wallet.ToExternalModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class ToExternalPresenter extends ToExternalContract.ToExternalPresenter {
    public static ToExternalPresenter newInstance() {
        return new ToExternalPresenter();
    }

    @Override
    public void onStart() {

    }

    @Override
    public ToExternalModel getModel() {
        return ToExternalModel.newInstance();
    }


    @Override
    public void postToExternal(int tkTp, int amt, String ads) {
        if (mIModel != null) {
            mIModel.postToExternal(tkTp, amt, ads)
                    .compose(RxScheduler.<BaseResponse<WalletResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<WalletResponse>>bindToLife())
                    .subscribe(new BaseObserver<WalletResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(WalletResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onToExternalSuc(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

