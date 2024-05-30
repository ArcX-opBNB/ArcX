 package com.daylong.httplibrary.model.model.home;

 import com.daylong.httplibrary.api.DefaultApi;
 import com.daylong.httplibrary.bean.request.DefaultRequest;
 import com.daylong.httplibrary.bean.response.defaults.HomeBannerResponse;
 import com.daylong.httplibrary.model.contract.home.HomeContract;

 import net.daylong.baselibrary.http.RetrofitFactory;
 import net.daylong.baselibrary.http.response.BasePageResponse;

 import io.reactivex.Observable;

 public class HomeModel implements HomeContract.HomeModel {
     public static HomeModel newInstance() {
         return new HomeModel();
     }



     @Override
     public Observable<BasePageResponse<HomeBannerResponse>> getHomeBanner() {
         return RetrofitFactory.getInstance().createApi(DefaultApi.class).getHomeBanner();
     }
 }
