package com.daylong.arcx.view.game;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;

public class DragonBallImageView extends MyImageView {

    public static DragonBallImageView create(ViewGroup viewGroup, ConstraintBuilder builder, Integer position, Integer regId) {
        return create(viewGroup, builder.buildPayoutParams(), position, regId);

    }

    public static DragonBallImageView create(ViewGroup viewGroup, ViewGroup.LayoutParams params, Integer position, Integer regId) {


        DragonBallImageView myImageView = new DragonBallImageView(viewGroup.getContext(), regId);
        myImageView.setLayoutParams(params);
        if (position != null) {
            viewGroup.addView(myImageView, position);
        } else {
            viewGroup.addView(myImageView);
        }
        return myImageView;

    }

    public static DragonBallImageView create(ViewGroup viewGroup, ConstraintBuilder builder) {
        return create(viewGroup, builder, null, null);

    }

    public static DragonBallImageView create(ViewGroup viewGroup, int position, ConstraintBuilder builder) {
        return create(viewGroup, builder, position, null);

    }

    public static DragonBallImageView create(ViewGroup viewGroup, ConstraintBuilder builder, int regId) {
        return create(viewGroup, builder, null, regId);


    }


    public DragonBallImageView(@NonNull Context context) {
        super(context);
    }

    public DragonBallImageView(@NonNull Context context, Integer regId) {
        super(context, regId);
    }

    private int curx;
    int cury;

    /**

     *
     * @param toView
     */
    public void moveToView(View toView) {
        setVisibility(View.VISIBLE);

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

                ObjectAnimator moveX = ObjectAnimator.ofFloat(DragonBallImageView.this, "x", curx);
                ObjectAnimator moveY = ObjectAnimator.ofFloat(DragonBallImageView.this, "y", cury);
                ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(DragonBallImageView.this, "scaleX", 1.0f);
                ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(DragonBallImageView.this, "scaleY", 1.0f);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(moveX, moveY, scaleDownX, scaleDownY);
                animatorSet.setDuration(0); 
                animatorSet.start();

                if (onAnimatorListener != null) {
                    onAnimatorListener.onAnimationEnd();
                }
            }
        });
        animatorSet.start();
    }

    private OnAnimatorListener onAnimatorListener;

    public void setOnAnimatorListener(OnAnimatorListener onAnimatorListener) {
        this.onAnimatorListener = onAnimatorListener;
    }

    public interface OnAnimatorListener {

        void onAnimationEnd();
    }

}
