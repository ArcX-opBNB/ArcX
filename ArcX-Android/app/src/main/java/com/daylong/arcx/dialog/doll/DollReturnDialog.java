package com.daylong.arcx.dialog.doll;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.daylong.arcx.R;
import com.daylong.arcx.view.RechargeNumberView;
import com.daylong.arcx.view.btn.CharterPayBtn;
import com.daylong.arcx.view.dragonball.AwardRv;
import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;
import com.daylong.gamelibrary.request.operate.StartGameRequest;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;
import com.daylong.httplibrary.bean.response.game.charter.UserCharterInfoResponse;
import com.daylong.httplibrary.model.contract.game.CharterContract;
import com.daylong.httplibrary.model.model.game.CharterModel;
import com.daylong.httplibrary.model.presenter.game.CharterPresenter;
import com.daylong.musiclibrary.emums.SoundPoolType;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseMvpFragmentDialog;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
import net.daylong.gamesocket.mrg.WebSocketMrg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DollReturnDialog extends BaseMvpFragmentDialog<CharterPresenter, CharterModel> implements CharterContract.CharterView, CharterPayBtn.OnCharterPayListener, MyBtn.OnImageClickListener {


    public static void showDialog(FragmentManager fragmentManager, boolean isCharter, ArrayList<AwardBean> awardBeans) {

        DollReturnDialog reportDialog = new DollReturnDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isCharter", isCharter);
        bundle.putSerializable("awardBeans", awardBeans);
        reportDialog.setArguments(bundle);

        if (reportDialog.getDialog() == null || !reportDialog.getDialog().isShowing()) {
            reportDialog.show(fragmentManager, reportDialog.toString());
        }
    }

    private int rightBtnId;

    @Override
    protected boolean isWinDismiss() {
        return false;
    }

    private AwardRv awardRv;

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {
        Bundle arguments = getArguments();

        if (arguments != null) {
            isCharter = arguments.getBoolean("isCharter", false);


        }

        rootView.setBackgroundResource(isCharter ? R.drawable.img_mch_doll_result_01 : R.drawable.img_mch_doll_result_02);

        int textId = View.generateViewId();
        float topMargin = isCharter ? 19 : 67;
        if (isCharter) {

            SoundPoolType.DOLL_WIN.play();

            int numberId = View.generateViewId();


            awardRv = new AwardRv(getContext());
            awardRv.setId(View.generateViewId());
            awardRv.setLayoutParams(new ConstraintBuilder().ww().topCenterH().topMargin(164).buildPayoutParams());
            addView(awardRv);

            MyTextView tvTest;
            tvTest = MyTextView.create(rootView, new ConstraintBuilder(135, 28).topToBottom(awardRv).centerH().topMargin(7));
            tvTest.setId(textId);
            tvTest.initText(com.daylong.reglinrary.R.string.str_doll_machine_status_suc, 12, R.color.color_fffc7b, true);
            tvTest.setBackgroundResource(R.drawable.shape_r12_ff0);
            tvTest.setGravity(Gravity.CENTER);


        } else {
            SoundPoolType.DOLL_WIN.play();

            MyTextView tvTest = MyTextView.create(rootView, new ConstraintBuilder(135, 49).center());
            tvTest.setId(textId);
            tvTest.initText(com.daylong.reglinrary.R.string.str_doll_machine_status_fail, 12, R.color.color_fffc7b, true);
            tvTest.setBackgroundResource(R.drawable.shape_r12_ff0);
            tvTest.setGravity(Gravity.CENTER);
        }


        MyTextView tvTop = MyTextView.create(rootView, new ConstraintBuilder().ww().bottomCenterH().bottomMargin(24));
        tvTop.initText(com.daylong.reglinrary.R.string.str_doll_machine_tap_to, 8, R.color.color_402e7c, true);
        tvTop.setGravity(Gravity.CENTER);


        rightBtnId = View.generateViewId();

        MyBtn myBtn = MyBtn.create(rootView, new ConstraintBuilder(60, 22).topToBottom(textId).left().rightToLeftById(rightBtnId).topMargin(topMargin).horizontalChainStyle(), R.drawable.img_mch_alert_btn, this);
        myBtn.setId(View.generateViewId());
        myBtn.initText(com.daylong.reglinrary.R.string.str_doll_btn_no, 8, true);
        myBtn.setGravity(Gravity.CENTER);
        MyBtn once = MyBtn.create(rootView, new ConstraintBuilder(60, 22).topToBottom(textId).right().leftMargin(10).leftToRightById(myBtn).topMargin(topMargin), R.drawable.img_mch_alert_btn, this);
        once.initText(com.daylong.reglinrary.R.string.str_doll_btn_once, 8, true);
        once.setId(rightBtnId);
        once.setGravity(Gravity.CENTER);
    }


    private boolean isCharter;


    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle != null) {

            ArrayList<AwardBean> awardBeans = (ArrayList<AwardBean>) bundle.getSerializable("awardBeans");
            if (awardBeans != null && awardRv != null) {
                awardRv.setData(awardBeans);
            }
        }
    }


    @Override
    public void onGameCharterDesc(CharterDescResponse descResponse) {
    }


    @Override
    public void onUserCharterInfo(UserCharterInfoResponse charterInfoResponse) {


    }

    @NonNull
    @Override
    protected CharterPresenter initPresenter() {
        return CharterPresenter.newInstance();
    }


    @Override
    public void dismiss() {
        super.dismiss();
        SoundPoolType.DOLL_WIN.stop();
    }

    @Override
    public void onPaySuc() {
        dismiss();

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == rightBtnId) {
            WebSocketMrg.getInstance().sendMsg(new StartGameRequest());

        } else {
            WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(GameOperateType.OFF_LINE));
        }


        dismiss();
    }
}
