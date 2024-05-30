package com.daylong.arcx.game;

import com.daylong.arcx.dialog.game.pushcoin.GatherDragonBallRewardDialog;
import com.daylong.arcx.dialog.game.pushcoin.WinDragonBallDialog;
import com.daylong.gamelibrary.act.IPushCoinGameActivity;
import com.daylong.gamelibrary.callback.OnPushCoinCallBack;
import com.daylong.gamelibrary.request.charter.CharterGameRequest;
import com.daylong.gamelibrary.strategy.PushCoinGameStrategy;
import com.daylong.gamelibrary.strategy.WebSocketGameStrategy;
import com.daylong.gamelibrary.view.btn.ICharterPushCoinBtn;
import com.daylong.gamelibrary.view.btn.service.IGameOperateView;
import com.daylong.gamelibrary.view.btn.service.IStartBtn;
import com.daylong.gamelibrary.view.title.BaseGameTitleView;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.game.dragon.DragonBallRewardBean;
import com.daylong.httplibrary.bean.request.PayRequest;
import com.daylong.arcx.dialog.charter.CharterEndReturnDialog;
import com.daylong.arcx.pay.PayListener;
import com.daylong.arcx.pay.mrg.PayListenerMrg;
import com.daylong.arcx.view.game.PushCoinGameTitle;
import com.daylong.arcx.view.game.btn.CharterPushBtn;
import com.daylong.arcx.view.game.btn.PushCoinStartGame;
import com.daylong.musiclibrary.bean.DeviceWinningBean;
import com.daylong.musiclibrary.emums.MediaPlayerType;
import com.daylong.musiclibrary.emums.SoundPoolType;
import com.daylong.musiclibrary.mrg.MediaPlayerMrg;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.utils.JsonUtil;
import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.sys.SystemUtil;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.user.BalanceRequest;
import net.daylong.gamesocket.strategy.response.SocketResponseStrategy;

import java.util.ArrayList;

public class PushCoinGameActivity extends IPushCoinGameActivity implements PayListener, OnPushCoinCallBack {
    private PushCoinGameTitle pushCoinGameTitle;

    @Override
    public BaseGameTitleView getBaseGameTitleView() {
        if (pushCoinGameTitle == null) {
            pushCoinGameTitle = new PushCoinGameTitle(this, true);

        }
        return pushCoinGameTitle;


    }

    private PushCoinGameStrategy instance;


    @Override
    protected void initData() {
        super.initData();
        PayListenerMrg.getInstance().addListeners(this);
        instance = PushCoinGameStrategy.getInstance();
        instance.setActivity(this);
        SocketResponseStrategy.getInstance().registerSocketResponse(instance);
        PushCoinGameStrategy.getInstance().register(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SocketResponseStrategy.getInstance().removerSocketResponse(instance);

        PayListenerMrg.getInstance().removerListeners(this);
        PushCoinGameStrategy.getInstance().deleteAll();

    }

    @Override
    public void onPaySuc(int payType, String odNo, PayRequest payRequest) {

        if (payType == 2) {
            WebSocketMrg.getInstance().sendMsg(new CharterGameRequest(payRequest.getCommodityId()));

        }
        WebSocketMrg.getInstance().sendMsg(new BalanceRequest());

    }

    @Override
    public void onPayFail() {

    }

    @Override
    protected ICharterPushCoinBtn getCharterBtn() {
        return new CharterPushBtn(this);
    }


    @Override
    protected IStartBtn getStartGameBtn() {
        return new PushCoinStartGame(this, gameInfo.getCostNum(), gameInfo.getMulTbln());
    }


    @Override
    protected IGameOperateView getPushCoinBtn() {
        return null;
    }

    @Override
    public void onChartEndReturn(long charterBalance, long returnNum, long totalNum) {
        super.onChartEndReturn(charterBalance, returnNum, totalNum);
        CharterEndReturnDialog.showDialog(getSupportFragmentManager(), charterBalance, returnNum, totalNum);
    }


    private
    WinDragonBallDialog winDragonBallDialog;

    @Override
    public void onDragonBall(int dragonBallNum, ArrayList<AwardBean> awardBeans) {
        if (awardBeans != null && awardBeans.size() > 0) {
            reTime();
            if (winDragonBallDialog == null) {
                winDragonBallDialog = new WinDragonBallDialog(rootView);
            }

            winDragonBallDialog.show(dragonBallNum, awardBeans, pushCoinGameTitle.getDragonBallListView(), pushCoinGameTitle.getAxcIconView());
        }


    }

    @Override
    public void onDragonBallMary(DragonBallRewardBean dragonBallRewardBean) {
        reTime();

        MediaPlayerType.SHOW_BALL_MALI.play();
        pushCoinGameTitle.getDragonBallListView().setNum(0);
        GatherDragonBallRewardDialog.show(dragonBallRewardBean, new BaseDialog.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
    }

    @Override
    public void exitRoom() {
        super.exitRoom();
        PushCoinGameStrategy.getInstance().deleteAll();
    }

    @Override
    public void onGameWinning(DeviceWinningBean data) {



        if (data.isOrdinary()) {

            SoundPoolType.AWARD_NORMAL.play();
            return;
        }


        if (data.getAwardMulti() != null && data.getAwardMulti() > 0) {
            SoundPoolType.getSoundPoolTypeByName(data.getAwardMulti() + "").play();
            return;
        }
        
        if (data.isStart()) {
            if (data.isPay()) {
                SoundPoolType.ALARM_BELL.play();
            }
            Integer productAwardType = data.getProductAwardType();
            if (productAwardType != null) {
                if (productAwardType == MediaPlayerType.GRM.getId()) {
                    Integer finalProductAwardType = productAwardType;
                    AppUtil.getMainHandler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MediaPlayerType.playMusic(finalProductAwardType);

                        }
                    }, 2000);
                } else {

                    
                    if (productAwardType == 1) {
                        productAwardType = Integer.parseInt((gameInfo.getSecondType() + "0000" + productAwardType));
                    }
                    MediaPlayerType.playMusic(productAwardType);

                }

            }
        } else {
            initMusic();
            MediaPlayerMrg.getInstance().play();
        }

    }
}
