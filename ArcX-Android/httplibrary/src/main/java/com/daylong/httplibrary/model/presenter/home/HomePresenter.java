package com.daylong.httplibrary.model.presenter.home;

import com.daylong.httplibrary.bean.response.defaults.HomeBannerResponse;
import com.daylong.httplibrary.model.contract.home.HomeContract;
import com.daylong.httplibrary.model.model.home.HomeModel;

import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;

public class HomePresenter extends HomeContract.HomeBannerPresenter {

    public static HomePresenter newInstance() {
        return new HomePresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public HomeModel getModel() {
        return HomeModel.newInstance();
    }


    @Override
    public void getHomeBanner() {

    }
}

