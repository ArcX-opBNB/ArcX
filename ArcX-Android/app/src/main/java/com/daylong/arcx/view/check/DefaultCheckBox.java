package com.daylong.arcx.view.check;

import android.content.Context;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class DefaultCheckBox extends androidx.appcompat.widget.AppCompatCheckBox {
    public DefaultCheckBox(@NonNull Context context, ConstraintBuilder constraintBuilder, int backReg) {
        super(context);
        constraintBuilder.width(29);
        constraintBuilder.height(15);
        setLayoutParams(constraintBuilder.buildPayoutParams());
        setButtonDrawable(null);
        setBackgroundResource(backReg);

    }
}
