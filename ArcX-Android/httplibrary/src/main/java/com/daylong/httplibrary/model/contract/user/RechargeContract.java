package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.response.user.RechargeResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import io.reactivex.Observable;

public interface RechargeContract {
    interface RechargeModel extends IViewBaseModel {



        Observable<BaseResponse<RechargeResponse>> getRechargeInfo();

    }

    interface RechargeView extends IBaseView {


        void onRechargeInfo(RechargeResponse data);


    }

    abstract class RechargePresenter extends BasePresenter<RechargeModel, RechargeView> {
        public abstract void getRechargeInfo();

    }
}
