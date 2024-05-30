package com.daylong.arcx.view.user.btn.login;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.daylong.userlibrary.view.login.ILoginBtn;
import com.daylong.userlibrary.view.login.ITouristLoginButton;
import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;


public class TouristLoginButton extends ITouristLoginButton {

    public static ILoginBtn create(ViewGroup viewGroup, ConstraintBuilder constraintBuilder) {
        TouristLoginButton button = new TouristLoginButton(viewGroup.getContext());
        button.setLayoutParams(constraintBuilder.buildPayoutParams());
        button.setTextColor(Color.WHITE);
        viewGroup.addView(button);

        return button;
    }
    public TouristLoginButton(@NonNull Context context) {
        super(context);
    }
    @Override
    public int bgRegId() {
        return R.drawable.img_login_phone;
    }

}
