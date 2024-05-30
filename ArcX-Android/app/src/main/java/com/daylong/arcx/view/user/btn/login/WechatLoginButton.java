package com.daylong.arcx.view.user.btn.login;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.daylong.userlibrary.view.login.IWechatLoginButton;
import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;


public class WechatLoginButton extends IWechatLoginButton  {

    public static WechatLoginButton create(ViewGroup viewGroup, ConstraintBuilder constraintBuilder) {
        WechatLoginButton button = new WechatLoginButton(viewGroup.getContext());
        button.setLayoutParams(constraintBuilder.buildPayoutParams());
        button.setTextColor(Color.WHITE);

        viewGroup.addView(button);

        return button;
    }

    public WechatLoginButton(@NonNull Context context) {
        super(context);
    }
    @Override
    public int bgRegId() {
        return R.drawable.img_login_wechat;
    }



}
