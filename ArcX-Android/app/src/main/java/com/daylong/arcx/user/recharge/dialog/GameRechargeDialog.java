package com.daylong.arcx.user.recharge.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.user.recharge.frt.PushCoinRechargeListFragment;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.img.MyImageView;
public class GameRechargeDialog extends BaseFragmentDialog {


    @Override
    protected ViewGroup getContentLayout() {
        return  new ConstraintBuilder(166,294).center().build(getContext());
    }

    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);
        contentView.setBackgroundResource(DrawableUtils.getDrawableByName("img_mch_recharge_alert"));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setId(View.generateViewId());
        frameLayout.setLayoutParams(new ConstraintBuilder(0,0).center().leftMargin(9).rightMargin(14).topMargin(50).bottomMargin(15).buildPayoutParams());
        contentView.addView(frameLayout);

        addFragment(new PushCoinRechargeListFragment(),frameLayout.getId(),"refrt");


        MyImageView myImageView = MyImageView.create(rootView, new ConstraintBuilder(23).bottom(contentView.getId()).bottomMargin(280).left(contentView.getId()).leftMargin(143), R.drawable.img_mch_close);

        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {



    }

    @Override
    public void initData() {

    }
}
