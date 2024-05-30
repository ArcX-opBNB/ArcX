package com.daylong.arcx.backpack.adapter.nft;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.arcx.R;
import com.daylong.httplibrary.bean.response.game.GameItemInfoResponse;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

/**

 */
public class NftAdapter extends BaseQuickAdapter<GameItemInfoResponse, MyViewHolder> {

    public NftAdapter() {
        super(0);
    }


    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {


        ConstraintLayout rootView = new ConstraintBuilder(78, 94).leftMargin(8).build(parent.getContext());

        rootView.setBackgroundResource(R.drawable.bg_game_claw_item);


        MyTextView tvName = MyTextView.create(rootView, new ConstraintBuilder().ww().topCenterH(1));
        tvName.setId(net.daylong.daylongbase.R.id.base_view_1);
        tvName.initText("Listing", 7, R.color.color_white);


        MyImageView ivIcon = MyImageView.create(rootView, new ConstraintBuilder(49, 38).topToBottom(tvName).centerH().topMargin(4));
        ivIcon.setId(net.daylong.daylongbase.R.id.base_view_2);
        ivIcon.setImageReg(R.drawable.img_home_nav_nft_puasher);


        MyImageView ivCoin2 = MyImageView.create(rootView, new ConstraintBuilder(12, 12).topToBottom(ivIcon).left().topMargin(1));
        ivCoin2.setId(net.daylong.daylongbase.R.id.base_view_3);

        ivCoin2.setImageReg(R.drawable.img_coin);

        MyTextView tvName2 = MyTextView.create(rootView, new ConstraintBuilder().ww().centerV(ivCoin2).centerH());
        tvName2.setId(net.daylong.daylongbase.R.id.base_view_4);
        tvName2.initText("NAME", 10, net.daylong.daylongbase.R.color.color_333);


        MyTextView tvNo = MyTextView.create(rootView, new ConstraintBuilder().ww().topToBottom(tvName2).left(tvName2).leftMargin(5).centerH());
        tvNo.setId(net.daylong.daylongbase.R.id.base_view_5);
        tvNo.initText("123123", 5, net.daylong.daylongbase.R.color.color_333);
        tvNo.setGravity(Gravity.CENTER_VERTICAL);

//        DrawableUtils.setLeftDrawable(tvNo,7,7,R.drawable.);
        return createBaseViewHolder(rootView);
    }


    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, GameItemInfoResponse deviceInfo) {


        myViewHolder.setImageUrl(net.daylong.daylongbase.R.id.base_view_1, deviceInfo.getProductImgUrl());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_2, deviceInfo.getProductName());


    }


}
