package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.user.UpdateUserInfoRequest;
import com.daylong.httplibrary.model.contract.user.UpdateUserInfoContract;
import com.daylong.httplibrary.model.model.user.UpdateUserInfoModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;


public class UpdateUserInfoPresenter extends UpdateUserInfoContract.UpdateUserInfoPresenter {

    public static UpdateUserInfoPresenter newInstance() {
        return new UpdateUserInfoPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public UpdateUserInfoModel getModel() {
        return UpdateUserInfoModel.newInstance();
    }


    @Override
    public void updateUserInfo(UpdateUserInfoRequest updateUserInfoRequest) {
        if (mIModel != null) {
            mIModel.updateUserInfo(updateUserInfoRequest)
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
                        protected void onSuccess(Object data) throws Exception {
                            if (mIView != null) {
                                mIView.onUpdateUserInfoSuc();
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

