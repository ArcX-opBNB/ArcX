package com.daylong.arcx.view.user.check;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.response.user.CheckInInfoResponse;
import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class CheckInItemView extends ConstraintLayoutView {

    public static void create(ViewGroup viewGroup) {

        int topMargin = 46;
        int leftMargin = 12;
        for (int i = 0; i < 7; i++) {
            int position = i % 3;
            int line = i / 3;
            ConstraintBuilder constraintBuilder = new ConstraintBuilder(i != 6 ? 46 : 112, 56);
            constraintBuilder.top().left();
            constraintBuilder.topMargin(topMargin + (line * 57) + (line * 3));

            if (i != 6) {
                constraintBuilder.leftMargin(leftMargin + (position * 51));
            } else {
                constraintBuilder.right();
            }
            CheckInItemView checkItemView = new CheckInItemView(viewGroup.getContext(), i);
            checkItemView.setLayoutParams(constraintBuilder.buildPayoutParams());
            viewGroup.addView(checkItemView);


        }
    }


    private MyTextView tvDay, tvCoinNum;
    private MyImageView ivCheck;
    private MyImageView ivAward;

    public CheckInItemView(@NonNull Context context, int day) {
        super(context);

        ivCheck = MyImageView.create(this, new ConstraintBuilder(42, 43).topCenterH().topMargin(10), R.drawable.img_rewards_halo);
        tvDay = MyTextView.create(this, new ConstraintBuilder().ww().topCenterH().topMargin(5));
        tvDay.initText(7, R.color.color_434343, true);
        ivAward = MyImageView.create(this, new ConstraintBuilder(20, 20).topCenterH().topMargin(21), R.drawable.img_coin);
        tvCoinNum = MyTextView.create(this, new ConstraintBuilder().ww().bottomCenterH().bottomMargin(4));
        tvCoinNum.initText(7, R.color.color_434343, true);


        setBackgroundResource(day == 6 ? R.drawable.img_checkin_cell_7 : R.drawable.img_checkin_cell);
    }


    public void initData(CheckInInfoResponse.SignListDTO signItem) {
        

        if (signItem.isCheck()) {
            ivAward.setImageReg(R.drawable.img_checkin_done);
            tvCoinNum.setVisibility(View.GONE);
        } else {
            AwardBean awardBean = signItem.getAwardList().get(0);
            if (awardBean != null) {
                tvCoinNum.setTextNumDot(awardBean.getAwardNum());
                ivAward.setImageUrl(awardBean.getAwardImgUrl());
            }

        }
    }

    public void setStatue(boolean isCheck) {
        ivCheck.setVisibility(isCheck ? View.VISIBLE : View.GONE);

    }
}
