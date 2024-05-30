package com.daylong.gamelibrary.view.title.visit.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.UserIconView;

public class GameVisitAdapter extends BaseQuickAdapter<UserInfoResponse, MyViewHolder> {
    public GameVisitAdapter() {
        super(0);
    }

    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserIconView imageView = new UserIconView(getContext());
        imageView.setLayoutParams( new ConstraintBuilder(18).leftMargin(2).buildPayoutParams());
        imageView.setId(net.daylong.daylongbase.R.id.base_view_iv);
        return createBaseViewHolder(imageView);
    }

    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, UserInfoResponse s) {
        myViewHolder.setUserIcon(net.daylong.daylongbase.R.id.base_view_iv, s);
    }
}
