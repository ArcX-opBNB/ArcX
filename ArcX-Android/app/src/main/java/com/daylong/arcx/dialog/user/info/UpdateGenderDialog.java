package com.daylong.arcx.dialog.user.info;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.act.UserInfoActivity;
import com.daylong.arcx.view.home.HomeTabGroupView;
import com.daylong.httplibrary.bean.request.user.UpdateUserInfoRequest;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.LinearLayoutBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.btn.MyImgBtn;
import net.daylong.baselibrary.view.img.MyImageView;

public class UpdateGenderDialog extends BaseFragmentDialog {


    public static void ShowDialog(UserInfoActivity userInfoActivity, UpdateUserInfoRequest updateUserInfoRequest) {
        UpdateGenderDialog updateNickNameDialog = new UpdateGenderDialog();
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


    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);

        contentView.setBackgroundResource(com.daylong.reglinrary.R.drawable.img_user_info_bg);
        Bundle arguments = getArguments();
        if (arguments != null) {
            info = (UpdateUserInfoRequest) arguments.getSerializable("info");
        }


        MyImageView.create(contentView, new ConstraintBuilder(73, 10).topCenterH().topMargin(9), com.daylong.reglinrary.R.drawable.img_user_title_change_name);


        RadioGroup radioGroup = new RadioGroup(getContext());

        radioGroup.setLayoutParams(new ConstraintBuilder(0, 24).leftTop().centerH().topMargin(49).buildPayoutParams());
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        radioGroup.setGravity(Gravity.CENTER);

        contentView.addView(radioGroup);
        RadioButton checkMale = new RadioButton(getContext());
        checkMale.setId(View.generateViewId());
        checkMale.setButtonDrawable(null);
        checkMale.setLayoutParams(new LinearLayoutBuilder(15).buildPayoutParams());
        checkMale.setBackgroundResource(com.daylong.reglinrary.R.drawable.select_gender);
        radioGroup.addView(checkMale);
       MyImageView.create(radioGroup, new LinearLayoutBuilder(24).leftMargin(5).buildPayoutParams(), null, R.drawable.img_gender_n);


        RadioButton checkFemale = new RadioButton(getContext());
        checkFemale.setId(View.generateViewId());
        checkFemale.setButtonDrawable(null);
        checkFemale.setLayoutParams(new LinearLayoutBuilder(15).leftMargin(22).buildPayoutParams());
        checkFemale.setBackgroundResource(com.daylong.reglinrary.R.drawable.select_gender);
        radioGroup.addView(checkFemale);

        MyImageView.create(radioGroup, new LinearLayoutBuilder(24).leftMargin(6).buildPayoutParams(), null, R.drawable.img_gender_f);


        if (info.getSex() == 1) {
            checkMale.setChecked(true);
        } else {
            checkFemale.setChecked(true);
        }
        BaseButton baseButton = MyBtn.create(contentView, new ConstraintBuilder(80, 28).bottomCenterH().bottomMargin(17), com.daylong.reglinrary.R.drawable.img_btn_user_update, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoActivity activity = (UserInfoActivity) getActivity();
                if (activity != null) {


                    Integer sex = info.getSex();

                    boolean checked = checkMale.isChecked();
                    boolean checked2 = checkFemale.isChecked();
                    if ((sex == 1 && checked) || sex == 2 && checked2) {
                        dismiss();
                    } else {
                        info.setSex(checked ? 1 : 2);
                        activity.updateUserInfo(info);
                        dismiss();
                    }

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
