package com.daylong.gamelibrary.view.title.visit;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.view.recycler.HorizontalRecyclerView;

import java.util.List;

public class GameVisitViewRv extends HorizontalRecyclerView {


    public BaseQuickAdapter<UserInfoResponse, MyViewHolder> adapter;

    public GameVisitViewRv(@NonNull Context context, BaseQuickAdapter<UserInfoResponse, MyViewHolder> adapter) {
        super(context);


        this.adapter = adapter;
        setAdapter(adapter);
    }

    public void setList(List<UserInfoResponse> list) {
        adapter.setList(list);
    }

}
