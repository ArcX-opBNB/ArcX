package com.daylong.httplibrary.model.contract.game;


import com.daylong.httplibrary.bean.response.game.GameInfoResponse;
import com.daylong.httplibrary.bean.response.game.GameItemInfoResponse;
import com.daylong.httplibrary.bean.response.game.QuickNameResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;
import net.daylong.baselibrary.http.response.IBaseView;

import java.util.List;

import io.reactivex.Observable;

public interface GameProductContract {
    interface GameProductModel extends IBaseModel {


        Observable<BasePageResponse<GameItemInfoResponse>> getGameProductBanner(int productType, int pageNum);

        Observable<BaseResponse<GameItemInfoResponse>> getUserGame();
        Observable<BaseResponse<QuickNameResponse>> getQuickGame(int devTp);

        Observable<BaseResponse<GameInfoResponse>> getGameInfo(int productId);
    }

    interface GameProductView extends IBaseView {

        void onGameProductBannerMsg(List<GameItemInfoResponse> list);


        void onGameInfo(GameInfoResponse gameInfoResponse);


    }

    abstract class GameProductPresenter extends BasePresenter<GameProductModel, GameProductView> {

        public abstract void getGameProductBanner(int productType, int pageNum);

        public abstract void getUserGame(int productId);

        public abstract void getGameInfo(int productId);
        public abstract void getQuickGame(int devTp);
        

    }
}
