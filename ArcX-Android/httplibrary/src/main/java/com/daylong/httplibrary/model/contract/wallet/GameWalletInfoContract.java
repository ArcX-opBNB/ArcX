package com.daylong.httplibrary.model.contract.wallet;


import com.daylong.httplibrary.bean.response.wallet.WalletConfigureResponse;
import com.daylong.httplibrary.bean.response.wallet.WalletInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.view.IViewBaseModel;
import net.daylong.baselibrary.http.view.IViewBaseView;

import io.reactivex.Observable;


public interface GameWalletInfoContract {
    interface GameWalletInfoModel extends IViewBaseModel {

        Observable<BaseResponse<WalletInfoResponse>> getGameWalletInfo();

        Observable<BaseResponse<WalletConfigureResponse>> getConfigureInfo();


    }

    interface GameWalletInfoView extends IViewBaseView {


        void onGameWalletInfo(WalletInfoResponse descResponse);
        void onWalletConfigureInfo(WalletConfigureResponse descResponse);


    }

    abstract class GameWalletInfoPresenter extends BasePresenter<GameWalletInfoModel, GameWalletInfoView> {

        public abstract void getGameWalletInfo();
        public abstract void getConfigureInfo();

    }
}
