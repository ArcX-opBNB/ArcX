package com.daylong.arcx.view.home.titlenav;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.CheckInDialog;

public class CheckInItem extends TitleNavItem {

    public CheckInItem(@NonNull Context context, FragmentManager fragmentManager) {
        super(context, fragmentManager);
    }

    @Override
    public int imgRegId() {
        return R.drawable.img_main_checkin;
    }

    @Override
    public void onClick(View view) {
        CheckInDialog.showDialog(fragmentManager);
    }


}
