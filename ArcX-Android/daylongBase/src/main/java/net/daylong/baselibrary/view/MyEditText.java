package net.daylong.baselibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class MyEditText extends EditText {


    public MyEditText(@NonNull Context context) {
        this(context,null);
    }

    public MyEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
            }

    public MyEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static MyEditText create(ViewGroup viewGroup, ConstraintBuilder constraintBuilder) {

        MyEditText editText = new MyEditText(viewGroup.getContext());
        editText.setLayoutParams(constraintBuilder.getParams());
        viewGroup.addView(editText);
        return editText;

    }


    @Override
    public void setTextSize(float size) {
        getPaint().setTextSize(AppUtil.getSize(size));
    }

}
