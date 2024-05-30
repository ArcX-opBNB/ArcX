package com.daylong.arcx.store;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.user.recharge.frt.RechargeListFragment;

import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
import net.daylong.gamesocket.bean.Balance;

public class StoreActivity  extends BaseActivity  {


    @Override
    protected boolean isAddBaseTitle() {
        return true;
    }

    @Override
    protected Integer getTitleName() {
        return R.string.recharge;
    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);

        initTitle();
        initContent();
    }


    private ConstraintLayout titleLayout;
    private MyTextView myCoin;

    private void initTitle() {

        titleLayout = new ConstraintBuilder(171, 40).topToBottom(baseTitleView.getId()).centerH().build(this);
        titleLayout.setId(View.generateViewId());
        titleLayout.setBackgroundResource(R.drawable.shape_r_14_bg_w);

        MyImageView.create(titleLayout, new ConstraintBuilder(19).leftCenterV().leftMargin(8), R.drawable.img_points);

        MyTextView myTextView = MyTextView.create(titleLayout, new ConstraintBuilder().ww().leftCenterV().leftMargin(31));



        myCoin = MyTextView.create(titleLayout, new ConstraintBuilder().ww().rightCenterV().rightMargin(8));
        myCoin.initText("", 11, R.color.color_434343);


        addView(titleLayout);

    }

    private void initContent() {


        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(Color.WHITE);
        frameLayout.setId(View.generateViewId());
        frameLayout.setLayoutParams(new ConstraintBuilder(0, 0).topToBottom(titleLayout).centerH().bottom().topMargin(8).buildPayoutParams());
        addView(frameLayout);
        addFragment(new RechargeListFragment(), frameLayout.getId());

    }


}
