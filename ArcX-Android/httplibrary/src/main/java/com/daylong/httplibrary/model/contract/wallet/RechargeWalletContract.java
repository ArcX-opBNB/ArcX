package com.daylong.httplibrary.model.contract.wallet;


import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.view.IViewBaseModel;
import net.daylong.baselibrary.http.view.IViewBaseView;

import io.reactivex.Observable;

/**

 */
public interface RechargeWalletContract {
    interface TransferWalletModel extends IViewBaseModel {

        /**

         *


         * @return
         */
        Observable<BaseResponse<Object>> postTransferWallet(int tkTp, int amt);


    }

    interface TransferWalletView extends IViewBaseView {


        void onTransferWalletSuc();


    }

    abstract class TransferWalletPresenter extends BasePresenter<TransferWalletModel, TransferWalletView> {

        public abstract void postTransferWallet(int tkTp, int amt);

    }
}
