package com.daylong.userlibrary.dialog;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.model.contract.user.CheckInContract;
import com.daylong.httplibrary.model.model.user.CheckInModel;
import com.daylong.httplibrary.model.presenter.user.CheckInPresenter;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseMvpFragmentDialog;

import java.util.List;

public abstract class BaseCheckInDialog extends BaseMvpFragmentDialog<CheckInPresenter, CheckInModel> implements CheckInContract.CheckInView {


    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {

    }

    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);


        mPresenter.getCheckInfo();
    }

    @Override
    public void initData() {

    }

    @NonNull
    @Override
    protected CheckInPresenter initPresenter() {
        return CheckInPresenter.newInstance();
    }

    @Override
    public void onCheckInSuc(List<AwardBean> data) {

    }

}
