package com.daylong.gamelibrary.request.base;

import com.daylong.basecache.GameCache;
import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.request.BaseGameRequest;

public class BaseGameOperateRequest extends BaseGameRequest {
    public BaseGameOperateRequest(GameOperateType gameOperateType) {
        super(GameCache.getGameCmd(), gameOperateType);
    }
}
