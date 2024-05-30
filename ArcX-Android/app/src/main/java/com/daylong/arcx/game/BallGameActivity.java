package com.daylong.arcx.game;

import android.view.View;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.doll.DollReturnDialog;
import com.daylong.arcx.view.game.PushCoinGameTitle;
import com.daylong.arcx.view.game.btn.start.DollStartGame;
import com.daylong.gamelibrary.act.IPushCoinGameActivity;
import com.daylong.gamelibrary.callback.OnGameDollCallBack;
import com.daylong.gamelibrary.meuns.GameCmdType;
import com.daylong.gamelibrary.meuns.GameType;
import com.daylong.gamelibrary.strategy.DollGameStrategy;
import com.daylong.gamelibrary.view.btn.ICharterPushCoinBtn;
import com.daylong.gamelibrary.view.btn.ball.BallController;
import com.daylong.gamelibrary.view.btn.doll.DollGameOperateView;
import com.daylong.gamelibrary.view.btn.ball.GameDownBallBtn;
import com.daylong.gamelibrary.view.btn.service.IGameOperateView;
import com.daylong.gamelibrary.view.btn.service.IStartBtn;
import com.daylong.gamelibrary.view.title.BaseGameTitleView;
import com.daylong.httplibrary.bean.AwardBean;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.gamesocket.strategy.response.SocketResponseStrategy;

import java.util.ArrayList;
import java.util.List;

public class BallGameActivity extends IPushCoinGameActivity implements OnGameDollCallBack, BallController.OnCatchDownListener {
    private BallController ballController;


    @Override
    public GameType getGameType() {
        return GameType.BALL_MACHINE;
    }

    @Override
    protected ICharterPushCoinBtn getCharterBtn() {
        return null;
    }

    private DollGameStrategy dollGameStrategy;

    @Override
    protected void initData() {
        super.initData();

        super.initData();
        

        dollGameStrategy = DollGameStrategy.getInstance();
        dollGameStrategy.setActivity(this);
        dollGameStrategy.register(this);

        SocketResponseStrategy.getInstance().registerSocketResponse(dollGameStrategy);

    }

    @Override
    public GameCmdType getGameCmdType() {
        return GameCmdType.GAME_CMD_BALL;
    }

    @Override
    public BaseGameTitleView getBaseGameTitleView() {
        return new PushCoinGameTitle(this);
    }


    @Override
    protected IStartBtn getStartGameBtn() {
        return new DollStartGame(this, gameInfo.getCostNum());
    }

    @Override
    protected IGameOperateView getPushCoinBtn() {

        ballController = new BallController(this);
        ballController.setLayoutParams(new ConstraintBuilder().ww().bottomCenterH().bottomMargin(34).buildPayoutParams());
        ballController.setOnCatchDownListener(this);
        return ballController;
    }

    @Override
    public void catchReturn(boolean isCatch, ArrayList<AwardBean> awardBeans) {
        DollReturnDialog.showDialog(getSupportFragmentManager(), isCatch,awardBeans) ;
    }

    @Override
    public void catchDown() {

    }

    @Override
    public void startGameSuc() {
        super.startGameSuc();

        if (ballController != null) {
            ballController.setDown(false);
        }
    }

    @Override
    public void onEnd() {
        ballController.setEnd();

    }

    @Override
    public void onTime(int time) {
        super.onTime(time);
        ballController.setTime(time);
    }

    @Override
    public void onToastTime(int time) {
        super.onToastTime(time);
    }

    @Override
    public void onCatchDown() {
        if (gameCountdownRunnable != null) {
            gameCountdownRunnable.stop();
        }

        if (tvLastTime != null && tvLastTime.getVisibility() == View.VISIBLE) {
            tvLastTime.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SocketResponseStrategy.getInstance().removerSocketResponse(dollGameStrategy);
        dollGameStrategy.register(this);
        dollGameStrategy.deleteAll();

    }

}
