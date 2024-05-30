package com.daylong.arcx.act;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.user.info.UpdateNickNameDialog;
import com.daylong.arcx.view.setting.CacheSettingItem;
import com.daylong.arcx.view.setting.DeleteSettingItem;
import com.daylong.arcx.view.setting.EmailSettingItem;
import com.daylong.arcx.view.setting.ExitLoginSettingItem;
import com.daylong.arcx.view.setting.LanguageSettingItem;
import com.daylong.arcx.view.setting.MusicSettingItem;
import com.daylong.arcx.view.setting.NoticeSettingItem;
import com.daylong.arcx.view.setting.PasswordSettingItem;
import com.daylong.arcx.view.setting.SoundSettingItem;
import com.daylong.arcx.view.setting.SupportSettingItem;
import com.daylong.arcx.view.setting.VersionSettingItem;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.btn.MyImgBtn;
import net.daylong.baselibrary.view.img.MyImageView;

public class SettingDialog extends BaseFragmentDialog {

    public static void showDialog(UserInfoActivity userInfoActivity) {
        SettingDialog settingDialog = new SettingDialog();
        settingDialog.show(userInfoActivity.getSupportFragmentManager(), settingDialog.toString());

    }

    @Override
    protected ViewGroup getContentLayout() {


        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new ConstraintBuilder(152, 250).center().buildPayoutParams());
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        return linearLayout;
    }

    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);

        contentView.setBackgroundResource(com.daylong.reglinrary.R.drawable.img_user_info_bg);


        createTitleSetting((LinearLayout) contentView);

        MyBtn.create(rootView, new ConstraintBuilder(15).bottomCenterH().bottomMargin(27), com.daylong.reglinrary.R.drawable.img_dialog_colse, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }

    private void createTitleSetting(LinearLayout linearLayout) {

        MyImageView.create(contentView, new ConstraintBuilder(38, 10).topMargin(9).bottomMargin(8), com.daylong.reglinrary.R.drawable.img_user_title_setting);


        NoticeSettingItem.create(linearLayout);
        MusicSettingItem.create(linearLayout);
        SoundSettingItem.create(linearLayout);
        LanguageSettingItem.create(linearLayout);
        EmailSettingItem.create(linearLayout);
        PasswordSettingItem.create(linearLayout);
        SupportSettingItem.create(linearLayout);
        DeleteSettingItem.create(linearLayout);




    }


    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {

    }

    @Override
    public void initData() {

    }
}
