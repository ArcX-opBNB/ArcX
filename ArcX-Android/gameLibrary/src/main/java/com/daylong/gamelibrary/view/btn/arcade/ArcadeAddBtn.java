package com.daylong.gamelibrary.view.btn.arcade;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;

import net.daylong.gamesocket.mrg.WebSocketMrg;

public class ArcadeAddBtn extends ArcadeBaseView {
    public ArcadeAddBtn(@NonNull Context context, int regId) {
        super(context);
        setImageResource(regId);

    }


    @Override
    public void sendMsg() {
        WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(getGameOperateType()));

    }


    @Override
    protected GameOperateType getGameOperateType() {
        return GameOperateType.CHANGE_GUN;
    }

    @Override
    protected String getBtnName() {

    }

    @Override
    protected int autoPushCoinTime() {
        return 500;
    }

    @Override
    protected int downPushCoinTime() {
        return 500;
    }
}
