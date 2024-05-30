package com.daylong.arcx.view.game;

import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.dialog.game.pushcoin.GatherDragonBallRewardDialog;
import com.daylong.arcx.dialog.game.pushcoin.WinDragonBallDialog;
import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.gamelibrary.bean.GameInfoBean;
import com.daylong.gamelibrary.callback.OnPushCoinCallBack;
import com.daylong.gamelibrary.meuns.GameStatus;
import com.daylong.gamelibrary.request.ExitGameRequest;
import com.daylong.gamelibrary.request.charter.CharterGameInfoRequest;
import com.daylong.gamelibrary.strategy.PushCoinGameStrategy;
import com.daylong.gamelibrary.view.title.BaseGameTitleView;
import com.daylong.gamelibrary.view.title.IGameUserView;
import com.daylong.gamelibrary.view.title.IUserGameBalance;
import com.daylong.gamelibrary.view.title.visit.BaseGameVisitView;
import com.daylong.gamelibrary.view.title.visit.IGameVisitView;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.game.dragon.DragonBallRewardBean;
import com.daylong.musiclibrary.bean.DeviceWinningBean;
import com.daylong.musiclibrary.emums.MediaPlayerType;
import com.daylong.musiclibrary.emums.SoundPoolType;
import com.daylong.musiclibrary.mrg.MediaPlayerMrg;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.SimpleCallback;
import com.daylong.arcx.R;
import com.daylong.arcx.dialog.charter.CharterEndToastDialog;
import com.daylong.arcx.dialog.game.GameSettingDialog;
import com.daylong.arcx.view.game.btn.PushCoinCharterBtn;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.utils.JsonUtil;
import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.view.button.MyImageBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.gamesocket.mrg.WebSocketMrg;

import java.util.ArrayList;

public class PushCoinGameTitle extends BaseGameTitleView implements OnPushCoinCallBack {

    private GameEnergyProgressView gameEnergyProgressView;
    private DragonBallListView dragonBallListView;

    public PushCoinGameTitle(@NonNull BaseGameActivity context, boolean isShowDragonBall) {
        super(context);


        
        if (isShowDragonBall) {
            dragonBallListView = new DragonBallListView(getContext(), userGameBalance, 5);
            dragonBallListView.setVisibility(View.GONE);
            addView(dragonBallListView);
        }

        gameEnergyProgressView = new GameEnergyProgressView(getContext(), dragonBallListView != null ? dragonBallListView : userGameBalance);
        gameEnergyProgressView.setVisibility(View.GONE);
        addView(gameEnergyProgressView);
        PushCoinGameStrategy.getInstance().register(this);
    }


    public DragonBallListView getDragonBallListView() {
        return dragonBallListView;
    }

    public PushCoinGameTitle(@NonNull BaseGameActivity context) {
        this(context, false);

        
    }

    @Override
    protected MyImageBtn getBackBtn() {
        return null;
    }

    @Override
    protected MyImageBtn getSettingBtn() {
        return MyImageBtn.create(this, new ConstraintBuilder(18).topRight(), R.drawable.img_mch_more);
    }

    private GameUserBalanceView gameUserBalanceView;

    @Override
    protected IUserGameBalance getUserBalance() {
        if (gameUserBalanceView == null) {
            gameUserBalanceView = new GameUserBalanceView(getContext());
        }
        return gameUserBalanceView;
    }

    @Override
    protected IGameUserView getGameUserView() {
        return new GameUserInfoView(getContext(), ibtBack);
    }


    public MyImageView getAxcIconView() {
        return gameUserBalanceView.getAxcIconView();

    }

    @Override

    protected IGameVisitView getGameVisitView() {
        return new BaseGameVisitView(getContext(), ibtSetting);
    }

    @Override
    public void userBalance(long goldNum, long integralNum) {
        userGameBalance.updateBalance(goldNum, integralNum);
    }

    protected PushCoinCharterBtn ICharterFlightButton;

    @Override
    public void gameInfo(GameInfoBean gameInfoBean) {
        super.gameInfo(gameInfoBean);


        
        if (gameEnergyProgressView != null) {

            gameEnergyProgressView.setState(gameStatus);
        }
        if (dragonBallListView != null) {
            dragonBallListView.setState(gameStatus);
        }

        
        if (gameStatus == GameStatus.GAME) {

            if (activity.getGameInfo().isShowCharter()) {
                if (ICharterFlightButton == null) {
                    ICharterFlightButton = new PushCoinCharterBtn(activity, ibtBack.getId());
                    addView(ICharterFlightButton);
                }
                
                if (ICharterFlightButton.getVisibility() != View.VISIBLE) {
                    ICharterFlightButton.setVisibility(View.VISIBLE);
                    WebSocketMrg.getInstance().sendMsg(new CharterGameInfoRequest());
                }
            }


        } else {
            if (ICharterFlightButton != null) {
                if (ICharterFlightButton.getVisibility() != View.GONE) {
                    ICharterFlightButton.setVisibility(View.GONE);
                }
            }
        }
    }

    @Override
    public void onRefreshTime() {

    }

    @Override
    public void onCoinReturn(long coin) {

    }

    
    @Override
    public void onChart(long charterBalance, int leftTime, long endTime) {
        super.onChart(charterBalance, leftTime, endTime);
        if (ICharterFlightButton != null) {
            ICharterFlightButton.updateStatus(leftTime > 0, leftTime);
        }
    }

    @Override
    public void onChartEndReturn(long charterBalance, long returnNum, long totalNum) {
        if (ICharterFlightButton != null) {
            ICharterFlightButton.updateStatus(false, 0);
        }
    }

    @Override
    protected void clickSetting(View view) {
        ibtSetting.setImageResource(R.drawable.img_mch_more_on);
        GameSettingDialog.showDialog(activity, view, new SimpleCallback() {
            @Override
            public void onDismiss(BasePopupView popupView) {
                super.onDismiss(popupView);
                ibtSetting.setImageResource(R.drawable.img_mch_more);

            }
        }, PopupPosition.Bottom);
    }

    @Override
    protected void back() {
        if (ICharterFlightButton != null && ICharterFlightButton.isChatter()) {
            
            CharterEndToastDialog.showDialog(activity.getSupportFragmentManager());
        } else {
            WebSocketMrg.getInstance().sendMsg(new ExitGameRequest());
            if (activity != null) {
                activity.exitRoom();
            }
        }
    }

    @Override
    public void onEnergy(int cnAmt, int ttAmt, long cgAmt, int lfTm) {

        
        if (gameEnergyProgressView != null) {
            gameEnergyProgressView.setState(gameStatus);
        }

        gameEnergyProgressView.setEnergy(cnAmt, ttAmt, cgAmt, lfTm);
    }

    
    @Override
    public void onDragonBall(int dragonBallNum, ArrayList<AwardBean> awardBeans) {
//        dragonBallListView.setNum(dragonBallNum);
        if (dragonBallListView != null) {
            dragonBallListView.setState(gameStatus);
        }
        if (awardBeans != null && awardBeans.size() > 0) {
            MediaPlayerType.DRAGON_BALL.play();
//            WinDragonBallDialog.show(awardBeans);
        } else {
            dragonBallListView.setNum(dragonBallNum);

        }
        if (dragonBallListView.getVisibility()!= View.VISIBLE) {
            dragonBallListView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDragonBallMary(DragonBallRewardBean dragonBallRewardBean) {

    }

    @Override
    public void onGameWinning(DeviceWinningBean data) {

    }
}
