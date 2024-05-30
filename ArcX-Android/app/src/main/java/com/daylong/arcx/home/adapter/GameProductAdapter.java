package com.daylong.arcx.home.adapter;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

public class GameProductAdapter extends BaseQuickAdapter<GameItemInfoResponse, MyViewHolder> {

    public GameProductAdapter() {
        super(0);
    }


    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {


        ConstraintLayout rootView = new ConstraintBuilder(87, 82).topMargin(6).leftMargin(5).build(parent.getContext());

        rootView.setBackgroundResource(R.drawable.bg_game_pusher_item);

        CardView cardView = new CardView(getContext());
        cardView.setRadius(AppUtil.getSize(8));
        cardView.setLayoutParams(new ConstraintBuilder(80, 53).topCenterH().topMargin(12).buildPayoutParams());

        MyImageView myImageView = MyImageView.create(cardView, new ConstraintBuilder().mm());
        myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        myImageView.setId(net.daylong.daylongbase.R.id.base_view_1);
        rootView.addView(cardView);

        MyTextView myTextView = MyTextView.create(rootView, new ConstraintBuilder().ww().topCenterH().topMargin(1));
        myTextView.setId(net.daylong.daylongbase.R.id.base_view_2);
        myTextView.initText(7, R.color.color_white, true);
        Shader shader = new LinearGradient(0, 0, 0, myTextView.getTextSize(),
                Color.parseColor("#66EEFF"), Color.parseColor("#71C5FF"), Shader.TileMode.CLAMP);
        myTextView.getPaint().setShader(shader);

        myTextView.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(3), getContext().getColor(R.color.color_273c76));

        MyTextView coinNum = MyTextView.create(rootView, new ConstraintBuilder().ww()
                .bottomCenterH().bottomMargin(5));
        coinNum.setId(net.daylong.daylongbase.R.id.base_view_4);
        coinNum.initText(8, R.color.color_fbfc64, true);
        DrawableUtils.setLeftDrawable(coinNum, 8, 8, R.drawable.img_coin);
        coinNum.setCompoundDrawablePadding(AppUtil.getSize(2));
        return createBaseViewHolder(rootView);
    }


    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, GameItemInfoResponse deviceInfo) {


        myViewHolder.setImageUrl(net.daylong.daylongbase.R.id.base_view_1, deviceInfo.getProductImgUrl());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_2, deviceInfo.getProductName());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_4, deviceInfo.getCostNum() + "");


    }


}
