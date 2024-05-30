package com.daylong.arcx.view.user;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.user.EnergyHelpDialog;
import com.daylong.gamelibrary.meuns.GameStatus;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.MyProgressBar;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

import org.greenrobot.eventbus.util.ErrorDialogConfig;

/**

 */
public class EnergyProgressView extends ConstraintLayoutView implements View.OnClickListener {


    private MyProgressBar myProgressBar;


    public EnergyProgressView(@NonNull Context context) {
        super(context);
    }

    public EnergyProgressView(@NonNull Context context, View leftView) {
        super(context);

        setId(View.generateViewId());
        if (leftView != null) {
            setLayoutParams(new ConstraintBuilder(39, 14).right().rightMargin(5).centerV(leftView).leftMargin(2).buildPayoutParams());
        }
        setBackgroundResource(com.daylong.reglinrary.R.drawable.img_bg_energybg);


        myProgressBar = MyProgressBar.create(this, new ConstraintBuilder(33, 8).leftTop().topMargin(2.5f).leftMargin(4), R.drawable.user_energy_dp, true, 5.0f, R.color.color_white);


        MyTextView pdText = myProgressBar.getPDText();
        pdText.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), getContext().getColor(R.color.main_color_80000));


        MyImageView.create(this, new ConstraintBuilder(12).centerV().leftMargin(4), com.daylong.reglinrary.R.drawable.img_energy);

        setOnClickListener(this);

    }

    private int cnAmt;
    private int ttAmt;
    private int cgAmt;
    private int lfTm;

    /**




     */
    public void setEnergy(int cnAmt, int ttAmt, int cgAmt, int lfTm) {
        this.cnAmt = cnAmt;
        this.ttAmt = ttAmt;
        this.cgAmt = cgAmt;
        this.lfTm = lfTm;
        if (myProgressBar != null) {
            int dp = (int) (cnAmt * 1.0f / ttAmt * 100);
            myProgressBar.setProgress(dp, String.valueOf(cnAmt));
        }


    }

    @Override
    public void onClick(View view) {
        EnergyHelpDialog.showDialog(AppUtil.getCurrentActivity(), cnAmt, ttAmt, cgAmt, lfTm);
    }
}
