package net.daylong.gamesocket.request;

import net.daylong.gamesocket.request.base.BaseMsg;
import net.daylong.gamesocket.request.base.BaseParam;

/**

 */
public class DefaultWebSocketRequest extends BaseMsg<BaseParam> {
    public DefaultWebSocketRequest(int cmd) {
        super(cmd,new BaseParam());
    }


}
