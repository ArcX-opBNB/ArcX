package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.request.user.OrderRequest;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import io.reactivex.Observable;

public interface OrderPostContract {
    interface OrderPostModel extends IViewBaseModel {


        Observable<BaseResponse<Object>> postOrder(OrderRequest orderRequest);


    }

    interface OrderPostView extends IBaseView {


        void onOrderPostSuc();



    }

    abstract class OrderPostPresenter extends BasePresenter<OrderPostModel, OrderPostView> {


        public abstract void postOrder(OrderRequest orderRequest);


    }
}
