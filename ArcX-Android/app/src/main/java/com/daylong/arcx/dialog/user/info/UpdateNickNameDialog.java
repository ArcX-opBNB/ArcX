package com.daylong.arcx.dialog.user.info;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;

import com.daylong.arcx.R;
import com.daylong.arcx.act.UserInfoActivity;
import com.daylong.httplibrary.bean.request.user.UpdateUserInfoRequest;
import com.daylong.httplibrary.model.presenter.user.UpdateUserInfoPresenter;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.MyEditText;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.btn.MyImgBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

import java.io.Serializable;

public class UpdateNickNameDialog extends BaseFragmentDialog {


    public static void ShowDialog(UserInfoActivity userInfoActivity, UpdateUserInfoRequest updateUserInfoRequest) {
        UpdateNickNameDialog updateNickNameDialog = new UpdateNickNameDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("info", updateUserInfoRequest);
        updateNickNameDialog.setArguments(bundle);
        updateNickNameDialog.show(userInfoActivity.getSupportFragmentManager(), updateNickNameDialog.toString());

    }


    @Override
    protected ViewGroup getContentLayout() {
        return new ConstraintBuilder(151, 139).center().build(getContext());
    }

    private UpdateUserInfoRequest info;
    private EditText etNickName;

    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);

        contentView.setBackgroundResource(com.daylong.reglinrary.R.drawable.img_user_info_bg);
        Bundle arguments = getArguments();
        if (arguments != null) {
            info = (UpdateUserInfoRequest) arguments.getSerializable("info");
        }


        MyImageView.create(contentView, new ConstraintBuilder(73, 10).topCenterH().topMargin(9), com.daylong.reglinrary.R.drawable.img_user_title_change_name);

         etNickName = new EditText(getContext());
        etNickName.setLayoutParams(new ConstraintBuilder(0, 25).topCenterH().topMargin(48).leftRightMargin(7).buildPayoutParams());
        etNickName.setBackgroundResource(com.daylong.reglinrary.R.drawable.bj_shape_r12_c_fff);
        etNickName.setHintTextColor(getContext().getColor(net.daylong.daylongbase.R.color.color_666));
        etNickName.setTextColor(getContext().getColor(net.daylong.daylongbase.R.color.color_333));
        etNickName.setHint(info.getPlyNm());
        etNickName.setGravity(Gravity.CENTER);
        contentView.setPadding(AppUtil.getSize(5), 0, AppUtil.getSize(5), 0);
        contentView.addView(etNickName);
        BaseButton baseButton = MyBtn.create(contentView, new ConstraintBuilder(80, 28).bottomCenterH().bottomMargin(17), com.daylong.reglinrary.R.drawable.img_btn_user_update, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoActivity activity = (UserInfoActivity) getActivity();
                if (activity != null) {
                    String trim = etNickName.getText().toString().trim();

                    if (TextUtils.isEmpty(trim)) {
                        return;
                    }

                    info.setPlyNm(trim);

                    activity.updateUserInfo(info);
                    dismiss();
                }
            }
        });
        baseButton.setGravity(Gravity.CENTER);
        baseButton.initBtn("ok", 10, R.color.color_white, true);
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
