package com.daylong.arcx.view.game;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import com.daylong.gamelibrary.meuns.GameStatus;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.layout.LinearLayoutView;

public class DragonBallListView extends LinearLayoutView {

    private final int DEFAULT = com.daylong.reglinrary.R.drawable.img_db_default;
    private final int SELECTED = com.daylong.reglinrary.R.drawable.img_db_selected;

    public DragonBallListView(Context context, View leftView, float topMargin) {
        super(context);
        setId(View.generateViewId());
        setLayoutParams(new ConstraintBuilder(54, 11).left(leftView).topToBottom(leftView).topMargin(topMargin).buildPayoutParams());
        setBackgroundResource(com.daylong.reglinrary.R.drawable.img_game_db_bg);
        setGravity(Gravity.CENTER_VERTICAL);
        setOrientation(HORIZONTAL);
        for (int i = 0; i < 7; i++) {
            MyImageView.create(this, new ConstraintBuilder(5).leftMargin(2.3f), DEFAULT);
        }
    }

    public void setNum(int num) {
        for (int i = 0; i < getChildCount(); i++) {
            MyImageView childAt = (MyImageView) getChildAt(i);

            if (i < num) {
                childAt.setImageRegCrop(SELECTED);
            } else {
                childAt.setImageRegCrop(DEFAULT);
            }
        }
    }

    public void setState(GameStatus gameStatus) {

        if (gameStatus == GameStatus.GAME && getVisibility() != View.VISIBLE) {
//            setVisibility(View.VISIBLE);
        } else {
            if (getVisibility() != View.GONE) {
                setVisibility(View.GONE);
            }
        }
    }


    public View getDragonView(int num) {
        return getChildAt(num - 1);
    }
}
