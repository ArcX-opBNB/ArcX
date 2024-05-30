package com.daylong.arcx.view.user.userinfo;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.daylong.arcx.R;
import com.daylong.arcx.act.SettingDialog;
import com.daylong.arcx.user.FeedbackActivity;
import com.daylong.arcx.user.address.MyAddressActivity;
import com.daylong.arcx.user.order.UserOrderActivity;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.layout.LinearLayoutView;

public class UserInfoItemGroupLayout extends CardView {

    public UserInfoItemGroupLayout(@NonNull Context context, View view) {
        super(context);
        setLayoutParams(new ConstraintBuilder(174, 0).wHei().topToBottom(view).centerH().topMargin(6).buildPayoutParams());
        setRadius(AppUtil.getSize(7));

        LinearLayoutView linearLayoutView = new LinearLayoutView(getContext());
        linearLayoutView.setOrientation(LinearLayoutView.VERTICAL);
        linearLayoutView.setLayoutParams(new ConstraintBuilder().mw().buildPayoutParams());





        linearLayoutView.addView(myOrder);
        linearLayoutView.addView(myAddress);
        linearLayoutView.addView(myFeedback);
        linearLayoutView.addView(mySetting);


        addView(linearLayoutView);

    }

}
