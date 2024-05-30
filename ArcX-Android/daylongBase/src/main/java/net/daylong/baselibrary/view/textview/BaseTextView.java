package net.daylong.baselibrary.view.textview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.daylongbase.R;

public class BaseTextView extends TextView {
    public static BaseTextView create(ViewGroup viewGroup, ConstraintBuilder constraint) {

        BaseTextView numTextView = new BaseTextView(viewGroup.getContext());
        numTextView.setLayoutParams(constraint.buildPayoutParams());
        viewGroup.addView(numTextView);
        return numTextView;

    }

    public BaseTextView(@NonNull Context context) {
        this(context, null);
    }

    public BaseTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
    }

    public BaseTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setColorReg(R.color.color_333);
    }


    @Override
    public void setTextSize(float size) {
        getPaint().setTextSize(AppUtil.getSize(size));
    }

    public int size(float size) {
        return AppUtil.getSize(size);
    }

    public void setTextColorReg(int id) {
        setTextColor(ContextCompat.getColor(getContext(), id));

    }

    public void setColorReg(int colorId) {
        setTextColor(ContextCompat.getColor(getContext(), colorId));

    }


    public void setTextNumDot(int num) {
        setText(StringUtils.numFormatDot(num));
    }


    public void setTextNumDot(long num) {
        setText(StringUtils.numFormatDot(num));
    }
}
