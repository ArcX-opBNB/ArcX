package com.daylong.gamelibrary.view.btn.ball;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.view.btn.service.IGameOperateBtnView;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class GameDownBallBtn extends IGameOperateBtnView {
    public GameDownBallBtn(@NonNull Context context, int regId) {
        super(context);
        setLayoutParams(new ConstraintBuilder(39).center().buildPayoutParams());
        setImageResource(regId);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected GameOperateType getGameOperateType() {
        return GameOperateType.ROCK;
    }


}
