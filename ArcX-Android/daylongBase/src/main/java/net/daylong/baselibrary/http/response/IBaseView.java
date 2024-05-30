package net.daylong.baselibrary.http.response;

import android.app.Activity;

import com.trello.rxlifecycle2.LifecycleTransformer;


public interface IBaseView {

    /**

     *
     * @param message
     */
    void showToast(String message);

    /**

     */
    void showLoadingDialog();

    /**

     */
    void showLoadingDialog(String message);

    /**

     */
    void dismissLoadingDialog();

    /**

     */
    void hideKeyBord();

    /**

     */
    void back();

    /**

     *
     * @param <T>
     * @return
     */
    <T> LifecycleTransformer<T> bindToLife();

    void onNetworkError();


    Activity getViewActivity();

}
