package net.daylong.baselibrary.http.interceptor;


import net.daylong.baselibrary.utils.MyLogUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;


public class HeadInterceptorUtil {
    /**

     *
     * @return
     */
    public static Interceptor getHeadInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                Request build = builder.build();
                return chain.proceed(build);
            }
        }


                ;
    }


    /**

     */
    private static String bodyToString(final Request request) {
        final Request copy = request.newBuilder().build();
        final Buffer buffer = new Buffer();
        try {
            copy.body().writeTo(buffer);
        } catch (IOException e) {
            return "something error,when show requestBody";
        }
        return buffer.readUtf8();
    }

    /**

     *
     * @param str
     * @return
     */
    public static String stringToUnicode(String str) {
        StringBuffer sb = new StringBuffer();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            sb.append("\\u" + Integer.toHexString(c[i]));
        }
        return sb.toString();
    }

    /**

     *
     * @return
     */
    public static Interceptor getLogInterceptor() {
        final Charset UTF8 = Charset.forName("UTF-8");
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                RequestBody requestBody = request.body();
                ResponseBody responseBody = response.body();
                String responseBodyString = responseBody.string();
                String requestMessage;
                requestMessage = request.method() + ' ' + request.url();
                if (requestBody != null) {
                    Buffer buffer = new Buffer();
                    requestBody.writeTo(buffer);
                    requestMessage += "?\n" + buffer.readString(UTF8);
                }



                if (!response.isSuccessful()) {
                    
                    
                    

                }

                return response.newBuilder().body(ResponseBody.create(responseBody.contentType(),
                        responseBodyString.getBytes())).build();
            }
        };
    }


    /**

     *
     * @return
     */
    public static Interceptor providerInterceptor() {
        return new CommonParamInterceptor();
    }
}
