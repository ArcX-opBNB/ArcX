package net.daylong.baselibrary.view.btn;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;


public class MyImgBtn extends androidx.appcompat.widget.AppCompatImageButton implements View.OnTouchListener {


    public static MyImgBtn create(ViewGroup viewGroup, ConstraintBuilder builder, Integer position, Integer regId, OnImageClickListener onImageClickListener) {


        MyImgBtn myImageView = new MyImgBtn(viewGroup.getContext(), regId, onImageClickListener);
        myImageView.setLayoutParams(builder.buildPayoutParams());
        if (position != null) {
            viewGroup.addView(myImageView, position);
        } else {
            viewGroup.addView(myImageView);
        }
        return myImageView;

    }

    public static MyImgBtn create(ViewGroup viewGroup, ConstraintBuilder builder, Integer regId, OnImageClickListener onImageClickListener) {
        return create(viewGroup, builder, null, regId, onImageClickListener);

    }

    public MyImgBtn(@NonNull Context context, int ImageReg, OnImageClickListener onImageClickListener) {
        super(context);
        this.onImageClickListener = onImageClickListener;
        setOnTouchListener(this);
        setImageResource(ImageReg);
        setBackgroundColor(Color.TRANSPARENT);
    }
    private long clickTime;
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (onImageClickListener == null) {
            return false;
        }
        Drawable buttonBackground = getDrawable(); 

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                buttonBackground .setColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_ATOP); 
                setImageDrawable(buttonBackground);
                break;

            
            case MotionEvent.ACTION_UP:
                
            case MotionEvent.ACTION_CANCEL:
                
                long curTime = System.currentTimeMillis();

                if (curTime - clickTime < 1000) {
                    return false;
                }
                clickTime = curTime;

                buttonBackground.clearColorFilter(); 
                setImageDrawable(buttonBackground);
                onImageClickListener.onClick(this);
                break;
        }
        return true;
    }


    private OnImageClickListener onImageClickListener;

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    public interface OnImageClickListener {


        void onClick(View view);


    }

}
