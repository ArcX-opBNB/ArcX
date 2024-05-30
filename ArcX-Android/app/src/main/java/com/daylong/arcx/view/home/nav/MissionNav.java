package com.daylong.arcx.view.home.nav;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class MissionNav extends BaseHomeNav {



    public MissionNav(@NonNull Context context, View toView) {
        super(context, toView);
    }

    @Override
    protected Integer getBgRegId() {
        return R.drawable.img_home_nav_mission;
    }

    @Override
    protected String getSignSvga() {
        return "mission_sign.svga";
    }


    @Override
    protected ConstraintBuilder getSignConstraintBuilder() {
        return new ConstraintBuilder(58, 47).topRight().topRightMargin(24, 10);
    }

    @Override
    protected ConstraintBuilder getViewConstraintBuilder() {
        return new ConstraintBuilder(97, 101).leftTop(toView).leftTopMargin(2,78);
    }


}
