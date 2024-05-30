package com.daylong.arcx.view.user;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.daylong.arcx.user.userinfo.adapter.UserAttributeAdapter;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.recycler.GridRecyclerView;

import java.util.List;

/**

 */
public class UserAttributeRv extends GridRecyclerView {

    private UserAttributeAdapter userAttributeAdapter;


    public UserAttributeRv(@NonNull Context context, View topView, View bottomView) {
        super(context);


        setLayoutParams(new ConstraintBuilder().mw().topToBottom(topView).topMargin(26).leftMargin(2).rightMargin(15).centerH().buildPayoutParams());

        userAttributeAdapter = new UserAttributeAdapter();
        setAdapter(userAttributeAdapter);
        DefaultView defaultView = new DefaultView(getContext());
        defaultView.setLayoutParams(new ConstraintBuilder(188, 60).topCenterH().buildPayoutParams());
        userAttributeAdapter.addFooterView(defaultView);
        userAttributeAdapter.setOnItemClickListener(new com.chad.library.adapter.base.listener.OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {


                LoginUserInfoResponse.AtbTblnDTO atbTblnDTO = userAttributeAdapter.getData().get(position);
                if (atbTblnDTO != null && atbTblnDTO.isShowUpdate()) {

                    if (onItemClickListener != null) {
                        onItemClickListener.click(atbTblnDTO);
                    }
                }


            }
        });

    }


    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(List<LoginUserInfoResponse.AtbTblnDTO> atbTblnDTOs) {
        userAttributeAdapter.setList(atbTblnDTOs);
    }

    public interface OnItemClickListener {
        void click(LoginUserInfoResponse.AtbTblnDTO item);
    }

}
