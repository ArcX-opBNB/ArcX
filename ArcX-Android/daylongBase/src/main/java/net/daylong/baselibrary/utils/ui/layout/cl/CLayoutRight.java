package net.daylong.baselibrary.utils.ui.layout.cl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;

import net.daylong.baselibrary.utils.sys.AppUtil;

/**

 */
public class CLayoutRight {


    public static ConstraintLayout.LayoutParams rightToRight(ConstraintLayout.LayoutParams params) {
        params.rightToRight = Constraints.LayoutParams.PARENT_ID;
        return params;

    }

    public static ConstraintLayout.LayoutParams rightToLeft(ConstraintLayout.LayoutParams params, int toLId) {
        params.rightToLeft = toLId;
        return params;
    }

    /**

     *
     * @param params

     * @return
     */
    public static ConstraintLayout.LayoutParams rightCenterRightMarginV(ConstraintLayout.LayoutParams params, float rightMargin) {
        params.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        if (rightMargin > 0) {
            params.rightMargin = AppUtil.getSize(rightMargin);
        }
        return rightToRightCenterRightMarginV(params, ConstraintLayout.LayoutParams.PARENT_ID, 0);
    }

    /**

     *
     * @param params


     * @return
     */
    public static ConstraintLayout.LayoutParams rightToRightCenterRightMarginV(ConstraintLayout.LayoutParams params, int toLId, float rightMargin) {
        ConstraintLayoutUtils.vh(params, null, ConstraintLayout.LayoutParams.PARENT_ID, toLId, ConstraintLayout.LayoutParams.PARENT_ID);
        if (rightMargin > 0) {
            params.rightMargin = AppUtil.getSize(rightMargin);
        }
        return params;
    }


    public static ConstraintLayout.LayoutParams createRightToRightCenterV(float w, float h, float rightMargin) {

        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        rightToRight(winLayoutParams);
        ConstraintLayoutUtils.centerV(winLayoutParams);
        ConstraintLayoutUtils.marginRight(winLayoutParams, rightMargin);
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams createRightRightMargin(float w, float h, float marginTop, float rightMargin) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        rightToRight(winLayoutParams);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        ConstraintLayoutUtils.marginRight(winLayoutParams, rightMargin);
        return winLayoutParams;
    }

}
