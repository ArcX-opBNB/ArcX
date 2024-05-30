package com.daylong.gamelibrary.callback;

import android.view.MotionEvent;
import android.view.View;

public class OnClickTouchListener implements View.OnTouchListener {

    private OnClickListener onClickListener;

    public OnClickTouchListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                v.setAlpha(0.8f);
                break;

            
            case MotionEvent.ACTION_UP:
                
            case MotionEvent.ACTION_CANCEL:
                
                v.setAlpha(1.0f);
                if (onClickListener != null) {

                    onClickListener.click(v);
                }
                break;
        }
        return true;
    }


    public interface OnClickListener {
        void click(View view);
    }

}
