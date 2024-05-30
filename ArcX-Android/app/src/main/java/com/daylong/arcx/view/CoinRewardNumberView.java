package com.daylong.arcx.view;

import android.content.Context;

import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.view.BaseNumberView;

/**

 */
public class CoinRewardNumberView extends BaseNumberView {


    public CoinRewardNumberView(Context context) {
        super(context);
    }

    @Override
    public String getKeyPrefix() {
        return "img_game_get_num_";
    }

    @Override
    protected CanvasImageBean getImageNum() {
        return new CanvasImageBean(12, 14);
    }

    @Override
    protected CanvasImageBean getImageDot() {
        return new CanvasImageBean(4, 14);
    }
}
