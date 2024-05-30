package com.daylong.arcx.home.adapter;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
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
public class GameClawProductAdapter extends BaseQuickAdapter<GameItemInfoResponse, MyViewHolder> {

    public GameClawProductAdapter() {
        super(0);
    }


    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {


        ConstraintLayout rootView = new ConstraintBuilder(162, 80).topMargin(8).build(parent.getContext());

        rootView.setBackgroundResource(R.drawable.bg_game_claw_item);

        CardView cardView = new CardView(getContext());
        cardView.setRadius(AppUtil.getSize(8));
        cardView.setLayoutParams(new ConstraintBuilder(155, 73).center().buildPayoutParams());

        MyImageView myImageView = MyImageView.create(cardView, new ConstraintBuilder().mm());
        myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        myImageView.setId(net.daylong.daylongbase.R.id.base_view_1);
        rootView.addView(cardView);

        MyTextView myTextView = MyTextView.create(rootView, new ConstraintBuilder().ww().bottomCenterH().bottomMargin(8));
        myTextView.setId(net.daylong.daylongbase.R.id.base_view_2);
        myTextView.initText(7, R.color.color_white, true);
        Shader shader = new LinearGradient(0, 0, 0, myTextView.getTextSize(),
                Color.parseColor("#66EEFF"), Color.parseColor("#71C5FF"), Shader.TileMode.CLAMP);
        myTextView.getPaint().setShader(shader);

        myTextView.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(3), getContext().getColor(R.color.color_273c76));

        return createBaseViewHolder(rootView);
    }


    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, GameItemInfoResponse deviceInfo) {


        myViewHolder.setImageUrl(net.daylong.daylongbase.R.id.base_view_1, deviceInfo.getProductImgUrl());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_2, deviceInfo.getProductName());


    }


}
