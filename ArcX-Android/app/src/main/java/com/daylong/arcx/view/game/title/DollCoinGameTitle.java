package com.daylong.arcx.view.game.title;

import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.charter.CharterEndToastDialog;
import com.daylong.arcx.dialog.game.GameSettingDialog;
import com.daylong.arcx.view.game.DragonBallListView;
import com.daylong.arcx.view.game.GameEnergyProgressView;
import com.daylong.arcx.view.game.GameUserBalanceView;
import com.daylong.arcx.view.game.GameUserInfoView;
import com.daylong.arcx.view.game.btn.PushCoinCharterBtn;
import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.gamelibrary.bean.GameInfoBean;
import com.daylong.gamelibrary.meuns.GameStatus;
import com.daylong.gamelibrary.request.ExitGameRequest;
import com.daylong.gamelibrary.request.charter.CharterGameInfoRequest;
import com.daylong.gamelibrary.view.title.BaseGameTitleView;
import com.daylong.gamelibrary.view.title.IGameUserView;
import com.daylong.gamelibrary.view.title.IUserGameBalance;
import com.daylong.gamelibrary.view.title.visit.BaseGameVisitView;
import com.daylong.gamelibrary.view.title.visit.IGameVisitView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.SimpleCallback;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.view.button.MyImageBtn;
import net.daylong.gamesocket.mrg.WebSocketMrg;

public class DollCoinGameTitle extends BaseGameTitleView {

    private GameEnergyProgressView gameEnergyProgressView;
    private DragonBallListView dragonBallListView;

    public DollCoinGameTitle(@NonNull BaseGameActivity context, boolean isShowDragonBall) {
        super(context);


        
        if (isShowDragonBall) {
            dragonBallListView = new DragonBallListView(getContext(), userGameBalance, 5);
            addView(dragonBallListView);
        }

        gameEnergyProgressView = new GameEnergyProgressView(getContext(), dragonBallListView != null ? dragonBallListView : userGameBalance);

        addView(gameEnergyProgressView);

    }

    public DollCoinGameTitle(@NonNull BaseGameActivity context) {
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

    @Override
    protected IUserGameBalance getUserBalance() {
        return new GameUserBalanceView(getContext());
    }

    @Override
    protected IGameUserView getGameUserView() {
        return new GameUserInfoView(getContext(), ibtBack);
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
        gameEnergyProgressView.setEnergy(cnAmt, ttAmt, cgAmt, lfTm);
    }
}
