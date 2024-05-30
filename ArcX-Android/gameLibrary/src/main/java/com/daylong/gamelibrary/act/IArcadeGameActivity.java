package com.daylong.gamelibrary.act;

import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.ViewGroup;

import com.daylong.gamelibrary.bean.GameInfoBean;
import com.daylong.gamelibrary.meuns.GameCmdType;
import com.daylong.gamelibrary.meuns.GameStatus;
import com.daylong.gamelibrary.meuns.GameType;
import com.daylong.gamelibrary.view.btn.service.IGameOperateView;
import com.daylong.gamelibrary.view.btn.service.IStartBtn;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

public abstract class IArcadeGameActivity extends BaseGameActivity {
    @Override
    public int getMyRequestedOrientation() {
        return ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
    }

    @Override
    public GameType getGameType() {

        return GameType.DOLL_MACHINE;
    }

    
    protected IStartBtn startBtn;
    /**

     */
    protected IGameOperateView pushCoinBtn;

    @Override
    public GameCmdType getGameCmdType() {
        return GameCmdType.GAME_CMD_BALL;
    }


    protected abstract IStartBtn getStartGameBtn();

    protected abstract IGameOperateView getPushCoinBtn();



    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);
        startBtn = getStartGameBtn();
        addView(startBtn);
    }

    private UserInfoResponse curGamingUserMsg;


    @Override
    public void gameInfo(GameInfoBean gameInfoBean) {
        super.gameInfo(gameInfoBean);

        startBtn.setData(gameInfoBean);

        
        if (gameStatus == GameStatus.FREE) {
            
            if (curGamingUserMsg != null) {
                curGamingUserMsg = null;
            }

            if (pushCoinBtn != null && pushCoinBtn.getVisibility() != View.GONE) {
                pushCoinBtn.setVisibility(View.GONE);
            }

        } else {
            if (gameStatus == GameStatus.GAME) {
                
                if (curGamingUserMsg != null && curGamingUserMsg.getUserId() == curGamingUserMsg.getUserId()) {
                    return;
                }
                if (pushCoinBtn == null) {
                    pushCoinBtn = getPushCoinBtn();
                    addView(pushCoinBtn);
                }

                if (pushCoinBtn.getVisibility() != View.VISIBLE) {
                    pushCoinBtn.setVisibility(View.VISIBLE);
                }
            }
        }
        curGamingUserMsg = gameInfoBean.getGamingUserMsg();

    }

    @Override
    public void startGameSuc() {
        super.startGameSuc();

    }

    @Override
    public void onCoinReturn(long coin) {
        super.onCoinReturn(coin);


    }
}
