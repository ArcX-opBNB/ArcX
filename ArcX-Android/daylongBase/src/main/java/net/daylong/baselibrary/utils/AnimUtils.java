package net.daylong.baselibrary.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import net.daylong.daylongbase.R;

import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.listener.AnimationEndListener;
import net.daylong.baselibrary.utils.sys.AppUtil;

public class AnimUtils {


    /**

     *

     * @return
     */
    private static Animation getAnimation(int reg) {
        return AnimationUtils.loadAnimation(BaseApplication.getInstance().getContext(), reg);
    }


    public static Animation rightToLeft() {


        return new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
    }

    public static Animation inLeft() {
        return new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
    }

    public static Animation outLeft() {
        return new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
    }


    public static Animation inRight() {
        return rightToLeft();
    }

    public static Animation inTop() {
        return getAnimation(R.anim.in_from_top);
    }


    public static void inRight(View view) {
        view.setVisibility(View.VISIBLE);
        Animation animation = inRight();
        animation.setDuration(300);
        view.startAnimation(animation);
    }

    public static void inLeft(View view) {
        view.setVisibility(View.VISIBLE);
        Animation animation = inLeft();
        animation.setDuration(300);
        view.startAnimation(animation);
    }


    public static Animation outRight() {
        return getAnimation(R.anim.out_from_right);
    }

    public static Animation outTop() {
        return getAnimation(R.anim.out_from_top);
    }

    public static Animation outBottom() {
        return getAnimation(R.anim.out_from_botton);
    }


    public static void re4outLeft(View view) {

        Animation animation = outRight();

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        view.startAnimation(animation);
    }

    public static void outRight(View view, AnimationEndListener animationEndListener) {

        Animation animation = outRight();

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
                if (animationEndListener != null) {
                    animationEndListener.onEnd();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        view.startAnimation(animation);
    }

    public static void outAllWinHint(View view, AnimationEndListener animationEndListener) {
        boolean horizontal = AppUtil.isHorizontal();

        Animation animation;
        if (horizontal) {
            animation = outTop();
        } else {
            animation = outRight();


        }

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
                if (animationEndListener != null) {
                    animationEndListener.onEnd();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        view.startAnimation(animation);
    }

    public static void outAllWinShow(View view) {


        if (AppUtil.isHorizontal()) {

            view.setVisibility(View.VISIBLE);
            Animation animation = inTop();
            animation.setDuration(300);
            view.startAnimation(animation);
        } else {
            inRight(view);


        }

    }

    public static void outLeft(View view, AnimationEndListener animationEndListener) {

        Animation animation = outLeft();
        animation.setDuration(300);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
                if (animationEndListener != null) {
                    animationEndListener.onEnd();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        view.startAnimation(animation);
    }

    public static AlphaAnimation getAlphaAnimation(float fromAlpha, float toAlpha, int durationMillis, Animation.AnimationListener listener) {
        AlphaAnimation animation = new AlphaAnimation(fromAlpha, toAlpha);
        if (listener != null) {
            animation.setAnimationListener(listener);
        }
        animation.setDuration(durationMillis);
        return animation;

    }


    public static AnimationSet getAutoViewAnim(float[] start, float[] end, int durationMillis, Animation.AnimationListener animationListener) {

        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation startAnimation = new AlphaAnimation(start[0], start[1]);
        startAnimation.setDuration(durationMillis);


        AlphaAnimation endAnimation = new AlphaAnimation(end[0], end[1]);
        endAnimation.setAnimationListener(animationListener);
        endAnimation.setStartOffset(durationMillis * 2);
        endAnimation.setDuration(durationMillis);
        animationSet.addAnimation(startAnimation);
        animationSet.addAnimation(endAnimation);

        return animationSet;
    }
    public static void start3DRotateAnimator(final View rootView, final View view1, final View view2) {
        final float from = view1.getVisibility() == View.INVISIBLE ? 0 : 180;
        final float to = from == 0 ? 180 : 0;

        ValueAnimator rotateAnimator = ValueAnimator.ofFloat(from, to);
        rotateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                if (value <= 90) {
                    if (view1.getVisibility() != View.INVISIBLE) {
                        view1.setVisibility(View.INVISIBLE);
                        view2.setVisibility(View.VISIBLE);
                    }
                    view1.setRotationY(value);
                } else {
                    if (view1.getVisibility() != View.VISIBLE) {
                        view1.setVisibility(View.VISIBLE);
                        view2.setVisibility(View.INVISIBLE);
                    }
                    view1.setRotationY(value - 180);
                }
            }
        });

        ValueAnimator tzAnimator = ValueAnimator.ofFloat(1, 0.6f, 1);
        tzAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                view1.setScaleX(value);
                view1.setScaleY(value);
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.setDuration(600);
        set.playTogether(rotateAnimator, tzAnimator);
        set.start();
    }
}
