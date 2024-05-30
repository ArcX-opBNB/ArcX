package com.daylong.gamelibrary.request.operate;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.request.base.BaseGameOperateRequest;

/**

 */
public class PushCoinRequest extends BaseGameOperateRequest {
    public PushCoinRequest() {
        super(GameOperateType.PUSH_COIN);
    }
}
