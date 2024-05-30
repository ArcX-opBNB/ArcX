package com.daylong.gamelibrary.view.floa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


import com.daylong.basecache.GameCache;

import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.BaseNumberView;
import net.daylong.baselibrary.view.DrawableUtils;

public class ComboNumberView extends BaseNumberView {

    public static ComboNumberView create(ViewGroup viewGroup) {
        ComboNumberView comboView = new ComboNumberView(AppUtil.getContext());

        comboView.setLayoutParams(new ConstraintBuilder(24, 24).rightBottom().rightBottomMargin(11, 30).buildPayoutParams());
        viewGroup.addView(comboView);
        return comboView;
    }

    public ComboNumberView(Context context) {
        super(context);
    }

    @Override
    public String getKeyPrefix() {
        return "img_combo_num_";
    }

    @Override
    protected CanvasImageBean getImageNum() {
        return new CanvasImageBean(11, 14);
    }

    @Override
    protected CanvasImageBean getImageDot() {
        return new CanvasImageBean(3, 14);
    }


    @Override
    protected CanvasImageBean getImageStartsWith() {
        return new CanvasImageBean(53, 24, DrawableUtils.getDrawableByName("img_combo"));
    }


    private int countNum = 0;
    private boolean isAnimEnd = true;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (num < countNum) {
                num++;
                numStr = StringUtils.numFormatDot(num);
                left = 0;
                invalidate();
                if (onAnimNumListener != null) {
                    onAnimNumListener.onComboNum(num);
                }
                postDelayed(this, 100);

            } else {
                isAnimEnd = true;
            }

        }
    };
    private Runnable endTimeRunnable = new Runnable() {
        @Override
        public void run() {
            setVisibility(View.GONE);
            num = 0;
            countNum = 0;
            isAnimEnd = true;
        }
    };

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(endTimeRunnable);
        removeCallbacks(runnable);


    }

    private OnAnimNumListener onAnimNumListener;

    public void setOnAnimNumListener(OnAnimNumListener onAnimNumListener) {
        this.onAnimNumListener = onAnimNumListener;
    }

    public interface OnAnimNumListener {

        void onComboNum(Long num);
    }

    /**

     *
     * @return
     */
    protected long overtimeHint() {
        return 1000 * 10;
    }

    @Override
    public void setNum(Long num) {

        num = num / GameCache.getGameMultiplier();

        if (countNum == 0 || isAnimEnd) {
            if (getVisibility() != View.VISIBLE) {
                setVisibility(View.VISIBLE);
            }
            removeCallbacks(runnable);
            post(runnable);
        }
        countNum += num;
        removeCallbacks(endTimeRunnable);
        postDelayed(endTimeRunnable, overtimeHint());

    }

}
