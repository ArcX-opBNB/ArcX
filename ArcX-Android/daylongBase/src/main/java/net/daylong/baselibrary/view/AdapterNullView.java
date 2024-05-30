package net.daylong.baselibrary.view;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
import net.daylong.daylongbase.R;

public class AdapterNullView extends ConstraintLayoutView {
    public AdapterNullView(@NonNull Context context) {
        super(context);

        setLayoutParams(new ConstraintBuilder().mm().buildPayoutParams());
        setBackgroundColor(getContext().getColor(R.color.color_f6f6f6));


        MyImageView myImageView = MyImageView.create(this, new ConstraintBuilder(140).topCenterH().topMargin(35), DrawableUtils.getDrawableByName("img_empty_placehoder"));
        myImageView.setId(View.generateViewId());


        MyTextView myTextView = MyTextView.create(this, new ConstraintBuilder().ww().topToBottom(myImageView).centerH());


    }
}
