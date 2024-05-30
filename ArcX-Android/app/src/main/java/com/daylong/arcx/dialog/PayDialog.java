package com.daylong.arcx.dialog;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.request.PayRequest;
import com.daylong.arcx.R;
import com.daylong.arcx.pay.PayListener;
import com.daylong.arcx.pay.mrg.PayListenerMrg;
import com.daylong.arcx.pay.mrg.PayMrg;
import com.daylong.arcx.uitls.DialogDefaultOpenAnimator;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;

import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class PayDialog extends BottomPopupView implements View.OnClickListener, PayListener {

    public static void show(BaseActivity activity, PayRequest payRequest) {


        new XPopup.Builder(activity)
                .customAnimator(new DialogDefaultOpenAnimator())
                .animationDuration(500)
                .asCustom(new PayDialog(activity, payRequest)).show();

    }

    private PayRequest payRequest;

    public PayDialog(@NonNull Context context, PayRequest payRequest) {
        super(context);
        this.payRequest = payRequest;
    }

    @Override
    protected void addInnerContent() {

        PayListenerMrg.getInstance().addListeners(this);
        ConstraintLayout contentView = new ConstraintBuilder().mm().height(81).build(getContext());
        contentView.setBackgroundResource(R.drawable.shape_top_r_24_bg_w);


        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(10));

        myTextView.setId(View.generateViewId());

        ConstraintLayout play = new ConstraintBuilder(108, 28).topToBottom(myTextView).centerH().topMargin(7).build(getContext());


        MyImageView myImageView = MyImageView.create(play, new ConstraintBuilder(14).leftCenterV().rightToLeftById(net.daylong.daylongbase.R.id.base_view_1).horizontalChainStyle(), R.drawable.icon_ali_pay);

        myImageView.setId(net.daylong.daylongbase.R.id.base_view_2);


        MyTextView myTextView2 = MyTextView.create(play, new ConstraintBuilder().ww().rightCenterV().leftMargin(7).leftToRightById(net.daylong.daylongbase.R.id.base_view_2));

        myTextView2.setId(net.daylong.daylongbase.R.id.base_view_1);

        play.setBackgroundResource(R.drawable.shape_30_bg_6ff);
        contentView.addView(play);

        play.setOnClickListener(this);

        bottomPopupContainer.addView(contentView);

    }

    @Override
    public void onClick(View view) {
        PayMrg.getInstance().aliPay(payRequest);
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
