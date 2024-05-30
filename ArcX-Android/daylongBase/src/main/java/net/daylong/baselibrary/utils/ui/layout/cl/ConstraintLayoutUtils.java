package net.daylong.baselibrary.utils.ui.layout.cl;

import android.content.Context;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import net.daylong.baselibrary.utils.sys.AppUtil;


public class ConstraintLayoutUtils {


    public static ConstraintLayout createMM(Context context) {
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(getLayoutParamsMM());
        return constraintLayout;
    }

    public static ViewGroup.LayoutParams size(ConstraintLayout.LayoutParams params, float w, float h) {
        params.width = AppUtil.getSize(w);
        params.height = AppUtil.getSize(h);
        return params;
    }

    public static ConstraintLayout createMM() {
        ConstraintLayout constraintLayout = new ConstraintLayout(AppUtil.getContext());
        constraintLayout.setLayoutParams(getLayoutParamsMM());
        return constraintLayout;
    }

    public static ConstraintLayout createM(float hei) {
        ConstraintLayout constraintLayout = new ConstraintLayout(AppUtil.getContext());
        constraintLayout.setLayoutParams(getLayoutParamsM(hei));
        return constraintLayout;
    }

    public static ConstraintLayout create(float w, float h) {
        ConstraintLayout constraintLayout = new ConstraintLayout(AppUtil.getContext());
        constraintLayout.setLayoutParams(getWinLayoutParams(w, h));
        return constraintLayout;
    }

    public static ConstraintLayout create(ConstraintLayout.LayoutParams params) {
        ConstraintLayout constraintLayout = new ConstraintLayout(AppUtil.getContext());
        constraintLayout.setLayoutParams(params);
        return constraintLayout;
    }


    /**

     *


     * @param topMargin mar
     * @return
     */
    public static ConstraintLayout.LayoutParams createHeightLeftTopAndTopMargin(float height, int leftId, float topMargin) {
        return CLayoutLeft.leftTopAndTopMargin(ConstraintLayoutUtils.getLayoutParamsW(height), leftId, topMargin);
    }

    /**

     *


     * @param topMargin mar
     * @return
     */
    public static ConstraintLayout.LayoutParams createHeightLeftToRightTopAndTopMargin(float height, int toRightId, float topMargin) {
        return CLayoutLeft.leftToRightTopAndTopMargin(ConstraintLayoutUtils.getLayoutParamsW(height), toRightId, topMargin);
    }


    /**

     *

     * @param topMargin mar
     * @return
     */
    public static ConstraintLayout.LayoutParams createLeftToRightTopToBottomAndTopMargin(float size, int toRightId, int toBottomId, float topMargin) {
        return CLayoutLeft.leftToRightTopToBottomAndTopMargin(ConstraintLayoutUtils.getWinLayoutParams(size), toRightId, toBottomId, topMargin);
    }


    public static ConstraintLayout.LayoutParams getWinLayoutParams(float size) {
        return getWinLayoutParams(size, size);
    }


    public static ConstraintLayout.LayoutParams getWinLayoutParams(float wight, float height) {
        return getLayoutParams(wight, height);

    }

    public static ConstraintLayout.LayoutParams getLayoutParams(float wight, float height) {
        return new ConstraintLayout.LayoutParams(AppUtil.getSize(wight), AppUtil.getSize(height));

    }

