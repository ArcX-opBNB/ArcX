package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class SupportSettingItem extends ISettingItemView {


    public static SupportSettingItem create(ViewGroup viewGroup) {
        SupportSettingItem musicSettingItem = new SupportSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }

    public SupportSettingItem(@NonNull Context context) {
        super(context);

    }


    @Override
    public String getName() {
        return "Support";
    }

    @Override
    public String getRightText() {
        return "";
    }

    @Override
    protected boolean isShowRightIcon() {
        return false;
    }

    @Override
    protected Integer getLeftIcon() {
        return com.daylong.reglinrary.R.drawable.img_setting_support;
    }
}
