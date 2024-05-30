package com.daylong.arcx.act;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.home.frt.GameListFragment;
import com.daylong.arcx.home.frt.HomeTitleFragment;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.view.BaseBackView;
import net.daylong.baselibrary.view.btn.MyBtn;

public abstract class BaseAxcActivity extends BaseActivity {

    protected FrameLayout frameTitle, contentFrame;


    protected int getFrtToViewId() {

        return frameTitle.getId();
    }

    protected ConstraintBuilder getConentConstraintBuilder() {
        return new ConstraintBuilder(0, 0).topToBottom(getFrtToViewId()).bottomCenterH();
    }


    protected Integer getContentBgColor() {
        return null;
    }

    protected int getRootViewBackRegId() {
        return R.drawable.img_email_login_bg;
    }

    protected  boolean isAddContentFragment(){
        return true;
    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);
        rootView.setBackgroundResource(getRootViewBackRegId());
        initTitle();


        if(isAddContentFragment()){
            contentFrame = new FrameLayout(this);
            contentFrame.setId(View.generateViewId());
            contentFrame.setLayoutParams(getConentConstraintBuilder().buildPayoutParams());
            if (getContentBgColor() != null) {
                contentFrame.setBackgroundColor(getContentBgColor());
            }
            addView(contentFrame);
        }
    }


    private void initTitle() {


        frameTitle = new FrameLayout(this);

        frameTitle.setId(View.generateViewId());
        frameTitle.setLayoutParams(new ConstraintBuilder().mw().leftTop().topMargin(22).buildPayoutParams());

        addFragment(new HomeTitleFragment(), frameTitle.getId());
        addView(frameTitle);


    }
}
