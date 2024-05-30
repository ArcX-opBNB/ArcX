package com.daylong.gamelibrary.view.floa;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

import androidx.annotation.NonNull;


import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.view.BaseNumberView;
import net.daylong.baselibrary.view.DrawableUtils;

public class FloatGameNumTextView extends BaseNumberView {
    private int leftCoin;

    public FloatGameNumTextView(@NonNull Context context, int leftCoin) {
        super(context);
        this.leftCoin = leftCoin;
        canvasImageStart.setImgRegId(leftCoin);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!TextUtils.isEmpty(numStr)) {
            super.onDraw(canvas);


            show();

        }

    }

    private AnimationSet animationSet;


    private boolean isAnimationStarted;

    public void show() {
         if (!isAnimationStarted) {
            isAnimationStarted = true;
            if (animationSet == null) {
                animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500);
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, AppUtil.getSize(-60));
                translateAnimation.setDuration(1000);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0f);
                alphaAnimation2.setDuration(500);
                alphaAnimation2.setStartOffset(500);

                alphaAnimation.setFillAfter(true);
                translateAnimation.setFillAfter(true);
                alphaAnimation2.setFillAfter(true);

                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        clearViewContent();

                        if (onAnimEndListener != null) {
                            onAnimEndListener.end(FloatGameNumTextView.this);
                        }
                        isAnimationStarted = false;
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                animationSet.addAnimation(alphaAnimation2);
            }


            startAnimation(animationSet);


        }
//
    }

    private OnAnimEndListener onAnimEndListener;

    public void setOnAnimEndListener(OnAnimEndListener onAnimEndListener) {
        this.onAnimEndListener = onAnimEndListener;
    }

    @Override
    public String getKeyPrefix() {
        return "img_game_get_num_";
    }

    @Override
    protected CanvasImageBean getImageNum() {
        return new CanvasImageBean(12, 14);
    }

    @Override
    protected CanvasImageBean getImageDot() {
        return new CanvasImageBean(4, 14);
    }


    @Override
    protected CanvasImageBean getImageStartsWith() {
        return new CanvasImageBean(19, 19, leftCoin);
    }

    public interface OnAnimEndListener {
        void end(FloatGameNumTextView view);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        if (animationSet == null) {
            clearAnimation();
        }
    }
}
