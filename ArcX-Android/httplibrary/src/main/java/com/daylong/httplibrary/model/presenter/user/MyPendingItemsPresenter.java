package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;
import com.daylong.httplibrary.model.contract.user.MyPendingItemsContract;
import com.daylong.httplibrary.model.model.user.MyPendingItemsModel;

import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;


public class MyPendingItemsPresenter extends MyPendingItemsContract.MyPendingItemsPresenter {

    public static MyPendingItemsPresenter newInstance() {
        return new MyPendingItemsPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public MyPendingItemsModel getModel() {
        return MyPendingItemsModel.newInstance();
    }


    @Override
    public void getMyPendingItemsList(int page) {
        if (mIModel != null) {
            mIModel.getMyPendingItemsList(page)
                    .compose(RxScheduler.<BasePageResponse<MyGoodsResponse>>rxSchedulerTransform())
                    .compose(mIView.<BasePageResponse<MyGoodsResponse>>bindToLife())
                    .subscribe(new BasePageObserver<MyGoodsResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(List<MyGoodsResponse> data, BasePageResponse<MyGoodsResponse> basePageResponse) throws Exception {
                            if (mIView != null) {
                                mIView.onMyPendingItemsInfoList(data);
                            }
                        }


                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

