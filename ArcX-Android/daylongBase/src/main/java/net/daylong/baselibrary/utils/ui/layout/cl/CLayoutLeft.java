package net.daylong.baselibrary.utils.ui.layout.cl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;

import net.daylong.baselibrary.utils.sys.AppUtil;

/**

 */
public class CLayoutLeft {

    /**

     *
     * @param params
     * @return
     */
    public static ConstraintLayout.LayoutParams top(ConstraintLayout.LayoutParams params, Integer left, Integer top, Integer right, Integer bottom) {
        return ConstraintLayoutUtils.vh(params, left, top, right, bottom);
    }

    /**

     *
     * @param params
     * @return
     */
    public static ConstraintLayout.LayoutParams centerH(ConstraintLayout.LayoutParams params) {
        return ConstraintLayoutUtils.centerH(params);
    }

    public static ConstraintLayout.LayoutParams margin(ConstraintLayout.LayoutParams winLayoutParams, float topMargin) {

        winLayoutParams.leftMargin = AppUtil.getSize(topMargin);
        return winLayoutParams;
    }

    /**

     *
     * @param params
     * @return
     */
    public static ConstraintLayout.LayoutParams leftToLeft(ConstraintLayout.LayoutParams params) {
        params.leftToLeft = Constraints.LayoutParams.PARENT_ID;
        return params;

    }


    /**

     *
     * @param params
     * @return
     */
    public static ConstraintLayout.LayoutParams leftToLeftId(ConstraintLayout.LayoutParams params, int toLId) {
        params.leftToLeft = toLId;
        return params;

    }

    /**

     *
     * @param params
     * @return
     */
    public static ConstraintLayout.LayoutParams leftTop(ConstraintLayout.LayoutParams params) {
        params.leftToLeft = Constraints.LayoutParams.PARENT_ID;
        params.topToTop = Constraints.LayoutParams.PARENT_ID;
        return params;

    }

    /**

     *
     * @param params
     * @return
     */
    public static ConstraintLayout.LayoutParams leftTop(ConstraintLayout.LayoutParams params, int leftId, int topId) {
        params.leftToLeft = leftId;
        params.topToTop = topId;
        return params;

    }

    /**

     *
     * @param params
     * @return
     */
    public static ConstraintLayout.LayoutParams leftTop(ConstraintLayout.LayoutParams params, int leftId) {
        return leftTop(params, leftId, Constraints.LayoutParams.PARENT_ID);

    }

    /**

     *
     * @param params


     * @return
     */
    public static ConstraintLayout.LayoutParams leftTopAndTopMargin(ConstraintLayout.LayoutParams params, int leftId, float topMargin) {
        ConstraintLayout.LayoutParams layoutParams = leftTop(params, leftId, Constraints.LayoutParams.PARENT_ID);
        layoutParams.topMargin = AppUtil.getSize(topMargin);
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams leftVerticalCenter(ConstraintLayout.LayoutParams params) {

        return leftVerticalCenterById(params, Constraints.LayoutParams.PARENT_ID);
    }

    public static ConstraintLayout.LayoutParams leftVerticalCenterToLeft(ConstraintLayout.LayoutParams params, int leftId) {
        leftVerticalCenter(params).leftToLeft = leftId;
        return params;
    }

    public static ConstraintLayout.LayoutParams leftVerticalCenterById(ConstraintLayout.LayoutParams params, int id) {
        params.leftToLeft = id;
        params.topToTop = id;
        params.bottomToBottom = id;
        return params;
    }


    /**

     *
     * @param params


     * @return
     */
    public static ConstraintLayout.LayoutParams leftToRightTopAndTopMargin(ConstraintLayout.LayoutParams params, int toRightId, float topMargin) {
        leftToRightId(params, toRightId);
        CLayoutTop.topToTop(params);
        params.topMargin = AppUtil.getSize(topMargin);
        return params;
    }

    /**

     *
     * @param params


     * @return
     */
    public static ConstraintLayout.LayoutParams leftToRightTopToBottomAndTopMargin(ConstraintLayout.LayoutParams params, int toRightId, int toBottomId, float topMargin) {
        leftToRightId(params, toRightId);
        CLayoutTop.topToBottom(params, toBottomId);
        params.topMargin = AppUtil.getSize(topMargin);
        return params;
    }


    /**

     *
     * @param params
     * @param toRId
     * @return
     */
    public static ConstraintLayout.LayoutParams leftToRightId(ConstraintLayout.LayoutParams params, int toRId) {
        params.leftToRight = toRId;
        return params;
    }


    /**


     *
     * @param params

     * @return
     */
    public static ConstraintLayout.LayoutParams leftToRightIdTopParent(ConstraintLayout.LayoutParams params, int toRightId) {
        params.leftToRight = toRightId;
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return params;
    }

    /**


     *
     * @param params

     * @return
     */
    public static ConstraintLayout.LayoutParams leftToRightIdTopToTop(ConstraintLayout.LayoutParams params, int toRightId, int toTopId) {
        params.leftToRight = toRightId;
        params.topToTop = toTopId;
        return params;
    }


    public static ConstraintLayout.LayoutParams leftTopRight(ConstraintLayout.LayoutParams params) {
        params.leftToLeft = Constraints.LayoutParams.PARENT_ID;
        params.topToTop = Constraints.LayoutParams.PARENT_ID;
        params.rightToRight = Constraints.LayoutParams.PARENT_ID;
        return params;
    }


    public static ConstraintLayout.LayoutParams leftTopRight(ConstraintLayout.LayoutParams params, int leftId, int topId, int rightId) {
        params.leftToLeft = leftId;
        params.topToTop = topId;
        params.rightToRight = rightId;
        return params;
    }
    //

    public static ConstraintLayout.LayoutParams leftTopBottom(ConstraintLayout.LayoutParams params) {
        params.leftToLeft = Constraints.LayoutParams.PARENT_ID;
        params.topToTop = Constraints.LayoutParams.PARENT_ID;
        params.bottomToBottom = Constraints.LayoutParams.PARENT_ID;
        return params;
    }


    public static ConstraintLayout.LayoutParams leftTopBottom(ConstraintLayout.LayoutParams params, int leftId, int topId, int bottomId) {
        params.leftToLeft = leftId;
        params.topToTop = topId;
        params.bottomToBottom = bottomId;
        return params;
    }


    //-------------------------------------------


    public static ConstraintLayout.LayoutParams createLeftTop(float w, float h) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        return leftTop(winLayoutParams);
    }


