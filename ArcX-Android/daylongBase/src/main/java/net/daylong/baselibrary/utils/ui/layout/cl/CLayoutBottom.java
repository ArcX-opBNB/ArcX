package net.daylong.baselibrary.utils.ui.layout.cl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;

/**

 */
public class CLayoutBottom {


    public static ConstraintLayout.LayoutParams createBTB(ConstraintLayout.LayoutParams params) {
        params.bottomToBottom = Constraints.LayoutParams.PARENT_ID;
        return params;

    }

    public static ConstraintLayout.LayoutParams bottomToBottom(ConstraintLayout.LayoutParams params) {
        params.bottomToBottom = Constraints.LayoutParams.PARENT_ID;
        return params;

    }

    public static ConstraintLayout.LayoutParams createBTT(ConstraintLayout.LayoutParams params, int toTId) {
        params.bottomToTop = toTId;
        return params;
    }


    public static ConstraintLayout.LayoutParams createBottomCenterH(int w, int h, float marginBottom) {

        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayoutUtils.centerH(winLayoutParams);
        ConstraintLayoutUtils.marginBottom(winLayoutParams, marginBottom);
        bottomToBottom(winLayoutParams);
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams createBottomCenterMWH(float marginBottom) {

        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsMW();
        winLayoutParams.width=0;
        ConstraintLayoutUtils.centerH(winLayoutParams);
        ConstraintLayoutUtils.marginBottom(winLayoutParams, marginBottom);
        bottomToBottom(winLayoutParams);
        return winLayoutParams;
    }
}
