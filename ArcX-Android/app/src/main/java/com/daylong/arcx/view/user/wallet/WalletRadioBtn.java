package com.daylong.arcx.view.user.wallet;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.core.content.ContextCompat;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.sys.AppUtil;

public class WalletRadioBtn extends androidx.appcompat.widget.AppCompatRadioButton implements CompoundButton.OnCheckedChangeListener {

    public static WalletRadioBtn create(ViewGroup viewGroup, String tableName, int regId) {

        WalletRadioBtn dayTask = new WalletRadioBtn(viewGroup.getContext(), tableName,regId);
        viewGroup.addView(dayTask);
        return dayTask;
    }


    private int regId;

    public WalletRadioBtn(Context context, String name, int regId) {
        super(context);
        this.regId = regId;
        setOnCheckedChangeListener(this);
        setButtonDrawable(new StateListDrawable());
        setText(name);
        setButtonDrawable(null);
        setId(View.generateViewId());
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(0, AppUtil.getSize(28));
        layoutParams.weight = 1;
        setLayoutParams(layoutParams);
        setGravity(Gravity.CENTER);
        setTextColor(getContext().getColor(R.color.color_white));
        getPaint().setTextSize(AppUtil.getSize(11));

    }

    @Override
    public void setTextSize(float size) {
        getPaint().setTextSize(AppUtil.getSize(size));
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


        if (isChecked) {
            setBackgroundResource(regId);
            setTextColor(Color.WHITE);
        } else {
            setTextColor(Color.parseColor("#A5A5A5"));
            setBackgroundResource(R.drawable.shape_tr);
        }
    }
}
