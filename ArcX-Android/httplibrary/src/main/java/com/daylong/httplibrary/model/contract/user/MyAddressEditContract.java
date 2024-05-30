package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.response.user.MyAddressResponse;

import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import io.reactivex.Observable;

/**

 */
public interface MyAddressEditContract {
    interface MyAddressEditModel extends IViewBaseModel {


        Observable<BasePageResponse<Object>> update(MyAddressResponse addressResponse);

    }

    interface MyAddressEditView extends IBaseView {
        void onMyAddressEditSuc();


    }

    abstract class MyAddressEditPresenter extends BasePresenter<MyAddressEditModel, MyAddressEditView> {


        public abstract void getMyAddressEditList(MyAddressResponse addressResponse);

    }
}
