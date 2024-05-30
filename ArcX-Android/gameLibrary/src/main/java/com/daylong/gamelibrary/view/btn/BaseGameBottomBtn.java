package com.daylong.gamelibrary.view.btn;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.view.btn.service.IGameOperateBtnView;

public  class BaseGameBottomBtn extends IGameOperateBtnView {
    public BaseGameBottomBtn(@NonNull Context context) {
        super(context);
    }

    @Override
    protected GameOperateType getGameOperateType() {
        return GameOperateType.BACKWARDS;
    }
}
