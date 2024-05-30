package com.daylong.arcx.adapter.store;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.arcx.R;
import com.daylong.arcx.view.RechargeNumberView;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;


public class StorePropAdapter extends BaseQuickAdapter<StoreInfoResponse.PpyIfoDTO.PpyTblnDTO, MyViewHolder> {
    public StorePropAdapter() {
        super(-1);
    }

    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {

        ConstraintLayout rootView = new ConstraintBuilder(59, 84).topMargin(6).rightMargin(2).build(parent.getContext());
        rootView.setId(net.daylong.daylongbase.R.id.base_view_9);
        rootView.setBackgroundResource(R.drawable.img_store_coin_item_bg);


        MyImageView ivCoin = MyImageView.create(rootView, new ConstraintBuilder(32, 32).topCenterH().topMargin(16));
        ivCoin.setId(net.daylong.daylongbase.R.id.base_view_1);


        RechargeNumberView rechargeNumberView = new RechargeNumberView(getContext());
        rechargeNumberView.setCanvasImageStart(new CanvasImageBean(7, 9, DrawableUtils.getDrawableByName("img_recharge_num_x")));
        rechargeNumberView.setCanvasImageNum(new CanvasImageBean(7, 9));
        rechargeNumberView.setCanvasImageDot(new CanvasImageBean(3, 9));
        rechargeNumberView.setId(net.daylong.daylongbase.R.id.base_view_2);
        rechargeNumberView.setLayoutParams(new ConstraintBuilder(9, 9).topRight().topRightMargin(10, 7).buildPayoutParams());
        rootView.addView(rechargeNumberView);
        MyTextView tvPrice = MyTextView.create(rootView, new ConstraintBuilder().ww().bottomCenterH().bottomMargin(4));

        tvPrice.setId(net.daylong.daylongbase.R.id.base_view_3);


        return createBaseViewHolder(rootView);
    }

    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, StoreInfoResponse.PpyIfoDTO.PpyTblnDTO ppyTblnDTO) {
        myViewHolder.setImageUrl(net.daylong.daylongbase.R.id.base_view_1, ppyTblnDTO.getPct());


        RechargeNumberView numberView = myViewHolder.getView(net.daylong.daylongbase.R.id.base_view_2);
        myViewHolder.setVisible(net.daylong.daylongbase.R.id.base_view_2, ppyTblnDTO.isShowNum());
        numberView.setNum(ppyTblnDTO.getPpyAmt());
        MyTextView tvPrice = myViewHolder.getView(net.daylong.daylongbase.R.id.base_view_3);


        if (ppyTblnDTO.isSoFlg()) {
            tvPrice.initText("Sold out", 13, R.color.color_50000000, true);

            DrawableUtils.setLeftDrawable(tvPrice, 10, -1);

        } else {
            tvPrice.initText(ppyTblnDTO.getAxcAmt() + "", 11, R.color.color_fbfc64, true);

            DrawableUtils.setLeftDrawable(tvPrice, 10, com.daylong.reglinrary.R.drawable.img_axc);


        }


    }
}
