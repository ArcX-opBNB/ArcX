package net.daylong.baselibrary.view.img;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.bean.IUserInfo;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class UserIconView extends MyImageView {

    public static UserIconView create(ViewGroup viewGroup, ConstraintBuilder builder) {


        UserIconView myImageView = new UserIconView(viewGroup.getContext());
        myImageView.setLayoutParams(builder.buildPayoutParams());
        viewGroup.addView(myImageView);
        return myImageView;

    }


    public UserIconView(@NonNull Context context) {
        super(context);
        setId(View.generateViewId());
    }


    public void setUserImage(IUserInfo userInfo) {
        setImageUrlRound(userInfo.getUserImgUrl());

    }

}
