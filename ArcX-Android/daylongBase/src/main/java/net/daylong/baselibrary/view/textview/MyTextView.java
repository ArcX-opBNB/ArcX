package net.daylong.baselibrary.view.textview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.SystemUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class MyTextView extends BaseTextView {

    public static MyTextView create(ViewGroup viewGroup, ViewGroup.LayoutParams params) {
        MyTextView numTextView = new MyTextView(viewGroup.getContext());
        numTextView.setLayoutParams(params);
        viewGroup.addView(numTextView);
        return numTextView;

    }

    public static MyTextView create(Context context, ConstraintBuilder constraint) {

        MyTextView numTextView = new MyTextView(context);
        numTextView.setLayoutParams(constraint.buildPayoutParams());
        return numTextView;

    }

    public static MyTextView create(ViewGroup viewGroup, ConstraintBuilder constraint) {

        MyTextView numTextView = new MyTextView(viewGroup.getContext());
        numTextView.setLayoutParams(constraint.getParams());
        viewGroup.addView(numTextView);
        return numTextView;

    }

    public static MyTextView create(ViewGroup viewGroup, int position, ViewGroup.LayoutParams params) {

        MyTextView numTextView = new MyTextView(viewGroup.getContext());
        numTextView.setLayoutParams(params);
        viewGroup.addView(numTextView, position);
        return numTextView;

    }

    public MyTextView(@NonNull Context context) {
        this(context, null);


    }

    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setId(View.generateViewId());

    }

    /**

     */
    public void setFakeBold() {
        getPaint().setFakeBoldText(true);
    }


    public void initText(String text, float textSize, Integer textColorId, boolean fakeBoldText) {

        setText(text);
        setTextSize(textSize);
        if (textColorId != null) {
            setTextColorReg(textColorId);
        }
        setFakeBoldText(fakeBoldText);

    }

    public void initText(float textSize, int textColorId, boolean fakeBoldText) {
        initText("", textSize, textColorId, fakeBoldText);
    }

    public void initText(float textSize, boolean fakeBoldText) {
        initText("", textSize, null, fakeBoldText);
    }

    public void initText(String text, float textSize, int textColorId) {
        initText(text, textSize, textColorId, false);
    }

    public void initText(int strId, float textSize, int textColorId, boolean fakeBoldText) {
        initText(SystemUtil.getString(strId), textSize, textColorId, fakeBoldText);
    }

    public void initTextFakeBold(String text, float textSize, int textColorId) {
        initText(text, textSize, textColorId, true);
    }

    public void setFakeBoldText(boolean fakeBoldText) {

        getPaint().setFakeBoldText(fakeBoldText);
    }


    public void setNum(long num) {
        setText(StringUtils.numFormatDot(num));
    }

}
