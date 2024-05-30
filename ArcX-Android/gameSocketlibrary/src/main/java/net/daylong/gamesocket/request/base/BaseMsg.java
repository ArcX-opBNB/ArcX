package net.daylong.gamesocket.request.base;


import net.daylong.gamesocket.cache.WebSocketCache;
import net.daylong.gamesocket.utls.SocketJsonUtil;

public class BaseMsg<T extends BaseParam> {

    private int cmd;
    private String accessToken;
    private T param;

    public BaseMsg(int cmd , T param) {
        this.cmd = cmd;
        this.accessToken = WebSocketCache.getInstance().getAccessToken();
        this.param = param;

    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public int getCmd() {
        return cmd;
    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }


    /**

     *
     * @return
     */
    public String getCmdMsg() {
         return SocketJsonUtil.toJson(this);
    }
}
