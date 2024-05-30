package net.daylong.baselibrary.utils.ui.layout.cl;

import androidx.constraintlayout.widget.ConstraintLayout;

import net.daylong.baselibrary.utils.sys.AppUtil;

public class BottomLayoutC {


    public static ConstraintLayout.LayoutParams bottomToBottom(ConstraintLayout.LayoutParams winLayoutParams) {
        return bottomToBottom(winLayoutParams, ConstraintLayout.LayoutParams.PARENT_ID);
    }

    public static ConstraintLayout.LayoutParams bottomToBottom(ConstraintLayout.LayoutParams winLayoutParams, int toBottomId) {

        winLayoutParams.bottomToBottom = toBottomId;
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams bottomToTop(ConstraintLayout.LayoutParams winLayoutParams, int toTopId) {

        winLayoutParams.bottomToTop = toTopId;
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams bottom(ConstraintLayout.LayoutParams winLayoutParams) {
        return bottom(winLayoutParams, ConstraintLayout.LayoutParams.PARENT_ID);
    }


    public static ConstraintLayout.LayoutParams bottom(ConstraintLayout.LayoutParams winLayoutParams, int toBottomId) {
        winLayoutParams.bottomToBottom = toBottomId;
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams bottomCenterH(ConstraintLayout.LayoutParams winLayoutParams) {
        bottom(winLayoutParams);
        winLayoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        winLayoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams bottomBottomMarginCenterH(ConstraintLayout.LayoutParams winLayoutParams, int bottomMargin) {
        winLayoutParams.bottomMargin = bottomMargin;
        return bottomCenterH(winLayoutParams);
    }

    public static ConstraintLayout.LayoutParams createBottomLeft(float w, float h) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        LeftLayoutC.left(winLayoutParams);
        return bottom(winLayoutParams);

    }

    public static void bottomMargin(ConstraintLayout.LayoutParams winLayoutParams, float bottomMargin) {
        margin(winLayoutParams,bottomMargin);
    }

    public static void margin(ConstraintLayout.LayoutParams winLayoutParams, float bottomMargin) {

        winLayoutParams.bottomMargin = AppUtil.getSize(bottomMargin);

    }

    public static ConstraintLayout.LayoutParams createBottomLeftWW(float leftMargin, float bottomMargin) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        LeftLayoutC.left(winLayoutParams);

        LeftLayoutC.leftMargin(winLayoutParams, leftMargin);
        bottomMargin(winLayoutParams, bottomMargin);
        return bottom(winLayoutParams);

    }


}
