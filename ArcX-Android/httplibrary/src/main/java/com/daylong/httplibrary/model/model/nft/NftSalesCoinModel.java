package com.daylong.httplibrary.model.model.nft;

import com.daylong.httplibrary.api.DefaultApi;
import com.daylong.httplibrary.api.NftApi;
import com.daylong.httplibrary.bean.request.nft.ExchangeCoinRequest;
import com.daylong.httplibrary.bean.response.nft.NftExchangeResponse;
import com.daylong.httplibrary.bean.response.nft.NftSalesCoinInfoResponse;
import com.daylong.httplibrary.model.contract.nft.NftSalesCoinContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import io.reactivex.Observable;

public class NftSalesCoinModel implements NftSalesCoinContract.NftSalesCoinModel {
    public static NftSalesCoinModel newInstance() {
        return new NftSalesCoinModel();
    }

    @Override
    public Observable<BaseResponse<NftSalesCoinInfoResponse>> getNftSalesCoinInfo() {
        return RetrofitFactory.getInstance().createApi(NftApi.class).getNftSalesCoinInfo();
    }

    @Override
    public Observable<BaseResponse<NftExchangeResponse>> exchangeCoin(String nftCd, long usdtAmt, long usdtExc) {
        return RetrofitFactory.getInstance().createApi(NftApi.class).ExchangeCoinRequest(new ExchangeCoinRequest(nftCd, usdtAmt, usdtExc));
    }
}
