package com.daylong.httplibrary.model.presenter.wallet;



import com.daylong.httplibrary.bean.response.wallet.WalletConfigureResponse;
import com.daylong.httplibrary.bean.response.wallet.WalletInfoResponse;
import com.daylong.httplibrary.model.contract.wallet.GameWalletInfoContract;
import com.daylong.httplibrary.model.model.wallet.GameWalletInfoModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class GameWalletInfoPresenter extends GameWalletInfoContract.GameWalletInfoPresenter {
    public static GameWalletInfoPresenter newInstance() {
        return new GameWalletInfoPresenter();
    }

    @Override
    public void onStart() {

    }

    @Override
    public GameWalletInfoContract.GameWalletInfoModel getModel() {
        return GameWalletInfoModel.newInstance();
    }



    @Override
    public void getGameWalletInfo() {
        if (mIModel != null) {
            mIModel.getGameWalletInfo()
                    .compose(RxScheduler.<BaseResponse<WalletInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<WalletInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<WalletInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(WalletInfoResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onGameWalletInfo(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void getConfigureInfo() {
        if (mIModel != null) {
            mIModel.getConfigureInfo()
                    .compose(RxScheduler.<BaseResponse<WalletConfigureResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<WalletConfigureResponse>>bindToLife())
                    .subscribe(new BaseObserver<WalletConfigureResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(WalletConfigureResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onWalletConfigureInfo(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

