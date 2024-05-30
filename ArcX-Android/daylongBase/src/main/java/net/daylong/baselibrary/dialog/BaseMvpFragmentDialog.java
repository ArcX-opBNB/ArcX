package net.daylong.baselibrary.dialog;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.LifecycleTransformer;

import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.IBaseModel;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
public abstract class BaseMvpFragmentDialog<P extends BasePresenter, M extends IBaseModel> extends BaseFragmentDialog implements IBaseView {
    /**

     */
    protected P mPresenter;
    /**

     */
    protected M mModel;

    @Override
    protected boolean isWinDismiss() {
        return true;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMvp();
    }

    /**

     *
     * @return
     */
    @NonNull
    protected abstract P initPresenter();

    private void initMvp() {
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mModel = (M) mPresenter.getModel();
            if (mModel != null) {
                mPresenter.attachMV(mModel, this);
            }
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachMV();
            mPresenter = null;
            System.gc();
        }
        super.onDestroyView();

    }



    @Override
    public void showLoadingDialog(String message) {

    }

    @Override
    public void dismissLoadingDialog() {
        ((BaseActivity) getActivity()).dismissLoadingDialog();
    }

    @Override
    public void hideKeyBord() {

    }

    @Override
    public void back() {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return ((BaseActivity) getActivity()).bindToLife();
    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public Activity getViewActivity() {
        return getActivity();
    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void showLoadingDialog() {

    }

}
