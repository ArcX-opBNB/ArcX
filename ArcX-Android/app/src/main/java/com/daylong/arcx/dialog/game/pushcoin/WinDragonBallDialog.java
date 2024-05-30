package com.daylong.arcx.dialog.game.pushcoin;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.view.CoinRewardNumberView;
import com.daylong.arcx.view.DragonBallAwardItemView;
import com.daylong.arcx.view.game.DragonBallImageView;
import com.daylong.arcx.view.game.DragonBallListView;
import com.daylong.httplibrary.bean.AwardBean;

import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.BaseSvgaImageView;
import net.daylong.baselibrary.view.img.MyImageView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinDragonBallDialog implements DragonBallImageView.OnAnimatorListener {


    private final int[] IDS = {net.daylong.daylongbase.R.id.base_view_1, net.daylong.daylongbase.R.id.base_view_2, net.daylong.daylongbase.R.id.base_view_3, net.daylong.daylongbase.R.id.base_view_4, net.daylong.daylongbase.R.id.base_view_6, net.daylong.daylongbase.R.id.base_view_6};

    private ConstraintLayout rootView;
    private MyImageView ivTitle;

    public WinDragonBallDialog(ViewGroup viewGroup) {
        dragonBallAwardItemViews = new HashMap<>();

        initView(viewGroup);
    }

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rootView.setBackgroundColor(Color.TRANSPARENT);
            hintOneDragon(dragonBallView);

            for (DragonBallAwardItemView value : dragonBallAwardItemViews.values()) {
                value.moveToView();
            }
        }
    };
    private BaseSvgaImageView svgaImageView;
    private int ivCoin = net.daylong.daylongbase.R.id.base_view_1;
    private int btnId = View.generateViewId();

    private Map<Integer, DragonBallAwardItemView> dragonBallAwardItemViews;

    public void initView(ViewGroup viewGroup) {

        if (rootView == null) {
            rootView = new ConstraintBuilder().mm().leftTop().build(viewGroup.getContext());
            rootView.setBackgroundColor(rootView.getContext().getColor(R.color.main_color_80000));
            viewGroup.addView(rootView);
            svgaImageView = BaseSvgaImageView.create(rootView, new ConstraintBuilder().mm().leftTop());
            ivTitle = MyImageView.create(rootView, new ConstraintBuilder(133, 57).bottomToTop(ivCoin).centerH().bottomMargin(27), R.drawable.img_dragon_bonus_title);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }


    }


    private DragonBallImageView ivDragonBall;
    private CoinRewardNumberView coinRewardNumberView;
    private MyImageView myImageView;

    private View dragonBallView;
    private View axcView;
    private DragonBallListView dragonBallListView;
    private int num;

    public void show(int num, List<AwardBean> awardBeans, DragonBallListView dragonBallListView, MyImageView axcView) {
        
        rootView.setBackgroundColor(rootView.getContext().getColor(R.color.main_color_80000));
        this.axcView = axcView;

        this.dragonBallListView = dragonBallListView;
        this.dragonBallView = dragonBallListView.getDragonView(num);
        this.num = num;
        AppUtil.getMainHandler().postDelayed(runnable, 3000);

        if (rootView.getVisibility() != View.VISIBLE) {
            rootView.setVisibility(View.VISIBLE);
        }

        svgaImageView.startAssetsSvga("dragon_ball_bg.svga");
        svgaImageView.setVisibility(View.VISIBLE);
        if (awardBeans.size() == 1) {
            AwardBean awardBean = awardBeans.get(0);
            if (ivDragonBall == null) {
                ivDragonBall = DragonBallImageView.create(rootView, new ConstraintBuilder(60, 60).center(), R.drawable.img_dragon_ball);
                ivDragonBall.setId(ivCoin);
                ivDragonBall.setOnAnimatorListener(this);
                myImageView = MyImageView.create(rootView, new ConstraintBuilder(126, 39).topToBottom(ivDragonBall).topMargin(12).centerH(), R.drawable.img_bg_show_win_num);
                myImageView.setId(btnId);
                coinRewardNumberView = new CoinRewardNumberView(rootView.getContext());
                coinRewardNumberView.setCanvasImageStart(new CanvasImageBean(18, 18, R.drawable.img_coin, 3));
                coinRewardNumberView.setLayoutParams(new ConstraintBuilder(14, 18).center(myImageView).buildPayoutParams());
                rootView.addView(coinRewardNumberView);
            }


            coinRewardNumberView.setNum(awardBean.getAwardNum());
            ivTitle.setVisibility(View.VISIBLE);
            myImageView.setVisibility(View.VISIBLE);
            coinRewardNumberView.setVisibility(View.VISIBLE);

        } else {
            int size = awardBeans.size();

            
            for (int i = 0; i < size; i++) {
                DragonBallAwardItemView dragonBallAwardItemView;
                if (i == 0) {
                    ConstraintBuilder left = new ConstraintBuilder().ww().centerV();
                    if (size == 2) {
                        left.horizontalChainStyle();
                        left.left();
                        left.rightToLeftById(IDS[size - 1]);
                    } else {
                        left.center();
                    }
                    dragonBallAwardItemView = getDragonBallAwardItemView(i);
                    if (dragonBallAwardItemView == null) {
                        dragonBallAwardItemView = DragonBallAwardItemView.create(rootView, left);
                    }
                    dragonBallAwardItemView.setLayoutParams(left.buildPayoutParams());
                    dragonBallAwardItemView.setAwardBean(awardBeans.get(i), awardBeans.size(), dragonBallView, axcView);
                    dragonBallAwardItemView.setId(IDS[i]);
                } else {

                    ConstraintBuilder constraintBuilder = new ConstraintBuilder().ww().top(IDS[0]);
                    
                    if (size == 2) {
                        constraintBuilder.leftToRightById(IDS[0]);
                        constraintBuilder.right();
                    } else {
                        if (i == 1) {
                            constraintBuilder.rightToLeftById(IDS[0]).left();
                        } else {
                            constraintBuilder.leftToRightById(IDS[0]).right();
                        }
                    }

                    dragonBallAwardItemView = getDragonBallAwardItemView(i);
                    if (dragonBallAwardItemView == null) {
                        dragonBallAwardItemView = DragonBallAwardItemView.create(rootView, constraintBuilder);
                    }
                    dragonBallAwardItemView.setLayoutParams(constraintBuilder.buildPayoutParams());

                    dragonBallAwardItemView.setId(IDS[i]);
                }
                dragonBallAwardItemView.setAwardBean(awardBeans.get(i), awardBeans.size(), dragonBallView, axcView);
                dragonBallAwardItemView.setOnAnimatorListener(this);
                dragonBallAwardItemViews.put(i, dragonBallAwardItemView);
            }

        }


    }


    public DragonBallAwardItemView getDragonBallAwardItemView(int i) {
        if (dragonBallAwardItemViews.containsKey(i)) {
            return dragonBallAwardItemViews.get(i);
        }
        return null;
    }

    public void initData() {

    }

    public void dismiss() {
        AppUtil.getMainHandler().removeCallbacks(runnable, null);

    }

    /**

     *
     * @param viewA
     */
    public void hintOneDragon(View viewA) {
        if (ivDragonBall != null) {
            ivDragonBall.moveToView(viewA);
        }
        setGone();
    }

    public void setGone() {
        if (svgaImageView != null) {
            svgaImageView.setVisibility(View.INVISIBLE);
            svgaImageView.close();
        }
        if (ivTitle != null) {
            ivTitle.setVisibility(View.INVISIBLE);
        }
        if (myImageView != null) {
            myImageView.setVisibility(View.INVISIBLE);
        }
        if (coinRewardNumberView != null) {
            coinRewardNumberView.setVisibility(View.INVISIBLE);
        }

    }


    public void delete() {
        svgaImageView.close();
    }


    @Override
    public void onAnimationEnd() {
        rootView.setVisibility(View.GONE);
        dragonBallListView.setNum(num);
    }
}
