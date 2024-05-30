package net.daylong.baselibrary.utils.ui.layout.cl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;

/**

 */
public class CLayoutTop {

    public static ConstraintLayout.LayoutParams top(ConstraintLayout.LayoutParams params, Integer left, Integer top, Integer right, Integer bottom) {
        return ConstraintLayoutUtils.vh(params, left, top, right, bottom);
    }


    public static ConstraintLayout.LayoutParams rightCenter(ConstraintLayout.LayoutParams params) {
        return top(params, null, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID);
    }

    public static ConstraintLayout.LayoutParams topRight(ConstraintLayout.LayoutParams params) {
        return top(params, null, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID, null);
    }


    private static ConstraintLayout.LayoutParams topCenterH(ConstraintLayout.LayoutParams params) {
        return ConstraintLayoutUtils.centerH(params);
    }

    public static ConstraintLayout.LayoutParams topToTop(ConstraintLayout.LayoutParams params) {
        params.topToTop = Constraints.LayoutParams.PARENT_ID;
        return params;

    }

    public static ConstraintLayout.LayoutParams topToBottom(ConstraintLayout.LayoutParams params, int toBId) {
        params.topToBottom = toBId;
        return params;
    }

    public static ConstraintLayout.LayoutParams topToTopCenterH(ConstraintLayout.LayoutParams params, int toTId) {
        params.topToTop = toTId;
        centerH(params);
        return params;
    }

    public static ConstraintLayout.LayoutParams topToTopMarginTopCenterH(ConstraintLayout.LayoutParams params, int toTId, float marginTop) {
        params.topToTop = toTId;
        ConstraintLayoutUtils.marginTop(params, marginTop);
        centerH(params);
        return params;
    }

    public static ConstraintLayout.LayoutParams topToBottomMarginTopCenterH(ConstraintLayout.LayoutParams params, int bottomId, float marginTop) {

        centerH(params);
        topToBottom(params, bottomId);
        ConstraintLayoutUtils.marginTop(params, marginTop);

        return params;
    }


    //---------------------

    public static ConstraintLayout.LayoutParams createTopTpBottom(int toBottomId) {

        ConstraintLayout.LayoutParams layoutParamsWW = ConstraintLayoutUtils.getLayoutParamsWW();
        CLayoutLeft.leftToLeft(layoutParamsWW);
        CLayoutRight.rightToRight(layoutParamsWW);
        layoutParamsWW.topToBottom = toBottomId;

        return layoutParamsWW;

    }

    public static ConstraintLayout.LayoutParams createTopToBottomMarginTopCenterH(float size, int toBottomId, float marginTop) {
        return topToBottomMarginTopCenterH(ConstraintLayoutUtils.getWinLayoutParams(size), toBottomId, marginTop);

    }

    public static ConstraintLayout.LayoutParams createTopToBottomMarginTopCenterH(float w, float h, int toBottomId, float marginTop) {
        return topToBottomMarginTopCenterH(ConstraintLayoutUtils.getWinLayoutParams(w, h), toBottomId, marginTop);

    }

    public static ConstraintLayout.LayoutParams createTopToBottomMarginTopCenterHWW(int toBottomId, float marginTop) {
        return topToBottomMarginTopCenterH(ConstraintLayoutUtils.getLayoutParamsWW(), toBottomId, marginTop);

    }

    public static ConstraintLayout.LayoutParams createTopToTopCenterH(int toTopId) {
        return topToTopCenterH(ConstraintLayoutUtils.getLayoutParamsWW(), toTopId);
    }

    public static ConstraintLayout.LayoutParams topToTopMarginTopCenterH(int toTopId, float marginTop) {
        return topToTopMarginTopCenterH(ConstraintLayoutUtils.getLayoutParamsWW(), toTopId, marginTop);

    }

    public static ConstraintLayout.LayoutParams topToTopMarginTopCenterH(float w, float h, int toTopId, float marginTop) {
        return topToTopMarginTopCenterH(ConstraintLayoutUtils.getWinLayoutParams(w, h), toTopId, marginTop);

    }


    /**

     *
     * @param params
     * @return
     */
    public static ConstraintLayout.LayoutParams topRightMarginTopAndRight(ConstraintLayout.LayoutParams params, float topMargin, float rightMargin) {

        topRight(params);
        ConstraintLayoutUtils.marginTopRight(params, topMargin, rightMargin);
        return params;

    }


    //--------------------------------------

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createCenter(ConstraintLayout.LayoutParams params) {
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        return params;

    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams centerH(ConstraintLayout.LayoutParams params) {
        return ConstraintLayoutUtils.centerH(params);

    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createTopRightMarginTopAndRight(float size, float topMargin, float rightMargin) {


        return topRightMarginTopAndRight(ConstraintLayoutUtils.getWinLayoutParams(size), topMargin, rightMargin);

    }


    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createCenterToId(ConstraintLayout.LayoutParams params, int toId) {
        params.topToTop = toId;
        params.bottomToBottom = toId;
        return params;

    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createTopToBottomCenterH(ConstraintLayout.LayoutParams params, int toBottomId) {
        //topCenterH(params);
        topToBottom(params, toBottomId);
        topCenterH(params);
        return params;

    }


    public static ConstraintLayout.LayoutParams createTopRightRightMargin(float size, float marginTop, float rightMargin) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(size);
        topToTop(winLayoutParams);
        CLayoutRight.rightToRight(winLayoutParams);
        ConstraintLayoutUtils.margin(winLayoutParams, null, marginTop, rightMargin, null);
        return winLayoutParams;
    }    public static ConstraintLayout.LayoutParams createTopRightRightMargin(float w,float h, float marginTop, float rightMargin) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w,h);
        topToTop(winLayoutParams);
        CLayoutRight.rightToRight(winLayoutParams);
        ConstraintLayoutUtils.margin(winLayoutParams, null, marginTop, rightMargin, null);
        return winLayoutParams;
    }

}
