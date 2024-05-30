package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.request.user.OrderRequest;
import com.daylong.httplibrary.model.contract.user.OrderPostContract;
import com.daylong.httplibrary.model.model.user.OrderPostModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;


public class OrderPostPresenter extends OrderPostContract.OrderPostPresenter {

    public static OrderPostPresenter newInstance() {
        return new OrderPostPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public OrderPostModel getModel() {
        return OrderPostModel.newInstance();
    }


    @Override
    public void postOrder(OrderRequest orderRequest) {
        if (mIModel != null) {
            mIModel.postOrder(orderRequest)
                    .compose(RxScheduler.<BaseResponse<Object>>rxSchedulerTransform())
                    .compose(mIView.<BaseResponse<Object>>bindToLife())
                    .subscribe(new BaseObserver<Object>() {


                        @Override
                        protected void onStart() {

                            if (mIView != null) {
                                mIView.showLoadingDialog();
                            }

                        }

                        @Override
                        protected void onSuccess(Object data) throws Exception {
                            if (mIView != null) {
                                mIView.onOrderPostSuc();
                            }
                        }

                        @Override
                        protected void onFinish() {

                            if (mIView != null) {
                                mIView.dismissLoadingDialog();
                            }
                        }
                    });
        }

    }
}

