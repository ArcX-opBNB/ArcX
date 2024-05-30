package net.daylong.baselibrary.utils.ui.layout.ll;

import android.widget.LinearLayout;

import net.daylong.baselibrary.utils.sys.AppUtil;

public class LinearLayoutUtils {

    public static LinearLayout.LayoutParams createLineLayoutWW() {
        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    public static LinearLayout.LayoutParams createLineLayoutMW() {
        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }


    public static LinearLayout.LayoutParams createLineLayoutTopMarginWW(float topMargin) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        layoutParams.topMargin = size(topMargin);
        return layoutParams;

    }

    public static LinearLayout.LayoutParams createLineLayout(float w, float h) {
        return new LinearLayout.LayoutParams(AppUtil.getSize(w), AppUtil.getSize(h));
    }

    public static LinearLayout.LayoutParams createLineLayout(int size) {
        return new LinearLayout.LayoutParams(AppUtil.getSize(size), AppUtil.getSize(size));
    }

    public static LinearLayout.LayoutParams createLineLayoutTopMargin(int size, float topMargin) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(AppUtil.getSize(size), AppUtil.getSize(size));

        layoutParams.topMargin = size(topMargin);
        return layoutParams;
    }

    private static int size(float size) {

        return AppUtil.getSize(size);
    }
}
