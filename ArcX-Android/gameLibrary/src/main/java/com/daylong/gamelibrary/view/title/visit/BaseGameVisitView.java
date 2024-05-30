package com.daylong.gamelibrary.view.title.visit;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class BaseGameVisitView extends IGameVisitView {

    public BaseGameVisitView(@NonNull Context context, View view) {
        super(context);
        setLayoutParams(new ConstraintBuilder(0, 18).leftToRightById(net.daylong.daylongbase.R.id.base_view_4).rightToLeftById(view.getId()).centerV(view.getId()).leftRightMargin(3).buildPayoutParams());
    }

    public BaseGameVisitView(@NonNull Context context, ConstraintBuilder constraintBuilder) {
        super(context);
        setLayoutParams(constraintBuilder.buildPayoutParams());
    }


}
