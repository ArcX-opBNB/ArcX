package net.daylong.baselibrary.http;

import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.http.factory.ResponseConverterFactory;
import net.daylong.baselibrary.http.interceptor.HeadInterceptorUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DefaultRetrofitFactory {
    private static final int DEFAULT_TIMEOUT_READ = 5;
    private static final int DEFAULT_TIMEOUT_WRITE = 5;
    private static final int DEFAULT_TIMEOUT_CONNECT = 5;


    private static DefaultRetrofitFactory sRetrofitFactory;
    private static OkHttpClient sOkHttpClient;
    private static Retrofit sRetrofit;

    /**

     */
    private DefaultRetrofitFactory() {
        sOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT_READ, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT_WRITE, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
//                .addInterceptor(HeadInterceptorUtil.providerInterceptor())
                .addInterceptor(HeadInterceptorUtil.getHeadInterceptor())
                .addInterceptor(HeadInterceptorUtil.getLogInterceptor())
                .build();


        sRetrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(sOkHttpClient)
                .addConverterFactory(ResponseConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    private String getBaseUrl() {
        return BaseApplication.getInstance().getBaseUrl();
    }

    /**

     *
     * @return
     */
    public static DefaultRetrofitFactory getInstance() {
        if (sRetrofitFactory == null) {
            synchronized (DefaultRetrofitFactory.class) {
                if (sRetrofitFactory == null) {
                    sRetrofitFactory = new DefaultRetrofitFactory();
                }
            }
        }
        return sRetrofitFactory;
    }

    /**

     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T createApi(Class<T> tClass) {
        return sRetrofit.create(tClass);
    }

    /**

     *

     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T createApi(String baseUrl, Class<T> tClass) {
        sRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(sOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return sRetrofit.create(tClass);
    }

}
