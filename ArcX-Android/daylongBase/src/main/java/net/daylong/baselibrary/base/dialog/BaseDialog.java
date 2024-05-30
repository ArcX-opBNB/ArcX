package net.daylong.baselibrary.base.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;

import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.frt.BaseFragment;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.daylongbase.R;

/**

 */
public abstract class BaseDialog extends DialogFragment {

    protected float mDimAmount = 0.9f;
    protected boolean mShowBottomEnable;
    private int mMargin = 0;

    protected int getAnimStyle() {
        return 0;
    }

    ;
    private boolean mOutCancel = true;
    private Context mContext;
    private int mWidth;
    private int mHeight;

    protected float getDimAmount() {
        return mDimAmount;
    }

    protected int gravity() {
        return Gravity.CENTER;
    }

    @StyleRes
    protected int getDialogStyle() {
        return R.style.MaterialSearch;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public Context getmContext() {
        return mContext;
    }


    /**

     *Y
     * @return
     */
    protected boolean isWinDismiss() {
        return false;
    }

    private Handler handler = new Handler();

    @Override
    public void onResume() {
        super.onResume();
        if (handler != null) {
            handler.postDelayed(() -> {
                if (getDialog() != null && getDialog().getWindow() != null) {
                    int style = getAnimStyle();
                    if (getAnimStyle() == 0) {
                        style = R.style.FragmentDialogAnimation;
                    }
                    getDialog().getWindow().setWindowAnimations(style);
                }

            }, 500);
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = BaseApplication.getInstance().getContext();

        setStyle(DialogFragment.STYLE_NORMAL, getDialogStyle());


    }

    protected ViewGroup rootView;

    protected int mLayoutResId() {
        return -1;
    }



    protected  ViewGroup getContentLayout(){
        return null;
    };
    protected ViewGroup contentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mLayoutResId() > 0) {
            rootView = (ViewGroup) inflater.inflate(mLayoutResId(), container, false);
            initView(rootView, this);
        } else {
            rootView = ConstraintLayoutUtils.createMM(getContext());
            if (getContentLayout() != null) {
                if (contentView == null) {
                    contentView = getContentLayout();
                    contentView.setId(R.id.base_content_id);
                    if (getContentBg() != null) {
                        contentView.setBackgroundResource(getContentBg());
                    }
                    contentView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    rootView.addView(contentView);
                }
            }

            initView(rootView, contentView, this);

            initView((ConstraintLayout) rootView, this);
        }
        initData();


        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWinDismiss()) {
                    dismiss();
                }
            }
        });
        initParams();
        return rootView;

    }

    protected Integer getContentBg() {

        return null;
    }
    public View getRootView() {
        return rootView;
    }

    public ConstraintLayout getRootConstraintView() {
        return (ConstraintLayout) rootView;
    }


    @Override
    public void onStop() {
        super.onStop();
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setWindowAnimations(0);
        }
    }

    protected boolean isBackDismiss() {
        return false;
    }


    /**

     */
    private void initParams() {
        Window window = getDialog().getWindow();
        mDimAmount = getDimAmount();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.dimAmount = mDimAmount;
            params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            
            if (getAnimStyle() != 0) {
                window.setWindowAnimations(getAnimStyle());

            } else {
                window.setWindowAnimations(R.style.FragmentDialogAnimation);
            }

            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); 
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); 
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN); 
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

            window.setAttributes(params);
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    if (!isBackDismiss()) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            return true;
                        }
                        return false;
                    } else {
                        return false;
                    }
                }
            });
        }
        setCancelable(mOutCancel);

    }

    /**

     *
     * @param dimAmount
     * @return
     */
    public BaseDialog setDimAmount(@FloatRange(from = 0, to = 1) float dimAmount) {
        mDimAmount = dimAmount;
        return this;
    }


    /**

     *
     * @param showBottom
     * @return
     */
    public BaseDialog setShowBottom(boolean showBottom) {
        mShowBottomEnable = showBottom;
        return this;
    }

    /**

     *
     * @param width
     * @param height
     * @return
     */
    public BaseDialog setSize(int width, int height) {
        mWidth = width;
        mHeight = height;
        return this;
    }

    /**

     *
     * @param margin
     * @return
     */
    public BaseDialog setMargin(int margin) {
        mMargin = margin;
        return this;
    }


    /**

     *
     * @param outCancel
     * @return
     */
    public BaseDialog setOutCancel(boolean outCancel) {
        mOutCancel = outCancel;
        return this;
    }

    public BaseDialog show(FragmentManager manager) {
        super.show(manager, String.valueOf(System.currentTimeMillis()));
        return this;
    }


    /**

     *
     * @param rootView
     * @param dialog
     */
    public abstract void initView(ConstraintLayout rootView, BaseDialog dialog);
    /**

     *
     * @param rootView
     * @param dialog
     */
    public  void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog){}
    /**

     *
     * @param dialog
     */
    protected void initView(View view, BaseDialog dialog) {
    }


    /**

     */
    public abstract void initData();

    /**

     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**

     *


     */
    public void addFragment(BaseFragment fragment, int container, String tag) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (!fragment.isAdded() && null == getChildFragmentManager().findFragmentByTag(tag)) {   
            transaction.add(container, fragment, tag).commitAllowingStateLoss(); 
        } else {
            transaction.show(fragment).commitAllowingStateLoss(); 
        }
    }


    @Override
    public void dismiss() {

        super.dismiss();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler = null;
        }
        if (OnDismissListener != null) {
            OnDismissListener.onDismiss();
        }
    }

    protected OnDismissListener OnDismissListener;

    public void setOnDismissListener(BaseDialog.OnDismissListener onDismissListener) {
        OnDismissListener = onDismissListener;
    }

    public interface OnDismissListener {

        void onDismiss();
    }


    public int getSize(float size) {
        return AppUtil.getSize(size);
    }

    public void addView(View view) {

        if (rootView instanceof ConstraintLayout) {
            ((ConstraintLayout) rootView).addView(view);
        }
    }
}
