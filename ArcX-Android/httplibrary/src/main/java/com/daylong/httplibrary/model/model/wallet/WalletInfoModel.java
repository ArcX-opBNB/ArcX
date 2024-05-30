package com.daylong.httplibrary.model.model.wallet;


import com.daylong.httplibrary.api.GameApi;
import com.daylong.httplibrary.api.WalletApi;
import com.daylong.httplibrary.bean.response.wallet.WalletInfoResponse;
import com.daylong.httplibrary.model.contract.wallet.WalletInfoContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class WalletInfoModel implements WalletInfoContract.WalletInfoModel, IBaseModel {
    public static WalletInfoModel newInstance() {
        return new WalletInfoModel();
    }





    @Override
    public Observable<BaseResponse<WalletInfoResponse>> getWalletInfo() {
        return RetrofitFactory.getInstance().createApi(WalletApi.class).getWalletInfo();
    }
}
