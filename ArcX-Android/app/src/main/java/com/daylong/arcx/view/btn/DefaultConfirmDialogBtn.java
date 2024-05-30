package com.daylong.arcx.view.btn;

import android.content.Context;
import android.view.Gravity;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;

public class DefaultConfirmDialogBtn extends BaseButton {
    public DefaultConfirmDialogBtn(@NonNull Context context, int id) {
        this(context, id, 16);
    }

    public DefaultConfirmDialogBtn(@NonNull Context context, int id, int topMargin) {
        super(context);


        ConstraintBuilder constraintBuilder = new ConstraintBuilder(64, 27).topToBottom(id);
        constraintBuilder.left().leftTopMargin(13, topMargin);

        setPadding(0, AppUtil.getSize(4), 0, 0);
        setGravity(Gravity.CENTER_HORIZONTAL);
        setBackgroundResource(R.drawable.img_mch_btn);
        initBtn(10, R.color.color_white, true);
        setLayoutParams(constraintBuilder.buildPayoutParams());
        setShadowLayer(3, 0, 0, getContext().getColor(R.color.color_c2001da7));

    }
}
