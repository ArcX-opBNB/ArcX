package com.daylong.httplibrary.model.presenter.wallet;


import com.daylong.httplibrary.bean.response.wallet.WalletResponse;
import com.daylong.httplibrary.model.contract.wallet.ToSpendingContract;
import com.daylong.httplibrary.model.model.wallet.ToSpendingModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class ToSpendingPresenter extends ToSpendingContract.ToSpendingPresenter {
    public static ToSpendingPresenter newInstance() {
        return new ToSpendingPresenter();
    }

    @Override
    public void onStart() {

    }

    @Override
    public ToSpendingModel getModel() {
        return ToSpendingModel.newInstance();
    }


    @Override
    public void postToSpending(int tkTp, int amt) {

        if (mIModel != null) {
            mIModel.postToSpending(tkTp, amt)
                    .compose(RxScheduler.<BaseResponse<WalletResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<WalletResponse>>bindToLife())
                    .subscribe(new BaseObserver<WalletResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(WalletResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onToSpendingSuc(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

