package net.daylong.baselibrary.view.img;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.BaseImageView;


public class MyImageView extends BaseImageView {


    public static MyImageView create(ViewGroup viewGroup, ConstraintBuilder builder, Integer position, Integer regId) {
        return create(viewGroup,builder.buildPayoutParams(),position,regId);

    }

    public static MyImageView create(ViewGroup viewGroup, ViewGroup.LayoutParams params, Integer position, Integer regId) {


        MyImageView myImageView = new MyImageView(viewGroup.getContext(), regId);
        myImageView.setLayoutParams(params);
        if (position != null) {
            viewGroup.addView(myImageView, position);
        } else {
            viewGroup.addView(myImageView);
        }
        return myImageView;

    }

    public static MyImageView create(ViewGroup viewGroup, ConstraintBuilder builder) {
        return create(viewGroup, builder, null, null);

    }

    public static MyImageView create(ViewGroup viewGroup, int position, ConstraintBuilder builder) {
        return create(viewGroup, builder, position, null);

    }

    public static MyImageView create(ViewGroup viewGroup, ConstraintBuilder builder, int regId) {
        return create(viewGroup, builder, null, regId);


    }

    public MyImageView(@NonNull Context context) {
        super(context);
        setId(View.generateViewId());
        setBackgroundResource(net.daylong.daylongbase.R.drawable.shape_ov_fff);
    }

    public MyImageView(@NonNull Context context, Integer regId) {
        super(context);
        setId(View.generateViewId());
        if (regId != null) {
            setImageRegCrop(regId);
        }
    }
}
