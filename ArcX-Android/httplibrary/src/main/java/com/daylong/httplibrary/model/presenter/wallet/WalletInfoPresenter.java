package com.daylong.httplibrary.model.presenter.wallet;



import com.daylong.httplibrary.bean.response.wallet.WalletInfoResponse;
import com.daylong.httplibrary.model.contract.wallet.WalletInfoContract;
import com.daylong.httplibrary.model.model.wallet.WalletInfoModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class WalletInfoPresenter extends WalletInfoContract.WalletInfoPresenter {
    public static WalletInfoPresenter newInstance() {
        return new WalletInfoPresenter();
    }

    @Override
    public void onStart() {

    }

    @Override
    public WalletInfoModel getModel() {
        return WalletInfoModel.newInstance();
    }



    @Override
    public void getWalletInfo() {
        if (mIModel != null) {
            mIModel.getWalletInfo()
                    .compose(RxScheduler.<BaseResponse<WalletInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<WalletInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<WalletInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(WalletInfoResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onWalletInfo(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

