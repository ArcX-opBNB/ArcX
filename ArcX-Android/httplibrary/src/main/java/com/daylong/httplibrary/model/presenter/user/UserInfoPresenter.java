package com.daylong.httplibrary.model.presenter.user;


import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.model.contract.user.UserInfoContract;
import com.daylong.httplibrary.model.model.user.UserInfoModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class UserInfoPresenter extends UserInfoContract.UserInfoPresenter {

    public static UserInfoPresenter newInstance() {
        return new UserInfoPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public UserInfoModel getModel() {
        return UserInfoModel.newInstance();
    }


    @Override
    public void getUserInfo() {
        if (mIModel != null) {
            mIModel.getUserInfoUserInfo()
                    .compose(RxScheduler.<BaseResponse<LoginUserInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<LoginUserInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<LoginUserInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onError(String message) throws Exception {
                            super.onError(message);
                        }

                        @Override
                        protected void onSuccess(LoginUserInfoResponse data) throws Exception {
                            if (mIView != null) {
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
    public void updateLevel(int atbTp) {
        if (mIModel != null) {
            mIModel.updateLevel(atbTp)
                    .compose(RxScheduler.<BaseResponse<Object>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<Object>>bindToLife())
                    .subscribe(new BaseObserver<Object>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(Object data) throws Exception {
                            if (mIView != null) {
                                mIView.onUpdateLevelSuc();
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void updatePassword(String email, String password, String code) {
        if (mIModel != null) {
            mIModel.updatePassword(email,password,code)
                    .compose(RxScheduler.<BaseResponse<Object>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<Object>>bindToLife())
                    .subscribe(new BaseObserver<Object>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(Object data) throws Exception {
                            if (mIView != null) {
                                mIView.onUpdatePasswordSuc();
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }


}

