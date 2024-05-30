package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.response.user.InvitationInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import io.reactivex.Observable;

public interface InvitationContract {
    interface InvitationModel extends IViewBaseModel {


        Observable<BaseResponse<InvitationInfoResponse>> getInvitationInfo();

        Observable<BaseResponse<Object>> bindInvitation(String code);


    }

    interface InvitationView extends IBaseView {

        void onInvitationInfoSuc(InvitationInfoResponse webSocketMsgResponse);

        void onBindInvitationSuc();


    }

    abstract class InvitationPresenter extends BasePresenter<InvitationModel, InvitationView> {


        public abstract void getInvitationInfo();

        public abstract void bindInvitation(String code);


    }
}
