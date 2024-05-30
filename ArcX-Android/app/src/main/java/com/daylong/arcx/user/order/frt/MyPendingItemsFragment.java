package com.daylong.arcx.user.order.frt;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;
import com.daylong.httplibrary.model.contract.user.MyPendingItemsContract;
import com.daylong.httplibrary.model.model.user.MyPendingItemsModel;
import com.daylong.httplibrary.model.presenter.user.MyPendingItemsPresenter;
import com.daylong.arcx.R;
import com.daylong.arcx.adapter.MyGoodsAdapter;
import com.daylong.arcx.user.order.UserOrderConfirmActivity;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.ui.frt.BaseListFragment;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;

import java.util.List;

public class MyPendingItemsFragment extends BaseListFragment<MyPendingItemsPresenter, MyPendingItemsModel, MyGoodsResponse> implements MyPendingItemsContract.MyPendingItemsView {
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
        mPresenter.getMyPendingItemsList(page);
    }


    private BaseButton btnNewAddress;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);

        btnNewAddress = BaseButton.create(rootView, new ConstraintBuilder(108, 28).bottomCenterH().bottomMargin(25));

        btnNewAddress.setGravity(Gravity.CENTER);
        btnNewAddress.setBackgroundResource(R.drawable.shape_r_30_bg_c48);
        btnNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserOrderConfirmActivity.start(getAppContext(), UserOrderConfirmActivity.class);
            }
        });
        btnNewAddress.setVisibility(View.GONE);
    }

    @NonNull
    @Override
    protected MyPendingItemsPresenter initPresenter() {
        return MyPendingItemsPresenter.newInstance();
    }

    @Override
    public void onMyPendingItemsInfoList(List<MyGoodsResponse> data) {

        setData(data);
        btnNewAddress.setVisibility(page==1&&data.size()==0?View.GONE:View.VISIBLE);
    }
}
