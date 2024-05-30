package com.daylong.gamelibrary.view.btn;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.view.btn.service.IGameOperateBtnView;

public class BaseGameTopBtn extends IGameOperateBtnView {
    public BaseGameTopBtn(@NonNull Context context) {
        super(context);
    }

    @Override
    protected GameOperateType getGameOperateType() {
        return GameOperateType.FORWARD;
    }
}
