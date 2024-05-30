package com.daylong.httplibrary.model.contract.user;


import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseModel;
import net.daylong.baselibrary.http.response.IBaseView;

import io.reactivex.Observable;


public interface FeedbackContract {
    interface FeedbackModel extends IBaseModel {
        Observable<BaseResponse<Object>> postFeedback(String str);

    }

    interface FeedbackView extends IBaseView {

        void onFeedback();


    }

    abstract class FeedbackPresenter extends BasePresenter<FeedbackModel, FeedbackView> {


        public abstract void postFeedback(String str);

        


    }
}
