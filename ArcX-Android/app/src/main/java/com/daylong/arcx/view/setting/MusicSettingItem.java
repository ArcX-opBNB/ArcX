package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.userlibrary.cache.UserCache;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

/**

 */
public class MusicSettingItem extends ISettingItemView {


    public static MusicSettingItem create(ViewGroup viewGroup) {
        MusicSettingItem musicSettingItem = new MusicSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }


    protected boolean isNo() {

        return UserCache.getInstance().getMusic();
    }


    public MusicSettingItem(@NonNull Context context) {
        super(context);



        CheckBox checkBox = new CheckBox(getContext());
        checkBox.setLayoutParams( new ConstraintBuilder(41, 14).rightCenterV().rightMargin(5).buildPayoutParams());
        checkBox.setButtonDrawable(null);
        checkBox.setBackgroundResource(R.drawable.setting_switch_selector);
        checkBox.setChecked(isNo());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkedChanged(buttonView, isChecked);
            }
        });
        addView(checkBox);
    }

    protected void checkedChanged(CompoundButton buttonView, boolean isChecked) {


        UserCache.getInstance().setMusic(isChecked);

    }

    @Override
    public String getName() {
        return "Music";
    }

    @Override
    protected Integer getLeftIcon() {
        return com.daylong.reglinrary.R.drawable.img_setting_music;
    }

    @Override
    public String getRightText() {
        return "";
    }

    @Override
    protected boolean isShowRightIcon() {
        return false;
    }
}
