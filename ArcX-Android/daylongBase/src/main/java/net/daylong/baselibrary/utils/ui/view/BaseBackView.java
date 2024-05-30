package net.daylong.baselibrary.utils.ui.view;

import android.content.Context;
import android.graphics.BlendMode;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.daylong.baselibrary.utils.sys.SystemUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.utils.ui.view.button.MyImageBtn;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.btn.MyImgBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
import net.daylong.daylongbase.R;

public class BaseBackView extends ConstraintLayoutView {

    private BaseActivity mActivity;

    public BaseBackView(@NonNull BaseActivity activity, Integer imageReg, boolean addback, ConstraintBuilder constraintBuilder) {

        super(activity);

        this.mActivity = activity;

        if (constraintBuilder != null) {
            setLayoutParams(constraintBuilder.buildPayoutParams());
        } else {
            setLayoutParams(new ConstraintBuilder(142, 24).leftBottom().bottomMargin(30).buildPayoutParams());
        }

        MyBtn.create(this, new ConstraintBuilder().mm().leftTop(), imageReg, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {


                if (onBackClickListener != null) {
                    onBackClickListener.onClick();
                } else {
                    mActivity.finish();
                    mActivity = null;
                }
            }
        });

        if (addback) {
            MyImageView.create(this, new ConstraintBuilder(11, 17).leftCenterV().leftMargin(4), DrawableUtils.getDrawableByName("img_base_back"));
        }

    }

    public BaseBackView(@NonNull BaseActivity activity, Integer imageReg, boolean addback) {
        this(activity, imageReg, addback, null);

    }


    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }

    private OnBackClickListener onBackClickListener;

    public void setOnBackClickListener(OnBackClickListener onBackClickListener) {
        this.onBackClickListener = onBackClickListener;
    }

    public interface OnBackClickListener {

        void onClick();
    }


}
