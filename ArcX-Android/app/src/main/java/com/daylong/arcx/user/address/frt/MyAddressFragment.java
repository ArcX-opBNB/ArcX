package com.daylong.arcx.user.address.frt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.daylong.httplibrary.bean.response.user.MyAddressResponse;
import com.daylong.httplibrary.model.contract.user.MyAddressContract;
import com.daylong.httplibrary.model.contract.user.MyAddressEditContract;
import com.daylong.httplibrary.model.model.user.MyAddressModel;
import com.daylong.httplibrary.model.presenter.user.MyAddressEditPresenter;
import com.daylong.httplibrary.model.presenter.user.MyAddressPresenter;
import com.daylong.arcx.adapter.MyAddressAdapter;
import com.daylong.arcx.user.address.NewAddressActivity;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.ui.frt.BaseListFragment;

import java.util.List;

public class MyAddressFragment extends BaseListFragment<MyAddressPresenter, MyAddressModel, MyAddressResponse> implements MyAddressContract.MyAddressView, MyAddressEditContract.MyAddressEditView {
    @Override
    public BaseQuickAdapter<MyAddressResponse, MyViewHolder> getAdapter() {
        return new MyAddressAdapter();
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
        mPresenter.getMyAddressList();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);

        baseQuickAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                int id = view.getId();
                MyAddressResponse myAddressResponse = baseQuickAdapter.getData().get(position);

                if (id == net.daylong.daylongbase.R.id.base_view_5) {


                    NewAddressActivity.start(getContext(), NewAddressActivity.class, "address", myAddressResponse);
                } else if (id == net.daylong.daylongbase.R.id.base_view_6) {
                    myAddressEditPresenter.getMyAddressEditList(new MyAddressResponse(3, myAddressResponse.getAddressId()));
                }
            }
        });

        Bundle arguments = getArguments();
        if (arguments != null) {
            boolean isOrder = arguments.getBoolean("isOrder");

            if (isOrder) {
                baseQuickAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                        Intent intent = new Intent();

                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("address", baseQuickAdapter.getData().get(position)); 
                        getActivity().setResult(Activity.RESULT_OK, resultIntent);
                        finish();
                    }
                });
            }
        }
    }

    private MyAddressEditPresenter myAddressEditPresenter;

    @NonNull
    @Override
    protected MyAddressPresenter initPresenter() {


        myAddressEditPresenter = new MyAddressEditPresenter();
        myAddressEditPresenter.attachMV(myAddressEditPresenter.getModel(), this);
        return MyAddressPresenter.newInstance();
    }

    @Override
    public void onStart() {
        super.onStart();

        page = 1;
        getListUrl();
    }

    @Override
    public void onMyAddressInfoList(List<MyAddressResponse> data) {
        setData(data);

    }

    @Override
    public void onMyAddressEditSuc() {
        page = 1;
        getListUrl();
    }
}
