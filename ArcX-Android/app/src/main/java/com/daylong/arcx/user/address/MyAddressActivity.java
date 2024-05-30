package com.daylong.arcx.user.address;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.user.address.frt.MyAddressFragment;

import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;

public class MyAddressActivity extends BaseActivity {

    @Override
    protected boolean isAddBaseTitle() {
        return true;
    }

    @Override
    protected Integer getTitleName() {
        return R.string.address_title;
    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);


        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(Color.WHITE);
        frameLayout.setLayoutParams(new ConstraintBuilder(0, 0).topToBottom(baseTitleView).bottomCenterH().buildPayoutParams());


        frameLayout.setId(net.daylong.daylongbase.R.id.base_frt);
        rootView.addView(frameLayout);


        boolean isOrder = getIntent().getBooleanExtra("isOrder", false);
        MyAddressFragment myAddressFragment = new MyAddressFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isOrder",isOrder);
        myAddressFragment.setArguments(bundle);
        addFragment(myAddressFragment, net.daylong.daylongbase.R.id.base_frt);

        BaseButton btnNewAddress = BaseButton.create(rootView, new ConstraintBuilder(163, 28).bottomCenterH().bottomMargin(27));

        btnNewAddress.setGravity(Gravity.CENTER);
        btnNewAddress.setBackgroundResource(R.drawable.shape_r_30_bg_c48);
        btnNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewAddressActivity.start(MyAddressActivity.this, NewAddressActivity.class);
            }
        });
    }
}
