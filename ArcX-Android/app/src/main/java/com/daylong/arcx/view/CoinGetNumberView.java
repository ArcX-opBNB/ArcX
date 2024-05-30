package com.daylong.arcx.view;

import android.content.Context;

import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.view.BaseNumberView;
public class CoinGetNumberView extends BaseNumberView {



    public CoinGetNumberView(Context context) {
        super(context);
    }

    @Override
    public String getKeyPrefix() {
        return "img_combo_num_";
    }

    @Override
    protected CanvasImageBean getImageNum() {
        return new CanvasImageBean(14, 18);
    }

    @Override
    protected CanvasImageBean getImageDot() {
        return new CanvasImageBean(5, 18);
    }
}
