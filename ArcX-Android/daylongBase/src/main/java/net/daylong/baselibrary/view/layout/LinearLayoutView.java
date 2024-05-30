package net.daylong.baselibrary.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import net.daylong.baselibrary.utils.sys.AppUtil;

public class LinearLayoutView extends LinearLayout {

    public LinearLayoutView(Context context) {
        this(context, null);
    }

    public LinearLayoutView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public int getSize(float size) {
        return AppUtil.getSize(size);
    }


    public static LayoutParams create() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }


}
