package net.daylong.baselibrary.utils.ui.layout.cl;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import net.daylong.baselibrary.utils.sys.AppUtil;

public abstract class ConstraintLayoutView extends ConstraintLayout {
    public ConstraintLayoutView(@NonNull Context context) {
        this(context, null);
    }

    public ConstraintLayoutView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ConstraintLayoutView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected int getSize(float size) {
        return AppUtil.getSize(size);
    }

    public boolean isNull(String msg) {
        return TextUtils.isEmpty(msg);
    }

}
