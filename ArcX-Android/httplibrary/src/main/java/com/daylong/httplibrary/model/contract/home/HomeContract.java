package com.daylong.httplibrary.model.contract.home;

import com.daylong.httplibrary.bean.response.defaults.HomeBannerResponse;

import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;
import net.daylong.baselibrary.http.response.IBaseView;

import java.util.List;

import io.reactivex.Observable;

public interface HomeContract {
    interface HomeModel extends IBaseModel {


        Observable<BasePageResponse<HomeBannerResponse>> getHomeBanner();
    }

    interface HomeView extends IBaseView {

        void onHomeBannerMsg(List<HomeBannerResponse> list);


    }

    abstract class HomeBannerPresenter extends BasePresenter<HomeModel, HomeView> {

        public abstract void getHomeBanner();
        

    }
}
