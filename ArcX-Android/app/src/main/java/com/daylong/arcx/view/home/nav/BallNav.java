package com.daylong.arcx.view.home.nav;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.act.game.BaseGameListActivity;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class BallNav extends BaseHomeNav {


    public BallNav(@NonNull Context context, View toView) {
        super(context, toView);
    }

    @Override
    protected Integer getBgRegId() {
        return R.drawable.img_home_nav_ball;
    }

    @Override
    protected String getSignSvga() {
        return "ball_sign.svga";
    }


    @Override
    protected ConstraintBuilder getSignConstraintBuilder() {
        return new ConstraintBuilder(43, 53).topRight().topRightMargin(5, 37);
    }

    @Override
    protected ConstraintBuilder getViewConstraintBuilder() {
        return new ConstraintBuilder(91, 95).top(toView).right().topRightMargin(88,9);
    }

    @Override
    protected void click() {
        BaseGameListActivity.start(getContext(), 3);

    }
}
