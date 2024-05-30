package com.daylong.arcx.view.store.prop;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.date.DateUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class PropHeaderView extends ConstraintLayoutView {

    private MyTextView tvTime;

    public PropHeaderView(@NonNull Context context) {
        super(context);


        setLayoutParams(new ConstraintBuilder(162, 21).topMargin(8).buildPayoutParams());

        MyImageView myImageView = MyImageView.create(this, new ConstraintBuilder(162, 21).center());
        myImageView.setBackgroundResource(R.drawable.img_store_porp_title);
        tvTime = MyTextView.create(this, new ConstraintBuilder().ww().rightCenterV(myImageView.getId()).rightMargin(8));
        tvTime.initText(7, R.color.color_white, false);
        tvTime.setCompoundDrawablePadding(AppUtil.getSize(1));
        DrawableUtils.setLeftDrawable(tvTime, 12, R.drawable.img_store_porp_re_porp);

    }

    public void setOnTimeClickList(View.OnClickListener onTimeClickList) {
        tvTime.setOnClickListener(onTimeClickList);
    }

    private final Runnable timeRun = new Runnable() {
        @Override
        public void run() {
            tvTime.setText(DateUtil.getTimeString(time));
            time--;
            postDelayed(this, 1000);

        }
    };

    private int time;

    public void setTime(int time) {

        this.time = time;
        removeCallbacks(timeRun);

        postDelayed(timeRun, 0);

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(timeRun);
    }
}
