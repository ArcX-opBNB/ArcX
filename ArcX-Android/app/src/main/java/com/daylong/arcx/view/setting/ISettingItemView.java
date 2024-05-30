package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.LinearLayoutBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.utils.ui.layout.cl.RightLayoutC;
import net.daylong.baselibrary.utils.ui.layout.cl.TopLayoutC;
import net.daylong.baselibrary.utils.ui.layout.ll.LinearLayoutUtils;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public abstract class ISettingItemView extends ConstraintLayoutView implements View.OnClickListener {
   protected MyTextView tvName;


    public abstract String getName();

    public abstract String getRightText();

    protected boolean isShowRightIcon() {
        return true;
    }

    private MyTextView tvRightText;


    protected Integer getLeftIcon() {
        return null;
    }

    private MyImageView ivLeftIcon;

    public ISettingItemView(@NonNull Context context) {
        super(context);

        setBackgroundResource(com.daylong.reglinrary.R.drawable.bj_shape_r12_c_1ff);
        setLayoutParams(new  LinearLayoutBuilder(139, 22).topMargin(4).buildPayoutParams());

        if (getLeftIcon() != null) {

            ivLeftIcon = MyImageView.create(this, new ConstraintBuilder(20).leftCenterV().leftMargin(2), getLeftIcon());


        }

        createName();

        createRightText();
        setOnClickListener(this);


    }

    private void createRightText() {
        LayoutParams layoutParamsWW = ConstraintLayoutUtils.getLayoutParamsWW();

        RightLayoutC.right(layoutParamsWW);
        RightLayoutC.margin(layoutParamsWW,8);
        TopLayoutC.centerV(layoutParamsWW);

        tvRightText = MyTextView.create(this, layoutParamsWW);
        tvRightText.initText(getRightText(),7,net.daylong.daylongbase.R.color.color_333,true);


    }



    private void createName() {


        ConstraintBuilder ww = new ConstraintBuilder().ww().centerV();


        if (ivLeftIcon != null) {
            ww.leftToRightById(ivLeftIcon).leftMargin(2);
        } else {
            ww.left().leftMargin(7);

        }


        tvName = MyTextView.create(this, ww);
        tvName.initText(getName(),7,net.daylong.daylongbase.R.color.color_333,true);


    }


    public void setTvRightText(String str) {
        tvRightText.setText(str);
    }

    @Override
    public void onClick(View v) {

    }
}
