package com.daylong.arcx.user.recharge;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.request.PayRequest;
import com.daylong.arcx.R;
import com.daylong.arcx.pay.PayListener;
import com.daylong.arcx.pay.mrg.PayListenerMrg;
import com.daylong.arcx.user.recharge.frt.RechargeListFragment;

import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
import net.daylong.gamesocket.listener.UserBalanceCallBack;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.user.BalanceRequest;
import net.daylong.gamesocket.strategy.response.WebSocketUserStrategy;

public class RechargeActivity extends BaseActivity implements UserBalanceCallBack, PayListener {


    @Override
    protected boolean isAddBaseTitle() {
        return true;
    }

    @Override
    protected Integer getTitleName() {
        return R.string.recharge;
    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);

        initTitle();
        initContent();
        WebSocketUserStrategy.getInstance().register(this);
        WebSocketUserStrategy.getInstance().setActivity(this);
        PayListenerMrg.getInstance().addListeners(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        WebSocketMrg.getInstance().sendMsg(new BalanceRequest());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        WebSocketUserStrategy.getInstance().setActivity(null);
        WebSocketUserStrategy.getInstance().remover(this);
        PayListenerMrg.getInstance().removerListeners(this);
    }

    private ConstraintLayout titleLayout;
    private MyTextView myCoin;

    private void initTitle() {

        titleLayout = new ConstraintBuilder(171, 40).topToBottom(baseTitleView.getId()).centerH().build(this);
        titleLayout.setId(View.generateViewId());
        titleLayout.setBackgroundResource(R.drawable.shape_r_14_bg_w);

        MyImageView.create(titleLayout, new ConstraintBuilder(19).leftCenterV().leftMargin(8), R.drawable.img_coin);

        MyTextView myTextView = MyTextView.create(titleLayout, new ConstraintBuilder().ww().leftCenterV().leftMargin(31));



        myCoin = MyTextView.create(titleLayout, new ConstraintBuilder().ww().rightCenterV().rightMargin(8));



        addView(titleLayout);

    }

    private void initContent() {


        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(Color.WHITE);
        frameLayout.setId(View.generateViewId());
        frameLayout.setLayoutParams(new ConstraintBuilder(0, 0).topToBottom(titleLayout).centerH().bottom().topMargin(8).buildPayoutParams());
        addView(frameLayout);

        addFragment(new RechargeListFragment(), frameLayout.getId());

    }

    @Override
    public void userBalance(long goldNum,long  integralNum) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (myCoin != null) {
                    myCoin.setTextNumDot(goldNum);
                }
            }
        });
    }

    @Override
    public void userEnergy(int cnAmt, int ttAmt, int cgAmt, int lfTm) {

    }


    @Override
    public void onPaySuc(int payType, String odNo, PayRequest payRequest) {


    }

    @Override
    public void onPayFail() {

    }
}