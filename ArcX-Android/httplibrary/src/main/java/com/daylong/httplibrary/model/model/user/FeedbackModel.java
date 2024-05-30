package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.request.user.FeedbackRequest;
import com.daylong.httplibrary.model.contract.user.FeedbackContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;

import io.reactivex.Observable;

public class FeedbackModel implements FeedbackContract.FeedbackModel {
    public static FeedbackModel newInstance() {
        return new FeedbackModel();
    }


    @Override
    public Observable<BaseResponse<Object>> postFeedback(String str) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).postFeedback(new FeedbackRequest(str));
    }
}
