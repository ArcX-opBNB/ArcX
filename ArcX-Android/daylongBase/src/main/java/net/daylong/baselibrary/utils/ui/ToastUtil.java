package net.daylong.baselibrary.utils.ui;

import android.content.Context;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.daylong.daylongbase.R;

import net.daylong.baselibrary.app.BaseApplication;


public class ToastUtil {
    private static Toast sToast = null;


    public static void show(String msg) {

        Toast.makeText(BaseApplication.getInstance().getContext(),msg,Toast.LENGTH_LONG).show();
    }





}
