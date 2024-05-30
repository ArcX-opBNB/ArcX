package com.daylong.gamelibrary.view.btn;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;
import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;

import net.daylong.baselibrary.app.Constant;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.gamesocket.mrg.WebSocketMrg;

/**

 */
public abstract class ICharterFlightButton extends ConstraintLayoutView implements View.OnClickListener {


    /**

     *
     * @return
     */
    protected abstract int getBackReg();

    public ICharterFlightButton(@NonNull Context context) {
        super(context);
        setBackgroundResource(getBackReg());
        setOnClickListener(this);

    }

    protected abstract CharterDescResponse getCharterDescResponse();

    @Override
    public void onClick(View v) {


        
        if (getCharterDescResponse() != null) {
            showCharterDialog();
        }
    }

    public void showCharterDialog() {

    }


    /**

     *
     * @param time
     */
    protected void setCharterTime(int time) {

    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            flightTime--;
            if (flightTime <= 0) {
                
                onCharterEnd();
                WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(GameOperateType.CHARTER_SETTLEMENT));

            } else {

                setCharterTime(flightTime);
                postDelayed(runnable, Constant.COUNTDOWN_1_S);
            }
        }
    };


    protected int flightTime;
    private boolean isChatter;

    /**

     *
     * @param isShow
     */
    public void isShowCharter(boolean isShow) {
        setVisibility(isShow ? View.VISIBLE : View.GONE);

    }


    

    /**

     *
     * @param isChatter
     */
    public void updateStatus(boolean isChatter, int endTime) {
        if (this.isChatter == isChatter) {
            return;
        }
        this.isChatter = isChatter;
        if (isChatter) {
            
            flightTime = endTime;
            onCharterStart(endTime);
            postDelayed(runnable, Constant.COUNTDOWN_1_S);
        } else {
            flightTime = 0;
            removeCallbacks(runnable);

            onCharterEnd();
        }


    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(runnable);
    }

    public boolean isChatter() {
        return flightTime > 0;
    }

    public abstract void onCharterStart(int flightTime);

    public abstract void onCharterEnd();
}
