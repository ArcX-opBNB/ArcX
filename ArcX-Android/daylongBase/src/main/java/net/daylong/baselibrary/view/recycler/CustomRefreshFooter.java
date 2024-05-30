package net.daylong.baselibrary.view.recycler;//package net.daylong.metapusherbaselibrary.view;
//
//import android.content.Context;
//import android.graphics.drawable.Drawable;
//import android.util.AttributeSet;
//import android.view.View;
//import android.widget.ProgressBar;
//
//import com.dalong.baselibrary.R;
//import com.scwang.smartrefresh.layout.api.RefreshLayout;
//import com.scwang.smartrefresh.layout.constant.RefreshState;
//import com.scwang.smartrefresh.layout.internal.InternalAbstract;
//
//public class CustomRefreshFooter extends InternalAbstract {
//
//    private ProgressBar progressBar;
//
//    public CustomRefreshFooter(Context context) {
//        this(context, null);
//    }
//
//    public CustomRefreshFooter(Context context, AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public CustomRefreshFooter(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//
//        View inflate = View.inflate(context, R.layout.view_item_refresh_footer, this);
//        progressBar = inflate.findViewById(R.id.reg_req_code_gif_view);
//
//
//    }
//    public void setLoadImageRes(int res) {
//        progressBar.setIndeterminateDrawable(getContext().getDrawable(res));
//    }
//    /**

//     *
//     * @param refreshLayout
//     * @param oldState
//     * @param newState
//     */
//    @Override
//    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
//
//        switch (newState) {

//
//                break;

//
//
//                break;

//
//                break;
//        }
//    }
//
//
//    public void setIndeterminateDrawable(int res ) {
//        Drawable d = getResources().getDrawable(res);
//
//        d.setBounds(1,1,40,40);
//
//        progressBar.setIndeterminateDrawable(d);
//        progressBar.setAlpha(50);
//
////        progressBar.setIndeterminateDrawable(getContext().getDrawable(res));
//    }
//}