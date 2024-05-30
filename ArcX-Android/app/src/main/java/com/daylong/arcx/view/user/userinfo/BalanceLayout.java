package com.daylong.arcx.view.user.userinfo;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.user.recharge.RechargeActivity;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class BalanceLayout extends CardView {
    private MyTextView tvMyBalance;

    public BalanceLayout(@NonNull Context context, View view) {
        super(context);
        setId(View.generateViewId());
        setRadius(AppUtil.getSize(7));
        setLayoutParams(new ConstraintBuilder(178, 60).topToBottom(view).centerH().topMargin(8).buildPayoutParams());
        ConstraintLayout balanceLayout = new ConstraintBuilder().mm().build(getContext());

        MyImageView myImageView = MyImageView.create(balanceLayout, new ConstraintBuilder(19).leftTop().leftTopMargin(8, 8), R.drawable.img_coin);
        myImageView.setId(View.generateViewId());

        MyTextView myTextView = MyTextView.create(balanceLayout, new ConstraintBuilder().ww().leftToRightById(myImageView).centerV(myImageView));



        tvMyBalance = MyTextView.create(balanceLayout, new ConstraintBuilder().ww().left(myImageView).topToBottom(myImageView).topMargin(10));
        tvMyBalance.initText(11, R.color.color_434343, true);


        BaseButton baseButton = BaseButton.create(balanceLayout, new ConstraintBuilder(52, 22).centerV().right().rightMargin(8));
        baseButton.setBackgroundResource(R.drawable.shape_r_22_bg_b30);

        baseButton.setGravity(Gravity.CENTER);
        baseButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                RechargeActivity.start(getContext(), RechargeActivity.class);
            }
        });

        addView(balanceLayout);

    }

    public void setBalance(long balance) {
        tvMyBalance.setTextNumDot(balance);
    }
}
