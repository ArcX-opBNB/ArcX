package net.daylong.baselibrary.listener;

import android.view.View;

public class MyOnclickListener implements View.OnClickListener {
    private OnClickListener onClickListener;
    private int time = 1000;

    public MyOnclickListener(OnClickListener onClickListener, int time) {
        this.onClickListener = onClickListener;
        this.time = time;
    }

    public MyOnclickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onClick(View view) {
        Long tag = (Long) view.getTag();

        long curTime = System.currentTimeMillis();
        if (tag != null && curTime - tag < time) {
            return;
        }
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }





    public interface OnClickListener {

        void onClick(View view);

    }

}
