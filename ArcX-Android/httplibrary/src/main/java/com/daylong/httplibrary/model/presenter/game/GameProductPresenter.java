package com.daylong.httplibrary.model.presenter.game;

import com.daylong.basecache.GameCache;
import com.daylong.httplibrary.bean.response.game.GameInfoResponse;
import com.daylong.httplibrary.bean.response.game.GameItemInfoResponse;
import com.daylong.httplibrary.bean.response.game.QuickNameResponse;
import com.daylong.httplibrary.model.contract.game.GameProductContract;
import com.daylong.httplibrary.model.model.game.GameProductModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;


public class GameProductPresenter extends GameProductContract.GameProductPresenter {

    public static GameProductPresenter newInstance() {
        return new GameProductPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public GameProductModel getModel() {
        return GameProductModel.newInstance();
    }


    @Override
    public void getGameProductBanner(int productType, int pageNum) {
        if (mIModel != null) {
            mIModel.getGameProductBanner(productType, pageNum)
                    .compose(RxScheduler.<BasePageResponse<GameItemInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BasePageResponse<GameItemInfoResponse>>bindToLife())
                    .subscribe(new BasePageObserver<GameItemInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(List<GameItemInfoResponse> data, BasePageResponse<GameItemInfoResponse> basePageResponse) throws Exception {
                            if (mIView != null) {
                                mIView.onGameProductBannerMsg(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void getUserGame(int productId) {
        if (mIModel != null) {
            mIModel.getUserGame()
                    .compose(RxScheduler.<BaseResponse<GameItemInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<GameItemInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<GameItemInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(GameItemInfoResponse data) throws Exception {
                            if (mIView != null) {
                                Integer productId1 = data.getProductId();
                                if (productId1 != null && productId1 <= 0) {
                                    productId1 = productId;
                                    
                                    GameCache.setGameLastTime(0);
                                }
                                getGameInfo(productId1);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void getGameInfo(int productId) {
        if (mIModel != null) {
            mIModel.getGameInfo(productId)
                    .compose(RxScheduler.<BaseResponse<GameInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<GameInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<GameInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(GameInfoResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onGameInfo(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void getQuickGame(int devTp) {
        if (mIModel != null) {
            mIModel.getQuickGame(devTp)
                    .compose(RxScheduler.<BaseResponse<QuickNameResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<QuickNameResponse>>bindToLife())
                    .subscribe(new BaseObserver<QuickNameResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(QuickNameResponse data) throws Exception {
                            if (mIView != null) {
                                getGameInfo(data.getDevIfo().getProductId());
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

