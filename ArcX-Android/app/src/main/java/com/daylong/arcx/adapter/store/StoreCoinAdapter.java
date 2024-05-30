package com.daylong.arcx.adapter.store;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.arcx.R;
import com.daylong.arcx.view.RechargeNumberView;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;


public class StoreCoinAdapter extends BaseQuickAdapter<StoreInfoResponse.CnTblnDTO, MyViewHolder> {
    public StoreCoinAdapter() {
        super(-1);
    }

    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {

        ConstraintLayout rootView = new ConstraintBuilder(59, 84).topMargin(6).rightMargin(2).build(parent.getContext());
        rootView.setBackgroundResource(R.drawable.img_store_coin_item_bg);


        MyImageView ivCoin = MyImageView.create(rootView, new ConstraintBuilder(49, 38).topCenterH().topMargin(11));
        ivCoin.setId(net.daylong.daylongbase.R.id.base_view_1);


        RechargeNumberView rechargeNumberView = new RechargeNumberView(getContext());
        rechargeNumberView.setCanvasImageNum(new CanvasImageBean(5, 7));
        rechargeNumberView.setCanvasImageDot(new CanvasImageBean(1.9f, 7));
        rechargeNumberView.setId(net.daylong.daylongbase.R.id.base_view_2);
        rechargeNumberView.setLayoutParams(new ConstraintBuilder(9, 9).topToBottom(ivCoin).centerH().topMargin(3).buildPayoutParams());

        rootView.addView(rechargeNumberView);
        MyTextView tvPrice = MyTextView.create(rootView, new ConstraintBuilder().ww().bottomCenterH().bottomMargin(4));

        tvPrice.setId(net.daylong.daylongbase.R.id.base_view_3);
        tvPrice.initText(11, R.color.color_fbfc64, true);


        return createBaseViewHolder(rootView);
    }

    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, StoreInfoResponse.CnTblnDTO cnTblnDTO) {
        myViewHolder.setImageUrl(net.daylong.daylongbase.R.id.base_view_1, cnTblnDTO.getPct());


        RechargeNumberView numberView = myViewHolder.getView(net.daylong.daylongbase.R.id.base_view_2);
        numberView.setNum(cnTblnDTO.getCnAmt());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_3, cnTblnDTO.getUsdtAmtStr());


    }
}
