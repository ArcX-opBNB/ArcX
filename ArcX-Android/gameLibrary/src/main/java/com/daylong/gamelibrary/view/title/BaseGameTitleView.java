package com.daylong.gamelibrary.view.title;

import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.gamelibrary.bean.GameInfoBean;
import com.daylong.gamelibrary.cache.UserCache;
import com.daylong.gamelibrary.callback.OnGameWebSocketCallBack;
import com.daylong.gamelibrary.meuns.GameCmdType;
import com.daylong.gamelibrary.meuns.GameStatus;
import com.daylong.gamelibrary.meuns.GameType;
import com.daylong.gamelibrary.strategy.WebSocketGameStrategy;
import com.daylong.gamelibrary.view.title.visit.IGameVisitView;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.utils.ui.view.button.MyImageBtn;
import net.daylong.gamesocket.listener.UserBalanceCallBack;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.DefaultWebSocketRequest;
import net.daylong.gamesocket.request.user.BalanceRequest;
import net.daylong.gamesocket.strategy.response.WebSocketUserStrategy;

public abstract class BaseGameTitleView extends ConstraintLayoutView implements OnGameWebSocketCallBack, UserBalanceCallBack {


    protected MyImageBtn ibtBack;
    protected MyImageBtn ibtSetting;
    protected IUserGameBalance userGameBalance;
    protected IGameUserView gameUserView;
    protected IGameVisitView gameVisitView;

    protected abstract MyImageBtn getBackBtn();

    protected abstract MyImageBtn getSettingBtn();

    /**

     *
     * @return
     */
    protected abstract IUserGameBalance getUserBalance();

    /**

     *
     * @return
     */
    protected abstract IGameUserView getGameUserView();

    protected abstract IGameVisitView getGameVisitView();


    protected BaseGameActivity activity;


    public BaseGameTitleView(@NonNull BaseGameActivity context) {
        super(context);
        this.activity = context;
        setLayoutParams(new ConstraintBuilder().mm().wHei().leftTop().topMargin(AppUtil.isHorizontal() ? 15 : 24).leftRightMargin(8).buildPayoutParams());


        ibtBack = getBackBtn();

        if (ibtBack != null) {
            ibtBack.setId(net.daylong.daylongbase.R.id.base_view_1);
            ibtBack.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    back();
                }
            });
        }

        ibtSetting = getSettingBtn();
        ibtSetting.setId(net.daylong.daylongbase.R.id.base_view_3);

        gameUserView = getGameUserView();
        gameUserView.setId(View.generateViewId());
        gameUserView.setId(net.daylong.daylongbase.R.id.base_view_4);
        userGameBalance = getUserBalance();
        if (userGameBalance != null) {
            userGameBalance.setId(net.daylong.daylongbase.R.id.base_view_2);

        }

        ibtSetting.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                clickSetting(view);
            }
        });

        if (userGameBalance != null) {
            addView(userGameBalance);

        }
        addView(gameUserView);
        WebSocketGameStrategy.getInstance().register(this);
        WebSocketUserStrategy.getInstance().register(this);
        WebSocketUserStrategy.getInstance().setActivity(activity);

        WebSocketMrg.getInstance().sendMsg(new BalanceRequest());

        gameVisitView = getGameVisitView();

        addView(gameVisitView);
    }


    @Override
    protected void onDetachedFromWindow() {
        WebSocketGameStrategy.getInstance().remover(this);
        WebSocketUserStrategy.getInstance().remover(this);
        WebSocketUserStrategy.getInstance().setActivity(null);
        activity = null;
        super.onDetachedFromWindow();

    }

    private Runnable getStartGameInfoRunnable = new Runnable() {
        @Override
        public void run() {
            
            if (activity.getGameType() == GameType.PUSH_COIN_MACHINE) {
                WebSocketMrg.getInstance().sendMsg(new DefaultWebSocketRequest(GameCmdType.C2S_INNO_DRAGON_MSG.getCdm()));
            }
            WebSocketMrg.getInstance().sendMsg(new DefaultWebSocketRequest(GameCmdType.C2S_ENERGY_MSG.getCdm()));
        }
    };

    @Override
    public void startGameSuc() {
//        WebSocketMrg.getInstance().sendMsg(new DefaultWebSocketRequest(GameCmdType.C2S_ENERGY_MSG.getCdm()));
//        WebSocketMrg.getInstance().sendMsg(new DefaultWebSocketRequest(GameCmdType.C2S_INNO_DRAGON_MSG.getCdm()));

    }

    protected GameStatus gameStatus;

    @Override
    public void gameInfo(GameInfoBean gameInfoBean) {
        

        
        GameStatus gameStatus = gameInfoBean.getGameStatus(UserCache.getUserId());
        
        if (gameStatus != this.gameStatus) {


            if (gameStatus != GameStatus.OTHER) {

                if (gameStatus == GameStatus.GAME) {





                    postDelayed(getStartGameInfoRunnable, 1000);

                }
                if (userGameBalance != null) {
                    userGameBalance.setVisibility(View.VISIBLE);
                    userGameBalance.setUserInfo(gameInfoBean.getGamingUserMsg());

                }
                if (gameUserView != null) {
                    gameUserView.setVisibility(View.GONE);

                }
            } else {


                if (userGameBalance != null) {
                    userGameBalance.setVisibility(View.GONE);

                }
                if (gameUserView != null) {
                    gameUserView.setVisibility(View.VISIBLE);
                    gameUserView.setGameUserInfo(gameInfoBean.getGamingUserMsg());
                }

            }
            
        }

        if (gameVisitView != null) {
            gameVisitView.setList(gameStatus, gameUserView, userGameBalance, gameInfoBean.getVisitList());
        }
        this.gameStatus = gameStatus;

    }

    @Override
    public void userBalance(long goldNum, long integralNum) {

        if (userGameBalance != null) {
            userGameBalance.updateBalance(goldNum, integralNum);
        }

    }


    @Override
    public void onChart(long charterBalance, int leftTime, long endTime) {

    }

    protected abstract void clickSetting(View view);

    protected abstract void back();


    @Override
    public void onChartEndReturn(long charterBalance, long returnNum, long totalNum) {

    }

    @Override
    public void onEnergy(int cnAmt, int ttAmt, long cgAmt, int lfTm) {

    }

    @Override
    public void userEnergy(int cnAmt, int ttAmt, int cgAmt, int lfTm) {

    }
}
