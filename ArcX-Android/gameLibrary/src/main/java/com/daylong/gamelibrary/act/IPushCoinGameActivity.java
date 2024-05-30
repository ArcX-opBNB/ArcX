package com.daylong.gamelibrary.act;

import android.view.View;
import android.view.ViewGroup;

import com.daylong.gamelibrary.bean.GameInfoBean;
import com.daylong.gamelibrary.callback.PushCoinListener;
import com.daylong.gamelibrary.meuns.GameCmdType;
import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.meuns.GameStatus;
import com.daylong.gamelibrary.meuns.GameType;
import com.daylong.gamelibrary.request.BaseGameRequest;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;
import com.daylong.gamelibrary.view.btn.service.IGameOperateView;
import com.daylong.gamelibrary.view.btn.service.IStartBtn;
import com.daylong.gamelibrary.view.floa.FloatingGoldCoinsGroup;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;
import com.daylong.musiclibrary.emums.SoundPoolType;

import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.gamesocket.mrg.WebSocketMrg;

public abstract class IPushCoinGameActivity extends BaseGameActivity {


    @Override
    public GameType getGameType() {

        return GameType.PUSH_COIN_MACHINE;
    }

    protected IStartBtn startBtn;
    protected IGameOperateView pushCoinBtn;

    @Override
    public GameCmdType getGameCmdType() {
        return GameCmdType.GAME_CMD_PUSH;
    }


    protected abstract IStartBtn getStartGameBtn();

    protected abstract IGameOperateView getPushCoinBtn();

    protected FloatingGoldCoinsGroup floatingGoldCoinsGroup;

    public int getFloatingIcon() {
        return DrawableUtils.getDrawableByName("img_coin");
    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);
        floatingGoldCoinsGroup = new FloatingGoldCoinsGroup(rootView, getFloatingIcon());

    }

    private UserInfoResponse curGamingUserMsg;

    @Override
    protected PushCoinListener.OnTouchPushCoinListener getOnTouchPushCoinListener() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void gameInfo(GameInfoBean gameInfoBean) {
        super.gameInfo(gameInfoBean);

        
        if (gameStatus == GameStatus.FREE) {
            
            if (curGamingUserMsg != null) {
                curGamingUserMsg = null;
            }
            if (startBtn == null) {
                startBtn = getStartGameBtn();
                addView(startBtn);
            }
            if (startBtn.getVisibility() != View.VISIBLE) {
                startBtn.setVisibility(View.VISIBLE);
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
                    if (pushCoinBtn != null) {
                        addView(pushCoinBtn);
                    }
                }
                if (pushCoinBtn != null && pushCoinBtn.getVisibility() != View.VISIBLE) {
                    pushCoinBtn.setVisibility(View.VISIBLE);
                }
                if (startBtn != null && startBtn.getVisibility() != View.GONE) {
                    startBtn.setVisibility(View.GONE);
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


        SoundPoolType.GET_COIN.play();
        floatingGoldCoinsGroup.addNum(coin);

    }

    
    @Override
    public void onPushCoin() {
        if (gameStatus != null && gameStatus == GameStatus.GAME) {
            WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(GameOperateType.PUSH_COIN));
        }


    }

    @Override
    public void onStartAuto() {
        if (gameStatus != null && gameStatus == GameStatus.GAME) {

            WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(GameOperateType.AUTO_PUSH_COIN));
            ToastUtil.show("Automatic coin delivery: ON");
        }

    }
    
    @Override
    public void onCloseAuto() {

        if (gameStatus != null && gameStatus == GameStatus.GAME) {
            ToastUtil.show("Automatic coin delivery: OFF");
            WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(GameOperateType.CANCEL_AUTO_PUSH_COIN));

        }
        
    }
}
