package com.daylong.gamelibrary.view.btn.arcade;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;

import net.daylong.gamesocket.mrg.WebSocketMrg;

public class ArcadePushCoinBtn extends ArcadeBaseView {
    public ArcadePushCoinBtn(@NonNull Context context, int regId) {
        super(context);
        setImageResource(regId);

    }



    @Override
    public void sendMsg() {
        WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(getGameOperateType()));

    }

    @Override
    protected String getBtnName() {

    }

    @Override
    protected int autoPushCoinTime() {
        return 3000;
    }

    @Override
    protected int downPushCoinTime() {
        return 3000;
    }

    @Override
    protected GameOperateType getGameOperateType() {
        return GameOperateType.PUSH_COIN;
    }


}
