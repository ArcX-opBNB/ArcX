package com.daylong.gamelibrary.view.btn.doll;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.view.btn.RemoteControlView;
import com.daylong.gamelibrary.view.btn.service.IGameOperateView;
import com.daylong.musiclibrary.emums.SoundPoolType;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.textview.MyTextView;

public class DollGameOperateView extends IGameOperateView {


    @Override
    protected GameOperateType getGameOperateType() {
        return null;
    }

    private GameCatchBtn gameCatchBtn;
    private RemoteControlView remoteControlView;
    private MyTextView tvTime;

    public DollGameOperateView(@NonNull Context context, int leftReg, int topReg, int rightReg, int bottomReg, int catchReg) {
        super(context);
        remoteControlView = new RemoteControlView(context, leftReg, topReg, rightReg, bottomReg);
        remoteControlView.setLayoutParams(new ConstraintBuilder().ww().leftTop().buildPayoutParams());
        addView(remoteControlView);
        setLayoutParams(new ConstraintBuilder().mw().leftBottom().leftBottomMargin(10, 26).rightMargin(10).buildPayoutParams());


        gameCatchBtn = new GameCatchBtn(context, catchReg);
        gameCatchBtn.setId(View.generateViewId());
        gameCatchBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onCatchDownListener != null) {
                    onCatchDownListener.onCatchDown();
                }
                gameCatchBtn.sendMsg();
                setDown(true);
            }
        });
        gameCatchBtn.setLayoutParams(new ConstraintBuilder(31).right().centerV(remoteControlView.getId()).buildPayoutParams());
        addView(gameCatchBtn);


        tvTime = MyTextView.create(this, new ConstraintBuilder().ww().bottomCenterH(gameCatchBtn).bottomMargin(5));
        tvTime.initText(8, net.daylong.daylongbase.R.color.color_main, true);

        setDown(false);
    }


    public void down() {
        if (onCatchDownListener != null) {
            onCatchDownListener.onCatchDown();
        }
        gameCatchBtn.sendMsg();
        setDown(true);
    }


    @Override
    protected void init() {

    }


    public void setTime(int time) {
        tvTime.setText(String.valueOf(time));
    }


    public void setDown(boolean isDown) {
        gameCatchBtn.setDown(isDown);
        remoteControlView.setdown(isDown);
        tvTime.setVisibility(isDown ? View.GONE : View.VISIBLE);

        if (isDown) {
            SoundPoolType.DOLL_CATCH.play();
            tvTime.setText("");
        }

    }

    private OnCatchDownListener onCatchDownListener;

    public void setOnCatchDownListener(OnCatchDownListener onCatchDownListener) {
        this.onCatchDownListener = onCatchDownListener;
    }

    public interface OnCatchDownListener {
        void onCatchDown();
    }
}
