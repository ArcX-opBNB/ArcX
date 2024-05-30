package com.daylong.httplibrary.model.model.game;

import com.daylong.httplibrary.api.GameApi;
import com.daylong.httplibrary.bean.response.game.GameInfoResponse;
import com.daylong.httplibrary.bean.response.game.GameItemInfoResponse;
import com.daylong.httplibrary.bean.response.game.QuickNameResponse;
import com.daylong.httplibrary.model.contract.game.GameProductContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.BasePageResponse;

import io.reactivex.Observable;

public class GameProductModel implements GameProductContract.GameProductModel {
    public static GameProductModel newInstance() {
        return new GameProductModel();
    }

    @Override
    public Observable<BasePageResponse<GameItemInfoResponse>> getGameProductBanner(int productType, int pageNum) {
        return RetrofitFactory.getInstance().createApi(GameApi.class).getGameProductBanner(productType, pageNum, MAX_PAGE_SIZE);
    }

    @Override
    public Observable<BaseResponse<GameItemInfoResponse>> getUserGame() {
        return RetrofitFactory.getInstance().createApi(GameApi.class).getUserGame();
    }

    @Override
    public Observable<BaseResponse<QuickNameResponse>> getQuickGame(int devTp) {
        return RetrofitFactory.getInstance().createApi(GameApi.class).getQuickGame(devTp);
    }

    @Override
    public Observable<BaseResponse<GameInfoResponse>> getGameInfo(int productId) {
        return RetrofitFactory.getInstance().createApi(GameApi.class).getGameInfo(productId);
    }


}
