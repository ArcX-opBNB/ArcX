package net.daylong.baselibrary.utils.ui.view.button;

import android.content.Context;
import android.util.AttributeSet;

public abstract class IImageButton extends androidx.appcompat.widget.AppCompatImageButton {
    public IImageButton(Context context) {
        this(context, null);
    }

    public IImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setScaleType(ScaleType.FIT_CENTER);

    }
}
