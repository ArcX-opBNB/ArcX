package com.daylong.gamelibrary.view.btn.service;


import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;

import net.daylong.baselibrary.listener.OnClickTouchListener;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.gamesocket.mrg.WebSocketMrg;

/**

 */
public abstract class IGameOperateView extends ConstraintLayoutView implements OnClickTouchListener.OnClickListener {
    protected abstract GameOperateType getGameOperateType();

    public IGameOperateView(@NonNull Context context) {
        super(context);

        init();
    }

    protected void init() {
        setOnTouchListener(new OnClickTouchListener(this, 333));
    }

    @Override
    public void click(View view) {
        WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(getGameOperateType()));

    }
}
