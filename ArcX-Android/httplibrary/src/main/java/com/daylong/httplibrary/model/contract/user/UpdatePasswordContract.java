package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.request.user.UpdatePasswordRequest;
import com.daylong.httplibrary.bean.response.user.LoginResponse;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import io.reactivex.Observable;

public interface UpdatePasswordContract {
    interface UpdatePasswordModel extends IViewBaseModel {


        Observable<BaseResponse<Object>> updatePassword(UpdatePasswordRequest UpdatePasswordRequest);

        Observable<BaseResponse<Object>> getEmailCode(String email);


    }

    interface UpdatePasswordView extends IBaseView {

        void onUpdatePasswordSuc(Object userInfoResponse);
        void onFail(String str);
        void onEmailCodeSuc();

    }

    abstract class UpdatePasswordPresenter extends BasePresenter<UpdatePasswordModel, UpdatePasswordView> {


        public abstract void updatePassword(UpdatePasswordRequest UpdatePasswordRequest);

        public abstract void getEmailCode(String email);



    }
}
