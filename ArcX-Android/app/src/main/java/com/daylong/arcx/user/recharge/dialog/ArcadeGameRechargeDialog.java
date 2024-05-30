package com.daylong.arcx.user.recharge.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.request.PayRequest;
import com.daylong.arcx.R;
import com.daylong.arcx.pay.PayListener;
import com.daylong.arcx.pay.mrg.PayListenerMrg;
import com.daylong.arcx.user.recharge.frt.ArcadeRechargeListFragment;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.img.MyImageView;

public class ArcadeGameRechargeDialog extends BaseFragmentDialog implements PayListener {


    @Override
    protected ViewGroup getContentLayout() {
        return  new ConstraintBuilder(189,170).center().build(getContext());
    }

    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);
        contentView.setBackgroundResource(DrawableUtils.getDrawableByName("img_mch_recharge_alert_landscape"));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setId(View.generateViewId());
        frameLayout.setLayoutParams(new ConstraintBuilder(0,0).center().leftMargin(9).rightMargin(14).topMargin(30).bottomMargin(15).buildPayoutParams());
        contentView.addView(frameLayout);

        addFragment(new ArcadeRechargeListFragment(),frameLayout.getId(),"refrt");


        MyImageView myImageView = MyImageView.create(rootView, new ConstraintBuilder(23).bottom(contentView.getId()).bottomMargin(134).left(contentView.getId()).leftMargin(172), R.drawable.img_mch_close);

        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        PayListenerMrg.getInstance().addListeners(this);
    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {



    }

    @Override
    public void initData() {

    }

    @Override
    public void onPaySuc(int payType, String odNo, PayRequest payRequest) {
        PayListenerMrg.getInstance().removerListeners(this);

        dismiss();
    }

    @Override
    public void onPayFail() {

    }
}
