package com.daylong.httplibrary.model.contract.store;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.BasePageRequest;
import com.daylong.httplibrary.bean.request.UsdTPayRequest;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;
import net.daylong.baselibrary.http.response.IBaseView;

import java.util.List;
import java.util.Objects;

import io.reactivex.Observable;

public interface StoreInfoContract {
    interface StoreInfoModel extends IBaseModel {


        Observable<BaseResponse<StoreInfoResponse>> getStoreInfo();

        Observable<BaseResponse<Object>> reProp();

        Observable<BasePageResponse<AwardBean>> pay(UsdTPayRequest usdTPayRequest);
    }

    interface StoreInfoView extends IBaseView {

        void onStoreInfoSuc(StoreInfoResponse storeInfoResponse);

        void onRePropSuc();

        void onPaySuc(AwardBean awardBean);


    }

    abstract class StoreInfoBannerPresenter extends BasePresenter<StoreInfoModel, StoreInfoView> {

        public abstract void getStoreInfo();

        public abstract void reProp();

        public abstract void pay(UsdTPayRequest usdTPayRequest);

    }
}
