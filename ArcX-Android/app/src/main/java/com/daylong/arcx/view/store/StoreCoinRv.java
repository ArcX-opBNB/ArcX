package com.daylong.arcx.view.store;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.daylong.arcx.R;
import com.daylong.arcx.adapter.store.StoreCoinAdapter;
import com.daylong.arcx.callback.OnPayItemClickListener;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.recycler.BaseRecyclerView;

import java.util.List;

public class StoreCoinRv extends BaseRecyclerView {
    private StoreCoinAdapter storeCoinAdapter;

    public StoreCoinRv(@NonNull Context context) {
        super(context);


        storeCoinAdapter = new StoreCoinAdapter();


        ConstraintLayout headerView = new ConstraintBuilder().mm().height(21).build(getContext());


        MyImageView myImageView = new MyImageView(getContext());
        myImageView.setImageReg(R.drawable.img_store_coin_title);
        myImageView.setLayoutParams(new ConstraintBuilder(168, 21).center().buildPayoutParams());
        headerView.addView(myImageView);

        storeCoinAdapter.addHeaderView(headerView);
        setAdapter(storeCoinAdapter);
        storeCoinAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (onPayItemClickListener != null) {
                    onPayItemClickListener.onItemCoinClick(storeCoinAdapter.getData().get(position));
                }
            }
        });
    }

    private OnPayItemClickListener onPayItemClickListener;

    public void setOnPayItemClickListener(OnPayItemClickListener onPayItemClickListener) {
        this.onPayItemClickListener = onPayItemClickListener;
    }

    protected GridLayoutManager gridLayoutManager;

    @Override
    public LayoutManager getMyLayoutManager() {
        if (gridLayoutManager == null) {
            gridLayoutManager = new GridLayoutManager(getContext(), 3);
        }
        return gridLayoutManager;
    }

    public void setData(List<StoreInfoResponse.CnTblnDTO> items) {

        storeCoinAdapter.setList(items);
    }
}
