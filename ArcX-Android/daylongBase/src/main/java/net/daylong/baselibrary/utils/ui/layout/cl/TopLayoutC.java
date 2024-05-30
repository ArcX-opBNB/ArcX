package net.daylong.baselibrary.utils.ui.layout.cl;

import androidx.constraintlayout.widget.ConstraintLayout;

import net.daylong.baselibrary.utils.sys.AppUtil;

public class TopLayoutC {


    public static ConstraintLayout.LayoutParams topToBottom(ConstraintLayout.LayoutParams winLayoutParams, int toBottomId) {

        winLayoutParams.topToBottom = toBottomId;
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams top(ConstraintLayout.LayoutParams winLayoutParams, int toTopId) {

        winLayoutParams.topToTop = toTopId;
        return winLayoutParams;
    }


    public static ConstraintLayout.LayoutParams topMargin(ConstraintLayout.LayoutParams winLayoutParams, float topMargin) {
        return margin(winLayoutParams, topMargin);
    }

    public static ConstraintLayout.LayoutParams margin(ConstraintLayout.LayoutParams winLayoutParams, float topMargin) {

        winLayoutParams.topMargin = AppUtil.getSize(topMargin);
        return winLayoutParams;
    }


    public static ConstraintLayout.LayoutParams topToTop(ConstraintLayout.LayoutParams winLayoutParams, int toTopId) {
        return top(winLayoutParams, toTopId);
    }

    public static ConstraintLayout.LayoutParams top(ConstraintLayout.LayoutParams winLayoutParams) {
        return top(winLayoutParams, ConstraintLayout.LayoutParams.PARENT_ID);
    }

    public static ConstraintLayout.LayoutParams createTopToBottomCenterH(float w, float h, int toBottomId) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayoutUtils.centerH(winLayoutParams);
        return topToBottom(winLayoutParams, toBottomId);

    }

    public static ConstraintLayout.LayoutParams createTopToBottomMCenterH(float w, float h, int toBottomId, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayoutUtils.centerH(winLayoutParams);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        return topToBottom(winLayoutParams, toBottomId);
    }

    public static ConstraintLayout.LayoutParams createTopToBottomMCenterHWW(int toBottomId, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        ConstraintLayoutUtils.centerH(winLayoutParams);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        return topToBottom(winLayoutParams, toBottomId);

    }


    public static ConstraintLayout.LayoutParams createTopToTopMCenterHWW(int toTopId, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        ConstraintLayoutUtils.centerH(winLayoutParams);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        return topToTop(winLayoutParams, toTopId);
    }


    public static ConstraintLayout.LayoutParams createTopToBottomMCenterV(float w, float h, int toBottomId, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayoutUtils.centerV(winLayoutParams);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        return topToBottom(winLayoutParams, toBottomId);


    }


    public static ConstraintLayout.LayoutParams createTopMarginTopCenterH(float w, float h, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayoutUtils.centerH(winLayoutParams);
        top(winLayoutParams);

        return ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
    }

    public static ConstraintLayout.LayoutParams createTopToBottomLeftMarginTop(float w, float h, int toBottomId, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);

        LeftLayoutC.left(winLayoutParams);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        return topToBottom(winLayoutParams, toBottomId);
    }

    public static ConstraintLayout.LayoutParams topToBottomMMCenterH(int toBottomId) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        winLayoutParams.width = 0;
        winLayoutParams.height = 0;
        topToBottom(winLayoutParams, toBottomId);
        ConstraintLayoutUtils.center(winLayoutParams);
        winLayoutParams.topToTop = ConstraintLayout.LayoutParams.UNSET;

        ConstraintLayoutUtils.centerH(winLayoutParams);
        return topToBottom(winLayoutParams, toBottomId);

    }

    public static ConstraintLayout.LayoutParams topToBottomMWCenterH(int toBottomId, float topMargin) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        winLayoutParams.width = 0;
        winLayoutParams.height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        winLayoutParams.topMargin = AppUtil.getSize(topMargin);
        ConstraintLayoutUtils.centerH(winLayoutParams);
        return topToBottom(winLayoutParams, toBottomId);

    }

    public static ConstraintLayout.LayoutParams topToBottomWWCenterH(int toBottomId) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        winLayoutParams.width = 0;
        ConstraintLayoutUtils.centerH(winLayoutParams);
        return topToBottom(winLayoutParams, toBottomId);

    }

    public static ConstraintLayout.LayoutParams leftMarginLeftCenterVById(float w, float h, float marginLeft, int id) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayoutUtils.vh(winLayoutParams, id, id, null, id);
        return ConstraintLayoutUtils.marginLeft(winLayoutParams, marginLeft);

    }

    public static ConstraintLayout.LayoutParams leftMarginLeftCenterV(float w, float h, float marginLeft) {
        return leftMarginLeftCenterVById(w, h, marginLeft, ConstraintLayout.LayoutParams.PARENT_ID);

    }

    public static ConstraintLayout.LayoutParams leftMarginLeftCenterVWW(float marginLeft) {


        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        ConstraintLayoutUtils.vh(winLayoutParams, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID, null, ConstraintLayout.LayoutParams.PARENT_ID);
        return ConstraintLayoutUtils.marginLeft(winLayoutParams, marginLeft);

    }


    public static ConstraintLayout.LayoutParams leftCenterVByTopBottomId(float w, float h, int id) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        return ConstraintLayoutUtils.vh(winLayoutParams, ConstraintLayout.LayoutParams.PARENT_ID, id, null, id);

    }


    public static ConstraintLayout.LayoutParams topByBottom(ConstraintLayout.LayoutParams params, int id) {
        params.topToBottom = id;
        return params;
    }


    public static ConstraintLayout.LayoutParams centerV(ConstraintLayout.LayoutParams layoutParamsWW) {
        return ConstraintLayoutUtils.centerV(layoutParamsWW);
    }

    public static ConstraintLayout.LayoutParams centerH(ConstraintLayout.LayoutParams layoutParamsWW) {
        top(layoutParamsWW);
        return ConstraintLayoutUtils.centerH(layoutParamsWW);
    }


}
