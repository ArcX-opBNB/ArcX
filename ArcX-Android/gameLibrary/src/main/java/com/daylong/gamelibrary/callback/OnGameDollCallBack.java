package com.daylong.gamelibrary.callback;

import com.daylong.httplibrary.bean.AwardBean;

import java.util.ArrayList;
import java.util.List;

public interface OnGameDollCallBack {


    /**

     *


     *
     */
    void catchReturn(boolean isCatch, ArrayList<AwardBean> awardBeans);

    void catchDown();

}
