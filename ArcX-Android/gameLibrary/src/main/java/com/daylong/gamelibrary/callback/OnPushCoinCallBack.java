package com.daylong.gamelibrary.callback;

import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.game.dragon.DragonBallRewardBean;
import com.daylong.musiclibrary.bean.DeviceWinningBean;

import java.util.ArrayList;

/**

 */
public interface OnPushCoinCallBack {


    /**

     * @param dragonBallNum
     */
    void onDragonBall(int dragonBallNum, ArrayList<AwardBean> awardBeans);
    void onDragonBallMary(DragonBallRewardBean dragonBallRewardBean);
    void onGameWinning(DeviceWinningBean deviceWinningBean);

}
