package com.daylong.httplibrary.model.contract.wallet;


import com.daylong.httplibrary.bean.response.wallet.WalletResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.view.IViewBaseModel;
import net.daylong.baselibrary.http.view.IViewBaseView;

import io.reactivex.Observable;

/**

 */
public interface ToExternalContract {
    interface ToExternalModel extends IViewBaseModel {

        /**

         *


         * @return
         */
        Observable<BaseResponse<WalletResponse>> postToExternal(int tkTp, int amt, String ads);


    }

    interface ToExternalView extends IViewBaseView {


        void onToExternalSuc(WalletResponse walletResponse);


    }

    abstract class ToExternalPresenter extends BasePresenter<ToExternalModel, ToExternalView> {

        public abstract void postToExternal(int tkTp, int amt, String ads);

    }
}
