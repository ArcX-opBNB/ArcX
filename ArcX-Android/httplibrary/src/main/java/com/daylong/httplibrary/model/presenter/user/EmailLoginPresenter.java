package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.request.user.EmailLoginRequest;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.model.contract.user.EmailLoginContract;
import com.daylong.httplibrary.model.model.user.EmailLoginModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;


public class EmailLoginPresenter extends EmailLoginContract.EmailLoginPresenter {

    public static EmailLoginPresenter newInstance() {
        return new EmailLoginPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public EmailLoginModel getModel() {
        return EmailLoginModel.newInstance();
    }


    @Override
    public void emailLogin(EmailLoginRequest emailLoginRequest) {

        if (mIModel != null) {
            mIModel.emailLogin(emailLoginRequest)
                    .compose(RxScheduler.<BaseResponse<LoginResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<LoginResponse>>bindToLife())
                    .subscribe(new BaseObserver<LoginResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onError(String message) throws Exception {
                            if (mIView != null) {
                                mIView.onFail(message);
                            }
                        }

                        @Override
                        protected void onSuccess(LoginResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onLoginSuc(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void getLoginUserInfo(long id) {
        if (mIModel != null) {
            mIModel.getLoginUserInfo()
                    .compose(RxScheduler.<BaseResponse<LoginUserInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<LoginUserInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<LoginUserInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onError(String message) throws Exception {
                            if (mIView != null) {
                                mIView.onFail(message);

                            }
                        }

                        @Override
                        protected void onSuccess(LoginUserInfoResponse data) throws Exception {
                            if (mIView != null) {
                                data.setPlyId(id);
                                mIView.onUserInfoSuc(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

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
                                mIView.onEmailCodeSuc(data);
                            }
                        }

                        @Override
                        protected void onError(String message) throws Exception {
                            if (mIView != null) {
                                mIView.onFail(message);

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

