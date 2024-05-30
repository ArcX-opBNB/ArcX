package net.daylong.baselibrary.view.btn;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;


public class MyBtn extends BaseButton implements View.OnTouchListener {


    public static MyBtn create(ViewGroup viewGroup, ConstraintBuilder builder, Integer position, Integer regId, OnImageClickListener onImageClickListener) {


        MyBtn myImageView = new MyBtn(viewGroup.getContext(), regId, onImageClickListener);
        myImageView.setLayoutParams(builder.buildPayoutParams());
        if (position != null) {
            viewGroup.addView(myImageView, position);
        } else {
            viewGroup.addView(myImageView);
        }
        return myImageView;

    }

    public static MyBtn create(ViewGroup viewGroup, ConstraintBuilder builder, Integer regId, OnImageClickListener onImageClickListener) {
        return create(viewGroup, builder, null, regId, onImageClickListener);

    }

    public MyBtn(@NonNull Context context, Integer ImageReg, OnImageClickListener onImageClickListener) {
        super(context);

        setId(View.generateViewId());
        setOnTouchListener(this);
        if (ImageReg != null) {
            setBackgroundResource(ImageReg);
        }
        if (onImageClickListener != null) {
            this.onImageClickListener = onImageClickListener;
        }

    }

    public MyBtn(@NonNull Context context) {
        this(context, null, null);

    }

    public MyBtn(@NonNull Context context, Integer imageReg) {
        this(context, imageReg, null);

    }

    private long clickTime;

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (onImageClickListener == null) {
            return false;
        }
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
                onClick();
                break;
        }
        return true;
    }


    protected void onClick() {
        if (onImageClickListener != null) {
            onImageClickListener.onClick(this);
        }
    }

    private OnImageClickListener onImageClickListener;

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    public interface OnImageClickListener {


        void onClick(View view);


    }

    /**

     */
    public void setFakeBold() {
        getPaint().setFakeBoldText(true);
    }


}
