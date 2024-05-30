package com.daylong.arcx.user.order.frt;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;
import com.daylong.httplibrary.model.contract.user.MyPendingItemsContract;
import com.daylong.httplibrary.model.model.user.MyPendingItemsModel;
import com.daylong.httplibrary.model.presenter.user.MyPendingItemsPresenter;
import com.daylong.arcx.adapter.MyOrderConfirmAdapter;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.ui.frt.BaseListFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderConfirmFragment extends BaseListFragment<MyPendingItemsPresenter, MyPendingItemsModel, MyGoodsResponse> implements MyPendingItemsContract.MyPendingItemsView {
    @Override
    public BaseQuickAdapter<MyGoodsResponse, MyViewHolder> getAdapter() {
        return new MyOrderConfirmAdapter();
    }


    public List<Long> getOrderId() {


        List<Long> list = new ArrayList<>();
        for (MyGoodsResponse datum : baseQuickAdapter.getData()) {
            list.add(datum.getAwardId());
        }

        return list;
    }

    @Override
    public void getListUrl() {
        mPresenter.getMyPendingItemsList(page);
    }

    @NonNull
    @Override
    protected MyPendingItemsPresenter initPresenter() {
        return MyPendingItemsPresenter.newInstance();
    }

    @Override
    public void onMyPendingItemsInfoList(List<MyGoodsResponse> data) {
        setData(data);

    }
}
