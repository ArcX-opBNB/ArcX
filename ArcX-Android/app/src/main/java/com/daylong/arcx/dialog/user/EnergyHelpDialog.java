package com.daylong.arcx.dialog.user;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.date.DateUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.MyProgressBar;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

/**

 */
public class EnergyHelpDialog extends BaseFragmentDialog {




    public static void showDialog(BaseActivity userInfoActivity, int cnAmt, int ttAmt, int cgAmt, int lfTm) {
        EnergyHelpDialog payConfirmDialog = new EnergyHelpDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("cnAmt", cnAmt);
        bundle.putInt("ttAmt", ttAmt);
        bundle.putInt("cgAmt", cgAmt);
        bundle.putInt("lfTm", lfTm);
        payConfirmDialog.setArguments(bundle);
        payConfirmDialog.show(userInfoActivity.getSupportFragmentManager(), payConfirmDialog.toString());
    }

    @Override
    protected ViewGroup getContentLayout() {
        return new ConstraintBuilder(116).wHei().center().build(getContext());
    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            lfTm--;
            tvTime.initText(DateUtil.parseSecondTime(lfTm), 6, R.color.color_white);
            AppUtil.getMainHandler().postDelayed(this, 1000);
        }
    };
    private int lfTm = 0;
    MyTextView tvTime;

    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);


        Bundle arguments = getArguments();


        int cnAmt = 0;
        int ttAmt = 0;
        int cgAmt = 0;
        if (arguments != null) {
            lfTm = arguments.getInt("lfTm");
            cnAmt = arguments.getInt("cnAmt");
            ttAmt = arguments.getInt("ttAmt");

        }
        contentView.setBackgroundResource(R.drawable.img_mch_alert);

        MyImageView.create(contentView, new ConstraintBuilder(27).topCenterH().topMargin(8), R.drawable.img_dialog_energy_help_icon);
        MyProgressBar myProgressBar = MyProgressBar.create(contentView, new ConstraintBuilder(63, 8).leftTop().topMargin(38).centerH(), R.drawable.user_energy_dp, true, 6.0f, R.color.color_white);

        MyTextView pdText = myProgressBar.getPDText();
        pdText.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), getContext().getColor(R.color.main_color_80000));


        MyTextView textView = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(50).leftRightMargin(6));
        textView.initText("When energy ≥ 1, AXC or crypto assets can be won through arcade games. Over time, energy will gradually return. Becoming a web3 player or increasing the charging level can greatly improve energy recovery efficiency.", 6, R.color.color_white);
        textView.setPadding(AppUtil.getSize(7), 0, AppUtil.getSize(7), AppUtil.getSize(7));
        if (lfTm > 0) {

            tvTime = MyTextView.create(contentView, new ConstraintBuilder(29, 13).topRight().topRightMargin(4, 3));
            tvTime.setBackgroundResource(R.drawable.img_dialog_time_bg);
            tvTime.setGravity(Gravity.CENTER);
            tvTime.initText(DateUtil.parseSecondTime(lfTm), 6, R.color.color_white);
            AppUtil.getMainHandler().postDelayed(runnable, 1000);
        }

        
        int dp = (int) (cnAmt * 1.0f / ttAmt * 100);
        myProgressBar.setProgress(dp, String.valueOf(cnAmt));


        MyBtn.create(rootView, new ConstraintBuilder(15).bottomCenterH().bottomMargin(27), com.daylong.reglinrary.R.drawable.img_dialog_colse, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {

    }

    @Override
    public void dismiss() {
        super.dismiss();
        AppUtil.getMainHandler().removeCallbacks(runnable, null);

    }

    @Override
    public void initData() {

    }
}
