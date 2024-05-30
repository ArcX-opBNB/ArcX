package net.daylong.gamesocket.request.user;

import net.daylong.gamesocket.emuns.CmdType;
import net.daylong.gamesocket.request.base.BaseMsg;
import net.daylong.gamesocket.request.base.BaseParam;

/**

 */
public class BalanceRequest extends BaseMsg<BaseParam> {
    public BalanceRequest() {
        super(CmdType.C2S_USER_BALANCE.getCmd(),new BaseParam());
    }

}
