package com.daylong.gamelibrary.act;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.basecache.GameCache;
import com.daylong.gamelibrary.bean.GameInfoBean;
import com.daylong.gamelibrary.cache.UserCache;
import com.daylong.gamelibrary.callback.GameCountListener;
import com.daylong.gamelibrary.callback.OnGameWebSocketCallBack;
import com.daylong.gamelibrary.callback.PushCoinListener;
import com.daylong.gamelibrary.meuns.GameCmdType;
import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.meuns.GameStatus;
import com.daylong.gamelibrary.meuns.GameType;
import com.daylong.gamelibrary.request.ExitGameRequest;
import com.daylong.gamelibrary.request.GameInfoRequest;
import com.daylong.gamelibrary.request.JoinGameRequest;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;
import com.daylong.gamelibrary.runnables.GameCountdownRunnable;
import com.daylong.gamelibrary.strategy.WebSocketGameStrategy;
import com.daylong.gamelibrary.view.btn.ICharterPushCoinBtn;
import com.daylong.gamelibrary.view.title.BaseGameTitleView;
import com.daylong.httplibrary.bean.response.game.GameInfoResponse;
import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;
import com.daylong.httplibrary.bean.response.game.charter.UserCharterInfoResponse;
import com.daylong.httplibrary.model.contract.game.CharterContract;
import com.daylong.httplibrary.model.model.game.CharterModel;
import com.daylong.httplibrary.model.presenter.game.CharterPresenter;
import com.daylong.musiclibrary.emums.SoundPoolType;
import com.daylong.musiclibrary.mrg.MediaPlayerMrg;
import com.daylong.musiclibrary.mrg.SoundPoolManager;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.img.BaseSvgaImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.strategy.response.SocketResponseStrategy;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseGameActivity extends BaseMvpActivity<CharterPresenter, CharterModel> implements PushCoinListener.OnTouchPushCoinListener, OnGameWebSocketCallBack, GameCountListener, CharterContract.CharterView, BaseSvgaImageView.OnAnimListener {

    private Set<Integer> errorSet = new HashSet<>();

    @Override
    protected boolean isFullScreen() {
        return true;
    }

    public static void start(Context context, Class<?> cla, GameInfoResponse gameInfoResponse) {
        Intent intent = new Intent(context, cla);
        intent.putExtra("gameInfo", gameInfoResponse);
        context.startActivity(intent);
    }


    public abstract BaseGameTitleView getBaseGameTitleView();

    private WebSocketGameStrategy webSocketGameStrategy;

    public abstract GameCmdType getGameCmdType();

    protected GameInfoResponse gameInfo;

    public abstract GameType getGameType();

    @NonNull
    @Override
    protected CharterPresenter initPresenter() {
        return CharterPresenter.newInstance();
    }

    private CharterDescResponse charterDescResponse;

    protected abstract ICharterPushCoinBtn getCharterBtn();

    protected ICharterPushCoinBtn charterBtn;

    @Override
    public void onGameCharterDesc(CharterDescResponse descResponse) {
        this.charterDescResponse = descResponse;

    }

    public CharterDescResponse getCharterDescResponse() {
        return charterDescResponse;
    }

    @Override
    public void onUserCharterInfo(UserCharterInfoResponse charterInfoResponse) {

    }

    protected int getTimeColor() {
        return net.daylong.daylongbase.R.color.color_main;
    }

    protected MyTextView tvLastTime;

    protected boolean isShowLstTime() {
        return true;
    }

    ;

    @Override
    protected void initView(ViewGroup rootView) {
        
        GameCache.setGameCmd(getGameCmdType().getCdm());
        super.initView(rootView);
        addView(getBaseGameTitleView());

        rootView.setBackgroundResource(DrawableUtils.getDrawableByName("shape_game_bg"));
        
        errorSet.add(1030);
        errorSet.add(1020);
        errorSet.add(1010);
        
        errorSet.add(1012);
        
        if (isShowLstTime()) {
            tvLastTime = MyTextView.create(rootView, new ConstraintBuilder().ww().center());
            tvLastTime.initText(75, getTimeColor(), true);
            tvLastTime.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(5), net.daylong.daylongbase.R.color.color_ff004dac);
        }
    }

    public GameCountdownRunnable gameCountdownRunnable;
    public Integer gameLastTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {


            if (gameStatus == GameStatus.GAME) {
                return true;
            }
            exitRoom();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void reTime() {
        gameCountdownRunnable.refreshTime();
    }

    @Override
    protected void initData() {


        webSocketGameStrategy = WebSocketGameStrategy.getInstance();
        webSocketGameStrategy.register(this);
        webSocketGameStrategy.setActivity(this);
        super.initData();
        
        SocketResponseStrategy.getInstance().registerSocketResponse(webSocketGameStrategy);
        gameInfo = (GameInfoResponse) getIntent().getSerializableExtra("gameInfo");


        gameCountdownRunnable = new GameCountdownRunnable(getGameType(), this);

        gameLastTime = GameCache.getGameLastTime();
        if (gameLastTime > 0) {
            gameCountdownRunnable.setGameTime(gameLastTime);
        }
        if (gameInfo != null) {
            GameCache.setGameRoomId(gameInfo.getProductId());
            WebSocketMrg.getInstance().sendMsg(new JoinGameRequest());
            WebSocketMrg.getInstance().sendMsg(new GameInfoRequest());

            if (gameInfo.isShowCharter()) {
                charterBtn = getCharterBtn();
                addView(charterBtn);
                mPresenter.getGameCharterDesc(GameCache.getGameRoomId());
            }
            initMusic();
        }
    }

    protected void initMusic() {

        MediaPlayerMrg.getInstance().init(this, gameInfo.getMusicPrefix(), UserCache.getMusic());
        MediaPlayerMrg.getInstance().initBgMusic(new String[]{"main_bgm"});
        SoundPoolManager.getInstance().setSound(UserCache.getMusic());
    }


    public GameInfoResponse getGameInfo() {
        return gameInfo;
    }


    @Override
    protected void onRestart() {
        super.onRestart();
    }

    protected boolean isMute() {
        return !GameCache.getMusic();
    }



    protected PushCoinListener.OnTouchPushCoinListener getOnTouchPushCoinListener() {
        return null;
    }




    @Override
    protected void onStart() {
        super.onStart();

        if (gameStatus != null && gameStatus != GameStatus.FREE) {
            MediaPlayerMrg.getInstance().play();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        MediaPlayerMrg.getInstance().stop();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }


    @Override
    public void onDown(float x, float y, PushCoinListener.Action action) {

    }

    
    @Override
    public void onStartAuto() {

    }

    
    @Override
    public void onCloseAuto() {


    }

    
    @Override
    public void onPushCoin() {

    }


    private boolean isMyStart;
    private BaseSvgaImageView startSvga;

    @Override
    public void startGameSuc() {
        dismissLoadingDialog();


        gameCountdownRunnable.start();
        MediaPlayerMrg.getInstance().play("start");
        if (tvLastTime != null && tvLastTime.getVisibility() == View.VISIBLE) {
            tvLastTime.setVisibility(View.GONE);
        }


        if (startSvga == null) {
            startSvga = BaseSvgaImageView.create(rootView, new ConstraintBuilder(188, 83).leftCenterV(), 1);
            startSvga.setOnAnimListener(this);
        }


        startSvga.setVisibility(View.VISIBLE);
        startSvga.startAssets("ready_go.svga");


    }


    @Override
    public void onSocketError(int cmd, int code, String desc) {
        if (errorSet.contains(code)) {
            ToastUtil.show(desc);
            dismissLoadingDialog();
        }
    }

    protected GameStatus gameStatus;

    @Override
    public void gameInfo(GameInfoBean gameInfoBean) {
        gameStatus = gameInfoBean.getGameStatus(UserCache.getUserId());


        if (gameStatus != GameStatus.GAME) {
            GameCache.setGameMultiplier(0);
            GameCache.setGameLastTime(0);
        }


        if (gameStatus == GameStatus.FREE) {
            
            MediaPlayerMrg.getInstance().stop();
        } else {
            
            MediaPlayerMrg.getInstance().play();

        }

    }

    public void exitRoom() {

        if (startSvga != null) {
            startSvga.close();
        }

        if (gameCountdownRunnable != null) {
            gameCountdownRunnable.delete();
            gameCountdownRunnable = null;
            if (gameStatus == GameStatus.GAME) {
                WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(GameOperateType.OFF_LINE));
            }
            WebSocketMrg.getInstance().sendMsg(new ExitGameRequest());


            webSocketGameStrategy.setActivity(null);
            webSocketGameStrategy.deleteAll();
            SocketResponseStrategy.getInstance().removerSocketResponse(webSocketGameStrategy);
            webSocketGameStrategy = null;
            GameCache.setGameRoomId(0);
            GameCache.setGameCmd(-1);

            finish();

        }

    }

    @Override
    public void onToastTime(int time) {
        if (tvLastTime != null) {
            if (tvLastTime.getVisibility() != View.VISIBLE) {
                tvLastTime.setVisibility(View.VISIBLE);
                SoundPoolType.GAME_TIMEOUT.play();
            }

            tvLastTime.setText(String.valueOf(time));
        }


    }

    @Override
    public void onEnd() {
        if (tvLastTime != null) {
            tvLastTime.setVisibility(View.GONE);
            SoundPoolType.GAME_TIMEOUT.stop();
        }
        WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(GameOperateType.OFF_LINE));

    }

    @Override
    public void onTime(int time) {

        GameCache.setGameLastTime(time);
    }

    @Override
    public void onRefreshTime(int time) {

    }


    @Override
    public void onRefreshTime() {
        if (gameCountdownRunnable != null) {
            gameCountdownRunnable.refreshTime();
        }

        if (tvLastTime != null && tvLastTime.getVisibility() == View.VISIBLE) {
            tvLastTime.setVisibility(View.GONE);
            SoundPoolType.GAME_TIMEOUT.stop();
        }
    }

    @Override
    public void onCoinReturn(long coin) {
        gameCountdownRunnable.refreshTime();
    }


    public boolean isCharter() {

        return false;
    }

    public boolean isMyStart() {
        return gameStatus != null && gameStatus == GameStatus.GAME;
    }


    @Override
    public void onChart(long charterBalance, int leftTime, long endTime) {

        boolean isCharter = charterBalance == 0 && leftTime == 0 && endTime == 0;


        if (charterBtn != null) {

            charterBtn.setCharterBalance(!isCharter, charterBalance);
        }


    }

    @Override
    public void onChartEndReturn(long charterBalance, long returnNum, long totalNum) {


        if (charterBtn != null) {

            charterBtn.setCharterBalance(false, charterBalance);
        }
    }


    @Override
    public void onEnergy(int cnAmt, int ttAmt, long cgAmt, int lfTm) {

    }


    @Override
    public void end() {
        startSvga.setVisibility(View.GONE);
    }
}
