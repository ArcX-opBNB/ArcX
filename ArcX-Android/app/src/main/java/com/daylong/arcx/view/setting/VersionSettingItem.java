package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.baselibrary.utils.ui.layout.cl.RightLayoutC;
import net.daylong.baselibrary.utils.ui.layout.cl.TopLayoutC;

public class VersionSettingItem extends ISettingItemView {


    public static VersionSettingItem create(ViewGroup viewGroup) {
        VersionSettingItem musicSettingItem = new VersionSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }

    public VersionSettingItem(@NonNull Context context) {
        super(context);


        LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(20, 10);
        RightLayoutC.right(winLayoutParams);
        TopLayoutC.centerV(winLayoutParams);
        CheckBox checkBox = new CheckBox(getContext());
        checkBox.setLayoutParams(winLayoutParams);


        setTvRightText(AppUtil.getAppVersionName(getContext()));


    }

    @Override
    public String getName() {

    }

    @Override
    public String getRightText() {
        return "";
    }




}
