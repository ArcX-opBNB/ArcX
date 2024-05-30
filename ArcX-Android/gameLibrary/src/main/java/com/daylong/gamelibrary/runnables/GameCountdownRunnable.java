package com.daylong.gamelibrary.runnables;


import android.os.Handler;

import com.daylong.gamelibrary.callback.GameCountListener;
import com.daylong.gamelibrary.meuns.GameCmdType;
import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.meuns.GameType;
import com.daylong.gamelibrary.request.BaseGameRequest;
import com.daylong.gamelibrary.request.RefreshTimeRequest;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.base.BaseMsg;

/**

 */
public class GameCountdownRunnable {


    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {

            time--;
            if (time < 0) {
                return;
            }
            
            gameCountListener.onTime(time);


            if (time <= toastTime) {
                if (time == 0) {
                    gameCountListener.onEnd();
                    return;
                } else {
                    gameCountListener.onToastTime(time);
                }
            }
            handler.postDelayed(this, 1000);
        }
    };
    private Handler handler;
    private int time; 
    private GameType gameType; 
    private int toastTime; 
    private GameCountListener gameCountListener; 

    public GameCountdownRunnable(GameType gameType, GameCountListener gameCountListener) {
        this.gameType = gameType;
        this.time = gameType.getGameTime();
        this.toastTime = gameType.getToastTime();
        this.gameCountListener = gameCountListener;
        handler = new Handler();

    }


    
    public void refreshTime() {
        time = gameType.getGameTime();

        gameCountListener.onRefreshTime(time);
        stop();
        handler.postDelayed(runnable, 1000);
        WebSocketMrg.getInstance().sendMsg(new RefreshTimeRequest());
    }

    public void setGameTime(int time) {
        this.time = time;

        gameCountListener.onRefreshTime(time);
        stop();

        handler.postDelayed(runnable, 1000);
    }

    public void start() {
        if (handler == null) {
            return;
        }

        stop();
        time = gameType.getGameTime();
        handler.postDelayed(runnable, 1000);
    }

    public void stop() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void delete() {
        stop();
        handler = null;
    }
}
