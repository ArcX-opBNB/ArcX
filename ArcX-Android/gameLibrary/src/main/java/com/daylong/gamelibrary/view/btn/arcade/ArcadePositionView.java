package com.daylong.gamelibrary.view.btn.arcade;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.ArcadePositionBean;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;


public class ArcadePositionView extends ConstraintLayout {
    public ArcadePositionView(Context context) {
        super(context);


        createStartBtn();

    }
    private StartArcadeBtn startArcadeBtn;

    private StartArcadeBtn createStartBtn() {
        if (startArcadeBtn == null) {
            startArcadeBtn = new StartArcadeBtn(getContext());
            addView(startArcadeBtn);
        }

        startArcadeBtn.setVisibility(View.VISIBLE);
        return startArcadeBtn;
    }

    private MyImageView ivUserIcon;

    private MyImageView createUserIcon() {
        if (ivUserIcon == null) {
            ivUserIcon = MyImageView.create(this,  new ConstraintBuilder(20).center());
            ivUserIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        ivUserIcon.setVisibility(View.VISIBLE);
        return ivUserIcon;

    }

    public void setData(ArcadePositionBean gamePosition) {
        UserInfoResponse gamingUserMsg = gamePosition.getUserInfoResponse();


        
        if (gamingUserMsg == null) {
            
            createStartBtn();
            if (ivUserIcon != null && ivUserIcon.getVisibility() != View.GONE) {
                ivUserIcon.setVisibility(View.GONE);
            }
            createStartBtn().setData(gamePosition);
        } else {
            if (startArcadeBtn != null && startArcadeBtn.getVisibility() != View.GONE) {
                startArcadeBtn.setVisibility(View.GONE);
            }
            createUserIcon().setImageUrlRound(gamingUserMsg.getUserImgUrl());

        }
    }
}
