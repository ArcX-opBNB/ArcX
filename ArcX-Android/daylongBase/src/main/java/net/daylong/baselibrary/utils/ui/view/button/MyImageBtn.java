package net.daylong.baselibrary.utils.ui.view.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class MyImageBtn extends IImageButton {
    public static MyImageBtn create(ViewGroup viewGroup, ConstraintBuilder constraintBuilder, @DrawableRes Integer resId) {
        MyImageBtn myImageBtn = new MyImageBtn(viewGroup.getContext());
        myImageBtn.setLayoutParams(constraintBuilder.buildPayoutParams());
        if (resId != null) {
            myImageBtn.setImageResource(resId);
        }
        viewGroup.addView(myImageBtn);
        return myImageBtn;
    }

    public static MyImageBtn create(ViewGroup viewGroup, ConstraintBuilder constraintBuilder) {
        return create(viewGroup, constraintBuilder, null);
    }

    public MyImageBtn(Context context) {
        this(context, null);
    }

    public MyImageBtn(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyImageBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }
}
