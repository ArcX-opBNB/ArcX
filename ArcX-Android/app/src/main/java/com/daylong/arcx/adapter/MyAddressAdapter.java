package com.daylong.arcx.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.httplibrary.bean.response.user.MyAddressResponse;
import com.daylong.arcx.R;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class MyAddressAdapter extends BaseQuickAdapter<MyAddressResponse, MyViewHolder> {

    public MyAddressAdapter() {
        super(0);
    }


    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {

        ConstraintLayout rootView2 = new ConstraintBuilder().mm().height(60).topMargin(8).build(parent.getContext());
        CardView cardView = new CardView(getContext());
        cardView.setRadius(AppUtil.getSize(7));
        cardView.setLayoutParams(new ConstraintBuilder(174, 57).center().buildPayoutParams());

        ConstraintLayout rootView = new ConstraintBuilder().mm().build(parent.getContext());
        cardView.addView(rootView);


        MyTextView tvName = MyTextView.create(rootView, new ConstraintBuilder().ww()
                .left()
                .top()
                .leftTopMargin(7, 6)
        );
        tvName.setId(net.daylong.daylongbase.R.id.base_view_1);
        tvName.initText(8, R.color.color_434343, true);


        MyTextView tvAddress = MyTextView.create(rootView, new ConstraintBuilder().ww()
                .left(tvName)
                .topToBottom(tvName)
                .topMargin(5)
        );
        tvAddress.setId(net.daylong.daylongbase.R.id.base_view_2);
        tvAddress.initText(7, R.color.color_aaaaaa, false);

        MyTextView tvPhone = MyTextView.create(rootView, new ConstraintBuilder().ww()
                .right()
                .top()

                .topRightMargin(7, 7)
        );
        tvPhone.setId(net.daylong.daylongbase.R.id.base_view_3);
        tvPhone.initText(8, R.color.color_434343, true);


        DefaultView defaultView = DefaultView.create(rootView, new ConstraintBuilder(160, 1).topToBottom(tvAddress).left(tvName).topMargin(4));
        defaultView.setId(View.generateViewId());


        MyImageView myImageView = MyImageView.create(rootView, new ConstraintBuilder(12).topToBottom(defaultView).left().leftMargin(6), R.drawable.img_address_checkbox);
        myImageView.setId(net.daylong.daylongbase.R.id.base_view_iv);

        MyTextView defAddress = MyTextView.create(rootView, new ConstraintBuilder().ww()
                .leftToRightById(myImageView)
                .centerV(myImageView)
                .leftMargin(4)
        );
        defAddress.setId(net.daylong.daylongbase.R.id.base_view_4);
        defAddress.initText(7, R.color.color_434343, false);


        MyTextView tvDelete = MyTextView.create(rootView, new ConstraintBuilder().ww()
                .right()
                .bottom()
                .rightBottomMargin(7, 7)
        );

        tvDelete.setId(net.daylong.daylongbase.R.id.base_view_6);

        DrawableUtils.seLeftDrawable(tvDelete, R.drawable.img_address_delete, AppUtil.getSize(9), AppUtil.getSize(9));


        MyTextView tvEt = MyTextView.create(rootView, new ConstraintBuilder().ww()
                .rightToLeftById(tvDelete.getId())
                .top(tvDelete.getId())
                .bottom(tvDelete.getId())
                .rightMargin(8)
        );
        tvEt.setId(net.daylong.daylongbase.R.id.base_view_5);

        DrawableUtils.seLeftDrawable(tvEt, R.drawable.img_address_edit, AppUtil.getSize(9), AppUtil.getSize(9));

        addChildClickViewIds(net.daylong.daylongbase.R.id.base_view_5);
        addChildClickViewIds(net.daylong.daylongbase.R.id.base_view_6);
        rootView2.addView(cardView);
        return createBaseViewHolder(rootView2);
    }


    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, MyAddressResponse deviceInfo) {

        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_1, deviceInfo.getName());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_2, deviceInfo.getAddress() + deviceInfo.getArea());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_3, deviceInfo.getAddress2());


        myViewHolder.setVisible(net.daylong.daylongbase.R.id.base_view_iv,deviceInfo.getDefaultFlag()==1);
        myViewHolder.setVisible(net.daylong.daylongbase.R.id.base_view_4,deviceInfo.getDefaultFlag()==1);

    }






}
