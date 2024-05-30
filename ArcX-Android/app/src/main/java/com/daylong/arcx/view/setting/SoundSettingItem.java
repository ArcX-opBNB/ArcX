package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;

import com.daylong.userlibrary.cache.UserCache;

/**

 */
public class SoundSettingItem extends MusicSettingItem {


    public static SoundSettingItem create(ViewGroup viewGroup) {
        SoundSettingItem musicSettingItem = new SoundSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }

    @Override
    protected boolean isNo() {
        return UserCache.getInstance().getSound();
    }

    public SoundSettingItem(@NonNull Context context) {
        super(context);


    }

    @Override
    protected void checkedChanged(CompoundButton buttonView, boolean isChecked) {
        UserCache.getInstance().setSound(isChecked);
    }

    @Override
    public String getName() {
        return "sound";
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
        return com.daylong.reglinrary.R.drawable.img_setting_sound_;
    }
}
