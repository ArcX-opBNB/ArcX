package com.daylong.httplibrary.model.contract.wallet;


import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.view.IViewBaseModel;
import net.daylong.baselibrary.http.view.IViewBaseView;

import io.reactivex.Observable;

/**

 */
public interface WithdrawalContract {
    interface WithdrawalModel extends IViewBaseModel {

        /**

         *


         * @return
         */
        Observable<BaseResponse<Object>> postWithdrawal(int tkTp, double amt);


    }

    interface WithdrawalView extends IViewBaseView {


        void onWithdrawalSuc();


    }

    abstract class WithdrawalPresenter extends BasePresenter<WithdrawalModel, WithdrawalView> {

        public abstract void postWithdrawal(int tkTp, double amt);

    }
}
