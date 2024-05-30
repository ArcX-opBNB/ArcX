package com.daylong.httplibrary.model.contract.wallet;

import com.daylong.httplibrary.bean.response.wallet.WalletInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.view.IViewBaseModel;
import net.daylong.baselibrary.http.view.IViewBaseView;

import io.reactivex.Observable;


public interface WalletInfoContract {
    interface WalletInfoModel extends IViewBaseModel {

        Observable<BaseResponse<WalletInfoResponse>> getWalletInfo();


    }

    interface WalletInfoView extends IViewBaseView {


        void onWalletInfo(WalletInfoResponse descResponse);


    }

    abstract class WalletInfoPresenter extends BasePresenter<WalletInfoModel, WalletInfoView> {

        public abstract void getWalletInfo();

    }
}
