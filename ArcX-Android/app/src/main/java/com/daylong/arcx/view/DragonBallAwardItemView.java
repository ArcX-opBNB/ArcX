package com.daylong.arcx.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.view.game.DragonBallImageView;
import com.daylong.httplibrary.bean.AwardBean;

import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.utils.AnimUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.layout.LinearLayoutView;

public class DragonBallAwardItemView extends LinearLayoutView {
    private CoinRewardNumberView coinRewardNumberView;
    private MyImageView ivIcon;

    public DragonBallAwardItemView(Context context) {
        super(context);
        setGravity(Gravity.CENTER_HORIZONTAL);
        setOrientation(VERTICAL);
        ivIcon = MyImageView.create(this, new ConstraintBuilder(39, 39));
        ivIcon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        coinRewardNumberView = new CoinRewardNumberView(getContext());
        coinRewardNumberView.setCanvasImageNum(new CanvasImageBean(9, 11));
        coinRewardNumberView.setCanvasImageDot(new CanvasImageBean(3, 11));
        coinRewardNumberView.setLayoutParams(new ConstraintBuilder(11, 11).topMargin(6).buildPayoutParams());
        addView(coinRewardNumberView);

    }

    public static DragonBallAwardItemView create(ViewGroup viewGroup, ConstraintBuilder constraintBuilder) {


        DragonBallAwardItemView dragonBallAwardItemView = new DragonBallAwardItemView(viewGroup.getContext());

        dragonBallAwardItemView.setLayoutParams(constraintBuilder.buildPayoutParams());
        viewGroup.addView(dragonBallAwardItemView);

        return dragonBallAwardItemView;
    }

    private View dragonBallView;
    private MyImageView axcView;
    private AwardBean awardBean;

    public void setAwardBean(AwardBean awardBean, int count, View dragonBallView, MyImageView axcView) {
        this.dragonBallView = dragonBallView;
        this.axcView = axcView;
        this.awardBean = awardBean;

        setVisibility(View.VISIBLE);
        ViewGroup.LayoutParams layoutParams = ivIcon.getLayoutParams();
        if (count == 2) {
            layoutParams.width = AppUtil.getSize(49);
        } else {
            layoutParams.width = AppUtil.getSize(30);

        }
        ivIcon.requestLayout();
        if (awardBean.getCommodityType() != 1) {
            coinRewardNumberView.setCanvasImageStart(null);
        } else {
            coinRewardNumberView.setCanvasImageStart(new CanvasImageBean(12, 12, R.drawable.img_coin, 1));
        }
        coinRewardNumberView.setVisibility(View.VISIBLE);
        ivIcon.setImageUrl(awardBean.getAwardImgUrl());
        coinRewardNumberView.setNum(awardBean.getAwardNum());
    }

    private int curx;
    int cury;

    /**

     *
     */
    public void moveToView() {


        if (getVisibility() != View.VISIBLE) {
            return;
        }


        View toView = null;
        if (awardBean != null) {
            Integer commodityType = awardBean.getCommodityType();
            if (commodityType == 1) {
                toView = dragonBallView;
            } else if (commodityType == 2) {
                toView = axcView;
            }
        }
        if (toView == null) {
            this.startAnimation(AnimUtils.getAlphaAnimation(1, 0, 500, null));
            return;
        }


        coinRewardNumberView.setVisibility(View.INVISIBLE);
        int widthA = toView.getWidth();
        int heightA = toView.getHeight();
        int widthB = getWidth();
        int heightB = getHeight();


        int[] location2 = new int[2];
        getLocationOnScreen(location2);

        curx = location2[0];
        cury = location2[1];


        
        float toScaleWidth = widthA * 0.5f;
        float toScaleHeight = heightA * 0.5f;

        
        float scaleX = toScaleWidth / widthB;
        float scaleY = toScaleHeight / heightB;


        
        float centerX = (widthB - (scaleX * widthB)) / 2;
        float centerY = (heightB - (scaleY * heightB)) / 2;
        


        int[] location = new int[2];
        toView.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];

        float tox = x + (toScaleWidth / 2) - centerX;
        float toY = y + (toScaleWidth / 2) - centerY;



        ObjectAnimator moveX = ObjectAnimator.ofFloat(this, "x", tox);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(this, "y", toY);
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(this, "scaleX", scaleX);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(this, "scaleY", scaleY);
        Interpolator interpolator = new AccelerateDecelerateInterpolator();


        moveX.setInterpolator(interpolator);
        moveY.setInterpolator(interpolator);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(moveX, moveY, scaleDownX, scaleDownY);
        animatorSet.setDuration(1000); 

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                ObjectAnimator moveX = ObjectAnimator.ofFloat(DragonBallAwardItemView.this, "x", curx);
                ObjectAnimator moveY = ObjectAnimator.ofFloat(DragonBallAwardItemView.this, "y", cury);
                ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(DragonBallAwardItemView.this, "scaleX", 1.0f);
                ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(DragonBallAwardItemView.this, "scaleY", 1.0f);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(moveX, moveY, scaleDownX, scaleDownY);
                animatorSet.setDuration(0); 
                animatorSet.start();
                if (onAnimatorListener != null) {
                    onAnimatorListener.onAnimationEnd();
                }


                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
                ConstraintBuilder.none(layoutParams);
                requestLayout();

                setVisibility(View.GONE);
                awardBean= null;
            }
        });
        animatorSet.start();
    }

    private DragonBallImageView.OnAnimatorListener onAnimatorListener;

    public void setOnAnimatorListener(DragonBallImageView.OnAnimatorListener onAnimatorListener) {
        this.onAnimatorListener = onAnimatorListener;
    }


}
