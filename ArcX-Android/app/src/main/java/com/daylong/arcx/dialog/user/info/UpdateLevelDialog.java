package com.daylong.arcx.dialog.user.info;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.act.UserInfoActivity;
import com.daylong.httplibrary.bean.request.user.UpdateUserInfoRequest;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.LinearLayoutBuilder;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.btn.MyImgBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

/**

 */
public class UpdateLevelDialog extends BaseFragmentDialog {


    public static void ShowDialog(UserInfoActivity userInfoActivity, LoginUserInfoResponse.AtbTblnDTO atbTblnDTO) {
        UpdateLevelDialog updateNickNameDialog = new UpdateLevelDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("info", atbTblnDTO);
        updateNickNameDialog.setArguments(bundle);
        updateNickNameDialog.show(userInfoActivity.getSupportFragmentManager(), updateNickNameDialog.toString());

    }


    @Override
    protected ViewGroup getContentLayout() {
        return new ConstraintBuilder(152, 189).center().build(getContext());
    }

    private LoginUserInfoResponse.AtbTblnDTO info;


    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);

        contentView.setBackgroundResource(com.daylong.reglinrary.R.drawable.img_user_info_update_level_bg);
        Bundle arguments = getArguments();
        if (arguments != null) {
            info = (LoginUserInfoResponse.AtbTblnDTO) arguments.getSerializable("info");
        }

        MyImageView ivIcon = MyImageView.create(contentView, new ConstraintBuilder(44, 43).topCenterH(), info.getIconRegId());

        int tvCurId = View.generateViewId();
        int tvToId = View.generateViewId();
        int tvNextId = View.generateViewId();

        MyTextView tvCur = MyTextView.create(contentView, new ConstraintBuilder().ww().left().rightToLeftById(tvToId).topToBottom(ivIcon).topMargin(5).horizontalChainStyle());
        tvCur.initText(info.getLvAmt(), 10, R.color.color_white,true);
        tvCur.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), R.color.main_color_80000);
        tvCur.setId(tvCurId);

        MyImageView myImageView = MyImageView.create(contentView, new ConstraintBuilder(8, 8).leftToRightById(tvCurId).centerV(tvCurId).rightToLeftById(tvNextId).leftRightMargin(5), com.daylong.reglinrary.R.drawable.img_to);
        myImageView.setId(tvToId);


        MyTextView tvNext = MyTextView.create(contentView, new ConstraintBuilder().ww().leftToRightById(tvToId).right().top(tvCurId));
        tvNext.initText(info.getNxLvAmt(), 10, R.color.color_white,true);
        tvNext.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), R.color.main_color_80000);
        tvNext.setId(tvNextId);

        MyTextView tvTopStr = MyTextView.create(contentView, new ConstraintBuilder().ww().topToBottom(tvCur).topMargin(22).centerH());
        tvTopStr.initText("You need to pay", 10, net.daylong.daylongbase.R.color.color_333,true);


        MyTextView tvUpdateNum = MyTextView.create(contentView, new ConstraintBuilder().ww().topToBottom(tvTopStr).topMargin(8).centerH());
        tvUpdateNum.setCompoundDrawablePadding(AppUtil.getSize(3));
        tvUpdateNum.initText(info.getCsAmt(), 15, R.color.color_ffe88a27,true);
        tvUpdateNum.setId(View.generateViewId());
        DrawableUtils.setLeftDrawable(tvUpdateNum, 12, DrawableUtils.getDrawableByName(info.isCoinPay() ? "img_coin" : "img_axc"));

        MyBtn baseButton = MyBtn.create(contentView, new ConstraintBuilder(80, 28).bottomCenterH().bottomMargin(17), com.daylong.reglinrary.R.drawable.img_btn_user_update, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoActivity activity = (UserInfoActivity) getActivity();
                if (activity != null) {

                    activity.updateLevel(info.getAtbTp());

                }
                dismiss();
            }
        });
        baseButton.setGravity(Gravity.CENTER);
        baseButton.initBtn("OK", 10, R.color.color_white, true);
        baseButton.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), R.color.color_fff6bfea);
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
    public void initData() {

    }
}
