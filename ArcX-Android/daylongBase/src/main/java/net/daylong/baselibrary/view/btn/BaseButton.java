package net.daylong.baselibrary.view.btn;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.sys.SystemUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class BaseButton extends androidx.appcompat.widget.AppCompatButton {

    public static BaseButton create(ViewGroup viewGroup, ViewGroup.LayoutParams params) {
        BaseButton button = new BaseButton(viewGroup.getContext());
        button.setLayoutParams(params);
        button.setTextColor(Color.WHITE);

        viewGroup.addView(button);

        return button;
    }

    public static BaseButton create(ViewGroup viewGroup, ConstraintBuilder constraintBuilder) {
        BaseButton button = new BaseButton(viewGroup.getContext());
        button.setLayoutParams(constraintBuilder.buildPayoutParams());
        button.setTextColor(Color.WHITE);

        viewGroup.addView(button);

        return button;
    }

    public BaseButton(@NonNull Context context) {
        this(context, null);
    }

    public BaseButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public int getSize(float size) {
        return AppUtil.getSize(size);
    }


    @Override
    public void setTextSize(float size) {
        getPaint().setTextSize(AppUtil.getSize(size));
    }

    public void setColorId(int id) {
        setTextColor(ContextCompat.getColor(getContext(), id));

    }

    public String getString(int regId) {
        return getContext().getString(regId);
    }


    public void initBtn(String text, int textSize, Integer textColorId, boolean fakeBoldText) {

        setText(text);
        setTextSize(textSize);
        if (textColorId != null) {
            setColorId(textColorId);
        }
        setFakeBoldText(fakeBoldText);

    }

    public void initBtn(int textSize, int textColorId, boolean fakeBoldText) {

        setTextSize(textSize);
        setColorId(textColorId);
        setFakeBoldText(fakeBoldText);

    }

    public void initBtn(String text, int textSize, int textColorId) {
        initBtn(text, textSize, textColorId, false);
    }

    public void initBtnFakeBold(String text, int textSize, int textColorId) {
        initBtn(text, textSize, textColorId, true);
    }

    public void initBtn(int strId, int textSize, int textColorId, boolean fakeBoldText) {
        initBtn(SystemUtil.getString(strId), textSize, textColorId, fakeBoldText);
    }

    public void initText(int strId, int textSize, boolean fakeBoldText) {
        initBtn(SystemUtil.getString(strId), textSize, null, fakeBoldText);
    }

    public void setFakeBoldText(boolean fakeBoldText) {

        getPaint().setFakeBoldText(fakeBoldText);
    }

}
