package com.daylong.arcx.user.task;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.user.task.frt.TaskListFragment;

import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class TaskActivity extends BaseActivity {




    @Override
    protected boolean isAddBaseTitle() {
        return true;
    }

    @Override
    protected Integer getTitleName() {
        return R.string.task;
    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);

        initContent();
    }

    private void initContent() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(Color.WHITE);
        frameLayout.setId(View.generateViewId());
        frameLayout.setLayoutParams(new ConstraintBuilder(0, 0).topToBottom(baseTitleView).centerH().bottom().buildPayoutParams());
        addView(frameLayout);

        addFragment(new TaskListFragment(),frameLayout.getId());

    }

}
