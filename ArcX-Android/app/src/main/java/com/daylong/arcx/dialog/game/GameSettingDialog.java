package com.daylong.arcx.dialog.game;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.musiclibrary.mrg.MediaPlayerMrg;
import com.daylong.musiclibrary.mrg.SoundPoolManager;
import com.daylong.userlibrary.cache.UserCache;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.XPopupCallback;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.MyImgBtn;
import net.daylong.baselibrary.view.img.MyImageView;


/**

 */
public class GameSettingDialog extends AttachPopupView {
    private BaseGameActivity activity;

    public GameSettingDialog(@NonNull BaseGameActivity activity) {
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
                .asCustom(new GameSettingDialog(activity))
                .show();
    }

    public static void showDialog(BaseGameActivity activity, View view, XPopupCallback xPopupCallback, PopupPosition popupPosition) {
        showDialog(activity, view, xPopupCallback, popupPosition, PopupAnimation.ScrollAlphaFromTop);

    }

    private boolean music;
    private MyImgBtn btnMusic;

    @Override
    protected void addInnerContent() {

        LinearLayout layout = new LinearLayout(getContext());
        layout.setLayoutParams(new LinearLayout.LayoutParams(AppUtil.getSize(18), ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.VERTICAL);


        MyImgBtn.create(layout, new ConstraintBuilder(18).topMargin(2), R.drawable.img_mch_back, new MyImgBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                if (activity != null) {
                    activity.exitRoom();
                }
            }
        });

        music = UserCache.getInstance().getMusic();
        btnMusic = MyImgBtn.create(layout, new ConstraintBuilder(18).topMargin(2), music ? R.drawable.img_mch_voice_on : R.drawable.img_mch_voice_off, new MyImgBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayerMrg.getInstance().setOpenMusic(!music);

                if (music) {
                    MediaPlayerMrg.getInstance().stop();
                } else {
                    MediaPlayerMrg.getInstance().play();

                }
                music = !music;
                btnMusic.setImageResource(music ? R.drawable.img_mch_voice_on : R.drawable.img_mch_voice_off);
                UserCache.getInstance().setMusic(music);
                SoundPoolManager.getInstance().setSound(music);
            }
        });
        MyImageView.create(layout, new ConstraintBuilder(18).topMargin(2), R.drawable.img_mch_guide);
        MyImageView.create(layout, new ConstraintBuilder(18).topMargin(2), R.drawable.img_mch_fix);

        attachPopupContainer.addView(layout);

    }

    @Override
    protected void onDismiss() {
        super.onDismiss();
        activity = null;
    }
}
