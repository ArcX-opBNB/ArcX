package com.daylong.httplibrary.model.contract.nft;

import com.daylong.httplibrary.bean.response.nft.NftExchangeResponse;
import com.daylong.httplibrary.bean.response.nft.NftSalesCoinInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseModel;
import net.daylong.baselibrary.http.response.IBaseView;

import java.util.List;

import io.reactivex.Observable;

public interface NftSalesCoinContract {
    interface NftSalesCoinModel extends IBaseModel {


        Observable<BaseResponse<NftSalesCoinInfoResponse>> getNftSalesCoinInfo();

        Observable<BaseResponse<NftExchangeResponse>> exchangeCoin(String nftCd, long usdtAmt, long usdtExc);
    }

    interface NftSalesCoinView extends IBaseView {

        void onNftSalesCoinInfo(NftSalesCoinInfoResponse list);
        void onExchangeCoin(NftExchangeResponse exchangeResponse);


    }

    abstract class NftSalesCoinBannerPresenter extends BasePresenter<NftSalesCoinModel, NftSalesCoinView> {

        public abstract void getNftSalesCoinInfo();
        public abstract void  exchangeCoin(String nftCd, long usdtAmt, long usdtExc);
        

    }
}
