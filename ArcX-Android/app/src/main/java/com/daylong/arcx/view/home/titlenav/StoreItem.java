package com.daylong.arcx.view.home.titlenav;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.ui.ToastUtil;

public class StoreItem extends TitleNavItem{
    public StoreItem(@NonNull Context context, FragmentManager fragmentManager) {
        super(context, fragmentManager);
    }

    @Override
    protected int rightMargin() {
        return 0;
    }

    @Override
    public int imgRegId() {
        return R.drawable.img_main_store;
    }

    @Override
    public void onClick(View view) {
        ToastUtil.show("rewu");
    }
}
