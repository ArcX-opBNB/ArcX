package com.daylong.arcx.dialog.game.pushcoin;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;


import com.daylong.arcx.view.dragonball.DragonBallsRewardWheel;
import com.daylong.arcx.view.dragonball.GatherDragonBallRewardView;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.game.dragon.DragonBallRewardBean;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.baselibrary.view.img.MyImageView;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class GatherDragonBallRewardDialog extends BaseFragmentDialog {

    public static void show(DragonBallRewardBean reward, BaseDialog.OnDismissListener onDismissListener) {
        GatherDragonBallRewardDialog gatherDragonBallRewardDialog = new GatherDragonBallRewardDialog();
        Bundle bundle = new Bundle();
        gatherDragonBallRewardDialog.setOnDismissListener(onDismissListener);
        bundle.putSerializable("reward", reward);
        gatherDragonBallRewardDialog.setArguments(bundle);
        gatherDragonBallRewardDialog.show(AppUtil.getCurrentActivity().getSupportFragmentManager(), gatherDragonBallRewardDialog.toString());

    }


    @Override
    protected boolean isWinDismiss() {
        return true;
    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {


        GatherDragonBallRewardView gatherDragonBallRewardView = new GatherDragonBallRewardView(getContext());
        gatherDragonBallRewardView.setLayoutParams(ConstraintLayoutUtils.getLayoutParamsMM());
        DragonBallRewardBean reward = (DragonBallRewardBean) getArguments().getSerializable("reward");

        gatherDragonBallRewardView.setData(reward);


        gatherDragonBallRewardView.setOnEndListener(new DragonBallsRewardWheel.OnEndListener() {
            @Override
            public void end(ArrayList<AwardBean> list) {


                AppUtil.getMainHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dismiss();
                        GatherDragonWinDialog.showDialog(getActivity().getSupportFragmentManager(),  list);


                    }
                }, 2000);

            }
        });

        rootView.addView(gatherDragonBallRewardView);


    }

    @Override
    public void initData() {

    }
}
