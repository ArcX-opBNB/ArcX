package com.daylong.gamelibrary.request.charter;

import com.daylong.gamelibrary.bean.prarm.CharterRequestParam;
import com.daylong.gamelibrary.meuns.GameCmdType;

import net.daylong.gamesocket.request.base.BaseMsg;
/**

 */
public class CharterGameRequest extends BaseMsg<CharterRequestParam> {
    public CharterGameRequest(int commodityId ) {
        super(GameCmdType.C2S_CHARTER.getCdm(), new CharterRequestParam(commodityId));
    }
}
