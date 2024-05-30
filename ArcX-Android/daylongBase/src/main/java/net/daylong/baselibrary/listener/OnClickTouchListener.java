package net.daylong.baselibrary.listener;

import android.view.MotionEvent;
import android.view.View;

public class OnClickTouchListener implements View.OnTouchListener {

    private OnClickListener onClickListener;
    private int onClickTime = 1000;

    public OnClickTouchListener(OnClickListener onClickListener, int onClickTime) {
        this.onClickListener = onClickListener;
        this.onClickTime = onClickTime;
    }

    public OnClickTouchListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    private Long curTime = 0L;

    private boolean isClick;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                long nextTime = System.currentTimeMillis();
                isClick = nextTime - curTime > onClickTime;
                if (isClick) {
                    curTime = nextTime;
                    v.setAlpha(0.8f);
                }
                break;

            
            case MotionEvent.ACTION_UP:
                
            case MotionEvent.ACTION_CANCEL:
                
                if (isClick) {
                    v.setAlpha(1.0f);
                    if (onClickListener != null) {
                        onClickListener.click(v);
                    }
                }
                break;
        }
        return true;
    }


    public interface OnClickListener {
        void click(View view);
    }

}