    public static ConstraintLayout.LayoutParams createLeftToRightIdAndTopToTopId(int size, int toRightId, int toTopId) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(size);
        return leftToRightIdTopToTop(winLayoutParams, toRightId, toTopId);
    }

    public static ConstraintLayout.LayoutParams createLeftToRightIdAndTopToTopId(float w, float h, int toRightId, int toTopId) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        return leftToRightIdTopToTop(winLayoutParams, toRightId, toTopId);

    }


    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createLeftTopRight(float wight, float height) {
        return leftTopRight(ConstraintLayoutUtils.getWinLayoutParams(wight, height));
    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createLeftTopBottom(float wight, float height) {
        return leftTopRight(ConstraintLayoutUtils.getWinLayoutParams(wight, height));
    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createLeftTopBottom(float size) {
        return leftTopRight(ConstraintLayoutUtils.getWinLayoutParams(size));
    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createCenterV(float size) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(size);
        ConstraintLayout.LayoutParams layoutParams = ConstraintLayoutUtils.centerV(winLayoutParams);
        return leftTop(layoutParams);
    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createCenterV(float w, float h) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayout.LayoutParams layoutParams = ConstraintLayoutUtils.centerV(winLayoutParams);
        return leftTop(layoutParams);
    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createCenter(float w, float h) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayout.LayoutParams layoutParams = ConstraintLayoutUtils.center(winLayoutParams);
        return layoutParams;
    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createCenterH(float w, float h) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        return ConstraintLayoutUtils.centerH(winLayoutParams);
    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createCenterHById(float w, float h, int id, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);

        ConstraintLayoutUtils.vh(winLayoutParams, id, ConstraintLayout.LayoutParams.PARENT_ID, id, null);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        return winLayoutParams;
    }

    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createCenterV(float w, float h, float marginLeft) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayout.LayoutParams layoutParams = ConstraintLayoutUtils.centerV(winLayoutParams);
        ConstraintLayoutUtils.marginLeft(winLayoutParams, marginLeft);
        return leftTop(layoutParams);
    }


    /**

     *
     * @param w
     * @param h
     * @param marginTop
     * @return
     */
    public static ConstraintLayout.LayoutParams createMarginTopCenterH(float w, float h, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayoutUtils.centerH(winLayoutParams);
        CLayoutTop.topToTop(winLayoutParams);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);

        return winLayoutParams;
    }


    public static ConstraintLayout.LayoutParams createLeftToRightRightToLeftWWV(int toRightId, int toLeftId) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        winLayoutParams.width = 0;
        winLayoutParams.height = 0;
        winLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        winLayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;

        leftToRightId(winLayoutParams, toRightId);
        CLayoutRight.rightToLeft(winLayoutParams, toLeftId);

        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams createMWH() {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        winLayoutParams.width = 0;
        winLayoutParams.height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        winLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        leftToLeft(winLayoutParams);
        CLayoutRight.rightToRight(winLayoutParams);

        return winLayoutParams;


    }

    public static ConstraintLayout.LayoutParams createLeftTopMarginTop(int size, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(size);

        leftToLeft(winLayoutParams);
        CLayoutTop.topToTop(winLayoutParams);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams createLeftTopMarginLeftTop(float w, float h, float marginLeft, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);

        leftToLeft(winLayoutParams);
        CLayoutTop.topToTop(winLayoutParams);
        ConstraintLayoutUtils.margin(winLayoutParams, marginLeft, marginTop, null, null);
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams createLeftTopMarginTop(int size, float marginLeft, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(size);

        leftToLeft(winLayoutParams);
        CLayoutTop.topToTop(winLayoutParams);
        ConstraintLayoutUtils.margin(winLayoutParams, marginLeft, marginTop, null, null);
        return winLayoutParams;
    }


}
