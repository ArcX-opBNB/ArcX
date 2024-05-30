package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.user.TaskReceiveRequest;
import com.daylong.httplibrary.bean.response.user.TaskInfoResponse;

import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import java.util.List;

import io.reactivex.Observable;

public interface TaskContract {
    interface TaskModel extends IViewBaseModel {



        Observable<BasePageResponse<TaskInfoResponse>> getTaskList();
        Observable<BasePageResponse<AwardBean>> receive(TaskReceiveRequest request);

    }

    interface TaskView extends IBaseView {
        void onTaskInfoList(List<TaskInfoResponse> data);
        void onReceiveSuc(List<AwardBean> data);


    }

    abstract class TaskPresenter extends BasePresenter<TaskModel, TaskView> {


        public abstract void getTaskList();
        public abstract void receive( Integer integer);

        

    }
}
