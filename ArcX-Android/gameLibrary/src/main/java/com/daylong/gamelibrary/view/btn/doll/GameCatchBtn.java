package com.daylong.gamelibrary.view.btn.doll;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.view.btn.service.IGameOperateBtnView;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.textview.MyTextView;

public class GameCatchBtn extends IGameOperateBtnView {
    public GameCatchBtn(@NonNull Context context,int regId) {
        super(context);
        setImageResource(regId);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected GameOperateType getGameOperateType() {
        return GameOperateType.CATCH;
    }


}
