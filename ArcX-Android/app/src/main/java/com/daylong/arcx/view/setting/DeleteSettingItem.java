package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class DeleteSettingItem extends ISettingItemView {


    public static DeleteSettingItem create(ViewGroup viewGroup) {
        DeleteSettingItem musicSettingItem = new DeleteSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }

    public DeleteSettingItem(@NonNull Context context) {
        super(context);

    }


    @Override
    public String getName() {
        return "Delete account";
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
        return com.daylong.reglinrary.R.drawable.img_setting_delete;
    }
}
