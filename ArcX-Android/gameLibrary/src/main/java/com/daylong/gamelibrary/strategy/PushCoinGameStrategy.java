package com.daylong.gamelibrary.strategy;

import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.gamelibrary.callback.OnGameDollCallBack;
import com.daylong.gamelibrary.callback.OnGameWebSocketCallBack;
import com.daylong.gamelibrary.callback.OnPushCoinCallBack;
import com.daylong.gamelibrary.meuns.GameCmdType;
import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.game.dragon.DragonBallRewardBean;
import com.daylong.musiclibrary.bean.DeviceWinningBean;

import net.daylong.baselibrary.utils.JsonUtil;
import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.strategy.response.ISocketResponseStrategy;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**

 */
public class PushCoinGameStrategy extends ISocketResponseStrategy {


    private BaseGameActivity activity;
    private static PushCoinGameStrategy mInstance;
    private final List<OnPushCoinCallBack> onGameWebSocketCallBacks;

    public PushCoinGameStrategy(List<OnPushCoinCallBack> onGameWebSocketCallBacks) {
        this.onGameWebSocketCallBacks = onGameWebSocketCallBacks;
    }

    public void setActivity(BaseGameActivity activity) {
        this.activity = activity;
    }

    public BaseGameActivity getActivity() {
        return activity;
    }

    public static PushCoinGameStrategy getInstance() {
        if (null == mInstance) {
            synchronized (WebSocketMrg.class) {
                if (mInstance == null) {
                    mInstance = new PushCoinGameStrategy();
                }
            }
        }
        return mInstance;
    }


    public void deleteAll() {
        removerOnPushCoinCallBack();
        removerGameWebSocketCallBacksAll();
        mInstance = null;
    }


    public void removerOnPushCoinCallBack() {
        
        onGameWebSocketCallBacks.clear();

    }


    public PushCoinGameStrategy() {
        onGameWebSocketCallBacks = new ArrayList<OnPushCoinCallBack>();

    }

    
    public void register(OnPushCoinCallBack callBack) {
        onGameWebSocketCallBacks.add(callBack);
    }

    public void remover(OnPushCoinCallBack callBack) {
        onGameWebSocketCallBacks.removeIf(userBalanceCallBack -> userBalanceCallBack == callBack);
    }

    public void removerGameWebSocketCallBacksAll() {
        onGameWebSocketCallBacks.clear();
    }


    @Override
    public void addCmd() {
        addCmd(GameCmdType.S2C_INNO_WIN_PRIZE.getReturnCdm());
        addCmd(GameCmdType.C2S_INNO_DRAGON_MSG.getReturnCdm());
        addCmd(GameCmdType.S2C_INNO_DRAGON_AWARD_MSG.getReturnCdm());


    }

    @Override
    public void issue(Integer cmd, JSONObject msg) {


        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    JSONObject serverMsg = msg.optJSONObject("serverMsg");

                    if (serverMsg == null) {
                        return;
                    }
                    for (OnPushCoinCallBack onGameWebSocketCallBack : onGameWebSocketCallBacks) {


                        
                        if (cmd.equals(GameCmdType.C2S_INNO_DRAGON_MSG.getReturnCdm())) {
                            onGameWebSocketCallBack.onDragonBall(serverMsg.optInt("dgbAmt"), null);

                            
                        } else if (cmd.equals(GameCmdType.S2C_INNO_DRAGON_AWARD_MSG.getReturnCdm())) {
                            JSONObject dgTnTbln = serverMsg.optJSONObject("dgTnTbln");
                            if (dgTnTbln != null) {
                                onGameWebSocketCallBack.onDragonBallMary(JsonUtil.fromJsonToObject(serverMsg.toString(), DragonBallRewardBean.class));
                            } else {
                                JSONArray awdTbln = serverMsg.optJSONArray("awdTbln");

                                ArrayList<AwardBean> list = new ArrayList<>();

                                if (awdTbln != null && awdTbln.length() > 0) {
                                    for (int i = 0; i < awdTbln.length(); i++) {
                                        JSONObject jsonObject = awdTbln.optJSONObject(i);

                                        int cmdTp = jsonObject.optInt("cmdTp");
                                        long awdAmt = jsonObject.optLong("awdAmt");
                                        String awdPct = jsonObject.optString("awdPct");
                                        list.add(new AwardBean(cmdTp, awdPct, awdAmt));
                                    }
                                }
                                onGameWebSocketCallBack.onDragonBall(serverMsg.optInt("cnbAmt"), list);

                            }

                        } else if (cmd.equals(GameCmdType.S2C_INNO_WIN_PRIZE.getReturnCdm())) {
                            onGameWebSocketCallBack.onGameWinning(JsonUtil.fromJsonToObject(serverMsg.toString(), DeviceWinningBean.class));
                        }
                    }
                }
            });
        }
    }
}
