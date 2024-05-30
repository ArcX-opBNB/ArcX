package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class LanguageSettingItem extends ISettingItemView {


    public static LanguageSettingItem create(ViewGroup viewGroup) {
        LanguageSettingItem musicSettingItem = new LanguageSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }

    public LanguageSettingItem(@NonNull Context context) {
        super(context);

    }


    @Override
    public String getName() {
        return "Language";
    }

    @Override
    public String getRightText() {
        return "English";
    }




}
