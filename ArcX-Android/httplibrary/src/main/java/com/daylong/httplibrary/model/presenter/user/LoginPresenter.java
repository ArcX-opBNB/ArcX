package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.request.user.LoginRequest;
import com.daylong.httplibrary.bean.response.AppInfoResponse;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.model.contract.user.LoginContract;
import com.daylong.httplibrary.model.model.user.LoginModel;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import net.daylong.baselibrary.app.Constant;
import net.daylong.baselibrary.http.ApiException;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class LoginPresenter extends LoginContract.LoginPresenter {

    public static LoginPresenter newInstance() {
        return new LoginPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public LoginModel getModel() {
        return LoginModel.newInstance();
    }


    @Override
    public void loginWechat() {

        wxLogin();
    }

    @Override
    public void loginTourist(LoginRequest loginRequest) {
        login(loginRequest);
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
                            super.onError(message);
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
    public void getAppInfoResponse() {
        if (mIModel != null) {
            mIModel.getAppInfoResponse()

                    .compose(RxScheduler.<BaseResponse<AppInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<AppInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<AppInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(AppInfoResponse data) throws Exception {
                            mIView.onWebSocketMsg(data);
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }


    private void wxLogin() {
        IWXAPI wxapi = WXAPIFactory.createWXAPI(mIView.getViewActivity(), Constant.WX_APP_ID, true);
        wxapi.registerApp(Constant.WX_APP_ID);
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo"; 
        wxapi.sendReq(req);
    }

    public void login(LoginRequest loginRequest) {

        mIModel.login(loginRequest)
                .compose(RxScheduler.<BaseResponse<LoginResponse>>rxSchedulerTransform())
                .compose(mIView.<BaseResponse<LoginResponse>>bindToLife())
                .subscribe(new BaseObserver<LoginResponse>() {


                    @Override
                    protected void onStart() {


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

                    @Override
                    protected void onError(ApiException apiException) throws Exception {
                        super.onError(apiException);
                    }
                });
    }


}

