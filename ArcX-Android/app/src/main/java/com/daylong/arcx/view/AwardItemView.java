package com.daylong.arcx.view;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;

import com.daylong.arcx.R;
import com.daylong.httplibrary.bean.AwardBean;

import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.layout.LinearLayoutView;

public class AwardItemView extends LinearLayoutView {
    CoinRewardNumberView coinRewardNumberView;
    MyImageView ivIcon;
    public AwardItemView(Context context) {
        super(context);
        setGravity(Gravity.CENTER_HORIZONTAL);
        setOrientation(VERTICAL);


        ivIcon = MyImageView.create(this, new ConstraintBuilder(74,59));
        ivIcon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        coinRewardNumberView = new CoinRewardNumberView(getContext());
        coinRewardNumberView.setCanvasImageNum(new CanvasImageBean(16, 18));
        coinRewardNumberView.setCanvasImageDot(new CanvasImageBean(6, 18));
        coinRewardNumberView.setLayoutParams(new ConstraintBuilder(18, 18).topMargin(13).buildPayoutParams());

        addView(coinRewardNumberView);

    }


    public void setAwardBean(AwardBean awardBean) {
        ivIcon.setImageUrl(awardBean.getAwardImgUrl());
        coinRewardNumberView.setNum(awardBean.getAwardNum());
    }


}
