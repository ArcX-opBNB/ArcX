package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.daylong.arcx.uitls.UserCache;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.textview.MyTextView;

public class EmailSettingItem extends ISettingItemView {

    private MyTextView tvEmail;


    public static EmailSettingItem create(ViewGroup viewGroup) {
        EmailSettingItem musicSettingItem = new EmailSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }

    public EmailSettingItem(@NonNull Context context) {
        super(context);


        tvEmail = MyTextView.create(this, new ConstraintBuilder().ww().leftToRightById(tvName).centerV().leftMargin(5));
        tvEmail.initText(7, net.daylong.daylongbase.R.color.color_333, true);
        tvEmail.setGravity(Gravity.CENTER_VERTICAL);
        setTvEmail(UserCache.getUserInfo().getEmail());
    }


    @Override
    public String getName() {
        return "E-mail：";
    }

    @Override
    public String getRightText() {
        return "";
    }


    public void setTvEmail(String email) {
        tvEmail.setText(email);
    }
}
