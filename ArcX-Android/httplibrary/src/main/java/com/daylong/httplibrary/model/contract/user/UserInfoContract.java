package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import io.reactivex.Observable;

public interface UserInfoContract {
    interface UserInfoModel extends IViewBaseModel {


        Observable<BaseResponse<LoginUserInfoResponse>> getUserInfoUserInfo();

        Observable<BaseResponse<Object>> updatePassword(String email, String password, String code);

        Observable<BaseResponse<Object>> updateLevel(int atbTp);

    }

    interface UserInfoView extends IBaseView {


        void onUserInfoSuc(LoginUserInfoResponse userInfoResponse);

        void onUpdateLevelSuc();
        void onUpdatePasswordSuc();


    }

    abstract class UserInfoPresenter extends BasePresenter<UserInfoModel, UserInfoView> {

        public abstract void getUserInfo();

        public abstract void updateLevel(int atbTp);
        public abstract void  updatePassword(String email, String password, String code);

        

    }
}
