package com.daylong.arcx.view.dragonball;

import android.content.Context;
import android.graphics.Color;
import android.view.View;


import com.daylong.arcx.R;
import com.daylong.httplibrary.bean.game.dragon.DragonBallRewardBean;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.utils.ui.layout.cl.LeftLayoutC;
import net.daylong.baselibrary.utils.ui.layout.cl.TopLayoutC;
import net.daylong.baselibrary.view.img.BaseSvgaImageView;
import net.daylong.baselibrary.view.img.MyImageView;

/**

 */
public class GatherDragonBallRewardView extends ConstraintLayoutView {

    public GatherDragonBallRewardView(Context context) {
        super(context);
        initView();
    }


    private MyImageView ivk1, ivk2;
    private DragonBallsRewardWheel rewardWheel;
    MyImageView ivTitle;

    private void initView() {


        int bgID = View.generateViewId();

        ivTitle = MyImageView.create(this, new ConstraintBuilder(133, 57).topCenterH().bottomToTop(bgID).verticalChainStyle(), R.drawable.img_dragon_train_title);
        createBg();
        createCheek(bgID);
        runVk();
        initRewardWheel();
    }


    private BaseSvgaImageView svgaImageView;

    /**

     */
    private void createBg() {
        MyImageView myImageView = MyImageView.create(this, new ConstraintBuilder(170, 171).topToBottom(ivTitle), R.drawable.img_dragon_light);

        svgaImageView = BaseSvgaImageView.create(this, new ConstraintBuilder(150, 138).centerH().topToBottom(ivTitle));

        svgaImageView.startAssets("sv_dragon_ball_lt.svga");


    }


    private void createCheek(int id) {


        ivk1 = MyImageView.create(this, new ConstraintBuilder(170, 171).topToBottom(ivTitle).bottomCenterH());
        ivk1.setImageResource(R.drawable.bg_gather_dragon_ball_light1);
        ivk1.setId(id);
        ivk2 = MyImageView.create(this, new ConstraintBuilder(170, 171).center(ivk1));
        ivk2.setVisibility(View.GONE);
        ivk2.setImageResource(R.drawable.bg_gather_dragon_ball_light2);


    }


    private void initRewardWheel() {
        rewardWheel = new DragonBallsRewardWheel(getContext());
        LayoutParams layoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        TopLayoutC.top(layoutParams, ivk1.getId());
        LeftLayoutC.left(layoutParams, ivk1.getId());
        LeftLayoutC.margin(layoutParams, 15);
        TopLayoutC.margin(layoutParams, 32);

        rewardWheel.setLayoutParams(new ConstraintBuilder().ww().center(ivk1).buildPayoutParams());
        addView(rewardWheel);

    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (ivk1.getVisibility() == View.VISIBLE) {
                ivk1.setVisibility(View.INVISIBLE);
                ivk2.setVisibility(View.VISIBLE);
            } else {
                ivk1.setVisibility(View.VISIBLE);
                ivk2.setVisibility(View.INVISIBLE);
            }
            AppUtil.getMainHandler().postDelayed(this, 300);
        }
    };


    @Override
    protected void onDetachedFromWindow() {
        if (svgaImageView != null) {
            svgaImageView.close();
        }
        super.onDetachedFromWindow();
        removeCallbacks(runnable);

    }

    public void runVk() {
        postDelayed(runnable, 300);

    }


    

    private DragonBallRewardBean reward;

    public void setData(DragonBallRewardBean reward) {
        this.reward = reward;
        rewardWheel.initData(reward);
    }

    public void setOnEndListener(DragonBallsRewardWheel.OnEndListener onEndListener) {

        rewardWheel.setOnEndListener(onEndListener);
    }
}
