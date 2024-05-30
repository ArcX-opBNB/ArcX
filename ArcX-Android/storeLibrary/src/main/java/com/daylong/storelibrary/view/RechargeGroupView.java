package com.daylong.storelibrary.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;


public class RechargeGroupView extends NestedScrollView {
    private LinearLayout rootView;
    public RechargeGroupView(@NonNull Context context) {
        super(context);
        setVisibility(View.INVISIBLE);


        rootView = new LinearLayout(getContext());
        rootView.setOrientation(LinearLayout.VERTICAL);

        rootView.setLayoutParams(new ConstraintBuilder(188, 408).center().buildPayoutParams());

        setOverScrollMode(View.OVER_SCROLL_NEVER);
        
        setVerticalScrollBarEnabled(false);
        
        setHorizontalScrollBarEnabled(false);



    }





}
