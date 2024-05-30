package com.daylong.httplibrary.model.presenter.nft;


import com.daylong.httplibrary.bean.response.nft.NftExchangeResponse;
import com.daylong.httplibrary.bean.response.nft.NftSalesCoinInfoResponse;
import com.daylong.httplibrary.model.contract.nft.NftSalesCoinContract;
import com.daylong.httplibrary.model.model.nft.NftSalesCoinModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;

public class NftSalesCoinPresenter extends NftSalesCoinContract.NftSalesCoinBannerPresenter {

    public static NftSalesCoinPresenter newInstance() {
        return new NftSalesCoinPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public NftSalesCoinModel getModel() {
        return NftSalesCoinModel.newInstance();
    }


    @Override
    public void getNftSalesCoinInfo() {

        if (mIModel != null) {
            mIModel.getNftSalesCoinInfo()
                    .compose(RxScheduler.<BaseResponse<NftSalesCoinInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<NftSalesCoinInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<NftSalesCoinInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(NftSalesCoinInfoResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onNftSalesCoinInfo(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void exchangeCoin(String nftCd, long usdtAmt, long usdtExc) {
        if (mIModel != null) {
            mIModel.exchangeCoin(nftCd, usdtAmt, usdtExc)
                    .compose(RxScheduler.<BaseResponse<NftExchangeResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<NftExchangeResponse>>bindToLife())
                    .subscribe(new BaseObserver<NftExchangeResponse>() {


                        @Override
                        protected void onStart() {

                            if (mIView != null) {
                                mIView.showLoadingDialog();
                            }

                        }

                        @Override
                        protected void onSuccess(NftExchangeResponse data) throws Exception {
                            if (mIView != null) {
                                getNftSalesCoinInfo();
                                mIView.onExchangeCoin(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                            if (mIView != null) {
                                mIView.dismissLoadingDialog();
                            }

                        }
                    });
        }
    }
}

