package net.daylong.baselibrary.http.observer;

import android.accounts.NetworkErrorException;
import android.text.TextUtils;

import net.daylong.baselibrary.app.AppManager;
import net.daylong.baselibrary.http.ApiException;
import net.daylong.baselibrary.http.base.BaseResponse;
import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.ui.ToastUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;


public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {

    public BaseObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {
        onStart();
    }

    @Override
    public void onNext(BaseResponse<T> tBaseResponse) {
        try {
            onSuccess(tBaseResponse.getData(), tBaseResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable e) {
        try {
            if (e instanceof ApiException) {
                ApiException apiE = (ApiException) e;


                if (apiE.isExitApp()) {
                    AppManager.getInstance().exitApp();
                    return;
                }


                if (apiE.isTokenError()) {


                    //


                    AppManager.getInstance().returnToHome();

                } else {
                    if (apiE.isSignError() || StringUtils.isEmpty(apiE.getErrorMsg())) {


                    } else {
                        onError(apiE.getErrorMsg());
                        onError(apiE);
                    }
                }
            } else if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof SocketTimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof HttpException
                    || e instanceof UnknownHostException) {
                onError("");
            } else {
                onError("");
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
    protected abstract void onSuccess(T data) throws Exception;

    protected void onSuccess(T data, BaseResponse<T> tBaseResponse) throws Exception {
        onSuccess(data);
    }


    /**

     *
     * @throws Exception
     */
    protected void onCodeOverdue(String message) throws Exception {
        ToastUtil.show(message);
    }


    /**

     *
     * @param message
     */
    protected void onError(String message) throws Exception {
        if (!TextUtils.equals(message, "fail")&&!TextUtils.isEmpty(message)) {
            ToastUtil.show(message);

        }
    }

    /**

     *
     * @param
     */
    protected void onError(ApiException apiException) throws Exception {

    }

    /**

     */
    protected abstract void onFinish();

}

