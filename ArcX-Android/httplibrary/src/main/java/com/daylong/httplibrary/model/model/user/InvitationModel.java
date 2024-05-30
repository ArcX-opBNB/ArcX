package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.request.user.InvitationRequest;
import com.daylong.httplibrary.bean.response.user.InvitationInfoResponse;
import com.daylong.httplibrary.model.contract.user.InvitationContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class InvitationModel implements InvitationContract.InvitationModel, IBaseModel {
    public static InvitationModel newInstance() {
        return new InvitationModel();
    }




    @Override
    public Observable<BaseResponse<InvitationInfoResponse>> getInvitationInfo() {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getInvitationInfo();
    }

    @Override
    public Observable<BaseResponse<Object>> bindInvitation(String code) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).bindInvitation(new InvitationRequest(code));
    }
}
