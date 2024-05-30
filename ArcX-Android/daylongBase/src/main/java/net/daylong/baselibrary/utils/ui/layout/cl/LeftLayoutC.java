package net.daylong.baselibrary.utils.ui.layout.cl;

import androidx.constraintlayout.widget.ConstraintLayout;

import net.daylong.baselibrary.utils.sys.AppUtil;

public class LeftLayoutC {


    public static ConstraintLayout.LayoutParams left(ConstraintLayout.LayoutParams winLayoutParams) {
        winLayoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams leftMargin(ConstraintLayout.LayoutParams winLayoutParams, float leftMargin) {
        winLayoutParams.leftMargin = AppUtil.getSize(leftMargin);
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams margin(ConstraintLayout.LayoutParams winLayoutParams, float leftMargin) {
        winLayoutParams.leftMargin = AppUtil.getSize(leftMargin);
        return winLayoutParams;
    }

    public static ConstraintLayout.LayoutParams leftTop(ConstraintLayout.LayoutParams params) {
        return leftTop(params, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID);

    }

    public static ConstraintLayout.LayoutParams leftButton(ConstraintLayout.LayoutParams params) {
        left(params);
        return BottomLayoutC.bottom(params);

    }

    public static ConstraintLayout.LayoutParams leftTop(ConstraintLayout.LayoutParams params, int leftId, int topId) {
        return ConstraintLayoutUtils.vh(params, leftId, topId, null, null);

    }

    public static ConstraintLayout.LayoutParams leftToLeft(ConstraintLayout.LayoutParams params, int leftId) {
        params.leftToLeft = leftId;
        return params;
    }

    public static ConstraintLayout.LayoutParams left(ConstraintLayout.LayoutParams params, int leftId) {
        params.leftToLeft = leftId;
        return params;

    }

    public static ConstraintLayout.LayoutParams leftToRight(ConstraintLayout.LayoutParams params) {
        return leftToRight(params, ConstraintLayout.LayoutParams.PARENT_ID);
    }

    public static ConstraintLayout.LayoutParams leftToRight(ConstraintLayout.LayoutParams params, int rightId) {
        params.leftToRight = rightId;
        return params;
    }


    ;


    public static ConstraintLayout.LayoutParams centerVById(ConstraintLayout.LayoutParams params, int id) {
        params.topToTop = id;
        params.bottomToBottom = id;
        return params;

    }
    public static ConstraintLayout.LayoutParams centerH(ConstraintLayout.LayoutParams params) {
        params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        params.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        return params;

    }

    public static ConstraintLayout.LayoutParams leftTopLeftMargin(ConstraintLayout.LayoutParams params, float leftMargin) {
        ConstraintLayout.LayoutParams layoutParams = leftTop(params);
        layoutParams.leftMargin = AppUtil.getSize(leftMargin);
        return layoutParams;

    }


    public static ConstraintLayout.LayoutParams leftTopLeftTopMargin(ConstraintLayout.LayoutParams params, float leftMargin, float topMargin) {
        ConstraintLayout.LayoutParams layoutParams = leftTop(params);
        layoutParams.leftMargin = AppUtil.getSize(leftMargin);
        layoutParams.topMargin = AppUtil.getSize(topMargin);
        return layoutParams;

    }

    public static ConstraintLayout.LayoutParams leftTopToBottom(ConstraintLayout.LayoutParams params, int toBottomId) {
        ConstraintLayoutUtils.vh(params, ConstraintLayout.LayoutParams.PARENT_ID, null, null, null).topToBottom = toBottomId;
        return params;
    }


    public static ConstraintLayout.LayoutParams getLeftTopToBottom(float w, float h, int toBottomId) {
        return leftTopToBottom(ConstraintLayoutUtils.getWinLayoutParams(w, h), toBottomId);

    }

    public static ConstraintLayout.LayoutParams getLeftTopToBottomMarginLeft(float w, float h, int toBottomId, float marginLeft) {
        ConstraintLayout.LayoutParams layoutParams = leftTopToBottom(ConstraintLayoutUtils.getWinLayoutParams(w, h), toBottomId);
        return ConstraintLayoutUtils.marginLeft(layoutParams, marginLeft);

    }

    public static ConstraintLayout.LayoutParams getLeftTopToBottomMarginLeftTop(float w, float h, int toBottomId, float marginLeft, float marginTop) {
        return ConstraintLayoutUtils.marginTop(getLeftTopToBottomMarginLeft(w, h, toBottomId, marginLeft), marginTop);

    }


    public static ConstraintLayout.LayoutParams TopCreateMarginTopH(int w, int h, float marginTop) {

        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        winLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        ConstraintLayoutUtils.centerH(winLayoutParams);
        return ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
    }

    public static ConstraintLayout.LayoutParams leftMarginLeftCenterV(ConstraintLayout.LayoutParams winLayoutParams, float marginLeft) {
        winLayoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        ConstraintLayoutUtils.centerV(winLayoutParams);
        return ConstraintLayoutUtils.marginLeft(winLayoutParams, marginLeft);
    }


    public static ConstraintLayout.LayoutParams createLeftMarginLeftCenterV(int w, int h, float marginLeft) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getWinLayoutParams(w, h);
        ConstraintLayoutUtils.centerV(winLayoutParams);
        winLayoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        return ConstraintLayoutUtils.marginLeft(winLayoutParams, marginLeft);
    }


    private static ConstraintLayout.LayoutParams getLayoutParams(float w, float h) {
        return ConstraintLayoutUtils.getWinLayoutParams(w, h);
    }

    private static ConstraintLayout.LayoutParams getLayoutParamsM(float h) {
        return new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, AppUtil.getSize(h));
    }

