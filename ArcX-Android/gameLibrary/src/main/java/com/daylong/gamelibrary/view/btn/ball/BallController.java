package com.daylong.gamelibrary.view.btn.ball;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.R;
import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.view.btn.doll.DollGameOperateView;
import com.daylong.gamelibrary.view.btn.service.IGameOperateView;

import net.daylong.baselibrary.utils.date.DateUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.textview.MyTextView;

public class BallController extends IGameOperateView {
    private GameDownBallBtn gameDownBallBtn;
    private MyTextView tvTime;

    public BallController(@NonNull Context context) {
        super(context);
        gameDownBallBtn = new GameDownBallBtn(getContext(), DrawableUtils.getDrawableByName("img_mch_ball_down"));
        gameDownBallBtn.setId(View.generateViewId());
        tvTime = MyTextView.create(this, new ConstraintBuilder().ww().topToBottom(gameDownBallBtn).centerH());
        tvTime.initText(10, net.daylong.daylongbase.R.color.color_main, true);
        tvTime.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), net.daylong.daylongbase.R.color.color_000000);

        addView(gameDownBallBtn);
        gameDownBallBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onCatchDownListener != null) {
                    onCatchDownListener.onCatchDown();
                }
                gameDownBallBtn.sendMsg();
                setDown(true);
            }
        });

    }

    public void setDown(boolean b) {
        gameDownBallBtn.setDown(b);


    }

    private OnCatchDownListener onCatchDownListener;

    public void setOnCatchDownListener(OnCatchDownListener onCatchDownListener) {
        this.onCatchDownListener = onCatchDownListener;
    }

    public void setEnd() {
        setDown(true);
        gameDownBallBtn.sendMsg();

    }

    public interface OnCatchDownListener {
        void onCatchDown();
    }

    @Override
    protected GameOperateType getGameOperateType() {
        return null;
    }


    public void setTime(int time) {
        tvTime.setText(String.valueOf(time));
    }

    @Override
    public void click(View view) {

    }
}
