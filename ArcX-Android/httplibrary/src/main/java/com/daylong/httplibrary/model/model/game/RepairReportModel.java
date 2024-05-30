package com.daylong.httplibrary.model.model.game;


import com.daylong.httplibrary.api.GameApi;
import com.daylong.httplibrary.bean.request.GameInfoRequest;
import com.daylong.httplibrary.model.contract.game.RepairReportContract;

import net.daylong.baselibrary.http.RetrofitFactory;
import net.daylong.baselibrary.http.base.BaseResponse;

import io.reactivex.Observable;


public class RepairReportModel implements RepairReportContract.RepairReportModel {

    public static RepairReportModel newInstance() {
        return new RepairReportModel();
    }



    @Override
    public Observable<BaseResponse<Object>> postRepairReport(Integer productId) {
        return RetrofitFactory.getInstance().createApi(GameApi.class).postRepairReport(new GameInfoRequest(productId));
    }
}
