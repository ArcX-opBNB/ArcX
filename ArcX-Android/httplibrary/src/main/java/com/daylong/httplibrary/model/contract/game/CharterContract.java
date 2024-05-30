package com.daylong.httplibrary.model.contract.game;

import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;
import com.daylong.httplibrary.bean.response.game.charter.UserCharterInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.view.IViewBaseModel;
import net.daylong.baselibrary.http.view.IViewBaseView;

import io.reactivex.Observable;


public interface CharterContract {
    interface CharterModel extends IViewBaseModel {

        Observable<BaseResponse<CharterDescResponse>> getGameCharterDesc(int productId);

        Observable<BaseResponse<UserCharterInfoResponse>> getUserCharterInfo();

    }

    interface CharterView extends IViewBaseView {


        void onGameCharterDesc(CharterDescResponse descResponse);

        void onUserCharterInfo(UserCharterInfoResponse charterInfoResponse);


    }

    abstract class CharterPresenter extends BasePresenter<CharterModel, CharterView> {

        public abstract void getGameCharterDesc(int productId);

        public abstract void getUserCharterInfo();

    }
}
