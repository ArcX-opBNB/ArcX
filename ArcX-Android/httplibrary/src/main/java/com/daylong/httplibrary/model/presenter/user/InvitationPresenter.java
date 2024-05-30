package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.response.user.InvitationInfoResponse;
import com.daylong.httplibrary.model.contract.user.InvitationContract;
import com.daylong.httplibrary.model.model.user.InvitationModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class InvitationPresenter extends InvitationContract.InvitationPresenter {

    public static InvitationPresenter newInstance() {
        return new InvitationPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public InvitationModel getModel() {
        return InvitationModel.newInstance();
    }


    @Override
    public void getInvitationInfo() {
        if (mIModel != null) {
            mIModel.getInvitationInfo()
                    .compose(RxScheduler.<BaseResponse<InvitationInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<InvitationInfoResponse>>bindToLife())
                    .subscribe(new BaseObserver<InvitationInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(InvitationInfoResponse data) throws Exception {
                            if (mIView != null) {
                                mIView.onInvitationInfoSuc(data);
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void bindInvitation(String code) {
        if (mIModel != null) {
            mIModel.bindInvitation(code)
                    .compose(RxScheduler.<BaseResponse<Object>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<Object>>bindToLife())
                    .subscribe(new BaseObserver<Object>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(Object data) throws Exception {
                            if (mIView != null) {
                                mIView.onBindInvitationSuc();
                            }
                        }

                        @Override
                        protected void onFinish() {

                        }
                    });
        }

    }
}

