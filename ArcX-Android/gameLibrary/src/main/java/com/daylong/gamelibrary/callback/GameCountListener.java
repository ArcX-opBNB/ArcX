package com.daylong.gamelibrary.callback;

/**

 */
public interface GameCountListener {

    void onToastTime(int time);

    void onEnd();
    void onTime(int time);
    void onRefreshTime(int time);

}
