package com.daylong.gamelibrary.callback;

import android.view.MotionEvent;
import android.view.View;

import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.gamelibrary.meuns.GameType;
import com.daylong.musiclibrary.emums.SoundPoolType;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;

public class PushCoinListener implements View.OnTouchListener {

    private static final long AUTO_TIME = 3000; 


    private Action action = Action.NONE; //


    private int autoPushCoinTime;
    private int downPushCoinTime;


    private DnPlayView dnPlayView;
    private BaseGameActivity activity;

    /**
     * @param autoPushCoinTime 
     * @param downPushCoinTime 
     */
    public PushCoinListener(DnPlayView dnPlayView, BaseGameActivity activity, OnTouchPushCoinListener onTouchPushCoinListener, int autoPushCoinTime, int downPushCoinTime) {
        this.activity = activity;
        this.onTouchPushCoinListener = onTouchPushCoinListener;
        this.dnPlayView = dnPlayView;
        this.autoPushCoinTime = autoPushCoinTime;
        this.downPushCoinTime = downPushCoinTime;
    }

    private long pushCoinTime;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            long c = currentTimeMillis - pushCoinTime;



            if (c >= autoPushCoinTime) {

                if (action == Action.NONE) {
                    SoundPoolType.PUSH_COIN.play();
                }
                onTouchPushCoinListener.onPushCoin();
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
        return action == Action.NONE ? downPushCoinTime : autoPushCoinTime;
    }


    private long downTime;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (AppUtil.isHorizontal() || !activity.isMyStart() || activity.getGameType() != GameType.PUSH_COIN_MACHINE) {

            return false;
        }
        int action = event.getAction();
        MyLogUtil.e(TAG, "action->" + action);


        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downTime = System.currentTimeMillis();
                
                AppUtil.getMainHandler().removeCallbacks(runnable, null);
                AppUtil.getMainHandler().postDelayed(runnable, 0);


                float x = event.getX();
                float y = event.getY();
                if (onTouchPushCoinListener != null) {
                    onTouchPushCoinListener.onDown(x, y, this.action);
                }
                if (this.action == Action.NONE) {
                    
//                    dnPlayView.getAutoView().showAutoAnim(x, y);
                }
                break;
            
            case MotionEvent.ACTION_UP:
                
            case MotionEvent.ACTION_CANCEL:
                
//                dnPlayView.getAutoView().hintAuto();


                if (this.action == Action.NONE) {
                    long difference = System.currentTimeMillis() - downTime;
                    


                    if (difference >= AUTO_TIME) {
                        
                        
                        this.action = Action.AUTO;
                        if (onTouchPushCoinListener != null) {
                            onTouchPushCoinListener.onStartAuto();
                        }
//                        dnPlayView.getAutoView().showAutoToast();
//                        WebSocketMrg.getInstance().sendMsg(StartGameRequest.getInstance().setOperateState(OperateState.AUTO_PUSH_COIN));
                        //AppUtil.getMainHandler().removeCallbacks(runnable, null);
                        return false;
                    }
                } else if (this.action == Action.AUTO) {
//                    SoundPoolType.GAME_AUTO_STOP.play();
//                    dnPlayView.getAutoView().showAutoStopToast();
//                    WebSocketMrg.getInstance().sendMsg(StartGameRequest.getInstance().setOperateState(OperateState.CANCEL_AUTO_PUSH_COIN));
                    if (onTouchPushCoinListener != null) {
                        onTouchPushCoinListener.onCloseAuto();
                    }
                }

                this.action = Action.NONE;
                AppUtil.getMainHandler().removeCallbacks(runnable, null);


                break;
        }


        return false;
    }


    
    public void close() {
        activity = null;
        AppUtil.getMainHandler().removeCallbacks(runnable, null);
    }

    //
    public enum Action {
        NONE, 
        AUTO; 
    }

    private OnTouchPushCoinListener onTouchPushCoinListener;

    public void setOnTouchPushCoinListener(OnTouchPushCoinListener onTouchPushCoinListener) {
        this.onTouchPushCoinListener = onTouchPushCoinListener;
    }

    /**

     */
    public interface OnTouchPushCoinListener {

        void onDown(float x, float y, Action action);

        void onStartAuto();

        void onCloseAuto();

        void onPushCoin();

    }
}
