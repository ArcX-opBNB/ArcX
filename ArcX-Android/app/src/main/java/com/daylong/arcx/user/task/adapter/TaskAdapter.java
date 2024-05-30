package com.daylong.arcx.user.task.adapter;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.httplibrary.bean.response.user.TaskInfoResponse;
import com.daylong.arcx.R;
import com.daylong.arcx.view.MyProgressBar;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class TaskAdapter extends BaseQuickAdapter<TaskInfoResponse, MyViewHolder> {

    public TaskAdapter() {
        super(0);
    }


    @NonNull
    @Override
    protected MyViewHolder onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = new CardView(getContext());
        cardView.setRadius(AppUtil.getSize(7));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, AppUtil.getSize(45));
        layoutParams.topMargin = AppUtil.getSize(7);
        layoutParams.leftMargin = AppUtil.getSize(8);
        layoutParams.rightMargin = AppUtil.getSize(8);
        cardView.setLayoutParams(layoutParams);


        ConstraintLayout rootView = new ConstraintBuilder().mHei(45).build(parent.getContext());
        cardView.addView(rootView);

        MyImageView myImageView = MyImageView.create(rootView, new ConstraintBuilder(29, 29).leftMargin(6).leftCenterV());
        myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        myImageView.setId(net.daylong.daylongbase.R.id.base_view_1);


        MyTextView tvTitle = MyTextView.create(rootView, new ConstraintBuilder(0,0).hWrap().leftToRightById(myImageView).top(myImageView).rightToLeftById(net.daylong.daylongbase.R.id.base_view_4).leftTopMargin(5, 3).rightMargin(2));
        tvTitle.setId(net.daylong.daylongbase.R.id.base_view_2);
        tvTitle.initText(8, R.color.color_434343, true);


        MyProgressBar myProgressBar = MyProgressBar.create(rootView,
                new ConstraintBuilder(63, 8)
                        .leftToRightById(myImageView)
                        .topToBottom(tvTitle).leftTopMargin(5, 3)
                , R.drawable.task_list_pd);
        myProgressBar.setId(net.daylong.daylongbase.R.id.base_view_3);
        myProgressBar.createTextProgress(6f, R.color.color_185A00);

        BaseButton baseButton = BaseButton.create(rootView, new ConstraintBuilder(51, 18).rightCenterV().rightMargin(6));
        baseButton.setId(net.daylong.daylongbase.R.id.base_view_4);
        baseButton.initBtn(9, R.color.color_434343, false);
        baseButton.setGravity(Gravity.CENTER);

        addChildClickViewIds(net.daylong.daylongbase.R.id.base_view_4);

        return createBaseViewHolder(cardView);
    }


    @Override
    protected void convert(@NonNull MyViewHolder myViewHolder, TaskInfoResponse deviceInfo) {

        myViewHolder.setImageUrl(net.daylong.daylongbase.R.id.base_view_1, deviceInfo.getTaskImgUrl());
        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_2, deviceInfo.getTaskDesc());
        MyProgressBar pd = myViewHolder.findView(net.daylong.daylongbase.R.id.base_view_3);
        pd.setProgress(deviceInfo.getDP(), deviceInfo.getPdStr());


        myViewHolder.setText(net.daylong.daylongbase.R.id.base_view_4, deviceInfo.getBtnText());


        int btnBg = R.drawable.btn_task_2;
        if (deviceInfo.isComplete()) {
            btnBg = R.drawable.btn_task_3;
        } else if (deviceInfo.isReceive()) {
            btnBg = R.drawable.btn_task_1;
        }

        myViewHolder.setBackgroundResource(net.daylong.daylongbase.R.id.base_view_4, btnBg);

    }


}
