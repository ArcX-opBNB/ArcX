package net.daylong.baselibrary.dialog;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.impl.LoadingPopupView;

import net.daylong.daylongbase.R;


public class MyLoadingDialog extends LoadingPopupView {


    public BasePopupView show(Activity activity) {
        return new XPopup.Builder(activity)

                .asCustom(new MyLoadingDialog(activity));

    }

    /**
     * @param context
     */
    public MyLoadingDialog(@NonNull Context context) {
        super(context, R.layout.dialog_my_loading);
    }


    @Override
    protected void onCreate() {
        super.onCreate();


    }
}

