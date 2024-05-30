package net.daylong.baselibrary.view.recycler;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshKernel;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;

import net.daylong.daylongbase.R;


/**
 * @author

 * @Description
 * @Date 2019/12/21
 * @Version 1.0
 */
public class CustomRefreshHeader extends LinearLayout implements RefreshHeader {
    private View view;
    private ImageView mImage;

    public CustomRefreshHeader(Context context) {
        this(context, null);
    }

    public CustomRefreshHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        view = View.inflate(context, R.layout.widget_custom_refresh_header, this);
        mImage = view.findViewById(R.id.iv_refresh_header);

    }


    public void setLoadImageRes(int res) {
        mImage.setBackgroundResource(res);
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {

    }

    private AnimationDrawable refreshingAnim;
    private long timeMillis;

    private boolean isPlay;

    /**

     *
     * @param refreshLayout
     * @param oldState
     * @param newState
     */
    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case PullDownToRefresh: 


                if (!isPlay) {
                    mImage.setVisibility(View.VISIBLE);
                    isPlay = true;
                    refreshingAnim = (AnimationDrawable) mImage.getBackground();
                    refreshingAnim.start();
                }


                break;
            case Refreshing: 
//                if (isShowImg) {
//                    mImage.setImageResource(R.drawable.anim_pull_refreshing);
//                }

                break;
            case ReleaseToRefresh:
                break;
        }
    }

    /**

     */
    @Override
    public int onFinish(RefreshLayout layout, boolean success) {

        
//        if (pullDownAnim != null && pullDownAnim.isRunning()) {
//            pullDownAnim.stop();
//        }
        isPlay = false;
        if (refreshingAnim != null && refreshingAnim.isRunning()) {
            mImage.setVisibility(View.INVISIBLE);
            refreshingAnim.stop();

        }

        return 0;
    }


    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }


    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {


        
        if (percent < 1) {
            mImage.setScaleX(1.0F);
            mImage.setScaleY(1.0F);

            
//            if (hasSetPullDownAnim) {
//                hasSetPullDownAnim = false;
//            }


        }

        
        if (percent >= 1.0) {

//            if (!hasSetPullDownAnim) {
////                mImage.setImageResource(R.drawable.anim_pull_end);
////                pullDownAnim = (AnimationDrawable) mImage.getDrawable();
////                pullDownAnim.start();
////
////                hasSetPullDownAnim = true;
//            }

//
        }

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }



    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }


    private boolean isShowImg = true;

    public boolean isShowImg() {
        return isShowImg;
    }

    public void setShowImg(boolean showImg) {
        isShowImg = showImg;
    }


}




