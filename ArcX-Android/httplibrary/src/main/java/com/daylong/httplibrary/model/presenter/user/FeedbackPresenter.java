package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.model.contract.user.FeedbackContract;
import com.daylong.httplibrary.model.model.user.FeedbackModel;

import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.observer.BaseObserver;
import net.daylong.baselibrary.utils.rx.RxScheduler;

public class FeedbackPresenter extends FeedbackContract.FeedbackPresenter {
    public static FeedbackPresenter newInstance() {
        return new FeedbackPresenter();
    }

    @Override
    public void onStart() {

    }

    @Override
    public FeedbackModel getModel() {
        return FeedbackModel.newInstance();
    }




    @Override
    public void postFeedback(String str) {
          if (mIModel != null) {
                      mIModel.postFeedback(str)
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
                                          mIView.onFeedback();
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

