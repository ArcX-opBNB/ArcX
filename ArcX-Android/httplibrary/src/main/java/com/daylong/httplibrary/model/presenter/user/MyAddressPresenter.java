package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.response.user.MyAddressResponse;
import com.daylong.httplibrary.model.contract.user.MyAddressContract;
import com.daylong.httplibrary.model.model.user.MyAddressModel;

import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;


public class MyAddressPresenter extends MyAddressContract.MyAddressPresenter {

    public static MyAddressPresenter newInstance() {
        return new MyAddressPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public MyAddressModel getModel() {
        return MyAddressModel.newInstance();
    }


    @Override
    public void getMyAddressList() {
        if (mIModel != null) {
            mIModel.getMyAddressList()
                    .compose(RxScheduler.<BasePageResponse<MyAddressResponse>>rxSchedulerTransform())
                    .compose(mIView.<BasePageResponse<MyAddressResponse>>bindToLife())
                    .subscribe(new BasePageObserver<MyAddressResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(List<MyAddressResponse> data, BasePageResponse<MyAddressResponse> basePageResponse) throws Exception {
                            if (mIView != null) {
                                mIView.onMyAddressInfoList(data);
                            }
                        }


                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

