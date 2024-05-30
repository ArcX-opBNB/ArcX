package com.daylong.httplibrary.model.model.wallet;


import com.daylong.httplibrary.api.WalletApi;
import com.daylong.httplibrary.bean.request.wallet.WithdrawalRequest;
import com.daylong.httplibrary.model.contract.wallet.WithdrawalContract;
import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class WithdrawalModel implements WithdrawalContract.WithdrawalModel, IBaseModel {
    public static WithdrawalModel newInstance() {
        return new WithdrawalModel();
    }


    @Override
    public Observable<BaseResponse<Object>> postWithdrawal(int tkTp, double amt) {
        return RetrofitFactory.getInstance().createApi(WalletApi.class).getWithdrawal(new WithdrawalRequest(tkTp, amt));
    }
}
