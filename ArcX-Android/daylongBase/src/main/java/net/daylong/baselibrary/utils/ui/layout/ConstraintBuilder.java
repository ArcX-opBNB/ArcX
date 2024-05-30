package net.daylong.baselibrary.utils.ui.layout;

import android.content.Context;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import net.daylong.baselibrary.utils.sys.AppUtil;


public class ConstraintBuilder {
    protected ConstraintLayout.LayoutParams payoutParams;

    public ConstraintBuilder(float w, float h) {
        this.payoutParams = new ConstraintLayout.LayoutParams(getSize(w), getSize(h));
    }

    public ConstraintBuilder(float size) {
        this.payoutParams = new ConstraintLayout.LayoutParams(getSize(size), getSize(size));
    }

    public ConstraintBuilder() {

    }

    public ConstraintBuilder(int w, int h) {
        this.payoutParams = new ConstraintLayout.LayoutParams(getSize(w), getSize(h));
    }

    public ConstraintBuilder size(int w, int h) {
        this.payoutParams = new ConstraintLayout.LayoutParams(getSize(w), getSize(h));
        return this;
    }


    
    public ConstraintBuilder margin(float left, float top, float right, float bottom) {
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

    
    public ConstraintBuilder margin(float margin) {

        return margin(margin, margin, margin, margin);
    }


    public ConstraintBuilder ww() {
        payoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        return this;
    }

    public ConstraintBuilder wHei() {
        payoutParams.height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        return this;
    }

    public ConstraintLayout.LayoutParams getParams() {
        return payoutParams;
    }

    public ConstraintBuilder w(float height) {
        payoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, AppUtil.getSize(height));

        return this;
    }

    /**

     *
     * @param wight
     * @return
     */
    public ConstraintBuilder wH0(float wight) {
        payoutParams = new ConstraintLayout.LayoutParams(AppUtil.getSize(wight), 0);

        return this;
    }

    /**

     */
    public ConstraintBuilder mm() {
        payoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);

