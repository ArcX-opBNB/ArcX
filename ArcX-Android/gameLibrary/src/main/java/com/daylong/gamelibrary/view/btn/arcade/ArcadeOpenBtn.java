package com.daylong.gamelibrary.view.btn.arcade;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;

import net.daylong.gamesocket.mrg.WebSocketMrg;

public class ArcadeOpenBtn extends ArcadeBaseView {
    public ArcadeOpenBtn(@NonNull Context context, int regId) {
        super(context);

        setImageResource(regId);

    }


    @Override
    public void sendMsg() {
        WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(getGameOperateType()));

    }


    @Override
    protected GameOperateType getGameOperateType() {
        return GameOperateType.SHOOT;
    }


    @Override
    protected String getBtnName() {

    }
}
