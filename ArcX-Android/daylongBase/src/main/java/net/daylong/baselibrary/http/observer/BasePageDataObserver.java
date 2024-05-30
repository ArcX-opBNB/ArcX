package net.daylong.baselibrary.http.observer;

import android.accounts.NetworkErrorException;
import android.text.TextUtils;

import net.daylong.baselibrary.app.AppManager;
import net.daylong.baselibrary.http.ApiException;
import net.daylong.baselibrary.http.response.BasePageDataResponse;
import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.ui.ToastUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BasePageDataObserver<T, B> implements Observer<BasePageDataResponse<T, B>> {

    public BasePageDataObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {
        onStart();
    }

    @Override
    public void onNext(BasePageDataResponse<T, B> tBaseResponse) {
        try {
            onSuccess(tBaseResponse.getList(), tBaseResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable e) {
        try {
            MyLogUtil.e("BaseObserver onError:" + e.getMessage());

            if (e instanceof ApiException) {
                ApiException apiE = (ApiException) e;
                if (apiE.isExitApp()) {
                    AppManager.getInstance().exitApp();
                    return;
                }


//
                if (apiE.isSignError() || StringUtils.isEmpty(e.getMessage())) {

                } else {
                    onError(e.getMessage());
                }

                onError(apiE);

            } else if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof SocketTimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof HttpException
                    || e instanceof UnknownHostException) {

            } else {
                MyLogUtil.e("BaseObserver onError:" + e.getMessage());

            }
            onFinish();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
        onFinish();
    }

    /**

     */
    protected abstract void onStart();

    /**

     *
     * @param data
     * @throws Exception
     */
    protected abstract void onSuccess(List<T> data, BasePageDataResponse<T,B> basePageResponse) throws Exception;

    /**

     *
     * @throws Exception
     */
    protected void onCodeOverdue(String message) throws Exception {
        ToastUtil.show(message);
        
    }

    protected void onCodeMesseng(String message) throws Exception {
        ToastUtil.show(message);
    }

    /**

     *
     * @param message
     */
    protected void onError(String message) throws Exception {
        if (!TextUtils.equals(message, "V1") && !TextUtils.equals(message, "fail")) {
            ToastUtil.show(message);
        }
    }

    /**

     */
    protected void onError(ApiException apiException) throws Exception {

    }

    /**

     */
    protected abstract void onFinish();

}
