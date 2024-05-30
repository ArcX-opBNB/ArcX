package com.daylong.arcx.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daylong.httplibrary.bean.response.defaults.HomeBannerResponse;

import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.view.img.MyImageView;


public class BannerAdapter extends com.youth.banner.adapter.BannerAdapter<HomeBannerResponse, BannerAdapter.BannerViewHolder> {


    public BannerAdapter() {
        super(null);
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        MyImageView imageView = new MyImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder holder, HomeBannerResponse data, int position, int size) {

        holder.imageView.setImageUrl(data.getImgUrl());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        MyImageView imageView;

        public BannerViewHolder(@NonNull MyImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}
