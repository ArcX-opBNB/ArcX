package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.request.user.UpdateUserInfoRequest;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import java.util.List;

import io.reactivex.Observable;

public interface UpdateUserInfoContract {
    interface UpdateUserInfoModel extends IViewBaseModel {



        Observable<BaseResponse<Object>> updateUserInfo(UpdateUserInfoRequest updateUserInfoRequest);

    }

    interface UpdateUserInfoView extends IBaseView {


        void onUpdateUserInfoSuc();


    }

    abstract class UpdateUserInfoPresenter extends BasePresenter<UpdateUserInfoModel, UpdateUserInfoView> {


        public abstract void updateUserInfo(UpdateUserInfoRequest updateUserInfoRequest);

    }
}
