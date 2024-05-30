package com.daylong.arcx.user.order;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.daylong.arcx.view.user.order.group.OrderGroupView;

import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class UserOrderActivity extends BaseActivity {

    @Override
    protected boolean isAddBaseTitle() {
        return true;
    }

    @Override
    protected Integer getTitleName() {
        return null;
    }


    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);

        OrderGroupView orderGroupView = OrderGroupView.create(rootView, this);
        orderGroupView.setId(View.generateViewId());


        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(Color.WHITE);
        frameLayout.setLayoutParams(new ConstraintBuilder(0, 0).topToBottom(orderGroupView).bottomCenterH().buildPayoutParams());


        frameLayout.setId(net.daylong.daylongbase.R.id.base_frt);
        rootView.addView(frameLayout);



    }

    @Override
    protected void initData() {
        super.initData();


    }

}
