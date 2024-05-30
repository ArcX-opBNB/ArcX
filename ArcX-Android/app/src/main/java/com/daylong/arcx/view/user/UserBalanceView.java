package com.daylong.arcx.view.user;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.store.StoreDialog;

import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.layout.LinearLayoutView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class UserBalanceView extends LinearLayoutView {


    private MyTextView tvBalance;
    private MyImageView myImageView;
    private MyImageView ivAdd;

    public UserBalanceView(@NonNull Context context, View toRightView, float leftMargin, int coinRegId) {
        this(context, toRightView, leftMargin, coinRegId, null);
    }

    public UserBalanceView(@NonNull Context context, View toRightView, float leftMargin, int coinRegId, View.OnClickListener onItemClickListener) {
        super(context);

        setId(View.generateViewId());
        setLayoutParams(new ConstraintBuilder(55, 18).leftToRightCenterV(toRightView).leftMargin(leftMargin).buildPayoutParams());
        setOrientation(LinearLayoutView.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundResource(R.drawable.img_user_balance_bg);


        ConstraintLayout build = new ConstraintBuilder().ww().leftMargin(2).build(context);

        myImageView = MyImageView.create(build, new ConstraintBuilder(12).centerV());
        myImageView.setImageReg(coinRegId);
        ivAdd = MyImageView.create(build, new ConstraintBuilder(5.5f).left(myImageView).bottom(myImageView).leftMargin(8), R.drawable.img_balance_plus);

        addView(build);


        tvBalance = MyTextView.create(this, new ConstraintBuilder().ww().leftMargin(1));
        tvBalance.initText("0", 6f, R.color.color_white, true);
        tvBalance.setMinimumWidth(getSize(10));
        tvBalance.setTypeface(Typeface.create("monospace", Typeface.NORMAL));

        if (onItemClickListener != null) {
            setOnClickListener(onItemClickListener);
        } else {
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    StoreDialog.showDialog(AppUtil.getCurrentActivity().getSupportFragmentManager());
                }
            });
        }

    }


    public void goneAddIv() {
        ivAdd.setVisibility(View.GONE);
    }

    public void setBalance(long balance) {
//        4.8 E
        if (balance >= 0) {
            String s = String.valueOf(balance);
            int length = s.length();
            if (length > 7 && length <= 9) {
                tvBalance.setTextSize(4.8f);
            } else if (length > 9) {
                tvBalance.setTextSize(4f);

            }
            tvBalance.setText(StringUtils.numFormatDot(balance));
        }
    }


    public MyImageView getIconView() {
        return myImageView;
    }

}
