package net.daylong.baselibrary.utils.ui.button;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseModel;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.utils.sys.AppUtil;

public abstract class ButtonMvp<P extends BasePresenter, M extends IBaseModel> extends androidx.appcompat.widget.AppCompatButton implements IBaseView {

    /**

     */
    protected P mPresenter;
    /**

     */
    protected M mModel;

    public ButtonMvp(@NonNull Context context) {
        this(context, null);
    }

    public ButtonMvp(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ButtonMvp(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mModel = (M) mPresenter.getModel();
            if (mModel != null) {
                mPresenter.attachMV(mModel, this);
            }
        }
    }


    /**

     *
     * @return
     */
    @NonNull
    protected abstract P initPresenter();

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showLoadingDialog(String message) {

    }

    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void hideKeyBord() {

    }

    @Override
    public void back() {

    }


    @Override
    public void onNetworkError() {

    }

    @Override
    public Activity getViewActivity() {
        return AppUtil.getCurrentActivity();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        if (mPresenter != null) {
            mPresenter.detachMV();
            System.gc();
        }
    }
}
