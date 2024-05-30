package com.daylong.arcx.view.home.banner;


import android.graphics.Color;
import android.view.ViewGroup;

import com.daylong.httplibrary.bean.response.defaults.HomeBannerResponse;
import com.daylong.arcx.adapter.BannerAdapter;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

import java.util.List;

public class HomeBannerView {

    private Banner<HomeBannerResponse, BannerAdapter> bannerView;
    private BannerAdapter bannerAdapter;


    public HomeBannerView(ViewGroup viewGroup) {

        ConstraintBuilder constraintBuilder = new ConstraintBuilder(188, 80).topCenterH().topMargin(30);

        bannerView = new Banner<HomeBannerResponse, BannerAdapter>(AppUtil.getContext());
        bannerView.setBackgroundColor(Color.WHITE);
        bannerView.setLayoutParams(constraintBuilder.buildPayoutParams());
        bannerAdapter = new BannerAdapter();
        bannerView.setAdapter(bannerAdapter);
        bannerView.setPadding(AppUtil.getSize(7), AppUtil.getSize(7), AppUtil.getSize(7), AppUtil.getSize(7));
        bannerView.setIndicator(new CircleIndicator(AppUtil.getContext()));

        viewGroup.addView(bannerView);
    }

    public Banner<HomeBannerResponse, BannerAdapter> getView() {
        return bannerView;
    }

    public void setBanner(List<HomeBannerResponse> list) {
        bannerAdapter.setDatas(list);
    }


    public void start() {
        bannerView.start();
    }

    public void stop() {
        bannerView.stop();
    }

    public void destroy() {
        bannerView.destroy();
    }

}
