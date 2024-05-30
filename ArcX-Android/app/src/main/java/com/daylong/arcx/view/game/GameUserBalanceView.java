package com.daylong.arcx.view.game;

import android.content.Context;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.uitls.UserCache;
import com.daylong.arcx.view.user.UserBalanceView;
import com.daylong.gamelibrary.view.title.IUserGameBalance;

import net.daylong.baselibrary.bean.IUserInfo;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.img.UserIconView;

public class GameUserBalanceView extends IUserGameBalance {
    private UserBalanceView userBalanceView;
    private UserBalanceView userAxcBalanceView;

    public GameUserBalanceView(@NonNull Context context) {
        super(context);
        setLayoutParams(new ConstraintBuilder().ww().
                height(18)
                .centerV(net.daylong.daylongbase.R.id.base_view_1)
                .left()
                .buildPayoutParams());


        ivUserIcon = UserIconView.create(this, new ConstraintBuilder(18).leftTop());


        userBalanceView = new UserBalanceView(getContext(), ivUserIcon, 2, R.drawable.img_coin);
        addView(userBalanceView);

        userAxcBalanceView = new UserBalanceView(getContext(), userBalanceView, 0, com.daylong.reglinrary.R.drawable.img_axc);
        addView(userAxcBalanceView);
        ivUserIcon.setUserImage(UserCache.getUserInfo());


    }

    public MyImageView getAxcIconView() {
        return userAxcBalanceView.getIconView();
    }


    private UserIconView ivUserIcon;

    private IUserInfo curUserInfo;


    @Override
    public void setUserInfo(IUserInfo userInfo) {

//        if (userInfo == null) {
//            return;
//        }
//        if (curUserInfo != null && Objects.equals(curUserInfo.getUserId(), userInfo.getUserId())) {
//            return;
//        }
//
//        ivUserIcon.setUserImage(userInfo);
//        curUserInfo = userInfo;
    }

    @Override
    public void updateBalance(long balance, long integralNum) {
        if (userBalanceView != null) {
            userBalanceView.setBalance(balance);

        }
        if (userAxcBalanceView != null && integralNum >= 0) {
            userAxcBalanceView.setBalance(integralNum);

        }
    }

}