        return this;
    }

    /**

     */
    public ConstraintBuilder mm0() {
        payoutParams = new ConstraintLayout.LayoutParams(0, 0);
        center();
        return this;
    }

    /**

     *

     * @return
     */
    public ConstraintBuilder m(float height) {
        payoutParams = new ConstraintLayout.LayoutParams(0, AppUtil.getSize(height));

        return this;
    }

    public ConstraintBuilder hWrap() {
        payoutParams.height = ConstraintLayout.LayoutParams.WRAP_CONTENT;

        return this;
    }

    public ConstraintBuilder wm() {
        payoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.MATCH_PARENT);

        return this;
    }

    public ConstraintBuilder mHei(float height) {
        payoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, AppUtil.getSize(height));

        return this;
    }

    public ConstraintBuilder mw() {
        payoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        return this;
    }

    public ConstraintBuilder m0w() {
        payoutParams = new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        return this;
    }

    public ConstraintBuilder layout(int w, int h) {
        payoutParams = new ConstraintLayout.LayoutParams(w, h);

        return this;
    }

    /**

     */
    public ConstraintBuilder centerHorizontally() {
        left();
        right();
        return this;
    }

    /**

     */
    public ConstraintBuilder centerH() {
        left();
        right();
        return this;
    }

    /**

     */
    public ConstraintBuilder centerH(View view) {
        left(view.getId());
        right(view.getId());
        return this;
    }

    /**

     */
    public ConstraintBuilder height(float height) {
        payoutParams.height = AppUtil.getSize(height);
        return this;
    }

    /**

     */
    public ConstraintBuilder NotSizeHeight(int height) {
        payoutParams.height = height;
        return this;
    }

    /**

     */
    public ConstraintBuilder width(float width) {
        payoutParams.width = AppUtil.getSize(width);
        return this;
    }

    /**

     */
    public ConstraintBuilder centerHorizontally(int id) {
        left(id);
        right(id);
        return this;
    }

    /**

     */


    public ConstraintBuilder center() {
        left();
        top();
        right();
        bottom();
        return this;
    }

    public ConstraintBuilder center(View view) {
        left(view.getId());
        top(view.getId());
        right(view.getId());
        bottom(view.getId());
        return this;
    }


    /**

     */
    public ConstraintBuilder centerById(int id) {
        left(id);
        top(id);
        right(id);
        bottom(id);
        return this;
    }

    /**

     */
    public ConstraintBuilder horizontalChainStyle() {
        payoutParams.horizontalChainStyle = ConstraintLayout.LayoutParams.CHAIN_PACKED;
        return this;
    }

    public ConstraintBuilder verticalChainStyle() {
        payoutParams.verticalChainStyle = ConstraintLayout.LayoutParams.CHAIN_PACKED;
        return this;
    }

    public ConstraintBuilder leftMargin(float left) {
        payoutParams.leftMargin = AppUtil.getSize(left);
        return this;
    }

    public ConstraintBuilder leftMarginNotBl(int left) {
        payoutParams.leftMargin = left;
        return this;
    }

    public ConstraintBuilder topMargin(float top) {
        payoutParams.topMargin = AppUtil.getSize(top);
        return this;
    }

    public ConstraintBuilder topMarginNotFor(int top) {
        payoutParams.topMargin = top;
        return this;
    }

    public ConstraintBuilder topRightMargin(float top, float right) {
        topMargin(top);
        rightMargin(right);
        return this;
    }

    public ConstraintBuilder rightMargin(float right) {
        payoutParams.rightMargin = AppUtil.getSize(right);
        return this;
    }

    public ConstraintBuilder rightBottomMargin(float right, float bottom) {

        rightMargin(right);
        bottomMargin(bottom);
        return this;
    }

    public ConstraintBuilder bottomMargin(float bottom) {
        payoutParams.bottomMargin = AppUtil.getSize(bottom);
        return this;
    }

    public ConstraintBuilder leftBottomMargin(float left, float bottom) {
        leftMargin(left);
        bottomMargin(bottom);

        return this;
    }


    public ConstraintBuilder leftRightMargin(float left, float right) {
        return leftMargin(left).rightMargin(right);
    }

    public ConstraintBuilder leftRightMargin(float size) {
        return leftMargin(size).rightMargin(size);
    }

    public ConstraintBuilder leftTopMargin(float left, float top) {
        return leftMargin(left).topMargin(top);
    }

    public ConstraintBuilder leftTopMargin(float size) {
        return leftTopMargin(size, size);
    }

    public ConstraintBuilder marginLeftAndRight(float margin) {
        return leftMargin(margin).rightMargin(margin);
    }


    public ConstraintBuilder left() {
        payoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        return this;
    }


    public ConstraintBuilder leftCenterV() {
        left();
        centerV();
        return this;
    }

    public ConstraintBuilder leftCenterV(int id) {
        left(id);
        centerV(id);
        return this;
    }

    public ConstraintBuilder leftCenterV(View view) {
        left(view.getId());
        centerV(view.getId());
        return this;
    }


    public ConstraintBuilder left(int id) {
        payoutParams.leftToLeft = id;
        return this;
    }

    public ConstraintBuilder left(View view) {
        left(view.getId());
        return this;
    }

    public ConstraintBuilder top() {
        payoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        return this;
    }

    public ConstraintBuilder topRight() {
        top();
        right();
        return this;
    }

    public ConstraintBuilder topRight(int id) {
        top(id);
        right(id);
        return this;
    }

    public ConstraintBuilder topRight(View view) {
        top(view.getId());
        right(view.getId());
        return this;
    }

    public ConstraintBuilder topToBottom() {
        topToBottom(ConstraintLayout.LayoutParams.PARENT_ID);
        return this;
    }

    public ConstraintBuilder topToBottom(int id) {
        payoutParams.topToBottom = id;
        return this;
    }

    public ConstraintBuilder topToBottom(View view) {
        topToBottom(view.getId());
        return this;
    }


    public ConstraintBuilder top(int id) {
        payoutParams.topToTop = id;
        return this;
    }

    public ConstraintBuilder top(View view) {
        payoutParams.topToTop = view.getId();
        return this;
    }

    public ConstraintBuilder right() {
        payoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        return this;
    }

    public ConstraintBuilder rightBottom() {
        right();
        bottom();
        return this;
    }

    public ConstraintBuilder rightBottom(int id) {
        right(id);
        bottom(id);
        return this;
    }

    public ConstraintBuilder right(int id) {
        payoutParams.rightToRight = id;
        return this;
    }

    public ConstraintBuilder right(View view) {
        return right(view.getId());
    }

    public ConstraintBuilder rightToLeftById(int id) {
        payoutParams.rightToLeft = id;
        return this;
    }

    public ConstraintBuilder bottom() {
        payoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        return this;
    }

    public ConstraintBuilder bottomToTop(int id) {
        payoutParams.bottomToTop = id;
        return this;
    }

    public ConstraintBuilder bottomToTop(View view) {
        payoutParams.bottomToTop = view.getId();
        return this;
    }

    public ConstraintBuilder bottom(int id) {
        payoutParams.bottomToBottom = id;
        return this;
    }

    public ConstraintBuilder bottom(View v) {
        payoutParams.bottomToBottom = v.getId();
        return this;
    }


    public ConstraintBuilder leftTop() {
        left();
        top();
        return this;
    }

    public ConstraintBuilder leftTop(View view) {
        left(view.getId());
        top(view.getId());
        return this;
    }

    public ConstraintBuilder leftTopBottom(int id) {
        left(id);
        top(id);
        bottom(id);
        return this;
    }


    public ConstraintBuilder leftTopToBottom(int id) {
        left(id);
        topToBottom(id);
        return this;
    }

    public ConstraintBuilder leftTopToBottom(View view) {
        left(view);
        topToBottom(view);
        return this;
    }

    public ConstraintBuilder rightTopToBottom(View view) {
        right(view);
        topToBottom(view);
        return this;
    }

    public ConstraintBuilder leftTopRightById(int id) {
        left(id);
        topToBottom(id);
        right(id);
        return this;
    }

    public ConstraintBuilder leftRight() {
        top();
        right();
        return this;
    }

    public ConstraintBuilder leftRight(View view) {
        top(view.getId());
        right(view.getId());
        return this;
    }

    public ConstraintBuilder leftToRightById(int id) {

        payoutParams.leftToRight = id;


        return this;
    }

    public ConstraintBuilder leftToRightById(View view) {

        return leftToRightById(view.getId());


    }

    public ConstraintBuilder leftToRightCenterV(View view) {
        return leftToRightById(view).centerV(view);


    }

    public ConstraintBuilder rightCenterV() {
        right();
        centerV();
        return this;
    }

    public ConstraintBuilder rightCenterV(int id) {
        right(id);
        centerV(id);
        return this;
    }


    public ConstraintBuilder topCenterH() {
        return top().centerHorizontally();
    }

    public ConstraintBuilder topCenterH(int id) {
        return top(id).centerHorizontally(id);
    }

    public ConstraintBuilder topCenterH(View view) {
        return top(view.getId()).centerHorizontally(view.getId());
    }

    public ConstraintBuilder bottomCenterH() {
        return bottom().centerHorizontally();
    }

    public ConstraintBuilder bottomCenterH(int id) {
        return bottom(id).centerHorizontally(id);
    }

    public ConstraintBuilder bottomCenterH(View view) {
        return bottom(view.getId()).centerHorizontally(view.getId());
    }

    public ConstraintBuilder centerV() {

        top();
        bottom();
        return this;
    }

    public ConstraintBuilder centerV(int id) {

        top(id);
        bottom(id);
        return this;
    }

    public ConstraintBuilder centerV(View v) {


        return centerV(v.getId());
    }


    public ConstraintBuilder leftBottom() {
        left();
        bottom();

        return this;
    }

    public ConstraintBuilder leftBottom(View view) {
        left(view.getId());
        bottom(view.getId());

        return this;
    }

    protected int getSize(float size) {
        return AppUtil.getSize(size);
    }

    public ConstraintBuilder addMargins(float left, float top, float right, float bottom) {
        margin(left, top, right, bottom);
        return this;
    }

    public ConstraintBuilder addMargin(float all) {
        margin(all, all, all, all);
        return this;
    }

    public ConstraintLayout build(Context context) {
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(payoutParams);
        return constraintLayout;
    }

    public ConstraintLayout.LayoutParams buildPayoutParams() {
        return payoutParams;
    }

    public static void none(ConstraintLayout.LayoutParams payoutParams) {

        payoutParams.leftToLeft=ConstraintLayout.LayoutParams.UNSET;
        payoutParams.leftToRight=ConstraintLayout.LayoutParams.UNSET;
        payoutParams.rightToRight=ConstraintLayout.LayoutParams.UNSET;
        payoutParams.rightToLeft=ConstraintLayout.LayoutParams.UNSET;
    }


}
