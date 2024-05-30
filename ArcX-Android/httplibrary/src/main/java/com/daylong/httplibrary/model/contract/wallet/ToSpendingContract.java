package com.daylong.httplibrary.model.contract.wallet;

import com.daylong.httplibrary.bean.response.wallet.WalletResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.view.IViewBaseModel;
import net.daylong.baselibrary.http.view.IViewBaseView;

import io.reactivex.Observable;


public interface ToSpendingContract {
    interface ToSpendingModel extends IViewBaseModel {

        Observable<BaseResponse<WalletResponse>> postToSpending(int tkTp, int amt);


    }

    interface ToSpendingView extends IViewBaseView {


        void onToSpendingSuc(WalletResponse walletResponse);


    }

    abstract class ToSpendingPresenter extends BasePresenter<ToSpendingModel, ToSpendingView> {

        public abstract void  postToSpending(int tkTp, int amt);

    }
}
