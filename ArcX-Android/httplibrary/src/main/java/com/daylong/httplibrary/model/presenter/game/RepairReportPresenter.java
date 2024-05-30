package com.daylong.httplibrary.model.presenter.game;

import com.daylong.httplibrary.model.contract.game.RepairReportContract;
import com.daylong.httplibrary.model.model.game.RepairReportModel;

import net.daylong.baselibrary.http.ApiException;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class RepairReportPresenter extends RepairReportContract.RepairReportPresenter {
    public static RepairReportPresenter newInstance() {
        return new RepairReportPresenter();
    }

    @Override
    public void onStart() {

    }

    @Override
    public RepairReportModel getModel() {
        return RepairReportModel.newInstance();
    }


    @Override
    public void postRepairReport(Integer productId) {
        if (mIModel != null) {
            mIModel.postRepairReport(productId)
                    .compose(RxScheduler.<BaseResponse<Object>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<Object>>bindToLife())
                    .subscribe(new BaseObserver<Object>() {


                        @Override
                        protected void onStart() {

                            if (mIView != null) {
                                mIView.showLoadingDialog();
                            }

                        }

                        @Override
                        protected void onError(ApiException apiException) throws Exception {
                            super.onError(apiException);
                            if (mIView != null) {
                                mIView.onRepairReportFail();
                            }
                        }

                        @Override
                        protected void onSuccess(Object data) throws Exception {
                            if (mIView != null) {
                                mIView.onRepairReportSuc();
                            }
                        }

                        @Override
                        protected void onFinish() {
                            if (mIView != null) {
                                mIView.dismissLoadingDialog();
                            }

                        }
                    });
        }
    }
}

