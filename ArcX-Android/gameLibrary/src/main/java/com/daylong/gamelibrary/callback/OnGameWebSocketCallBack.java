package com.daylong.gamelibrary.callback;

import com.daylong.gamelibrary.bean.GameInfoBean;

public interface OnGameWebSocketCallBack {


    /**

     */
    void startGameSuc();

    /**

     *

     */
    void gameInfo(GameInfoBean gameInfoBean);


    /**

     */
    void onRefreshTime();

    /**

     *
     * @param coin
     */
    void onCoinReturn(long coin);

    /**

     *
     * @param charterBalance
     * @param leftTime
     * @param endTime
     */
    void onChart(long charterBalance, int leftTime, long endTime);

    /**

     *
     * @param charterBalance
     * @param returnNum
     * @param totalNum
     */
    void onChartEndReturn(long charterBalance, long returnNum, long totalNum);




    /**

     *
     * @param cnAmt 
     * @param ttAmt 
     * @param cgAmt 
     * @param lfTm 
     */
    void onEnergy(int cnAmt, int ttAmt,long cgAmt, int lfTm);
}
