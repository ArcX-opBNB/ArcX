package com.daylong.arcx.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.httplibrary.bean.response.user.MyGoodsResponse;
import com.daylong.arcx.R;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class MyGoodsAdapter extends BaseQuickAdapter<MyGoodsResponse, MyViewHolder> {

    public MyGoodsAdapter() {
        super(0);
    }


    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout rootView2 = new ConstraintBuilder().mm().height(70).topMargin(8).build(parent.getContext());


        CardView cardView = new CardView(getContext());
        cardView.setRadius(AppUtil.getSize(7));
        cardView.setLayoutParams( new ConstraintBuilder(171,68).center().buildPayoutParams());

        ConstraintLayout rootView = new ConstraintBuilder().mm().build(parent.getContext());
        cardView.addView(rootView);


        MyImageView myImageView = MyImageView.create(rootView, new ConstraintBuilder(52, 52).leftCenterV().leftMargin(8));
        myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        myImageView.setId(net.daylong.daylongbase.R.id.base_view_1);


        MyTextView myTextView = MyTextView.create(rootView, new ConstraintBuilder().ww()
                .leftToRightById(myImageView.getId())
                .top(myImageView)
                .leftTopMargin(7, 1)
        );
        myTextView.setId(net.daylong.daylongbase.R.id.base_view_2);
        myTextView.initText(8, R.color.color_434343, true);


        MyTextView tvNunName = MyTextView.create(rootView, new ConstraintBuilder().ww()
                .left(myTextView)
                .topToBottom(myTextView)
                .topMargin(3));
        tvNunName.setId(net.daylong.daylongbase.R.id.base_view_4);



        MyTextView coinNum = MyTextView.create(rootView, new ConstraintBuilder().ww()
                .right()
                .centerV(tvNunName)
                .rightMargin(8));
        coinNum.setId(net.daylong.daylongbase.R.id.base_view_5);
        coinNum.initText(7, R.color.color_979797, false);

        rootView2.addView(cardView);
        return createBaseViewHolder(rootView2);
    }


    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, MyGoodsResponse deviceInfo) {


        myViewHolder.setImageUrl(net.daylong.daylongbase.R.id.base_view_1, deviceInfo.getAwardImgUrl());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_2, deviceInfo.getAwardName());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_5, "x" + deviceInfo.getAwardNum() + "");


    }


}
