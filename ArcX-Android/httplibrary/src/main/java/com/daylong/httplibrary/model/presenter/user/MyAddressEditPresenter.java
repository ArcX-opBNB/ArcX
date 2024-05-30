package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.response.user.MyAddressResponse;
import com.daylong.httplibrary.model.contract.user.MyAddressEditContract;
import com.daylong.httplibrary.model.model.user.MyAddressEditModel;

import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;


public class MyAddressEditPresenter extends MyAddressEditContract.MyAddressEditPresenter {

    public static MyAddressEditPresenter newInstance() {
        return new MyAddressEditPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public MyAddressEditModel getModel() {
        return MyAddressEditModel.newInstance();
    }


    @Override
    public void getMyAddressEditList(MyAddressResponse addressResponse) {
        if (mIModel != null) {
            mIModel.update(addressResponse)
                    .compose(RxScheduler.<BasePageResponse<Object>>rxSchedulerTransform())
                    .compose(mIView.<BasePageResponse<Object>>bindToLife())
                    .subscribe(new BasePageObserver<Object>() {


                        @Override
                        protected void onStart() {

                            if (mIView != null) {
                                mIView.showLoadingDialog();
                            }

                        }

                        @Override
                        protected void onSuccess(List<Object> data, BasePageResponse<Object> basePageResponse) throws Exception {
                            mIView.onMyAddressEditSuc();
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

