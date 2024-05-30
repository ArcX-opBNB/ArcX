package net.daylong.gamesocket.strategy.response;

import android.app.Activity;

import net.daylong.gamesocket.listener.UserBalanceCallBack;
import net.daylong.gamesocket.mrg.WebSocketMrg;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WebSocketUserStrategy extends ISocketResponseStrategy {

    private static WebSocketUserStrategy mInstance;


    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public static WebSocketUserStrategy getInstance() {
        if (null == mInstance) {
            synchronized (WebSocketMrg.class) {
                if (mInstance == null) {
                    mInstance = new WebSocketUserStrategy();
                }
            }
        }
        return mInstance;
    }

    private final List<UserBalanceCallBack> webSocketUserBalanceCallBackList;


    public List<UserBalanceCallBack> getWebSocketUserBalanceCallBackList() {
        return webSocketUserBalanceCallBackList;
    }

    public WebSocketUserStrategy() {
        webSocketUserBalanceCallBackList = new ArrayList<UserBalanceCallBack>();

    }

    
    public void register(UserBalanceCallBack callBack) {
        webSocketUserBalanceCallBackList.add(callBack);
    }

    public void remover(UserBalanceCallBack callBack) {
        webSocketUserBalanceCallBackList.removeIf(userBalanceCallBack -> userBalanceCallBack == callBack);
    }

    @Override
    public void addCmd() {
        addCmd(1004); 
        addCmd(1102); 
    }

    @Override
    public void issue(Integer cmd, JSONObject msg) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject serverMsg = msg.optJSONObject("serverMsg");
                    for (UserBalanceCallBack userBalanceCallBack : webSocketUserBalanceCallBackList) {
                        if (cmd.equals(1004)) {
                            
                            int goldNum = serverMsg.optInt("gdAmt", 0);
                            
                            int integralNum = serverMsg.optInt("axcAmt", 0);
                            userBalanceCallBack.userBalance(goldNum, integralNum);

                        } else if (cmd.equals(1102)) {
                            userBalanceCallBack.userEnergy(serverMsg.optInt("cnAmt", 0)
                                    , serverMsg.optInt("ttAmt", 0)
                                    , serverMsg.optInt("cgAmt", 0)
                                    ,serverMsg.optInt("lfTm", 0)
                            );
                        }


                    }
                }
            });
        }

    }

    private Long goldNum; 
    private Long integralNum; 

    public void forCallBack(long goldNum, long integralNum) {

        for (UserBalanceCallBack userBalanceCallBack : webSocketUserBalanceCallBackList) {
            userBalanceCallBack.userBalance(goldNum, integralNum);
        }
    }
}
