package com.daylong.arcx.view;

import android.content.Context;

import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.view.BaseNumberView;

public class RechargeNumberView extends BaseNumberView {


    public RechargeNumberView(Context context) {
        super(context);
    }

    @Override
    public String getKeyPrefix() {
        return "img_recharge_num_";
    }

    @Override
    protected CanvasImageBean getImageNum() {
        return new CanvasImageBean(11, 15);
    }

    @Override
    protected CanvasImageBean getImageDot() {
        return new CanvasImageBean(4, 15);
    }


}
