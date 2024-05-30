package com.daylong.arcx.view.game;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.view.title.IGameUserView;

import net.daylong.baselibrary.bean.IUserInfo;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.UserIconView;

public class GameUserInfoView extends IGameUserView {
    private UserIconView ivUserIcon;

    public GameUserInfoView(@NonNull Context context, View view) {
        super(context);
        ConstraintBuilder constraintBuilder = new ConstraintBuilder(18);


        if (view != null) {
            constraintBuilder.leftToRightById(view).centerV(view);
        }
        ivUserIcon = UserIconView.create(this,constraintBuilder.leftMargin(6));

    }

    @Override
    public void setGameUserInfo(IUserInfo info) {
        ivUserIcon.setUserImage(info);
    }
}