    public static ConstraintLayout.LayoutParams createLeftToLeftMarginLeftCenterVById(int w, int h, int toLeftVId, float marginLeft) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParams(w, h);
        leftToLeft(layoutParams, toLeftVId);
        centerVById(layoutParams, toLeftVId);
        return ConstraintLayoutUtils.marginLeft(layoutParams, marginLeft);

    }

    public static ConstraintLayout.LayoutParams createLToRAndRtoRCenterVById(int w, int h, int lToRId, int rToRId, int vId) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParams(w, h);
        leftToRight(layoutParams, lToRId);
        centerVById(layoutParams, vId);
        return RightLayoutC.right(layoutParams, rToRId);

    }

    public static ConstraintLayout.LayoutParams createLeftTopTopMargin(float w, float h, float topMargin) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParams(w, h);
        leftTop(layoutParams);
        return ConstraintLayoutUtils.marginTop(layoutParams, topMargin);

    }

    public static ConstraintLayout.LayoutParams createLeftTopLeftTopMargin(int w, int h, float topMargin, float marginLeft) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParams(w, h);
        leftTop(layoutParams);
        ConstraintLayoutUtils.marginTop(layoutParams, topMargin);
        return ConstraintLayoutUtils.marginLeft(layoutParams, marginLeft);

    }


    public static ConstraintLayout.LayoutParams createLeftTopLeftTopMarginWW(float marginLeft, float topMargin) {
        ConstraintLayout.LayoutParams layoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        leftTop(layoutParams);
        ConstraintLayoutUtils.marginTop(layoutParams, topMargin);
        return ConstraintLayoutUtils.marginLeft(layoutParams, marginLeft);

    }

    public static ConstraintLayout.LayoutParams leftTopTopMargin(ConstraintLayout.LayoutParams layoutParams, int w, int h, float topMargin) {

        layoutParams.width = w;
        layoutParams.height = h;
        leftTop(layoutParams);
        return ConstraintLayoutUtils.marginTop(layoutParams, topMargin);

    }

    public static ConstraintLayout.LayoutParams createLeftTopTopMarginM(int h) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParamsM(h);
        return leftTop(layoutParams);

    }

    public static ConstraintLayout.LayoutParams createLeftToLeftMarginBottom(float w, float h, int leftId, int bottomId, float marginBottom) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParams(w, h);
        leftToLeft(layoutParams, leftId);

        ConstraintLayoutUtils.marginBottom(layoutParams, marginBottom);


        return BottomLayoutC.bottomToBottom(layoutParams, bottomId);

    }


    public static ConstraintLayout.LayoutParams createLeftTopTopMargin(int w, int h, int leftAndTopId, float topMargin) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParams(w, h);
        leftTop(layoutParams, leftAndTopId, leftAndTopId);
        return ConstraintLayoutUtils.marginTop(layoutParams, topMargin);

    }

    public static ConstraintLayout.LayoutParams createLeftTopToBottomMarginLeftTopWW(int toBottomId, float marginLeft, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsWW();
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        left(winLayoutParams);
        ConstraintLayoutUtils.marginLeft(winLayoutParams, marginLeft);


        return TopLayoutC.topToBottom(winLayoutParams, toBottomId);
    }

    public static ConstraintLayout.LayoutParams createLeftTopToBottomByIdMarginTop(float w, int toBottomId, float marginTop) {
        ConstraintLayout.LayoutParams winLayoutParams = ConstraintLayoutUtils.getLayoutParamsH(w);
        left(winLayoutParams);
        ConstraintLayoutUtils.marginTop(winLayoutParams, marginTop);
        return TopLayoutC.topToBottom(winLayoutParams, toBottomId);
    }


}
