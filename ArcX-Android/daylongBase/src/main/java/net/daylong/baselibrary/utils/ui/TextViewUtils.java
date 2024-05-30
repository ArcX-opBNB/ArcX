package net.daylong.baselibrary.utils.ui;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorRes;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.view.textview.MyTextView;

public class TextViewUtils {


    /**

     * @param params


     * @return
     */
    public static TextView create(ViewGroup viewGroup, ViewGroup.LayoutParams params, int size, @ColorRes Integer color) {
        MyTextView myTextView = MyTextView.create(viewGroup, params);
        if (color != null) {
            myTextView.setTextColor(AppUtil.getContext().getColor(color));
        } else {
            myTextView.setTextColor(Color.WHITE);
        }
        myTextView.setTextSize(size);
        return myTextView;
    }

    /**

     * @param params

     * @return
     */
    public static TextView create(ViewGroup viewGroup, ViewGroup.LayoutParams params, int size) {
        return create(viewGroup, params, size, null);
    }


}
