package com.daylong.arcx.view.home.nav;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.act.game.BaseGameListActivity;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class ClawNav extends BaseHomeNav {


    public ClawNav(@NonNull Context context, View toView) {
        super(context, toView);
    }

    @Override
    protected Integer getBgRegId() {
        return R.drawable.img_home_nav_nft_claw;
    }


    @Override
    protected String getSignSvga() {
        return "claw_sign.svga";
    }

    @Override
    protected ConstraintBuilder getSignConstraintBuilder() {
        return new ConstraintBuilder(53, 38).topRight().topRightMargin(25, 21);
    }

    @Override
    protected ConstraintBuilder getViewConstraintBuilder() {
        return new ConstraintBuilder(87, 98).leftTop(toView).leftTopMargin(2, 85);
    }


    @Override
    protected void click() {
        BaseGameListActivity.start(getContext(), 2);
    }
}
