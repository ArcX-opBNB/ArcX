package net.daylong.baselibrary.utils.ui.layout;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;


import net.daylong.baselibrary.utils.sys.AppUtil;


public class LinearLayoutBuilder {
    protected LinearLayout.LayoutParams payoutParams;

    public LinearLayoutBuilder(float w, float h) {
        this.payoutParams = new LinearLayout.LayoutParams(getSize(w), getSize(h));
    }

    public LinearLayoutBuilder(float size) {
        this.payoutParams = new LinearLayout.LayoutParams(getSize(size), getSize(size));
    }

    public LinearLayoutBuilder() {

    }

    public LinearLayoutBuilder(int w, int h) {
        this.payoutParams = new LinearLayout.LayoutParams(getSize(w), getSize(h));
    }

    public LinearLayoutBuilder size(int w, int h) {
        this.payoutParams = new LinearLayout.LayoutParams(getSize(w), getSize(h));
        return this;
    }


    
    public LinearLayoutBuilder margin(float left, float top, float right, float bottom) {
        try {
            if (left < 0 || top < 0 || right < 0 || bottom < 0) {
                throw new IllegalArgumentException("Margins cannot be negative");
            }
            this.leftMargin(left);
            this.topMargin(top);
            this.rightMargin(right);
            this.bottomMargin(bottom);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return this;
    }

    
    public LinearLayoutBuilder margin(float margin) {

        return margin(margin, margin, margin, margin);
    }


    public LinearLayoutBuilder ww() {
        payoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        return this;
    }

    public LinearLayoutBuilder wHei() {
        payoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        return this;
    }

    public LinearLayout.LayoutParams getParams() {
        return payoutParams;
    }

    public LinearLayoutBuilder w(float height) {
        payoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, AppUtil.getSize(height));

        return this;
    }

    /**

     *
     * @param wight
     * @return
     */
    public LinearLayoutBuilder wH0(float wight) {
        payoutParams = new LinearLayout.LayoutParams(AppUtil.getSize(wight), 0);

        return this;
    }

    /**

     */
    public LinearLayoutBuilder mm() {
        payoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        return this;
    }


    /**

     *

     * @return
     */
    public LinearLayoutBuilder m(float height) {
        payoutParams = new LinearLayout.LayoutParams(0, AppUtil.getSize(height));

        return this;
    }

    public LinearLayoutBuilder hWrap() {
        payoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;

        return this;
    }

    public LinearLayoutBuilder wm() {
        payoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);

        return this;
    }

    public LinearLayoutBuilder mHei(float height) {
        payoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, AppUtil.getSize(height));

        return this;
    }

    public LinearLayoutBuilder mw() {
        payoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        return this;
    }

    public LinearLayoutBuilder m0w() {
        payoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);

        return this;
    }

    public LinearLayoutBuilder layout(int w, int h) {
        payoutParams = new LinearLayout.LayoutParams(w, h);

        return this;
    }



    /**

     */
    public LinearLayoutBuilder centerH() {
        payoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        return this;
    }

    /**

     */
    public LinearLayoutBuilder height(float height) {
        payoutParams.height = AppUtil.getSize(height);
        return this;
    }

    /**

     */
    public LinearLayoutBuilder NotSizeHeight(int height) {
        payoutParams.height = height;
        return this;
    }

    /**

     */
    public LinearLayoutBuilder width(float width) {
        payoutParams.width = AppUtil.getSize(width);
        return this;
    }


    public LinearLayoutBuilder leftMargin(float left) {
        payoutParams.leftMargin = AppUtil.getSize(left);
        return this;
    }

    public LinearLayoutBuilder leftMarginNotBl(int left) {
        payoutParams.leftMargin = left;
        return this;
    }

    public LinearLayoutBuilder topMargin(float top) {
        payoutParams.topMargin = AppUtil.getSize(top);
        return this;
    }

    public LinearLayoutBuilder topMarginNotFor(int top) {
        payoutParams.topMargin = top;
        return this;
    }

    public LinearLayoutBuilder topRightMargin(float top, float right) {
        topMargin(top);
        rightMargin(right);
        return this;
    }

    public LinearLayoutBuilder rightMargin(float right) {
        payoutParams.rightMargin = AppUtil.getSize(right);
        return this;
    }

    public LinearLayoutBuilder rightBottomMargin(float right, float bottom) {

        rightMargin(right);
        bottomMargin(bottom);
        return this;
    }

    public LinearLayoutBuilder bottomMargin(float bottom) {
        payoutParams.bottomMargin = AppUtil.getSize(bottom);
        return this;
    }

    public LinearLayoutBuilder leftBottomMargin(float left, float bottom) {
        leftMargin(left);
        bottomMargin(bottom);

        return this;
    }


    public LinearLayoutBuilder leftRightMargin(float left, float right) {
        return leftMargin(left).rightMargin(right);
    }

    public LinearLayoutBuilder leftRightMargin(float size) {
        return leftMargin(size).rightMargin(size);
    }

    public LinearLayoutBuilder leftTopMargin(float left, float top) {
        return leftMargin(left).topMargin(top);
    }

    public LinearLayoutBuilder marginLeftAndRight(float margin) {
        return leftMargin(margin).rightMargin(margin);
    }


    protected int getSize(float size) {
        return AppUtil.getSize(size);
    }

    public LinearLayoutBuilder addMargins(float left, float top, float right, float bottom) {
        margin(left, top, right, bottom);
        return this;
    }

    public LinearLayoutBuilder addMargin(float all) {
        margin(all, all, all, all);
        return this;
    }

    public LinearLayout build(Context context) {
        LinearLayout LinearLayout = new LinearLayout(context);
        LinearLayout.setLayoutParams(payoutParams);
        return LinearLayout;
    }

    public LinearLayout.LayoutParams buildPayoutParams() {
        return payoutParams;
    }


}
