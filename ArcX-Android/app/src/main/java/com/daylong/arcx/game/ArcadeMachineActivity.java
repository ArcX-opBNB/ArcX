package com.daylong.arcx.game;

import com.daylong.gamelibrary.act.IArcadeGameActivity;
import com.daylong.gamelibrary.request.charter.CharterGameRequest;
import com.daylong.gamelibrary.view.ArcadePositionLayout;
import com.daylong.gamelibrary.view.btn.ICharterPushCoinBtn;
import com.daylong.gamelibrary.view.btn.arcade.ArcadeOperateView;
import com.daylong.gamelibrary.view.btn.service.IGameOperateView;
import com.daylong.gamelibrary.view.btn.service.IStartBtn;
import com.daylong.gamelibrary.view.title.BaseGameTitleView;
import com.daylong.httplibrary.bean.request.PayRequest;
import com.daylong.arcx.R;
import com.daylong.arcx.dialog.charter.CharterEndReturnDialog;
import com.daylong.arcx.pay.PayListener;
import com.daylong.arcx.pay.mrg.PayListenerMrg;
import com.daylong.arcx.view.game.ArcadeGameTitle;
import com.daylong.arcx.view.game.btn.CharterPushBtn;

import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.user.BalanceRequest;

public class ArcadeMachineActivity extends IArcadeGameActivity implements PayListener {
    @Override
    protected boolean isMute() {
        return true;
    }

    @Override
    public BaseGameTitleView getBaseGameTitleView() {
        return new ArcadeGameTitle(this);
    }

    @Override
    protected ICharterPushCoinBtn getCharterBtn() {
        return new CharterPushBtn(this);
    }
    @Override
    protected IStartBtn getStartGameBtn() {
        return new ArcadePositionLayout(this);
    }

    @Override
    protected IGameOperateView getPushCoinBtn() {
        return new ArcadeOperateView(this, R.drawable.img_mch_arc_left, R.drawable.img_mch_arc_up, R.drawable.img_mch_arc_right, R.drawable.img_mch_arc_down, R.drawable.img_mch_arc_fire, R.drawable.img_mch_arc_plus, R.drawable.img_mch_arc_slots);
    }

    @Override
    public void onChartEndReturn(long charterBalance, long returnNum, long totalNum) {
        super.onChartEndReturn(charterBalance, returnNum, totalNum);
        CharterEndReturnDialog.showDialog(getSupportFragmentManager(), charterBalance, returnNum, totalNum);
    }
    @Override
    protected void initData() {
        super.initData();
        PayListenerMrg.getInstance().addListeners(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PayListenerMrg.getInstance().removerListeners(this);

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
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
