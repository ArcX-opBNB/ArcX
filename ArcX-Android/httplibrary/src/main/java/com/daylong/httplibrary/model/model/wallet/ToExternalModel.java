package com.daylong.httplibrary.model.model.wallet;


import com.daylong.httplibrary.api.WalletApi;
import com.daylong.httplibrary.bean.request.wallet.ToExternalRequest;
import com.daylong.httplibrary.bean.response.wallet.WalletResponse;
import com.daylong.httplibrary.model.contract.wallet.ToExternalContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class ToExternalModel implements ToExternalContract.ToExternalModel, IBaseModel {
    public static ToExternalModel newInstance() {
        return new ToExternalModel();
    }






    @Override
    public Observable<BaseResponse<WalletResponse>> postToExternal(int tkTp, int amt, String ads) {
        return RetrofitFactory.getInstance().createApi(WalletApi.class).postToExternal(new ToExternalRequest(tkTp,amt,ads));
    }
}
