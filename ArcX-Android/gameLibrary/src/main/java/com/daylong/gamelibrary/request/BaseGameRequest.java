package com.daylong.gamelibrary.request;

import com.daylong.basecache.GameCache;
import com.daylong.gamelibrary.bean.prarm.BaseGameRequestParam;
import com.daylong.gamelibrary.meuns.GameOperateType;

import net.daylong.gamesocket.request.base.BaseMsg;

public abstract class BaseGameRequest extends BaseMsg<BaseGameRequestParam> {
    public BaseGameRequest(int cmd) {
        super(cmd, new BaseGameRequestParam());
    }

    public BaseGameRequest(int cmd, GameOperateType gameOperateType) {
        super(cmd, new BaseGameRequestParam(GameCache.getGameRoomId(), gameOperateType.getCode()));
    }


    @Override
    public String getCmdMsg() {

        Integer gameMultiplier = GameCache.getGameMultiplier();
        if (gameMultiplier > 0) {
            getParam().setGdMul(gameMultiplier);
        } else {
            getParam().setGdMul(null);
        }
        return super.getCmdMsg();
    }
}
