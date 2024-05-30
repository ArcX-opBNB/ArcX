package com.daylong.httplibrary.model.model.user;

import com.daylong.httplibrary.api.UserApi;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.user.TaskReceiveRequest;
import com.daylong.httplibrary.bean.response.user.TaskInfoResponse;
import com.daylong.httplibrary.model.contract.user.TaskContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseModel;

import io.reactivex.Observable;

public class TaskModel implements TaskContract.TaskModel, IBaseModel {
    public static TaskModel newInstance() {
        return new TaskModel();
    }


    @Override
    public Observable<BasePageResponse<TaskInfoResponse>> getTaskList() {
        return RetrofitFactory.getInstance().createApi(UserApi.class).getTaskList();
    }

    @Override
    public Observable<BasePageResponse<AwardBean>> receive(TaskReceiveRequest request) {
        return RetrofitFactory.getInstance().createApi(UserApi.class).receive(request);
    }



}
