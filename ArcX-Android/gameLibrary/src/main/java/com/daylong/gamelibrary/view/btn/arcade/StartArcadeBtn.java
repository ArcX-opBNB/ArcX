package com.daylong.gamelibrary.view.btn.arcade;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.basecache.GameCache;
import com.daylong.gamelibrary.view.btn.service.IStartBtn;
import com.daylong.httplibrary.bean.ArcadePositionBean;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DrawableUtils;

public class StartArcadeBtn extends IStartBtn {
    public StartArcadeBtn(@NonNull Context context) {
        super(context);

        setLayoutParams(new ConstraintBuilder(68, 26).center().buildPayoutParams());
        setBackgroundResource(DrawableUtils.getDrawableByName("img_mch_play"));

    }


    private ArcadePositionBean positionBean;

    public void setData(ArcadePositionBean positionBean) {
        this.positionBean = positionBean;

    }

    @Override
    public void onClick(View view) {
        if (positionBean != null) {
            GameCache.setGameRoomId(positionBean.getProductId());
        }
        super.onClick(view);

    }
}
