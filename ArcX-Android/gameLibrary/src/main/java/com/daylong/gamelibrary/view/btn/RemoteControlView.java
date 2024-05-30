package com.daylong.gamelibrary.view.btn;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.view.btn.service.IGameOperateBtnView;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;

/**

 */
public class RemoteControlView extends ConstraintLayoutView {
    private IGameOperateBtnView topBtn;
    private IGameOperateBtnView leftBtn;
    private IGameOperateBtnView rightBtn;
    private IGameOperateBtnView bottomBtn;

    public RemoteControlView(@NonNull Context context, int leftReg, int topReg, int rightReg, int bottomReg) {
        super(context);
        int BTN_SIZE = 28;
        topBtn = new BaseGameTopBtn(getContext());
        topBtn.setLayoutParams(new ConstraintBuilder(BTN_SIZE).leftTop().leftMargin(33).buildPayoutParams());
        topBtn.setId(View.generateViewId());
        topBtn.setImageResource(topReg);


        leftBtn = new BaseGameLeftBtn(getContext());
        leftBtn.setId(View.generateViewId());
        leftBtn.setLayoutParams(new ConstraintBuilder(BTN_SIZE).leftTop().topMargin(23).buildPayoutParams());
        leftBtn.setImageResource(leftReg);

        rightBtn = new BaseGameRightBtn(getContext());
        rightBtn.setId(net.daylong.daylongbase.R.id.base_view_3);
        rightBtn.setLayoutParams(new ConstraintBuilder(BTN_SIZE).leftToRightById(topBtn).top().leftTopMargin(5, 23).buildPayoutParams());
        rightBtn.setImageResource(rightReg);

        bottomBtn = new BaseGameBottomBtn(getContext());
        bottomBtn.setId(net.daylong.daylongbase.R.id.base_view_3);
        bottomBtn.setLayoutParams(new ConstraintBuilder(BTN_SIZE).leftToRightById(leftBtn).topToBottom(topBtn).leftTopMargin(5, 18).buildPayoutParams());
        bottomBtn.setImageResource(bottomReg);

        addView(leftBtn);
        addView(topBtn);
        addView(rightBtn);
        addView(bottomBtn);

        setId(View.generateViewId());
    }


    public void setdown(boolean isDown) {


        topBtn.setDown(isDown);
        leftBtn.setDown(isDown);
        rightBtn.setDown(isDown);
        bottomBtn.setDown(isDown);


    }
}
