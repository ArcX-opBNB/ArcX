package net.daylong.baselibrary.utils.ui.layout.cl;

import androidx.constraintlayout.widget.ConstraintLayout;

import net.daylong.baselibrary.utils.sys.AppUtil;

public class RightLayoutC {


    public static ConstraintLayout.LayoutParams right(ConstraintLayout.LayoutParams params) {

        return right(params, ConstraintLayout.LayoutParams.PARENT_ID);
    }

    public static ConstraintLayout.LayoutParams right(ConstraintLayout.LayoutParams params, int rightId) {

        params.rightToRight = rightId;
        return params;
    }

    public static ConstraintLayout.LayoutParams rightBottomMarginRB(ConstraintLayout.LayoutParams params, int rightId, int bottomId, int rightMargin, int bottomMargin) {
        params.rightToRight = rightId;
        params.bottomToBottom = bottomId;
        params.rightMargin = rightMargin;
        params.bottomMargin = bottomMargin;
        return params;
    }
    public static ConstraintLayout.LayoutParams rightBottomMarginRB(ConstraintLayout.LayoutParams params, int rightMargin, int bottomMargin) {
        return rightBottomMarginRB(params,ConstraintLayout.LayoutParams.PARENT_ID,ConstraintLayout.LayoutParams.PARENT_ID,rightMargin,bottomMargin);
    }

    public static ConstraintLayout.LayoutParams rightTop(ConstraintLayout.LayoutParams params, int rightId, int topId) {
        params.rightToRight = rightId;
        params.topToTop = topId;
        return params;
    }

    public static ConstraintLayout.LayoutParams rightTop(ConstraintLayout.LayoutParams params) {
        return rightTop(params, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID);
    }

    public static ConstraintLayout.LayoutParams rightMarginRightCenterVById(float w, float h, float marginRight, int id) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);

        winLayoutParams.leftToLeft = ConstraintLayout.LayoutParams.UNSET;
        ConstraintLayoutUtils.vh(winLayoutParams, null, id, id, id);
        right(winLayoutParams);
        return ConstraintLayoutUtils.marginRight(winLayoutParams, marginRight);


    }

    public static ConstraintLayout.LayoutParams createRightMarginRightCenterVById(float w, float h, float marginRight, int id) {
        return rightMarginRightCenterVById(w, h, marginRight, id);


    }

    public static ConstraintLayout.LayoutParams createRightCenterVByTopBottomId(float w, float h, int id) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        return ConstraintLayoutUtils.vh(winLayoutParams, null, id, ConstraintLayout.LayoutParams.PARENT_ID, id);

    }

    public static ConstraintLayout.LayoutParams createRightTopToBottomIdMarginTopRight(float w, float h, int id, float marginTop, float marginRight) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        ConstraintLayoutUtils.marginRight(winLayoutParams, marginRight);
        winLayoutParams.topToBottom = id;
        winLayoutParams.rightToRight = id;

        return winLayoutParams;

    }

    public static ConstraintLayout.LayoutParams createRightTopTopMargin(float w, float h, int rightAndTopId, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        rightTop(winLayoutParams, rightAndTopId, rightAndTopId);
        return ConstraintLayoutUtils.marginRight(winLayoutParams, marginTop);

    }

    public static ConstraintLayout.LayoutParams createRightTopRightMargin(float w, float h, int rightAndTopId, float marginRight) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        rightTop(winLayoutParams, rightAndTopId, rightAndTopId);
        return margin(winLayoutParams, marginRight);

    }

    public static ConstraintLayout.LayoutParams createRightCenterVById(float w, float h, int centerId, float marginRight) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        right(winLayoutParams);
        ConstraintLayoutUtils.centerV(winLayoutParams, centerId);

        return ConstraintLayoutUtils.marginRight(winLayoutParams, marginRight);

    }

    public static ConstraintLayout.LayoutParams createRightCenterV(float w, float h, float marginTop, float marginRight) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        right(winLayoutParams);
        ConstraintLayoutUtils.centerV(winLayoutParams);
        TopLayoutC.margin(winLayoutParams, marginTop);
        return ConstraintLayoutUtils.marginRight(winLayoutParams, marginRight);

    }

    public static ConstraintLayout.LayoutParams createRightCenterV(float size, float marginTop, float marginRight) {
        return createRightCenterV(size, size, marginTop, marginRight);
    }

    public static ConstraintLayout.LayoutParams createRightTopTopMarginWW(int rightAndTopId, float marginRight) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        rightTop(winLayoutParams, rightAndTopId, rightAndTopId);
        return ConstraintLayoutUtils.marginRight(winLayoutParams, marginRight);

    }

    public static ConstraintLayout.LayoutParams createLeftToLeftMarginBottom(float w, float h, int rightId, int bottomId, float marginBottom) {
        ConstraintLayout.LayoutParams layoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        right(layoutParams, rightId);
        ConstraintLayoutUtils.marginBottom(layoutParams, marginBottom);


        return BottomLayoutC.bottomToBottom(layoutParams, bottomId);

    }


    public static ConstraintLayout.LayoutParams rightMargin(ConstraintLayout.LayoutParams winLayoutParams, float margin) {

        return margin(winLayoutParams, margin);
    }

    public static ConstraintLayout.LayoutParams margin(ConstraintLayout.LayoutParams winLayoutParams, float margin) {

        winLayoutParams.rightMargin = AppUtil.getSize(margin);
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams rightToLeft(ConstraintLayout.LayoutParams winLayoutParams, int rightId) {
        winLayoutParams.rightToLeft = rightId;
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams createRightTopMarginTR(int size, float marginTop, float marginRight) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(size);

        right(winLayoutParams);
        CLayoutTop.topToTop(winLayoutParams);
        ConstraintLayoutUtils.margin(winLayoutParams, null, marginTop, marginRight, null);
        return winLayoutParams;
    }


}
