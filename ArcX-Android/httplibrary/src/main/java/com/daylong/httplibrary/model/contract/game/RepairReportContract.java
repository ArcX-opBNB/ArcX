package com.daylong.httplibrary.model.contract.game;


import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseModel;
import net.daylong.baselibrary.http.response.IBaseView;

import io.reactivex.Observable;


public interface RepairReportContract {
    interface RepairReportModel extends IBaseModel {

        Observable<BaseResponse<Object>> postRepairReport(Integer productId);

    }

    interface RepairReportView extends IBaseView {


        void onRepairReportSuc();
        void onRepairReportFail();


    }

    abstract class RepairReportPresenter extends BasePresenter<RepairReportModel, RepairReportView> {
        public abstract void postRepairReport(Integer productId);



    }
}