    public static ConstraintLayout.LayoutParams getLayoutParamsWW() {
        return new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);


    }

    public static ConstraintLayout.LayoutParams getLayoutParamsW(float height) {
        return new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, getSize(height));

    }

    public static ConstraintLayout.LayoutParams getLayoutParamsH(float wight) {
        return new ConstraintLayout.LayoutParams(getSize(wight), ConstraintLayout.LayoutParams.WRAP_CONTENT);

    }


    public static ConstraintLayout.LayoutParams getLayoutParamsMM() {
        return new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);


    }

    public static ConstraintLayout.LayoutParams getLayoutParamsMM0() {
        return new ConstraintLayout.LayoutParams(0, 0);


    }

    public static ConstraintLayout.LayoutParams getLayoutParamsWM() {
        return new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.MATCH_PARENT);


    }

    public static ConstraintLayout.LayoutParams getLayoutParamsM(float h) {
        return new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, AppUtil.getSize(h));


    }

    public static ConstraintLayout.LayoutParams getLayoutParamsWWLR() {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams getLayoutParamsMW() {
        return new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

    } public static ConstraintLayout.LayoutParams getLayoutParamsM0W() {
        return new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);

    }

    public static ConstraintLayout.LayoutParams getWinLayoutParamsCenter(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);

        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    /**

     *
     * @param wight
     * @param height
     * @return
     */
    public static ConstraintLayout.LayoutParams getWinLayoutParamsBLR(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    /**

     *
     * @param wight
     * @param height
     * @return
     */
    public static ConstraintLayout.LayoutParams getWinLayoutParamsBR(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    /**

     *
     * @param wight
     * @param height
     * @return
     */
    public static ConstraintLayout.LayoutParams getWinLayoutParamsTLR(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams getWinLayoutParamsLTB(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams getWinLayoutParamsLB(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams getWinLayoutParamsLB(float height) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParamsM(height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams getWinLayoutParamsTB(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams getWinLayoutParamsTB(float height) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParamsM(height);
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    /**

     *
     * @param wight
     * @param height
     * @return
     */
    public static ConstraintLayout.LayoutParams getWinLayoutParamsLR(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    /**

     *
     * @param wight
     * @param height
     * @return
     */
    public static ConstraintLayout.LayoutParams getWinLayoutParamsTL(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    /**

     *

     * @return
     */
    public static ConstraintLayout.LayoutParams createWLT(float height) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParamsWW();
        layoutParams.height = getSize(height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }


    /**

     *

     * @return
     */
    public static ConstraintLayout.LayoutParams createWL(float height) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParamsWW();
        layoutParams.height = getSize(height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    /**

     *

     * @return
     */
    public static ConstraintLayout.LayoutParams createW(float height) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParamsWW();
        layoutParams.height = getSize(height);
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams getWinLayoutParamsLT(float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams getWinLayoutParamsLT(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams getWinLayoutParamsMLT(float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(height);
        layoutParams.width = ConstraintLayout.LayoutParams.MATCH_PARENT;
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams getWinLayoutParamsMMLT() {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParamsMM();
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    /**

     *
     * @param wight
     * @param height
     * @return
     */
    public static ConstraintLayout.LayoutParams getWinLayoutParamsL(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    /**

     *
     * @param wight
     * @param height
     * @return
     */
    public static ConstraintLayout.LayoutParams getWinLayoutParamsTR(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }

    /**

     *
     * @param wight
     * @param height
     * @return
     */
    public static ConstraintLayout.LayoutParams getWinLayoutParamsR(float wight, float height) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        return layoutParams;
    }


    /**

     *
     * @param wight
     * @param height
     * @param tToId
     * @param lTorId
     * @return
     */
    public static ConstraintLayout.LayoutParams getWinLayoutParamsTTAndLR(float wight, float height, int tToId, int lTorId) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(wight, height);
        layoutParams.topToTop = tToId;
        layoutParams.leftToRight = lTorId;

        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams vh(ConstraintLayout.LayoutParams params, Integer left, Integer top, Integer right, Integer bottom) {
        if (left != null) {
            params.leftToLeft = left;
        }
        if (top != null) {
            params.topToTop = top;
        }
        if (right != null) {
            params.rightToRight = right;
        }
        if (bottom != null) {
            params.bottomToBottom = bottom;
        }
        return params;
    }

    public static ConstraintLayout.LayoutParams vh(ConstraintLayout.LayoutParams params, Integer id) {
        params.width = 0;
        params.height = 0;
        return vh(params, id, id, id, id);
    }

    public static ConstraintLayout.LayoutParams centerV(ConstraintLayout.LayoutParams params, Integer id) {

        return vh(params, null, id, null, id);
    }


    public static ConstraintLayout.LayoutParams margin(ConstraintLayout.LayoutParams params, Float left, Float top, Float right, Float bottom) {
        if (left != null) {
            params.leftMargin = getSize(left);
        }
        if (top != null) {
            params.topMargin = getSize(top);
        }
        if (right != null) {
            params.rightMargin = getSize(right);
        }
        if (bottom != null) {
            params.bottomMargin = getSize(bottom);
        }
        return params;
    }

    public static ConstraintLayout.LayoutParams marginTopRight(ConstraintLayout.LayoutParams params, Float top, Float right) {
        return margin(params, null, top, right, null);
    }

    public static ConstraintLayout.LayoutParams marginTop(ConstraintLayout.LayoutParams params, Float top) {
        return margin(params, null, top, null, null);
    }

    public static ConstraintLayout.LayoutParams marginBottom(ConstraintLayout.LayoutParams params, Float bottom) {
        return margin(params, null, null, null, bottom);
    }

    public static ConstraintLayout.LayoutParams marginLeft(ConstraintLayout.LayoutParams params, Float left) {
        return margin(params, left, null, null, null);
    }

    public static ConstraintLayout.LayoutParams marginRight(ConstraintLayout.LayoutParams params, Float right) {
        return margin(params, null, null, right, null);
    }


    public static ConstraintLayout.LayoutParams center(ConstraintLayout.LayoutParams params) {
        return vh(params, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID);
    }


    public static ConstraintLayout.LayoutParams center(int toId) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        vh(layoutParams, toId, toId, toId, toId);
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams center(ConstraintLayout.LayoutParams params, int toId) {
        vh(params, toId, toId, toId, toId);
        return params;
    }

    public static ConstraintLayout.LayoutParams centerSizeToId(float size, int toId) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(size);
        vh(layoutParams, toId, toId, toId, toId);
        return layoutParams;
    }

    public static ConstraintLayout.LayoutParams centerSize(float size) {
        ConstraintLayout.LayoutParams layoutParams = getWinLayoutParams(size);

        return center(layoutParams);
    }

    public static ConstraintLayout.LayoutParams centerWW() {
        ConstraintLayout.LayoutParams params = getLayoutParamsWW();
        return vh(params, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID, ConstraintLayout.LayoutParams.PARENT_ID);
    }

    public static ConstraintLayout.LayoutParams centerV(ConstraintLayout.LayoutParams params) {
        return vh(params, null, ConstraintLayout.LayoutParams.PARENT_ID, null, ConstraintLayout.LayoutParams.PARENT_ID);
    }

    public static ConstraintLayout.LayoutParams centerH(ConstraintLayout.LayoutParams params) {
        return vh(params, ConstraintLayout.LayoutParams.PARENT_ID, null, ConstraintLayout.LayoutParams.PARENT_ID, null);
    }

    public static ConstraintLayout.LayoutParams centerHById(ConstraintLayout.LayoutParams params, int id) {
        return vh(params, id, null, id, null);
    }


    private static int getSize(float size) {
        return AppUtil.getSize(size);
    }

    //-------------------------------------------------------------


    /**

     *
     * @return
     */
    public static ConstraintLayout.LayoutParams createLeftToRightCenterV(int rightId) {

        ConstraintLayout.LayoutParams w = createW(9);
        CLayoutLeft.leftToRightId(w, rightId);
        CLayoutTop.createCenterToId(w, rightId);

        return w;
    }

    /**

     *
     * @return
     */
    public static ViewGroup.LayoutParams createRightCenterV(int rightId) {

        ConstraintLayout.LayoutParams w = createW(9);
        CLayoutLeft.leftToRightId(w, rightId);
        CLayoutTop.createCenterToId(w, rightId);

        return w;
    }


    /**

     *
     * @param wight
     * @param height

     * @return
     */
    public static ConstraintLayout.LayoutParams createRightCenterRightMargin(float wight, float height, float rightMargin) {

        ConstraintLayout.LayoutParams layoutParams = getLayoutParams(wight, height);

        return CLayoutRight.rightCenterRightMarginV(layoutParams, rightMargin);

    }

    public static void createTopToBottomCenterH(ConstraintLayout.LayoutParams params, int toBottomId) {
        CLayoutTop.createTopToBottomCenterH(params, toBottomId);
    }

    //
    public static ConstraintLayout.LayoutParams createCenter(int size) {
        return center(getWinLayoutParams(size));
    }

    public static ConstraintLayout.LayoutParams createCenter(float w, float h) {
        return center(getWinLayoutParams(w, h));
    }


}
