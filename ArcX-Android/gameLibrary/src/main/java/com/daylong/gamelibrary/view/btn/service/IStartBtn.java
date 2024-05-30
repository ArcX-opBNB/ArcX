package com.daylong.gamelibrary.view.btn.service;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.bean.GameInfoBean;
import com.daylong.gamelibrary.request.operate.StartGameRequest;

import net.daylong.baselibrary.listener.MyOnclickListener;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.gamesocket.mrg.WebSocketMrg;

public class IStartBtn extends ConstraintLayoutView implements MyOnclickListener.OnClickListener {
    public IStartBtn(@NonNull Context context) {
        super(context);
        setOnClickListener(new MyOnclickListener(this));
    }


    @Override
    public void onClick(View view) {
        WebSocketMrg.getInstance().sendMsg(new StartGameRequest());
    }


    public  void setData(GameInfoBean gameInfoBean ){}

}
