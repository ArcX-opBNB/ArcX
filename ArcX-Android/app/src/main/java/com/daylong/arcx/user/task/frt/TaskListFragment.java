package com.daylong.arcx.user.task.frt;

import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.response.user.TaskInfoResponse;
import com.daylong.httplibrary.model.contract.user.TaskContract;
import com.daylong.httplibrary.model.model.user.TaskModel;
import com.daylong.httplibrary.model.presenter.user.TaskPresenter;
import com.daylong.arcx.dialog.DefaultDialog;
import com.daylong.arcx.user.task.adapter.TaskAdapter;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.ui.frt.BaseListFragment;

import java.util.List;

public class TaskListFragment extends BaseListFragment<TaskPresenter, TaskModel, TaskInfoResponse> implements TaskContract.TaskView {
    @Override
    public BaseQuickAdapter<TaskInfoResponse, MyViewHolder> getAdapter() {
        return new TaskAdapter();
    }

    @Override
    public void getListUrl() {

        mPresenter.getTaskList();

    }

    @Override
    protected void initData() {
        super.initData();

        setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {


                TaskInfoResponse taskInfoResponse = baseQuickAdapter.getData().get(position);


                if (taskInfoResponse.isReceive()) {
                    mPresenter.receive(taskInfoResponse.getTaskId());
                }


            }
        });
    }

    @NonNull
    @Override
    protected TaskPresenter initPresenter() {
        return TaskPresenter.newInstance();
    }

    @Override
    public void onTaskInfoList(List<TaskInfoResponse> data) {
        setData(data);

    }

    @Override
    public void onReceiveSuc(List<AwardBean> data) {
        if (data == null||data.size()==0) {
            return;
        }
        DefaultDialog.showDialog(getChildFragmentManager(), data.get(0));
        mPresenter.getTaskList();
    }
}
