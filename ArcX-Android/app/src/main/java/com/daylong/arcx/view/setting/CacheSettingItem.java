package com.daylong.arcx.view.setting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnConfirmListener;

import net.daylong.baselibrary.utils.CacheUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.baselibrary.utils.ui.layout.cl.RightLayoutC;
import net.daylong.baselibrary.utils.ui.layout.cl.TopLayoutC;

public class CacheSettingItem extends ISettingItemView {


    public static CacheSettingItem create(ViewGroup viewGroup) {
        CacheSettingItem musicSettingItem = new CacheSettingItem(viewGroup.getContext());

        viewGroup.addView(musicSettingItem);
        return musicSettingItem;
    }

    public CacheSettingItem(@NonNull Context context) {
        super(context);


        LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(20, 10);
        RightLayoutC.right(winLayoutParams);
        TopLayoutC.centerV(winLayoutParams);
        CheckBox checkBox = new CheckBox(getContext());
        checkBox.setLayoutParams(winLayoutParams);


        
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    String totalCacheSize = CacheUtil.getTotalCacheSize(getContext());
                    setTvRightText(totalCacheSize);
//                   LogUtil.e( "run: totalCacheSize--->" + totalCacheSize);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public String getName() {

    }

    @Override
    public String getRightText() {
        return "";
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);

                new OnConfirmListener() {
                    @Override
                    public void onConfirm() {
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                try {
                                    CacheUtil.clearAllCache(getContext());
                                    AppUtil.getCurrentActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {

                                            setTvRightText("0");

                                        }
                                    });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();


                    }
                })
                .show();
    }
}
