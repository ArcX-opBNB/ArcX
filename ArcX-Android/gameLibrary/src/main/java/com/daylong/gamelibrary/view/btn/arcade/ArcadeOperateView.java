package com.daylong.gamelibrary.view.btn.arcade;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.view.btn.RemoteControlView;
import com.daylong.gamelibrary.view.btn.service.IGameOperateView;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

/**

 */
public class ArcadeOperateView extends IGameOperateView {


    @Override
    protected GameOperateType getGameOperateType() {
        return null;
    }

    private RemoteControlView remoteControlView;


    public ArcadeOperateView(@NonNull Context context, int leftReg, int topReg, int rightReg, int bottomReg, int openReg, int addReg, int pushCoinReg) {
        super(context);
        remoteControlView = new RemoteControlView(context, leftReg, topReg, rightReg, bottomReg);
        remoteControlView.setLayoutParams(new ConstraintBuilder().ww().leftBottom().buildPayoutParams());
        addView(remoteControlView);
        setLayoutParams(new ConstraintBuilder().mw().leftBottom().leftBottomMargin(23, 25).rightMargin(10).buildPayoutParams());


        ArcadeOpenBtn arcadeOpenBtn = new ArcadeOpenBtn(context, openReg);
        arcadeOpenBtn.setId(View.generateViewId());
        arcadeOpenBtn.setLayoutParams(new ConstraintBuilder(36).bottom().right().rightBottomMargin(24, 4).buildPayoutParams());
        addView(arcadeOpenBtn);


        ArcadeAddBtn arcadeAddBtn = new ArcadeAddBtn(context, addReg);
        arcadeAddBtn.setId(View.generateViewId());
        arcadeAddBtn.setLayoutParams(new ConstraintBuilder(25).bottomToTop(arcadeOpenBtn).right().rightBottomMargin(19, 5).buildPayoutParams());
        addView(arcadeAddBtn);


        ArcadePushCoinBtn arcadePushCoinBtn = new ArcadePushCoinBtn(context, pushCoinReg);
        arcadePushCoinBtn.setId(View.generateViewId());
        arcadePushCoinBtn.setLayoutParams(new ConstraintBuilder(28).bottomToTop(arcadeAddBtn).right().rightBottomMargin(19, 5).buildPayoutParams());
        addView(arcadePushCoinBtn);


    }

    @Override
    protected void init() {

    }


}
