package com.daylong.httplibrary.model.presenter.user;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.user.TaskReceiveRequest;
import com.daylong.httplibrary.bean.response.user.TaskInfoResponse;
import com.daylong.httplibrary.model.contract.user.TaskContract;
import com.daylong.httplibrary.model.model.user.TaskModel;

import net.daylong.baselibrary.http.observer.BasePageObserver;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.utils.rx.RxScheduler;

import java.util.List;


public class TaskPresenter extends TaskContract.TaskPresenter {

    public static TaskPresenter newInstance() {
        return new TaskPresenter();
    }

    @Override
    public void onStart() {


    }

    @Override
    public TaskModel getModel() {
        return TaskModel.newInstance();
    }


    @Override
    public void getTaskList() {
        if (mIModel != null) {
            mIModel.getTaskList()
                    .compose(RxScheduler.<BasePageResponse<TaskInfoResponse>>rxSchedulerTransform())
                    .compose(mIView.<BasePageResponse<TaskInfoResponse>>bindToLife())
                    .subscribe(new BasePageObserver<TaskInfoResponse>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(List<TaskInfoResponse> data, BasePageResponse<TaskInfoResponse> basePageResponse) throws Exception {
                            if (mIView != null) {
                                mIView.onTaskInfoList(data);
                            }
                        }


                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }

    @Override
    public void receive(Integer integer) {
        if (mIModel != null) {
            mIModel.receive(new TaskReceiveRequest(integer))
                    .compose(RxScheduler.<BasePageResponse<AwardBean>>rxSchedulerTransform())
                    .compose(mIView.<BasePageResponse<AwardBean>>bindToLife())
                    .subscribe(new BasePageObserver<AwardBean>() {


                        @Override
                        protected void onStart() {


                        }

                        @Override
                        protected void onSuccess(List<AwardBean> data, BasePageResponse<AwardBean> basePageResponse) throws Exception {
                            if (mIView != null) {
                                mIView.onReceiveSuc(data);
                            }
                        }


                        @Override
                        protected void onFinish() {

                        }
                    });
        }
    }
}

