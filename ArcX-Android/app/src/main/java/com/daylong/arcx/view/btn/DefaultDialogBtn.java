package com.daylong.arcx.view.btn;

import android.content.Context;
import android.view.Gravity;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;

import net.daylong.baselibrary.view.btn.BaseButton;

public class DefaultDialogBtn extends BaseButton {
    public DefaultDialogBtn(@NonNull Context context) {
        super(context);

        setPadding(0, getSize(7), 0, 0);
        setGravity(Gravity.CENTER_HORIZONTAL);
        initBtn(10, R.color.color_434343, true);
        setBackgroundResource(R.drawable.img_collect_btn);
    }
}
