package com.daylong.arcx.view.store;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.daylong.arcx.R;
import com.daylong.arcx.adapter.store.StoreCoinAdapter;
import com.daylong.arcx.adapter.store.StorePropAdapter;
import com.daylong.arcx.callback.OnPayItemClickListener;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.recycler.BaseRecyclerView;

import java.util.List;

/**

 */
public class StorePropRv extends BaseRecyclerView {
    private StorePropAdapter storeCoinAdapter;

    public StorePropRv(@NonNull Context context) {
        super(context);


        storeCoinAdapter = new StorePropAdapter();
        setAdapter(storeCoinAdapter);

        DefaultView defaultView = new DefaultView(getContext());
        defaultView.setLayoutParams(new ConstraintBuilder().mm().height(50).buildPayoutParams());
        defaultView.setBackgroundColor(Color.TRANSPARENT);


        storeCoinAdapter.addFooterView(defaultView);

        storeCoinAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                StoreInfoResponse.PpyIfoDTO.PpyTblnDTO ppyTblnDTO = storeCoinAdapter.getData().get(position);

                if (onPayItemClickListener != null&&!ppyTblnDTO.isSoFlg()) {
                    onPayItemClickListener.onItemPropClick(ppyTblnDTO);
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

    public void setData(List<StoreInfoResponse.PpyIfoDTO.PpyTblnDTO> items) {

        storeCoinAdapter.setList(items);
    }
}
