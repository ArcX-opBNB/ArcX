package com.daylong.gamelibrary.dialog.defaults;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.daylong.httplibrary.model.contract.game.RepairReportContract;
import com.daylong.httplibrary.model.model.game.RepairReportModel;
import com.daylong.httplibrary.model.presenter.game.RepairReportPresenter;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseMvpFragmentDialog;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;


public class RepairReportDialog extends BaseMvpFragmentDialog<RepairReportPresenter, RepairReportModel> implements RepairReportContract.RepairReportView {

    public static void showDialog(FragmentManager fragmentManager, int productId) {

        RepairReportDialog reportDialog = new RepairReportDialog();

        Bundle bundle = new Bundle();
        bundle.putLong("productId", productId);
        reportDialog.setArguments(bundle);
        if (reportDialog.getDialog() == null || !reportDialog.getDialog().isShowing()) {
            reportDialog.show(fragmentManager, reportDialog.toString());
        }
    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {

        ConstraintLayout.LayoutParams layoutParams = ConstraintLayoutUtils.getLayoutParams(156, 90);
        ConstraintLayoutUtils.center(layoutParams);



        initTitle(rootView);
        initBtn(rootView);
    }

    private void initBtn(ConstraintLayout rootView) {



    }

    private void initTitle(ConstraintLayout rootView) {


    }

    @Override
    public void initData() {

    }

    @NonNull
    @Override
    protected RepairReportPresenter initPresenter() {
        return RepairReportPresenter.newInstance();
    }

    @Override
    public void onRepairReportSuc() {

        dismiss();
    }

    @Override
    public void onRepairReportFail() {

        dismiss();
    }
}
