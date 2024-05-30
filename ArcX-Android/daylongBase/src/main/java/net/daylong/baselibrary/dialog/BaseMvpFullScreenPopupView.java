package net.daylong.baselibrary.dialog;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.lxj.xpopup.impl.FullScreenPopupView;
import com.trello.rxlifecycle2.LifecycleTransformer;

import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;

import java.lang.ref.WeakReference;
public class BaseMvpFullScreenPopupView extends FullScreenPopupView implements IBaseView {


    private WeakReference<BaseMvpActivity> mActivity;


    public BaseMvpFullScreenPopupView(@NonNull BaseMvpActivity activity) {
        super(activity);
        mActivity = new WeakReference<BaseMvpActivity>(activity);
    }

    @Override
    public void showToast(String message) {
        mActivity.get().showToast(message);
    }

    @Override
    public void showLoadingDialog() {
        mActivity.get().showLoadingDialog();
    }

    @Override
    public void showLoadingDialog(String message) {
        mActivity.get().showLoadingDialog(message);

    }

    @Override
    public void dismissLoadingDialog() {
        mActivity.get().dismissLoadingDialog();

    }

    @Override
    public void hideKeyBord() {

    }

    @Override
    public void back() {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return mActivity.get().bindToLife();
    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public Activity getViewActivity() {
        return mActivity.get();
    }
}
