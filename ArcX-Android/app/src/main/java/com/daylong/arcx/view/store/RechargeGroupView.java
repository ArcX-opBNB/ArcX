package com.daylong.arcx.view.store;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;

import com.daylong.arcx.callback.OnPayItemClickListener;
import com.daylong.arcx.nft.NftSalesCoinActivity;
import com.daylong.arcx.view.store.prop.PropHeaderView;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DefaultView;


public class RechargeGroupView extends NestedScrollView {
    private LinearLayout rootView;
    private StoreCoinRv storeCoinRv;
    private PropHeaderView propHeaderView;
    private StorePropRv storePropRv;

    public RechargeGroupView(@NonNull Context context, View tTb) {
        super(context);

        setLayoutParams(new ConstraintBuilder(0, 0).centerH().topToBottom(tTb).bottom().topMargin(12).buildPayoutParams());
        rootView = new LinearLayout(getContext());
        rootView.setLayoutParams(new ConstraintBuilder().mw().buildPayoutParams());
        rootView.setOrientation(LinearLayout.VERTICAL);
        rootView.setGravity(Gravity.CENTER_HORIZONTAL);
        setOverScrollMode(View.OVER_SCROLL_NEVER);
        
        setVerticalScrollBarEnabled(false);
        
        setHorizontalScrollBarEnabled(false);


        superUserPayView = new SuperUserPayItemView(getContext());
        rootView.addView(superUserPayView);
        superUserPayView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onPayItemClickListener != null) {
                    onPayItemClickListener.onItemSpClick(superUserPayView.getSpPlyIfoDTO());
                }

            }
        });
        payCoinMachineItemView = new PayCoinMachineItemView(getContext());
        payCoinMachineItemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                NftSalesCoinActivity.start(getContext());
            }
        });
        rootView.addView(payCoinMachineItemView);

        addView(rootView);

        storeCoinRv = new StoreCoinRv(getContext());
        storeCoinRv.setLayoutParams(new ConstraintBuilder().mw().topMargin(1).leftMargin(3).rightMargin(2).buildPayoutParams());
        rootView.addView(storeCoinRv);


        propHeaderView = new PropHeaderView(getContext());

        rootView.addView(propHeaderView);
        storePropRv = new StorePropRv(getContext());
        storePropRv.setLayoutParams(new ConstraintBuilder().mw().topMargin(1).leftMargin(3).buildPayoutParams());
        rootView.addView(storePropRv);


    }

    private OnPayItemClickListener onPayItemClickListener;

    public void setOnPayItemClickListener(OnPayItemClickListener onPayItemClickListener) {
        this.onPayItemClickListener = onPayItemClickListener;
        storePropRv.setOnPayItemClickListener(onPayItemClickListener);
        storeCoinRv.setOnPayItemClickListener(onPayItemClickListener);
    }

    public void setOnTimeClickList(View.OnClickListener onTimeClickList) {
        propHeaderView.setOnTimeClickList(onTimeClickList);
    }


    private SuperUserPayItemView superUserPayView;
    private PayCoinMachineItemView payCoinMachineItemView;

    public void setData(StoreInfoResponse storeInfoResponse) {

        superUserPayView.setData(storeInfoResponse.getSpPly());
        payCoinMachineItemView.setData(storeInfoResponse.getSelCnMch());
        storeCoinRv.setData(storeInfoResponse.getCnTbln());
        propHeaderView.setTime(storeInfoResponse.getPpyIfo().getRfTm());

        storePropRv.setData(storeInfoResponse.getPpyIfo().getPpyTbln());

    }


}
