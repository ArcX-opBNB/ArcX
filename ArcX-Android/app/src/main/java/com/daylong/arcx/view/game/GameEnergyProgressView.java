package com.daylong.arcx.view.game;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.gamelibrary.meuns.GameStatus;
import com.daylong.gamelibrary.meuns.GameType;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.MyProgressBar;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.layout.LinearLayoutView;
import net.daylong.baselibrary.view.textview.MyTextView;

/**

 */
public class GameEnergyProgressView extends ConstraintLayoutView {


    private MyTextView tvAddNu;
    private MyProgressBar myProgressBar;


    public GameEnergyProgressView(@NonNull Context context) {
        super(context);
    }

    public GameEnergyProgressView(@NonNull Context context, View leftView) {
        super(context);

        setId(View.generateViewId());
        if (leftView != null) {
            setLayoutParams(new ConstraintBuilder(52, 13).left(leftView).topToBottom(leftView).topMargin(4).buildPayoutParams());
        }
        setBackgroundResource(com.daylong.reglinrary.R.drawable.img_bg_energybg);


        myProgressBar = MyProgressBar.create(this, new ConstraintBuilder(44, 8).leftTop().topMargin(2.5f).leftMargin(4), com.daylong.reglinrary.R.drawable.garm_energy_dp, true, 5.0f, R.color.color_white);
        MyTextView pdText = myProgressBar.getPDText();
        pdText.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), getContext().getColor(R.color.main_color_80000));

        tvAddNu = MyTextView.create(this, new ConstraintBuilder().ww().rightCenterV().rightMargin(7).leftMargin(1));
        tvAddNu.initText("0", 6, R.color.color_white, true);
        tvAddNu.setMinimumWidth(getSize(10));
        tvAddNu.setTypeface(Typeface.create("monospace", Typeface.NORMAL));
        tvAddNu.setVisibility(View.GONE);
        MyImageView.create(this, new ConstraintBuilder(10).centerV().leftMargin(1), com.daylong.reglinrary.R.drawable.img_energy);


    }

    //
    public void setEnergy(int cnAmt, int ttAmt, long cgAmt, int lfTm) {

        if (getVisibility()!= View.VISIBLE) {
            setVisibility(View.VISIBLE);
        }
        if (myProgressBar != null) {
            int dp = (int) (cnAmt * 1.0f / ttAmt * 100);
            myProgressBar.setProgress(dp, String.valueOf(cnAmt));
        }




//        if (cgAmt != 0) {
//            tvAddNu.setText(String.valueOf(cnAmt));
//        }
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

}
