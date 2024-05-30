package com.daylong.arcx.view.home.nav;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.btn.MyImgBtn;
import net.daylong.baselibrary.view.img.BaseSvgaImageView;
import net.daylong.baselibrary.view.img.MyImageView;

public abstract class BaseHomeNav extends ConstraintLayoutView implements View.OnTouchListener {


    /**

     *
     * @return
     */
    protected abstract Integer getBgRegId();

    /**

     *
     * @return
     */
    protected abstract String getSignSvga();

    protected abstract ConstraintBuilder getSignConstraintBuilder();

    protected abstract ConstraintBuilder getViewConstraintBuilder();


    protected View toView;

    public BaseHomeNav(@NonNull Context context, View toView) {
        super(context);
        this.toView = toView;
        setId(View.generateViewId());
        setOnTouchListener(this);


        BaseSvgaImageView svgaImageView = new BaseSvgaImageView(getContext());
        svgaImageView.setLayoutParams(getSignConstraintBuilder().buildPayoutParams());
        svgaImageView.setLoops(-1);
        svgaImageView.startAssets(getSignSvga());
        setLayoutParams(getViewConstraintBuilder().getParams());
        addView(svgaImageView);
        setBackgroundResource(getBgRegId());
    }

    private long clickTime;


    @Override
    public boolean onTouch(View view, MotionEvent event) {

        Drawable buttonBackground = getBackground(); 

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                buttonBackground.setColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_ATOP); 
                setBackgroundDrawable(buttonBackground);
                break;

            
            case MotionEvent.ACTION_UP:
                
            case MotionEvent.ACTION_CANCEL:
                
                long curTime = System.currentTimeMillis();

                buttonBackground.clearColorFilter(); 
                setBackgroundDrawable(buttonBackground);
                if (curTime - clickTime < 1000) {
                    return false;
                }
                clickTime = curTime;
                if (onNavClickListener != null) {
                    onNavClickListener.click();
                } else {
                    click();

                }
                break;
        }
        return true;
    }


    private OnNavClickListener onNavClickListener;

    public void setOnNavClickListener(OnNavClickListener onNavClickListener) {
        this.onNavClickListener = onNavClickListener;
    }

    public interface OnNavClickListener {
        void click();
    }


    protected void click() {
    }
}
