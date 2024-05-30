package com.daylong.arcx.view.game.btn;

import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.pushcoin.SelectGameCoinDialog;
import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.gamelibrary.view.btn.service.IStartBtn;
import com.daylong.httplibrary.bean.response.game.GameMultiplier;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;


public class PushCoinStartGame extends IStartBtn {
    public PushCoinStartGame(@NonNull BaseGameActivity activity, int gameCoin) {
        this(activity, gameCoin, null);
    }

    private GameMultiplier gameMultiplier;
    private BaseGameActivity activity;

    public PushCoinStartGame(@NonNull BaseGameActivity activity, int gameCoin, GameMultiplier gameMultiplier) {
        super(activity);
        this.activity = activity;

        this.gameMultiplier = gameMultiplier;

        setLayoutParams(new ConstraintBuilder(81, 30).bottomCenterH().bottomMargin(56).horizontalChainStyle().buildPayoutParams());
        setBackgroundResource(R.drawable.img_mch_game_push_coin_btn);
    }

    @Override
    public void onClick(View view) {

        if (gameMultiplier != null) {
            if (activity != null) {
                SelectGameCoinDialog.showDialog(activity.getSupportFragmentManager(), gameMultiplier);
            }
        } else {
            super.onClick(view);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        activity = null;

        super.onDetachedFromWindow();

    }
}
