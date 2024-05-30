package com.daylong.arcx.view.home.titlenav;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public abstract class TitleNavItem extends androidx.appcompat.widget.AppCompatImageButton implements View.OnClickListener {

    protected int rightMargin() {
        return 15;
    }

    public abstract int imgRegId();

    protected FragmentManager fragmentManager;

    public TitleNavItem(@NonNull Context context, FragmentManager fragmentManager) {
        super(context);
        this.fragmentManager = fragmentManager;
        setLayoutParams(new ConstraintBuilder(21, 30).rightMargin(rightMargin()).buildPayoutParams());
        setImageResource(imgRegId());
        setScaleType(ScaleType.CENTER);
        setOnClickListener(this);
        setBackgroundColor(Color.TRANSPARENT);
    }


    @Override
    protected void onDetachedFromWindow() {
        fragmentManager = null;
        super.onDetachedFromWindow();
    }
}
