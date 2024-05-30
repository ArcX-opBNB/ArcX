package net.daylong.baselibrary.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import androidx.constraintlayout.widget.ConstraintLayout;

import net.daylong.baselibrary.utils.sys.AppUtil;

public class KeyboardPatch {
    private Activity activity;
    private View decorView;
    private View contentView;
    private float setInitBottomMargin;
    private float showBottomMargin = 30;

    public void setShowBottomMargin(float showBottomMargin) {
        this.showBottomMargin = showBottomMargin;
    }

    public void setSetInitBottomMargin(float setInitBottomMargin) {
        this.setInitBottomMargin = setInitBottomMargin;
    }

    public KeyboardPatch(Activity act, View contentView) {
        this.activity = act;
        this.decorView = act.getWindow().getDecorView();
        this.contentView = contentView;
    }


    public void enable() {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void disable() {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        decorView.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            Rect r = new Rect();
            decorView.getWindowVisibleDisplayFrame(r);
            int height = decorView.getContext().getResources().getDisplayMetrics().heightPixels;
            int diff = height - r.bottom;
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) contentView.getLayoutParams();

            MyLogUtil.e("rag-->" + diff);
            MyLogUtil.e("rag-->" + r.toString());

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (diff > 0) {
                        if (layoutParams.bottomMargin <= 0) {
                            layoutParams.bottomMargin = diff + AppUtil.getSize(showBottomMargin);
                            contentView.setLayoutParams(layoutParams);
                            MyLogUtil.e("rag-->bottomMargin:" + (diff));

                        }
                    } else {
                        if (layoutParams.bottomMargin != 0) {
                            layoutParams.bottomMargin = AppUtil.getSize(setInitBottomMargin);
                            contentView.setLayoutParams(layoutParams);
                            MyLogUtil.e("rag-->bottomMargin--0");


                        }
                    }
                }
            });

        }
    };
}
