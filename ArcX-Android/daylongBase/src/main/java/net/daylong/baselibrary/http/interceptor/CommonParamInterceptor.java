package net.daylong.baselibrary.http.interceptor;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.http.Body;

/**

 */
public class CommonParamInterceptor implements Interceptor {
    private static final String REQUEST_METHOD_POST = "POST";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        if (request.method() == REQUEST_METHOD_POST) {
            request = addPostBaseParams(request);
        } else {
            request = addGetBaseParams(request);

        }


        return chain.proceed(request);


    }

    /**

     *
     * @param request
     * @return
     */
    private Request addGetBaseParams(Request request) {


        HttpUrl.Builder builder = request.url().newBuilder();
        

        //if (UserCache.getInstance().getAccToken() != null) {
        //    builder.addQueryParameter("accessToken", UserCache.getInstance().getAccToken());
        //
        //}

        //builder.addQueryParameter("versionCode", String.valueOf(SystemUtil.getVersionCode()));
        //builder.addQueryParameter("language", MultiLanguageUtils.getCurrentLanguage());
        
        
        //String productId = AppSharedPreferencesManage.getInstance().getProductId();


        //if (!TextUtils.isEmpty(productId)) {
        
        //
        ////}
        //HttpUrl newUrl =
        //        builder.addQueryParameter("version", SystemUtil.getVersionName())
        //                .build();
        return request.newBuilder()
                //.url(newUrl)
                .build();
    }

    /**

     *
     * @param request
     * @return
     */
    private Request addPostBaseParams(Request request) {

        boolean isAddProductId = false;
        /**




         */
        RequestBody body = request.body();

        if (body instanceof Body) {
            Body formBody = (Body) request.body();
            FormBody.Builder builder = new FormBody.Builder();

            //for (int i = 0; i < formBody.size(); i++) {
            
            //    if (formBody.value(i) != null) {
            //
            //        String name = formBody.name(i);
            //        builder.add(name, formBody.value(i));
            //
            //        if ("productId".equals(name)) {
            //            isAddProductId = true;
            //        }
            //
            //    }
            //
            //
            //}

//            builder.add("version", SystemUtil.getVersionName());

//            builder.add("language", MultiLanguageUtils.getCurrentLanguage());
//

//            builder.add("mobilePlatform", "1");

//            builder.add("versionCode", String.valueOf(SystemUtil.getVersionCode()));


//
//
//
//
//            String productId = AppSharedPreferencesManage.getInstance().getProductId();
//            if (!TextUtils.isEmpty(productId) && !isAddProductId) {
//                builder.add("productId", productId);//
//
//            }
//            if (UserCache.getInstance().getAccToken() != null) {

//
//            }
//            formBody = builder.build();
//            request = request.newBuilder().post(formBody).build();
        }
        return request;
    }


}
