package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.daylong.userlibrary.cache.UserCache;

import net.daylong.baselibrary.app.AppManager;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.baselibrary.utils.ui.layout.cl.RightLayoutC;
import net.daylong.baselibrary.utils.ui.layout.cl.TopLayoutC;

public class ExitLoginSettingItem extends ISettingItemView {


    public static ExitLoginSettingItem create(ViewGroup viewGroup) {
        ExitLoginSettingItem musicSettingItem = new ExitLoginSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }

    public ExitLoginSettingItem(@NonNull Context context) {
        super(context);


        LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(20, 10);
        RightLayoutC.right(winLayoutParams);
        TopLayoutC.centerV(winLayoutParams);
        CheckBox checkBox = new CheckBox(getContext());
        checkBox.setLayoutParams(winLayoutParams);


    }

    @Override
    public String getName() {

    }

    @Override
    public String getRightText() {
        return "";
    }

    @Override
    protected boolean isShowRightIcon() {
        return true;
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        UserCache.getInstance().exitLogin();

        AppManager.getInstance().returnToHome();



    }
}
