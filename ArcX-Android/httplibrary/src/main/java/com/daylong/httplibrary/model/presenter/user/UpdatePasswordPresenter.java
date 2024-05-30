package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.request.user.UpdatePasswordRequest;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.model.contract.user.UpdatePasswordContract;
import com.daylong.httplibrary.model.model.user.UpdatePasswordModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class UpdatePasswordPresenter extends UpdatePasswordContract.UpdatePasswordPresenter {

    public static UpdatePasswordPresenter newInstance() {
        return new UpdatePasswordPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public UpdatePasswordModel getModel() {
        return UpdatePasswordModel.newInstance();
    }




    @Override
    public void updatePassword(UpdatePasswordRequest UpdatePasswordRequest) {

        if (mIModel != null) {
            mIModel.updatePassword(UpdatePasswordRequest)
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
                                mIView.onUpdatePasswordSuc(data);
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

    @Override
    public void getEmailCode(String email) {

        if (mIModel != null) {
            mIModel.getEmailCode(email)
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
                                mIView.onEmailCodeSuc();
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

