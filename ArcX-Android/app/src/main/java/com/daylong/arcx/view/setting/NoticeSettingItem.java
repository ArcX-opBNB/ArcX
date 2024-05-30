package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.baselibrary.utils.ui.layout.cl.RightLayoutC;
import net.daylong.baselibrary.utils.ui.layout.cl.TopLayoutC;

public class NoticeSettingItem extends ISettingItemView {


    public static NoticeSettingItem create(ViewGroup viewGroup) {
        NoticeSettingItem musicSettingItem = new NoticeSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }

    public NoticeSettingItem(@NonNull Context context) {
        super(context);

    }


    @Override
    public String getName() {
        return "Notice";
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
        return com.daylong.reglinrary.R.drawable.img_setting_notice;
    }
}
