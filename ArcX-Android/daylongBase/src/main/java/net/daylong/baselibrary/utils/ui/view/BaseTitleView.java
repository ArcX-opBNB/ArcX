package net.daylong.baselibrary.utils.ui.view;

import android.content.Context;
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
import net.daylong.baselibrary.view.textview.MyTextView;
import net.daylong.daylongbase.R;

public class BaseTitleView extends ConstraintLayoutView {
    private MyTextView myTextView;
    private MyImageBtn myImageBtn;
    private BaseActivity activity;

    public BaseTitleView(@NonNull Context context) {
        this(context, null);
    }

    public BaseTitleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseTitleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayoutParams(new ConstraintBuilder().mm().height(30).leftTop().buildPayoutParams());
        myImageBtn = MyImageBtn.create(this, new ConstraintBuilder(12).leftMargin(8).leftCenterV());
        myTextView = MyTextView.create(this, new ConstraintBuilder().mm().leftTop());
        myTextView.setTextColorReg(R.color.color_333);
        myTextView.setTextSize(11);
        myTextView.setGravity(Gravity.CENTER);
        setId(R.id.base_root_title);
    }

    /**

     *
     * @param activity act

     */
    public void init(int backRegId, BaseActivity activity, Integer strId) {
        myImageBtn.setBackgroundResource(backRegId);
        if (activity != null) {
            myImageBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.finish();
                }
            });
        }
        if (strId != null) {
            myTextView.setText(SystemUtil.getString(strId));
        }
    }

    public void setTitleName(String str) {
        if (str != null) {
            myTextView.setText(str);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (activity != null) {
            activity = null;
        }
    }
}
