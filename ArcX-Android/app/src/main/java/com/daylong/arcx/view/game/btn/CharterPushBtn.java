package com.daylong.arcx.view.game.btn;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.view.btn.ICharterPushCoinBtn;
import com.daylong.arcx.R;

public class CharterPushBtn extends ICharterPushCoinBtn {
    public CharterPushBtn(@NonNull Context context, int btnReg, String charterTitle, int charterTitleColor, int shadowColor, int icon, int coinColor) {
        super(context, btnReg, charterTitle, charterTitleColor, shadowColor, icon, coinColor);

    }

    public CharterPushBtn(@NonNull Context context) {

    }

}
