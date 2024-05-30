package com.daylong.arcx.view.game.btn;

import android.graphics.Typeface;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.gamelibrary.view.btn.ICharterFlightButton;
import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;
import com.daylong.arcx.R;
import com.daylong.arcx.dialog.charter.CharterDialog;

import net.daylong.baselibrary.utils.date.DateUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.textview.MyTextView;

public class PushCoinCharterBtn extends ICharterFlightButton {

    private BaseGameActivity activity;

    public PushCoinCharterBtn(@NonNull BaseGameActivity context, int id) {
        super(context);
        activity = context;
        setLayoutParams(new ConstraintBuilder(23).left(id).topToBottom(id).topMargin(4).buildPayoutParams());
        setVisibility(View.GONE);
    }

    @Override
    public void showCharterDialog() {
        super.showCharterDialog();
        CharterDialog.showDialog(activity.getSupportFragmentManager(), activity.getCharterDescResponse(), isChatter());
    }

    private MyTextView tvTime;

    @Override
    public void onCharterStart(int flightTime) {
        
        if (tvTime == null) {
            tvTime = MyTextView.create(this, new ConstraintBuilder().ww().topCenterH().topMargin(5));
            tvTime.initText(6, R.color.color_white, true);
            tvTime.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), R.color.color_cc000000);
            Typeface monospace = Typeface.create("monospace", Typeface.NORMAL);
            tvTime.setTypeface(monospace);
        }
        tvTime.setText(DateUtil.parseSecondTime2(flightTime));
        setBackgroundResource(R.drawable.img_mch_solo_timer);
        tvTime.setVisibility(View.VISIBLE);
    }

    @Override
    protected void setCharterTime(int time) {
        tvTime.setText(DateUtil.parseSecondTime2(time));

    }

    @Override
    public void onCharterEnd() {
        if (tvTime != null) {
            tvTime.setVisibility(View.GONE);
            setBackgroundResource(R.drawable.img_mch_solo);
        }

    }

    @Override
    protected int getBackReg() {
        return R.drawable.img_mch_solo;
    }

    @Override
    protected CharterDescResponse getCharterDescResponse() {
        return activity.getCharterDescResponse();
    }


}
