package com.daylong.arcx.dialog.game;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.arcx.R;
import com.daylong.arcx.user.recharge.dialog.ArcadeGameRechargeDialog;
import com.daylong.userlibrary.cache.UserCache;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.XPopupCallback;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;


/**

 */
public class ArcadeGameSettingDialog extends AttachPopupView {
    private BaseGameActivity activity;

    public ArcadeGameSettingDialog(@NonNull BaseGameActivity activity) {
        super(activity);
        this.activity = activity;
    }

    public static void showDialog(BaseGameActivity activity, View view, XPopupCallback xPopupCallback, PopupPosition popupPosition, PopupAnimation popupAnimation) {
        new XPopup.Builder(activity)
                .popupPosition(popupPosition)
                .atView(view)
                .setPopupCallback(xPopupCallback)
                .hasShadowBg(false)
                .popupAnimation(popupAnimation)
                .asCustom(new ArcadeGameSettingDialog(activity))
                .show();
    }

    public static void showDialog(BaseGameActivity activity, View view, XPopupCallback xPopupCallback, PopupPosition popupPosition) {
        showDialog(activity, view, xPopupCallback, popupPosition, PopupAnimation.ScrollAlphaFromTop);

    }

    private     boolean music;
    @Override
    protected void addInnerContent() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, AppUtil.getSize(23));
        layoutParams.topMargin = AppUtil.getSize(4);
        LinearLayout layout = new LinearLayout(getContext());
        layout.setLayoutParams(layoutParams);
        layout.setOrientation(LinearLayout.HORIZONTAL);


        MyImageView play = MyImageView.create(layout, new ConstraintBuilder(23).leftMargin(4), R.drawable.img_mch_buy);

        play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ArcadeGameRechargeDialog gameRechargeDialog = new ArcadeGameRechargeDialog();
                gameRechargeDialog.show(activity.getSupportFragmentManager(), "gameRechargeDialog");
                dismiss();
            }
        });



        music = UserCache.getInstance().getMusic();
        MyImageView ivMusic = MyImageView.create(layout, new ConstraintBuilder(23).leftMargin(4), music ? R.drawable.img_mch_voice_on : R.drawable.img_mch_voice_off);
        ivMusic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                music = !music;
                UserCache.getInstance().setMusic(music);
                ivMusic.setImageRegCrop(music ? R.drawable.img_mch_voice_on : R.drawable.img_mch_voice_off);
                activity.getDnPlayView().setIsMute(!music);
            }
        });
        attachPopupContainer.addView(layout);


    }

    @Override
    protected void onDismiss() {
        super.onDismiss();
        activity = null;
    }
}
