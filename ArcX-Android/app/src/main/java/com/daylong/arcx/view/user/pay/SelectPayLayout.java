package com.daylong.arcx.view.user.pay;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.response.user.RechargeResponse;
import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class SelectPayLayout extends ConstraintLayout implements View.OnClickListener {
    public SelectPayLayout(@NonNull Context context) {
        super(context);


        setLayoutParams(new ConstraintBuilder().mm0().buildPayoutParams());


        ConstraintLayout content = new ConstraintBuilder().mm().height(81).build(getContext());
        addView(content);
        content.setBackgroundResource(R.drawable.shape_pay_bg);


        MyTextView myTextView = MyTextView.create(content, new ConstraintBuilder().ww().topCenterH().topMargin(10).buildPayoutParams());


        MyImageView btnPay = MyImageView.create(content, new ConstraintBuilder(108, 28).topCenterH().topMargin(30));
        btnPay.setOnClickListener(this);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setVisibility(GONE);
            }
        });
        content.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public void onClick(View view) {


    }


    private RechargeResponse.GoldListDTO goldListDTO;

    public void show(RechargeResponse.GoldListDTO goldListDTO) {
        this.goldListDTO = goldListDTO;

        setVisibility(View.VISIBLE);
    }


}
