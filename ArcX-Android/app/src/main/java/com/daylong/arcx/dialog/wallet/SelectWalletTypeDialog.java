package com.daylong.arcx.dialog.wallet;


import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.enums.WalletType;
import com.daylong.arcx.uitls.DialogDefaultOpenAnimator;
import com.daylong.arcx.view.user.wallet.SelectWalletType;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;


import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;


public class SelectWalletTypeDialog extends BottomPopupView {


    public static void show(BaseActivity activity, SelectWalletType.OnItemClickListener onItemClickListener) {


        new XPopup.Builder(activity)
                .customAnimator(new DialogDefaultOpenAnimator())
                .animationDuration(500)
                .asCustom(new SelectWalletTypeDialog(activity, onItemClickListener)).show();

    }

    private SelectWalletType.OnItemClickListener onItemClickListener;

    public SelectWalletTypeDialog(@NonNull Context context, SelectWalletType.OnItemClickListener onItemClickListener) {
        super(context);
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    protected void addInnerContent() {

        LinearLayout contentView = new LinearLayout(getContext());
        contentView.setLayoutParams(new ConstraintBuilder(188, 224).buildPayoutParams());
        contentView.setGravity(Gravity.CENTER_HORIZONTAL);
        contentView.setOrientation(LinearLayout.VERTICAL);
        contentView.setBackgroundResource(R.drawable.shape_top_r_13_bg_225a);


        for (WalletType value : WalletType.values()) {
            SelectWalletType selectWalletType = new SelectWalletType(getContext(), value, this);
            selectWalletType.setOnItemClickListener(onItemClickListener);
            contentView.addView(selectWalletType);

        }


        bottomPopupContainer.addView(contentView);


    }

    @Override
    protected void onCreate() {
        super.onCreate();


    }
}
