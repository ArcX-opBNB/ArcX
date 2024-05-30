package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;

import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import java.util.List;

import io.reactivex.Observable;

/**

 */
public interface MyPendingItemsContract {
    interface MyPendingItemsModel extends IViewBaseModel {



        Observable<BasePageResponse<MyGoodsResponse>> getMyPendingItemsList(int page);

    }

    interface MyPendingItemsView extends IBaseView {
        void onMyPendingItemsInfoList(List<MyGoodsResponse> data);


    }

    abstract class MyPendingItemsPresenter extends BasePresenter<MyPendingItemsModel, MyPendingItemsView> {


        public abstract void getMyPendingItemsList(int page);

    }
}
