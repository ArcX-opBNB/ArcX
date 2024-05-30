package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;
import com.daylong.httplibrary.model.contract.user.SendGoodsContract;
import com.daylong.httplibrary.model.model.user.SendGoodsModel;

import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;


public class SendGoodsPresenter extends SendGoodsContract.SendGoodsPresenter {

    public static SendGoodsPresenter newInstance() {
        return new SendGoodsPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public SendGoodsModel getModel() {
        return SendGoodsModel.newInstance();
    }


    @Override
    public void getSendGoodsList(int page) {
        if (mIModel != null) {
            mIModel.getSendGoodsList(page)
                    .compose(RxScheduler.<BasePageResponse<MyGoodsResponse>>rxSchedulerTransform())
                    .compose(mIView.<BasePageResponse<MyGoodsResponse>>bindToLife())
                    .subscribe(new BasePageObserver<MyGoodsResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(List<MyGoodsResponse> data, BasePageResponse<MyGoodsResponse> basePageResponse) throws Exception {
                            if (mIView != null) {
                                mIView.onSendGoodsInfoList(data);
                            }
                        }


                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

