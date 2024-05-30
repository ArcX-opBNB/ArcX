package com.daylong.arcx.user.order.frt;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;
import com.daylong.httplibrary.model.contract.user.SendGoodsContract;
import com.daylong.httplibrary.model.model.user.SendGoodsModel;
import com.daylong.httplibrary.model.presenter.user.SendGoodsPresenter;
import com.daylong.arcx.adapter.MyGoodsAdapter;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.ui.frt.BaseListFragment;

import java.util.List;

public class SendGoodsFragment extends BaseListFragment<SendGoodsPresenter, SendGoodsModel, MyGoodsResponse> implements SendGoodsContract.SendGoodsView {
    @Override
    public BaseQuickAdapter<MyGoodsResponse, MyViewHolder> getAdapter() {
        return new MyGoodsAdapter();
    }


    @Override
    protected boolean isRefresh() {
        return true;
    }

    @Override
    protected boolean isLoadMore() {
        return true;
    }

    @Override
    public void getListUrl() {
        mPresenter.getSendGoodsList(page);
    }

    @NonNull
    @Override
    protected SendGoodsPresenter initPresenter() {
        return SendGoodsPresenter.newInstance();
    }

    @Override
    public void onSendGoodsInfoList(List<MyGoodsResponse> data) {
        setData(data);

    }
}
