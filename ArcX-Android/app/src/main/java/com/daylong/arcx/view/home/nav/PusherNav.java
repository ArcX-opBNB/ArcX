package com.daylong.arcx.view.home.nav;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.act.game.BaseGameListActivity;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class PusherNav extends BaseHomeNav {


    public PusherNav(@NonNull Context context, View toView) {
        super(context, toView);
    }

    @Override
    protected Integer getBgRegId() {
        return R.drawable.img_home_nav_nft_puasher;
    }

    @Override
    protected String getSignSvga() {
        return "puasher_sign.svga";
    }



    @Override
    protected ConstraintBuilder getSignConstraintBuilder() {
        return new ConstraintBuilder(53, 50).topRight().topRightMargin(27, 43);
    }

    @Override
    protected ConstraintBuilder getViewConstraintBuilder() {
        return new ConstraintBuilder(110, 110).top(toView).topMargin(45).right();
    }

    @Override
    protected void click() {
        super.click();

        BaseGameListActivity.start(getContext(), 1);
    }
}
