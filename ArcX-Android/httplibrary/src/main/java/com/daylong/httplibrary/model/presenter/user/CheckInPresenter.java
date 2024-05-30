package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.response.user.CheckInInfoResponse;
import com.daylong.httplibrary.model.contract.user.CheckInContract;
import com.daylong.httplibrary.model.model.user.CheckInModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;


public class CheckInPresenter extends CheckInContract.CheckInPresenter {

    public static CheckInPresenter newInstance() {
        return new CheckInPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public CheckInModel getModel() {
        return CheckInModel.newInstance();
    }


    @Override
    public void checkIn() {
        if (mIModel != null) {
            mIModel.checkIn()
                    .compose(RxScheduler.<BasePageResponse<AwardBean>>rxSchedulerTransform())
                    .compose(mIView.<BasePageResponse<AwardBean>>bindToLife())
                    .subscribe(new BasePageObserver<AwardBean>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(List<AwardBean> data, BasePageResponse<AwardBean> basePageResponse) throws Exception {
                            if (mIView != null) {
                                mIView.onCheckInSuc(data);
                            }
                        }


                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void getCheckInfo() {
        if (mIModel != null) {
            mIModel.getCheckInfo()
                    .compose(RxScheduler.<BaseResponse<CheckInInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<CheckInInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<CheckInInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(CheckInInfoResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onCheckInInfo(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

