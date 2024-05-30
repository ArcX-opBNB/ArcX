package com.daylong.httplibrary.model.model.wallet;


import com.daylong.httplibrary.api.WalletApi;
import com.daylong.httplibrary.bean.request.wallet.WithdrawalRequest;
import com.daylong.httplibrary.bean.response.wallet.WalletResponse;
import com.daylong.httplibrary.model.contract.wallet.ToSpendingContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class ToSpendingModel implements ToSpendingContract.ToSpendingModel, IBaseModel {
    public static ToSpendingModel newInstance() {
        return new ToSpendingModel();
    }






    @Override
    public Observable<BaseResponse<WalletResponse>> postToSpending(int tkTp, int amt) {
        return RetrofitFactory.getInstance().createApi(WalletApi.class).postToSpending(new WithdrawalRequest(tkTp,amt));
    }
}
