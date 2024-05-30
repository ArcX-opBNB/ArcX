package com.daylong.arcx.view.home;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class HomeTabView extends ConstraintLayoutView {
    private MyImageView myImageView;
    private MyTextView tvTabName;

    private boolean check;
    private DefaultView bgView;

    public HomeTabView(@NonNull Context context, String tabName, int regId) {
        super(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.weight = 1;
        setLayoutParams(layoutParams);
        createBg();
        createTextView(tabName);
        createImageView(regId);

    }

    private void createBg() {
        bgView = DefaultView.create(this, new ConstraintBuilder(63, 47).bottomCenterH());
        bgView.setBackgroundColor(Color.WHITE);

    }


    public void setCheck(boolean check) {
        this.check = check;
        bgView.setBackgroundColor(check ? getContext().getColor(R.color.main_color) : Color.WHITE);
        tvTabName.setVisibility(isCheck() ? VISIBLE : GONE);
        ConstraintLayout.LayoutParams layoutParams = (LayoutParams) myImageView.getLayoutParams();
        layoutParams.bottomMargin = (check ? getSize(11) : getSize(0));
        myImageView.requestLayout();
    }

    public boolean isCheck() {
        return check;
    }

    private void createTextView(String tabName) {
        tvTabName = MyTextView.create(this, new ConstraintBuilder().mm().height(11).bottomMargin(11).bottomCenterH());
        tvTabName.initText(tabName, 8, net.daylong.daylongbase.R.color.color_333, true);
        tvTabName.setVisibility(GONE);
        tvTabName.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void createImageView(int reg) {
        myImageView = MyImageView.create(this, new ConstraintBuilder(63, 47).bottomCenterH());
        myImageView.setId(View.generateViewId());
        myImageView.setImageReg(reg);
        myImageView.setScaleType(ImageView.ScaleType.CENTER);
    }
}
