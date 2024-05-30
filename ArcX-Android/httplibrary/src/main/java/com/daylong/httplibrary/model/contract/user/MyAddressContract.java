package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.response.user.MyAddressResponse;

import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import java.util.List;

import io.reactivex.Observable;

/**

 */
public interface MyAddressContract {
    interface MyAddressModel extends IViewBaseModel {



        Observable<BasePageResponse<MyAddressResponse>> getMyAddressList();

    }

    interface MyAddressView extends IBaseView {
        void onMyAddressInfoList(List<MyAddressResponse> data);


    }

    abstract class MyAddressPresenter extends BasePresenter<MyAddressModel, MyAddressView> {


        public abstract void getMyAddressList();

    }
}
