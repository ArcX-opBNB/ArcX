package net.daylong.baselibrary.view.textview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class NumTextView extends BaseTextView {


    public static NumTextView create(ViewGroup viewGroup, ViewGroup.LayoutParams params) {

        NumTextView numTextView = new NumTextView(viewGroup.getContext());
        numTextView.setLayoutParams(params);
        viewGroup.addView(numTextView);
        return numTextView;

    }    public static NumTextView create(ViewGroup viewGroup, ConstraintBuilder  constraintBuilder) {

        NumTextView numTextView = new NumTextView(viewGroup.getContext());
        numTextView.setLayoutParams(constraintBuilder.buildPayoutParams());
        viewGroup.addView(numTextView);
        return numTextView;

    }

    public static NumTextView create(ViewGroup viewGroup, ViewGroup.LayoutParams params, float size) {

        NumTextView numTextView = new NumTextView(viewGroup.getContext());
        numTextView.setTextSize(size);
        numTextView.setLayoutParams(params);
        viewGroup.addView(numTextView);
        return numTextView;

    }    public static NumTextView create(ViewGroup viewGroup, ConstraintBuilder constraintBuilder, float size) {

        NumTextView numTextView = new NumTextView(viewGroup.getContext());
        numTextView.setTextSize(size);
        numTextView.setLayoutParams(constraintBuilder.buildPayoutParams());
        viewGroup.addView(numTextView);
        return numTextView;

    }

    public NumTextView(@NonNull Context context) {
        this(context, null);
    }

    public NumTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    /**

     *
     * @param num
     */
    public void setNum(long num) {
        if (num >= 0) {
            setText(StringUtils.numFormatDot(num));
        } else {

        }
    }


    public void seLeftDrawable(int leftId) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), leftId);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            setCompoundDrawables(drawable, null, null, null);
        }
    }


    public void setNUmForDot(int num) {
       setText( StringUtils.getCoinNum(num));
    }
}
