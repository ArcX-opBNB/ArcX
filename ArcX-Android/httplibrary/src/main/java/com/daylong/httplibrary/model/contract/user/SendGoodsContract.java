package com.daylong.httplibrary.model.contract.user;

import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;

import net.daylong.baselibrary.http.mvp.BasePresenter;
import net.daylong.baselibrary.http.response.BasePageResponse;
import net.daylong.baselibrary.http.response.IBaseView;
import net.daylong.baselibrary.http.view.IViewBaseModel;

import java.util.List;

import io.reactivex.Observable;

/**

 */
public interface SendGoodsContract {
    interface SendGoodsModel extends IViewBaseModel {



        Observable<BasePageResponse<MyGoodsResponse>> getSendGoodsList(int page);

    }

    interface SendGoodsView extends IBaseView {
        void onSendGoodsInfoList(List<MyGoodsResponse> data);


    }

    abstract class SendGoodsPresenter extends BasePresenter<SendGoodsModel, SendGoodsView> {


        public abstract void getSendGoodsList(int page);

    }
}
