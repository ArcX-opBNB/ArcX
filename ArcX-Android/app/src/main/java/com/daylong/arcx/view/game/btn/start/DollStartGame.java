package com.daylong.arcx.view.game.btn.start;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.pushcoin.SelectGameCoinDialog;
import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.gamelibrary.view.btn.service.IStartBtn;
import com.daylong.httplibrary.bean.response.game.GameMultiplier;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

/**

 */
public class DollStartGame extends IStartBtn {
    public DollStartGame(@NonNull Context context, int gameCoin) {
        this(context, gameCoin, null);
    }


    public DollStartGame(@NonNull Context context, int gameCoin, GameMultiplier gameMultiplier) {
        super(context);
        setBackgroundResource(R.drawable.img_mch_game_doll_btn);
        setLayoutParams(new ConstraintBuilder(81, 30).bottomCenterH().bottomMargin(46).horizontalChainStyle().buildPayoutParams());


        MyTextView tvNun = MyTextView.create(this, new ConstraintBuilder()
                .ww().bottomCenterH().bottomMargin(5));
        tvNun.initText(8, true);
        tvNun.setGravity(Gravity.CENTER);
        tvNun.setTextNumDot(gameCoin);
        DrawableUtils.setLeftDrawable(tvNun, 10, R.drawable.img_coin);
    }

}
