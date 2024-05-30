package net.daylong.baselibrary.http;

import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.http.factory.ResponseConverterFactory;
import net.daylong.baselibrary.http.factory.ResponseRtcConverterFactory;
import net.daylong.baselibrary.http.interceptor.HeadInterceptorUtil;

import java.security.cert.CertificateException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.X509TrustManager;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRtcFactory {
    private static final int DEFAULT_TIMEOUT_READ = 5;
    private static final int DEFAULT_TIMEOUT_WRITE = 5;
    private static final int DEFAULT_TIMEOUT_CONNECT = 5;


    private static RetrofitRtcFactory sRetrofitFactory;
    private static OkHttpClient sOkHttpClient;
    private static Retrofit sRetrofit;


    private static ConnectionSpec getConnectionSpec() {
        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_0).cipherSuites(CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA).build();
        return spec;
    }


    /**

     */
    private RetrofitRtcFactory() {
        sOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT_READ, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT_WRITE, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
//                .addInterceptor(HeadInterceptorUtil.providerInterceptor())
                .addInterceptor(HeadInterceptorUtil.getHeadInterceptor())
                .addInterceptor(HeadInterceptorUtil.getLogInterceptor())
//                .connectionSpecs(Collections.singletonList(getConnectionSpec()))
                .build();


        sRetrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(sOkHttpClient)
                .addConverterFactory(ResponseRtcConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    private String getBaseUrl() {
        return "https://overseas-webrtc.tliveplay.com/";
    }


    public static RetrofitRtcFactory getInstance() {
        if (sRetrofitFactory == null) {
            synchronized (RetrofitRtcFactory.class) {
                if (sRetrofitFactory == null) {
                    sRetrofitFactory = new RetrofitRtcFactory();
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
