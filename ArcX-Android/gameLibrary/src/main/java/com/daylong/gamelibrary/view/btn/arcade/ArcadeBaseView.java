package com.daylong.gamelibrary.view.btn.arcade;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.view.btn.service.IGameOperateBtnView;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.ToastUtil;

public abstract class ArcadeBaseView extends IGameOperateBtnView implements View.OnTouchListener {

    public ArcadeBaseView(@NonNull Context context) {
        super(context);
    }

    private static final long AUTO_TIME = 3000; 


    protected  abstract  String getBtnName();

    private Action action = Action.NONE; //


    protected int autoPushCoinTime() {
        return 333;
    }

    ;

    protected int downPushCoinTime() {
        return 333;
    }

    ; 


    private long pushCoinTime;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            long c = currentTimeMillis - pushCoinTime;



            if (c >= autoPushCoinTime()) {
                sendMsg();
                pushCoinTime = currentTimeMillis;
            } else {


            }

            AppUtil.getMainHandler().postDelayed(runnable, getPushCoinTime());

        }
    };


    /**

     *
     * @return
     */
    private int getPushCoinTime() {
        return action == Action.NONE ? downPushCoinTime() : autoPushCoinTime();
    }


    private long downTime;

    @Override
    protected void initListener() {


        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {


        int action = event.getAction();
        MyLogUtil.e(TAG, "action->" + action);

        Drawable buttonBackground = getDrawable(); 

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downTime = System.currentTimeMillis();
                
                AppUtil.getMainHandler().removeCallbacks(runnable, null);
                AppUtil.getMainHandler().postDelayed(runnable, 0);

                buttonBackground.setColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_ATOP); 
                setImageDrawable(buttonBackground);
                break;
            
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                

                if (this.action == Action.NONE) {
                    long difference = System.currentTimeMillis() - downTime;
                    


                    if (difference >= AUTO_TIME) {
                        
                        
                        this.action = Action.AUTO;


                        return true;
                    }
                } else if (this.action == Action.AUTO) {




                }

                this.action = Action.NONE;
                AppUtil.getMainHandler().removeCallbacks(runnable, null);
                buttonBackground.clearColorFilter(); 
                setImageDrawable(buttonBackground);

                break;
        }


        return true;
    }

    //
    public enum Action {
        NONE, 
        AUTO; 
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AppUtil.getMainHandler().removeCallbacks(runnable, null);
    }
}
