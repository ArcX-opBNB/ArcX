package com.daylong.arcx.view.user.order.group;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;


public class TaskRadioBtn extends androidx.appcompat.widget.AppCompatRadioButton {

    public static TaskRadioBtn create(ViewGroup viewGroup, String tableName, float leftMargin) {

        TaskRadioBtn dayTask = new TaskRadioBtn(viewGroup.getContext(), leftMargin);
        dayTask.setText(tableName);
        viewGroup.addView(dayTask);
        return dayTask;
    }

    public TaskRadioBtn(Context context, float leftMargin) {
        super(context);

        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, new ColorDrawable(Color.TRANSPARENT)); 
        stateListDrawable.addState(new int[]{}, new ColorDrawable(Color.TRANSPARENT)); 


        setButtonDrawable(stateListDrawable);
        setLayoutParams(new ConstraintBuilder(33, 15).leftMargin(leftMargin).buildPayoutParams());
        setTextColor(getContext().getColor(R.color.color_434343));
        setGravity(Gravity.CENTER);
        setTextSize(8);

        setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setTextSize(b ? 11 : 8);
                setTextColor(getContext().getColor(net.daylong.daylongbase.R.color.color_333));
                setTextColor(getContext().getColor(R.color.color_434343));
            }
        });
    }

    @Override
    public void setTextSize(float size) {
        getPaint().setTextSize(AppUtil.getSize(size));
    }

}
