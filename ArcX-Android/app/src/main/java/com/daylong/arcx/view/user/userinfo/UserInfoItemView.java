package com.daylong.arcx.view.user.userinfo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class UserInfoItemView extends ConstraintLayoutView {
    public UserInfoItemView(@NonNull Context context, String titleName, int regId, Class<?> cla) {
        super(context);


        setLayoutParams(new ConstraintBuilder(174, 34).buildPayoutParams());


        MyImageView myImageView = MyImageView.create(this, new ConstraintBuilder(16).leftTop().leftTopMargin(5, 9), regId);
        myImageView.setId(View.generateViewId());


        MyImageView.create(this, new ConstraintBuilder(10).rightCenterV().rightMargin(6), R.drawable.img_arrow_right);


        MyTextView myTextView = MyTextView.create(this, new ConstraintBuilder().ww().leftToRightById(myImageView).leftMargin(5).centerV());
        myTextView.initText(titleName, 8, R.color.color_434343, false);


        View view = new View(getContext());
        view.setLayoutParams(new ConstraintBuilder(154, 1).bottomCenterH().buildPayoutParams());
        view.setBackgroundColor(getContext().getColor(R.color.color_f4f4f4));
        addView(view);
        setBackgroundColor(Color.TRANSPARENT);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cla != null) {
                    BaseActivity.start(getContext(), cla);
                }
            }
        });
    }
}
