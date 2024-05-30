package com.daylong.arcx.view.user.wallet;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.enums.WalletType;
import com.lxj.xpopup.core.BasePopupView;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.LinearLayoutBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class SelectWalletType extends ConstraintLayoutView implements View.OnClickListener {
    private WalletType walletType;

    private BasePopupView popupView;

    public SelectWalletType(@NonNull Context context, WalletType walletType, BasePopupView popupView) {
        super(context);
        this.walletType = walletType;
        this.popupView = popupView;
        setLayoutParams(new LinearLayoutBuilder(172, 28).topMargin(8).buildPayoutParams());
        setBackgroundResource(R.drawable.shape_r16_fff);
        MyImageView itemIcon = MyImageView.create(this, new ConstraintBuilder(18).leftCenterV().leftMargin(8), walletType.getRegId());
        itemIcon.setPadding(getSize(1), getSize(1), getSize(1), getSize(1));
        itemIcon.setBackgroundResource(R.drawable.shape_oval_000);

        MyTextView tvName = MyTextView.create(this, new ConstraintBuilder().ww().leftToRightById(itemIcon).centerV(itemIcon).leftMargin(3));
        tvName.initText(walletType.getName(), 7, net.daylong.daylongbase.R.color.color_333, false);

        setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.click(walletType);
        }
        popupView.dismiss();
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void click(WalletType walletType);

    }

}
