package net.daylong.baselibrary.utils.ui.act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import net.daylong.baselibrary.app.AppManager;
import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.dialog.ArcadeReturnDialog;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.sys.SystemUtil;
import net.daylong.baselibrary.utils.ui.EdittextUtils;
import net.daylong.baselibrary.utils.ui.frt.BaseFragment;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.baselibrary.utils.ui.view.BaseBackView;
import net.daylong.baselibrary.utils.ui.view.BaseTitleView;
import net.daylong.baselibrary.view.BaseImageView;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.daylongbase.R;
import net.daylong.gamesocket.listener.WebSocketDefaultListener;
import net.daylong.gamesocket.strategy.response.SocketResponseStrategy;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends RxAppCompatActivity implements IBaseView, WebSocketDefaultListener {


    public static void start(Context context, Class<?> clas) {

        Intent intent = new Intent(context, clas);
        context.startActivity(intent);
    }

    public static void start(Context context, Class<?> clas, String key, Serializable val) {

        Intent intent = new Intent(context, clas);
        intent.putExtra(key, val);
        context.startActivity(intent);
    }


    /**

     */
    protected Context mContext;
    protected ViewGroup rootView = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
    }

    protected boolean isFullScreen() {
        return true;
    }


    /**

     *

     */
    public int getMyRequestedOrientation() {
        return ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    /**

     *

     */
    protected boolean isRequestedOrientation() {
        return true;
    }

    protected BaseTitleView baseTitleView;

    protected int getBackImg() {
        return DrawableUtils.getDrawableByName("img_btn_back");
    }

    protected BaseTitleView getBaseTitleView() {
        if (baseTitleView == null) {
            baseTitleView = new BaseTitleView(this);
            baseTitleView.setId(View.generateViewId());
            baseTitleView.init(getBackImg(), this, getTitleName());
        }
        return baseTitleView;
    }


    protected Integer getBackBgRegId() {
        return null;
    }

    protected BaseBackView baseBackView;

    protected boolean isShowBackCoin() {
        return true;
    }

    protected BaseBackView getBaseBackView() {
        if (baseBackView == null) {
            baseBackView = new BaseBackView(this, getBackBgRegId(), isShowBackCoin());
            baseBackView.setId(View.generateViewId());
            baseBackView.bringToFront();
        }
        return baseBackView;
    }


    /**

     *
     * @return
     */
    protected Integer getTitleName() {
        return null;
    }

    ;

    protected ViewGroup getContentView() {
        if (rootView == null) {
            rootView = ConstraintLayoutUtils.createMM(this);
            rootView.setId(R.id.base_root_id);
            if (isAddBaseTitle()) {
                addView(getBaseTitleView());
            }


        }
        return rootView;
    }


    /**

     *
     * @return
     */
    protected boolean isAddBaseTitle() {
        return false;
    }


    /**
     * ButterKnife
     */
    private Unbinder mUnbinder;

    /**
     * @param savedInstanceState
     */
    private void init(Bundle savedInstanceState) {

        mContext = BaseApplication.getInstance().getContext();
        initSys();
        

        
        if (getLayoutId() != null) {
            setContentView(getLayoutId());
            mUnbinder = ButterKnife.bind(this);
        } else {
            if (getContentView() != null) {
                setContentView(getContentView());
            }
        }


        AppManager.getInstance().addActivity(this);
        if (getBackBgRegId() != null) {
            addView(getBaseBackView());
        }
        if (rootView != null) {
            initView(rootView);
        } else {
            initView();
        }

        initData();
        initBg();
        if (baseBackView != null) {
            baseBackView.bringToFront();
        }
    }

    /**

     *
     * @return
     */
    protected Integer getBgImgRegId() {
        return null;
    }

    /**

     */
    protected void initBg() {
        if (getBgImgRegId() != null) {
            BaseImageView baseImageView = MyImageView.create(rootView, 0, new ConstraintBuilder().mm());
            baseImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            baseImageView.setBackgroundResource(getBgImgRegId());

        }
    }


    /**

     *
     * @return
     */
    protected String getBgImgName() {
        return null;
    }

    
    protected void initSys() {
        
        if (isRequestedOrientation()) {
            setRequestedOrientation(getMyRequestedOrientation());
        }
        if (isFullScreen()) {
            SystemUtil.fullScreen(this);
        }
    }


    /**


     *
     * @return
     */
    protected Integer getLayoutId() {
        return null;
    }


    /**


     */
    protected void initData() {
    }

    protected void initView(ViewGroup rootView) {
    }

    protected void initView() {
    }


//    protected boolean isDispatchTouchEvent() {
//        return true;
//    }

    //@Override
    //public boolean dispatchTouchEvent(MotionEvent ev) {
    //    boolean dispatchTouchEvent = isDispatchTouchEvent();
    //
    //    if (dispatchTouchEvent) {
    //        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
    //            View v = getCurrentFocus();
    //            if (isShouldHideKeyboard(v, ev)) {
    //                hideKeyBord();
    //            }
    //        } else {
    //            onTouchEvent(getCurrentFocus());
    //        }
    //    }
    //    return super.dispatchTouchEvent(ev);
    //}


    protected void onTouchEvent(View view) {

    }

    /**

     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && ((v instanceof EditText) || (v instanceof Button) || (v instanceof ImageButton))) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                
                return false;
            } else {
                return true;
            }
        }
        
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();

        SocketResponseStrategy.getInstance().getWebSocketDefaultStrategy().register(this);
    }


    @Override
    protected void onStop() {
        super.onStop();
        SocketResponseStrategy.getInstance().getWebSocketDefaultStrategy().remover(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        AppManager.getInstance().finishActivity(this);

    }

    public boolean isNotNull(String... str) {
        return !isNull(str);

    }

    public boolean isNull(String... str) {
        return StringUtils.isNull(str);
    }

    public boolean isOrNull(String... str) {
        return StringUtils.isOrNull(str);
    }


    public String getText(EditText editText) {
        return EdittextUtils.getText(editText);
    }


    /**

     *


     */
    public void addFragment(BaseFragment fragment, int container) {
        if (fragment == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {   
            transaction.add(container, fragment).commitAllowingStateLoss(); 
        } else {
            transaction.show(fragment).commitAllowingStateLoss(); 
        }
    }


    /**

     *


     */
    public void addFragment(BaseFragment fragment, int container, String tag) {
        FragmentManager fm = getSupportFragmentManager();
        if (!fragment.isAdded() && null == fm.findFragmentByTag(tag)) {
            FragmentTransaction ft = fm.beginTransaction();
            fm.executePendingTransactions();
            ft.add(container, fragment, tag);
            ft.commitAllowingStateLoss();
        }
    }


    public boolean isAddFragment(BaseFragment fragment) {
        return fragment.isAdded();
    }


    /**

     *
     * @param fragment
     */
    public void hideFragment(BaseFragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
//            if (fragment.isVisible()) {
            transaction.hide(fragment).commit();
//            }
        }
    }

    /**

     */
    public void hideFragment(String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);


        if (fragment != null && fragment.isAdded() && fragment.isVisible()) {

            transaction.hide(fragment).commit();
        }
    }

    /**

     *
     * @param fragment
     */
    public void removeFragment(BaseFragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
            if (fragment.isVisible()) {
                transaction.remove(fragment).commit();
            }
        }
    }

    /**

     *
     * @param fragment
     */
    public void showFragment(BaseFragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (fragment != null) {
            if (!fragment.isVisible()) {
                transaction.show(fragment).commit();
            }
        }
    }

    /**

     */
    public void showFragment(String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (null != fragment && !fragment.isVisible()) {
            transaction.show(fragment).commit();

        }


    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    /**

     *
     * @param view
     */
    public void addView(View view) {
        if (rootView != null) {
            rootView.addView(view);

        }
    }

    /**

     *

     * @param view     view
     */
    public void addView(int position, View view) {
        if (rootView != null) {
            rootView.addView(view, position);
        }
    }


    public int getSize(float size) {
        return AppUtil.getSize(size);
    }

    @Override
    public void showToast(String message) {

    }

    protected BasePopupView loadingDialog;

    @Override
    public void showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new XPopup.Builder(this)
                    .asLoading();
        }

        if (loadingDialog != null && !loadingDialog.isShow()) {
            loadingDialog.show();
        }

    }

    @Override
    public void showLoadingDialog(String message) {

    }

    @Override
    public void dismissLoadingDialog() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (loadingDialog != null && loadingDialog.isShow()) {
                    loadingDialog.dismiss();
                }
            }
        });
    }

    @Override
    public void hideKeyBord() {

    }

    @Override
    public void back() {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public Activity getViewActivity() {
        return this;
    }


    @Override
    public void connect() {

    }

    @Override
    public void reconnect() {

    }

    @Override
    public void connectSuc() {


    }

    @Override
    public void connectFail() {

    }

    @Override
    public void responseError(int cmd, int code, String desc) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onSocketError(cmd, code, desc);
            }
        });
    }

    public void onSocketError(int cmd, int code, String desc) {
    }

    @Override
    public void arcadeCoinReturn(Long coin) {

        


        ArcadeReturnDialog.showDialog(getSupportFragmentManager(), coin);


    }
}


