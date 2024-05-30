package com.daylong.arcx.uitls;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import com.lxj.xpopup.animator.PopupAnimator;

/**

 */
public class DialogDefaultOpenAnimator extends PopupAnimator {
    @Override
    public void initAnimator() {
        //targetView.setScaleX(0);
        //targetView.setScaleY(0);
        //targetView.setAlpha(0);

    }

    @Override
    public void animateShow() {


        AnimationSet animationSet = new AnimationSet(true);
        //
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.4f, 1.1f, 0.4f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(300);

        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1 / 1.1f, 1.0f, 1 / 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation2.setDuration(200);
        scaleAnimation2.setStartOffset(300);
        //
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);

        //
        targetView.startAnimation(animationSet);

    }

    @Override
    public void animateDismiss() {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(300);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0f, 1.0f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation2.setDuration(200);
        scaleAnimation2.setStartOffset(300);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        targetView.startAnimation(animationSet);
        //targetView.animate().scaleX(0).scaleY(0).alpha(0).setInterpolator(new FastOutSlowInInterpolator()).setDuration(500).start();
    }
}
