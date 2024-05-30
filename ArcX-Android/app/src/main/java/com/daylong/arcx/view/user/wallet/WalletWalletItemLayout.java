package com.daylong.arcx.view.user.wallet;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.enums.WalletType;
import com.daylong.arcx.user.wallet.ToSpendingActivity;
import com.daylong.arcx.user.wallet.WithdrawalActivity;
import com.daylong.httplibrary.bean.response.wallet.WalletConfigureResponse;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class WalletWalletItemLayout extends ConstraintLayoutView implements View.OnClickListener {


    private MyTextView tvNum;

    private WalletType walletType;

    public static WalletWalletItemLayout create(ViewGroup viewGroup, View toL, View toB, WalletType walletType, boolean isClick) {
        WalletWalletItemLayout walletWalletItemLayout = new WalletWalletItemLayout(viewGroup.getContext(), toL, toB, walletType, false, isClick);
        viewGroup.addView(walletWalletItemLayout);
        return walletWalletItemLayout;
    }

    public static WalletWalletItemLayout create(ViewGroup viewGroup, View toL, View toB, WalletType walletType, boolean isToeX, boolean isClick) {
        WalletWalletItemLayout walletWalletItemLayout = new WalletWalletItemLayout(viewGroup.getContext(), toL, toB, walletType, isToeX, isClick);
        viewGroup.addView(walletWalletItemLayout);
        return walletWalletItemLayout;
    }

    public static WalletWalletItemLayout createToEx(ViewGroup viewGroup, View toL, View toB, WalletType walletType, boolean isClick) {
        WalletWalletItemLayout walletWalletItemLayout = new WalletWalletItemLayout(viewGroup.getContext(), toL, toB, walletType, true, isClick);
        viewGroup.addView(walletWalletItemLayout);
        return walletWalletItemLayout;
    }


    private DefaultView defaultView;

    private boolean isToeX = false;

    public WalletWalletItemLayout(@NonNull Context context, View toL, View toB, WalletType walletType, boolean isToeX, boolean isClick) {
        super(context);
        this.isToeX = isToeX;
        this.walletType = walletType;
        setId(View.generateViewId());

        setLayoutParams(new ConstraintBuilder(0, 29).topToBottom(toB).centerH(toL).buildPayoutParams());
        MyImageView itemIcon = MyImageView.create(this, new ConstraintBuilder(18).leftMargin(8).leftCenterV(), walletType.getRegId());
        itemIcon.setPadding(getSize(1), getSize(1), getSize(1), getSize(1));
//
        itemIcon.setBackgroundResource(R.drawable.shape_oval_000);
//
        MyTextView tvName = MyTextView.create(this, new ConstraintBuilder().ww().leftToRightById(itemIcon).centerV(itemIcon).leftMargin(5));
        tvName.initText(walletType.getName(), 8, R.color.color_white, false);
//
//
        tvNum = MyTextView.create(this, new ConstraintBuilder().ww().right().centerV(itemIcon).rightMargin(8));
        tvNum.initText(8, R.color.color_white, false);
//
//
        defaultView = DefaultView.create(this, new ConstraintBuilder(158, 1).bottomCenterH());
        defaultView.setBackgroundColor(Color.parseColor("#ff7d64d5"));
        tvNum.setText("0");


        if (isClick) {
            setOnClickListener(this);
        }
    }


    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setNum(double balance) {
        this.balance = balance;
        tvNum.setText(String.valueOf(balance));
    }

    public void goneLine() {
        defaultView.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        if (isToeX) {
            ToSpendingActivity.start(getContext(), balance, walletType);

        } else {
            WithdrawalActivity.start(getContext(), balance, walletType,configureInfo);

        }
    }

    private WalletConfigureResponse configureInfo;

    public void setConfigureInfo(WalletConfigureResponse configureInfo) {

        this.configureInfo = configureInfo;
    }
}
