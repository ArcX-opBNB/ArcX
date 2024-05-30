package net.daylong.gamesocket.strategy.response;

import net.daylong.gamesocket.SocketLogUtil;
import net.daylong.gamesocket.mrg.WebSocketMrg;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

public class SocketResponseStrategy {

    private static SocketResponseStrategy mInstance;

    /**

     */
    public void registerSocketResponse(ISocketResponseStrategy iSocketResponseStrategy) {
        iSocketResponseStrategySet.add(iSocketResponseStrategy);
    }


    /**

     */
    public void removerSocketResponse(ISocketResponseStrategy iSocketResponseStrategy) {
        iSocketResponseStrategySet.remove(iSocketResponseStrategy);
    }

    public static SocketResponseStrategy getInstance() {
        if (null == mInstance) {
            synchronized (WebSocketMrg.class) {
                if (mInstance == null) {
                    mInstance = new SocketResponseStrategy();
                }
            }
        }
        return mInstance;
    }

    /**

     */
    private final WebSocketDefaultStrategy webSocketDefaultStrategy;
    private final Set<ISocketResponseStrategy> iSocketResponseStrategySet;

    public SocketResponseStrategy() {
        iSocketResponseStrategySet = new HashSet<>();
        webSocketDefaultStrategy = new WebSocketDefaultStrategy();
        WebSocketUserStrategy userStrategy = WebSocketUserStrategy.getInstance();
        iSocketResponseStrategySet.add(userStrategy);
    }


    public WebSocketDefaultStrategy getWebSocketDefaultStrategy() {
        return webSocketDefaultStrategy;
    }


    public void callback(String msg) {
        try {



            JSONObject jsonObject = new JSONObject(msg);
            JSONObject param = jsonObject.optJSONObject("param");
            if (param != null) {
                int cmd = jsonObject.optInt("cmd");
                
                int errorCode = param.optInt("errorCode");
                
                
                if (errorCode != 1) {
                    String errorDesc = param.optString("errorDesc");
                    webSocketDefaultStrategy.responseError(cmd, errorCode, errorDesc);
                    
                } else {

                    
                    if (cmd == 2006) {
                        JSONObject serverMsg = param.optJSONObject("serverMsg");
                        int operateType = serverMsg.optInt("operateType", -1);
                        if (operateType == 9) {
                            long returnNum = serverMsg.optLong("earnNum");
                            webSocketDefaultStrategy.arcadeCoinReturn(returnNum);
                        }
                    }


                    
                    for (ISocketResponseStrategy iSocketResponseStrategy : iSocketResponseStrategySet) {
                        if (iSocketResponseStrategy.isCurrCmd(cmd)) {
                            iSocketResponseStrategy.issue(cmd, param);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
