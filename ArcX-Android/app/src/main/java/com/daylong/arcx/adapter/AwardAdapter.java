package com.daylong.arcx.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.arcx.R;
import com.daylong.arcx.view.AwardItemView;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class AwardAdapter extends BaseQuickAdapter<AwardBean, MyViewHolder> {

    public AwardAdapter() {
        super(0);
    }


    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {


        AwardItemView awardItemView = new AwardItemView(getContext());
        awardItemView.setLayoutParams( new ConstraintBuilder().ww().rightMargin(8).buildPayoutParams());
        awardItemView.setId(net.daylong.daylongbase.R.id.base_view_1);
        return createBaseViewHolder(awardItemView);
    }


    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, AwardBean awardBean) {

        AwardItemView awardItemView = myViewHolder.getView(net.daylong.daylongbase.R.id.base_view_1);
        awardItemView.setAwardBean(awardBean);



    }


}
