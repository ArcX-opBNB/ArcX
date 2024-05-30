package com.daylong.arcx.dialog;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.arcx.R;
import com.daylong.arcx.view.btn.DefaultDialogBtn;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
public class DefaultDialog extends BaseFragmentDialog {


    public static void showDialog(FragmentManager fragmentManager, AwardBean awardBean, int titleRegId) {
        DefaultDialog webDialog = new DefaultDialog();
        if (webDialog.getDialog() == null || !webDialog.getDialog().isShowing()) {
            Bundle bundle = new Bundle();
            bundle.putInt("titleReg", titleRegId);
            bundle.putSerializable("awardBean", awardBean);
            webDialog.setArguments(bundle);
            webDialog.show(fragmentManager, "CheckInDialog");
        }
    }

    public static void showDialog(FragmentManager fragmentManager, AwardBean awardBean) {
        showDialog(fragmentManager, awardBean, -1);
    }

    private MyImageView ivTitle;
    private MyImageView ivCoinIcon, ivCoinBg;
    private MyTextView tvCoinNum;

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {
        ivTitle = MyImageView.create(rootView, new ConstraintBuilder(118, 40).topCenterH().topMargin(56), R.drawable.img_rewards_title);
        ivTitle.setId(View.generateViewId());

        ivCoinBg = MyImageView.create(rootView, new ConstraintBuilder(130, 130).topToBottom(ivTitle).centerH().topMargin(36), R.drawable.img_rewards_halo);
        ivCoinBg.setId(View.generateViewId());

        ivCoinIcon = MyImageView.create(rootView, new ConstraintBuilder(85, 85).center(ivCoinBg).centerH());
        ivCoinIcon.setId(View.generateViewId());
        ivCoinIcon.setBackgroundColor(Color.RED);

        tvCoinNum = MyTextView.create(rootView, new ConstraintBuilder(0, 23).centerH(ivCoinBg).bottom(ivCoinBg).bottomMargin(5));
        tvCoinNum.setGravity(Gravity.CENTER);
        tvCoinNum.initText(17, R.color.color_white, true);

        DefaultDialogBtn defaultDialogBtn = new DefaultDialogBtn(getContext());


        defaultDialogBtn.setLayoutParams(new ConstraintBuilder(109, 37).bottomCenterH().bottomMargin(76).buildPayoutParams());
        rootView.addView(defaultDialogBtn);
        defaultDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }


    @Override
    public void initData() {


        Bundle arguments = getArguments();
        if (arguments != null) {
            AwardBean awardBean = (AwardBean) arguments.getSerializable("awardBean");
            if (awardBean != null) {
                ivCoinIcon.setImageUrl(awardBean.getAwardImgUrl());
                tvCoinNum.setTextNumDot(awardBean.getAwardNum());
            }

            int titleReg = arguments.getInt("titleReg", -1);
            if (titleReg != -1) {
                ivTitle.setImageReg(titleReg);
            }
        }
    }
}
