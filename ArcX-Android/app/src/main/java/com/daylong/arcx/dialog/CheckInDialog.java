package com.daylong.arcx.dialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.response.user.CheckInInfoResponse;
import com.daylong.userlibrary.dialog.BaseCheckInDialog;
import com.daylong.arcx.R;
import com.daylong.arcx.view.user.check.CheckInItemView;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;

import java.util.List;

public class CheckInDialog extends BaseCheckInDialog {
    public static void showDialog(FragmentManager fragmentManager) {
        CheckInDialog webDialog = new CheckInDialog();
        if (webDialog.getDialog() == null || !webDialog.getDialog().isShowing()) {
            Bundle bundle = new Bundle();
            webDialog.setArguments(bundle);
            webDialog.show(fragmentManager, "CheckInDialog");
        }
    }

    @Override
    protected ViewGroup getContentLayout() {
        return new ConstraintBuilder(176, 289).center().build(getContext());
    }

    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        contentView.setBackgroundResource(R.drawable.img_checkin_alert);
        CheckInItemView.create(contentView);
        super.initView(rootView, contentView, dialog);


    }

    @Override
    public void initData() {
        super.initData();
    }


    private BaseButton btnCheck;
    private View.OnClickListener checkListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            mPresenter.checkIn();

        }
    };


    @Override
    public void onCheckInInfo(CheckInInfoResponse data) {

        List<CheckInInfoResponse.SignListDTO> signList = data.getSignList();
        
        boolean dayCheck = data.isCheck();

        boolean isCheck = false;
        for (int i = 0; i < signList.size(); i++) {

            CheckInInfoResponse.SignListDTO signListDTO = signList.get(i);
            boolean itemCheck = signListDTO.isCheck();
            CheckInItemView childAt = (CheckInItemView) contentView.getChildAt(i);

            if (!isCheck && !dayCheck && !itemCheck) {
                isCheck = true;
                childAt.setStatue(isCheck);
            } else {
                childAt.setStatue(false);
            }
            childAt.initData(signListDTO);
        }


        if (btnCheck == null) {
            btnCheck = BaseButton.create(contentView, new ConstraintBuilder(109, 31).bottomCenterH().bottomMargin(14));
            btnCheck.setGravity(Gravity.CENTER_HORIZONTAL);
            btnCheck.setPadding(0, getSize(7), 0, 0);

        }

        btnCheck.setOnClickListener(dayCheck ? null : checkListener);
        btnCheck.setText(data.getCheckBtnStr());
        btnCheck.setBackgroundResource(dayCheck ? R.drawable.img_collect_btn_disable : R.drawable.img_collect_btn);
    }

    @Override
    public void onCheckInSuc(List<AwardBean> data) {
        mPresenter.getCheckInfo();

        if (data == null||data.size()==0) {
            return;
        }

        
        DefaultDialog.showDialog(getChildFragmentManager(), data.get(0), -1);

    }
}
