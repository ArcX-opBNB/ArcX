package com.daylong.arcx.view.dragonball;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;


import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.AnimUtils;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.baselibrary.view.img.MyImageView;

public class DragonBallsRewardItemView extends ConstraintLayout {


    public static final int SELECT_IMG_SIZE = 26;
    public static final int COIN_IMG_SIZE = 12;
    public static final int BG_IMG_SIZE = 25;
    public static final int SELECT_PASS_SIZE = 24;

    public DragonBallsRewardItemView(Context context) {
        this(context, null);
    }

    public DragonBallsRewardItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private ImageView ivBg, ivSelected, ivPass;
    private MyImageView icCoin;
    private AlphaAnimation alphaAnimation;

    private boolean isPass;

    public DragonBallsRewardItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ivBg = MyImageView.create(this, new ConstraintBuilder(BG_IMG_SIZE, BG_IMG_SIZE).center());
        ivBg.setImageResource(R.drawable.ic_bg_dragon_balls_reward_item);
        ivSelected = MyImageView.create(this, new ConstraintBuilder(SELECT_IMG_SIZE).center());
        ivSelected.setVisibility(View.INVISIBLE);

        ivPass = MyImageView.create(this, new ConstraintBuilder(SELECT_PASS_SIZE).center());
        ivPass.setVisibility(View.INVISIBLE);


        icCoin = MyImageView.create(this, new ConstraintBuilder(COIN_IMG_SIZE).center());
        alphaAnimation = AnimUtils.getAlphaAnimation(1.0f, 0.5f, 100, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ivSelected.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    public void setPath(String coinPath) {
        icCoin.setImageUrl(coinPath);
    }


    /**

     */
    public void selected(boolean isAnim) {

        ivSelected.setVisibility(View.VISIBLE);
        if (ivPass.getVisibility() != View.VISIBLE) {
            ivBg.setVisibility(View.VISIBLE);
        }


        ivSelected.setImageResource(R.drawable.ic_bg_dragon_balls_reward_item_select);
        if (isAnim) {
            ivSelected.startAnimation(alphaAnimation);
        } else {
            pass();
        }
    }

    public void pass() {
        ivPass.setImageResource(R.drawable.ic_bg_dragon_balls_reward_item_pass);
        ivPass.setVisibility(View.VISIBLE);
        ivBg.setVisibility(View.INVISIBLE);

    }


}
