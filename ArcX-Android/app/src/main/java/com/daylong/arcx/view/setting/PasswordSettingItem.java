package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.act.UserInfoActivity;
import com.daylong.arcx.dialog.user.info.UpdatePasswordDialog;
import com.daylong.arcx.uitls.UserCache;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.textview.MyTextView;

public class PasswordSettingItem extends ISettingItemView {


    public static PasswordSettingItem create(ViewGroup viewGroup) {
        PasswordSettingItem musicSettingItem = new PasswordSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }

    public PasswordSettingItem(@NonNull Context context) {
        super(context);


        MyBtn myBtn = MyBtn.create(this, new ConstraintBuilder(32, 15).rightCenterV().marginLeftAndRight(4), com.daylong.reglinrary.R.drawable.img_setting_btn_mini, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                UpdatePasswordDialog.showDialog((UserInfoActivity) AppUtil.getCurrentActivity());
            }
        });

        myBtn.initBtn("SET", 7, R.color.color_white, true);
        myBtn.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), R.color.color_fff6bfea);
        myBtn.setGravity(Gravity.CENTER);

    }


    @Override
    public String getName() {
        return "Password：";
    }

    @Override
    public String getRightText() {
        return "";
    }


}
