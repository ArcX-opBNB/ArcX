package com.daylong.arcx.view.game;

import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.act.BaseGameActivity;
import com.daylong.gamelibrary.view.title.visit.BaseGameVisitView;
import com.daylong.gamelibrary.view.title.visit.IGameVisitView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.SimpleCallback;
import com.daylong.arcx.R;
import com.daylong.arcx.dialog.charter.ArcadeExitDialog;
import com.daylong.arcx.dialog.charter.CharterEndToastDialog;
import com.daylong.arcx.dialog.game.ArcadeGameSettingDialog;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class ArcadeGameTitle extends PushCoinGameTitle {

    public ArcadeGameTitle(@NonNull BaseGameActivity context) {
        super(context);
    }

    @Override
    protected IGameVisitView getGameVisitView() {
        return new BaseGameVisitView(getContext(), new ConstraintBuilder(0, 15).rightToLeftById(ibtSetting.getId()).centerV(ibtSetting).leftRightMargin(3));
    }

    @Override
    protected void clickSetting(View view) {
        ibtSetting.setImageResource(R.drawable.img_mch_more_on);
        ArcadeGameSettingDialog.showDialog(activity, view, new SimpleCallback() {
            @Override
            public void onDismiss(BasePopupView popupView) {
                super.onDismiss(popupView);
                ibtSetting.setImageResource(R.drawable.img_mch_more);

            }
        }, PopupPosition.Bottom);
    }


    @Override
    protected void back() {
        if (ICharterFlightButton != null && ICharterFlightButton.isChatter()) {
            
            CharterEndToastDialog.showDialog(activity.getSupportFragmentManager());
        } else {

            if (activity.isMyStart()) {
                ArcadeExitDialog.showDialog(activity.getSupportFragmentManager());
            } else {
                activity.exitRoom();
            }


        }
    }
}
