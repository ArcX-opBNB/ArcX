package com.daylong.arcx.user.userinfo.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.arcx.view.user.UserAttributeItemView;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class UserAttributeAdapter extends BaseQuickAdapter<LoginUserInfoResponse.AtbTblnDTO, MyViewHolder> {

    public UserAttributeAdapter() {
        super(0);
    }


    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {

        ConstraintLayout rootView = new ConstraintBuilder(73, 82).leftMargin(13).build(parent.getContext());

        UserAttributeItemView userAttributeItemView = new UserAttributeItemView(getContext());
        userAttributeItemView.setId(net.daylong.daylongbase.R.id.base_view_1);
        rootView.addView(userAttributeItemView);
        return createBaseViewHolder(rootView);
    }


    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, LoginUserInfoResponse.AtbTblnDTO atbTblnDTO) {

        UserAttributeItemView view = myViewHolder.getView(net.daylong.daylongbase.R.id.base_view_1);
        view.setData(atbTblnDTO);
    }


}
