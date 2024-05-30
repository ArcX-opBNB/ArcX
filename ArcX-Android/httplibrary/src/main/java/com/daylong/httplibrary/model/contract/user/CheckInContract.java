package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.response.user.CheckInInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import java.util.List;

import io.reactivex.Observable;

public interface CheckInContract {
    interface CheckInModel extends IViewBaseModel {



        Observable<BasePageResponse<AwardBean>> checkIn();
        Observable<BaseResponse<CheckInInfoResponse>> getCheckInfo();

    }

    interface CheckInView extends IBaseView {


        void onCheckInSuc(List<AwardBean> data);
        void onCheckInInfo(CheckInInfoResponse data);


    }

    abstract class CheckInPresenter extends BasePresenter<CheckInModel, CheckInView> {


        public abstract void checkIn();
        public abstract void getCheckInfo();

        

    }
}
