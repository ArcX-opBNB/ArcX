package com.daylong.gamelibrary.view.btn.service;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;

import net.daylong.baselibrary.utils.ui.view.button.MyImageBtn;
import net.daylong.gamesocket.mrg.WebSocketMrg;

public abstract class IGameOperateBtnView extends MyImageBtn {


    protected abstract GameOperateType getGameOperateType();

    public IGameOperateBtnView(@NonNull Context context) {
        super(context);

        initListener();


    }

    protected void initListener() {
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                Drawable buttonBackground = getDrawable(); 

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        buttonBackground.setColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_ATOP); 
                        setImageDrawable(buttonBackground);
                        sendMsg();
                        break;

                    
                    case MotionEvent.ACTION_UP:
                        
                    case MotionEvent.ACTION_CANCEL:
                        
                        buttonBackground.clearColorFilter(); 
                        setImageDrawable(buttonBackground);
                        sendStop();
                        break;
                }
                return true;
            }

        });
    }


    public void sendMsg() {
        WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(getGameOperateType()));
    }

    public void sendStop() {
        WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(GameOperateType.STOP));
    }

    public void setDown(boolean isDown) {
        Drawable buttonBackground = getDrawable(); 

        if (isDown) {
            buttonBackground.setColorFilter(Color.parseColor("#80000000"), PorterDuff.Mode.SRC_ATOP); 
        } else {
            buttonBackground.clearColorFilter(); 
        }
        setEnabled(!isDown);
        setClickable(!isDown);

        setImageDrawable(buttonBackground);
    }

}
