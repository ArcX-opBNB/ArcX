package com.daylong.arcx.user.recharge.adapter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.daylong.httplibrary.bean.response.user.RechargeResponse;
import com.daylong.arcx.R;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class ArcadeRechargeAdapter extends BaseQuickAdapter<RechargeResponse.GoldListDTO, MyViewHolder> {

    public ArcadeRechargeAdapter() {
        super(0);
    }

    private int selectPosition = -1;

    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = new CardView(getContext());
        cardView.setRadius(AppUtil.getSize(7));
        cardView.setId(net.daylong.daylongbase.R.id.base_content_id);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(AppUtil.getSize(52), AppUtil.getSize(55));
        layoutParams.topMargin = AppUtil.getSize(7);
        layoutParams.leftMargin = AppUtil.getSize(5);
        cardView.setLayoutParams(layoutParams);
        ConstraintLayout rootView = new ConstraintBuilder(52, 55).build(parent.getContext());
        cardView.addView(rootView);
        MyImageView myImageView = MyImageView.create(rootView, new ConstraintBuilder(32, 32).topCenterH());
        myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        myImageView.setId(net.daylong.daylongbase.R.id.base_view_1);
        myImageView.setBackgroundColor(Color.RED);



        MyTextView BtnPay = MyTextView.create(rootView, new ConstraintBuilder(32, 12).bottom().bottomMargin(3).centerH());
        BtnPay.setId(net.daylong.daylongbase.R.id.base_view_3);
        BtnPay.initText(8, R.color.color_434343, true);
        BtnPay.setBackgroundResource(R.drawable.shape_invitation_btn_bg);
        BtnPay.setGravity(Gravity.CENTER);
        addChildClickViewIds(net.daylong.daylongbase.R.id.base_view_3);


        MyTextView myTextView = MyTextView.create(rootView, new ConstraintBuilder().ww().bottomToTop(BtnPay.getId()).centerH().bottomMargin(2));
        myTextView.setId(net.daylong.daylongbase.R.id.base_view_2);
        myTextView.initText(7, R.color.color_434343, true);


        CardView cardViewC = new CardView(getContext());
        cardViewC.setId(net.daylong.daylongbase.R.id.base_view_5);
        cardViewC.setLayoutParams(new ConstraintBuilder().mm0().buildPayoutParams());
        cardViewC.setBackground(getGradientDrawable(R.color.color_185A00));
        rootView.addView(cardViewC);


        return createBaseViewHolder(cardView);
    }


    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, RechargeResponse.GoldListDTO deviceInfo) {
        int pos = getPosition(myViewHolder);

        myViewHolder.setVisible(net.daylong.daylongbase.R.id.base_view_5,pos == selectPosition);
        myViewHolder.setImageUrl(net.daylong.daylongbase.R.id.base_view_1, deviceInfo.getAwardImgUrl());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_2, deviceInfo.getAwardNum() + "");
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_3, deviceInfo.getPrice() + "");
//        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_4, deviceInfo.getCostNum() + "");


    }

    public int getPosition(BaseViewHolder baseViewHolder) {
        return baseViewHolder.getAbsoluteAdapterPosition() - getHeaderLayoutCount();
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
        notifyDataSetChanged();

    }


    public GradientDrawable getGradientDrawable(int color) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setStroke(AppUtil.getSize(2), ContextCompat.getColor(getContext(), color)); 
        shape.setCornerRadius(AppUtil.getSize(7)); 
        return shape;

    }

}
