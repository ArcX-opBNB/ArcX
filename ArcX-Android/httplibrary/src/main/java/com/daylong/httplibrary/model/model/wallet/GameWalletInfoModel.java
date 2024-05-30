package com.daylong.httplibrary.model.model.wallet;


import com.daylong.httplibrary.api.WalletApi;
import com.daylong.httplibrary.bean.response.wallet.WalletConfigureResponse;
import com.daylong.httplibrary.bean.response.wallet.WalletInfoResponse;
import com.daylong.httplibrary.model.contract.wallet.GameWalletInfoContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class GameWalletInfoModel implements GameWalletInfoContract.GameWalletInfoModel, IBaseModel {
    public static GameWalletInfoModel newInstance() {
        return new GameWalletInfoModel();
    }





    @Override
    public Observable<BaseResponse<WalletInfoResponse>> getGameWalletInfo() {
        return RetrofitFactory.getInstance().createApi(WalletApi.class).getGameWalletInfo();
    }

    @Override
    public Observable<BaseResponse<WalletConfigureResponse>> getConfigureInfo() {
        return RetrofitFactory.getInstance().createApi(WalletApi.class).getWalletConfigureInfo();
    }
}
