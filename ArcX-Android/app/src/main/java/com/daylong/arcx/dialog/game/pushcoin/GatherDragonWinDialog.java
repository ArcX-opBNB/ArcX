
package com.daylong.arcx.dialog.game.pushcoin;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.daylong.arcx.R;
import com.daylong.arcx.act.UserInfoActivity;
import com.daylong.arcx.view.btn.DefaultDialogBtn;
import com.daylong.arcx.view.dragonball.AwardRv;
import com.daylong.httplibrary.bean.AwardBean;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.btn.MyImgBtn;
import net.daylong.baselibrary.view.img.BaseSvgaImageView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**

 */
public class GatherDragonWinDialog extends BaseFragmentDialog {


    public static void showDialog(FragmentManager fragmentManager, ArrayList<AwardBean> awardBeans) {
        GatherDragonWinDialog webDialog = new GatherDragonWinDialog();
        if (webDialog.getDialog() == null || !webDialog.getDialog().isShowing()) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("awardBean", awardBeans);
            webDialog.setArguments(bundle);
            webDialog.show(fragmentManager, "CheckInDialog");
        }
    }


    private MyImageView ivTitle;

    AwardRv awardRv;
    private BaseSvgaImageView svgaImageView;

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {


        svgaImageView = BaseSvgaImageView.create(rootView, new ConstraintBuilder().mm().leftTop());
        svgaImageView.startAssetsSvga("dragon_ball_bg.svga");
        int rvId = View.generateViewId();
        int btnId = View.generateViewId();
        ivTitle = MyImageView.create(rootView, new ConstraintBuilder(133, 57).topCenterH().bottomToTop(rvId).verticalChainStyle(), R.drawable.img_dragon_train_title);
        ivTitle.setId(View.generateViewId());


        awardRv = new AwardRv(getContext());
        awardRv.setId(rvId);
        awardRv.setLayoutParams(new ConstraintBuilder().ww().topToBottom(ivTitle).centerH().bottomToTop(btnId).topMargin(17).bottomMargin(17).leftRightMargin(8).buildPayoutParams());
        addView(awardRv);


        BaseButton baseButton = MyBtn.create(rootView, new ConstraintBuilder(83, 32).topMargin(27).bottomCenterH().topToBottom(awardRv), R.drawable.img_btn_dragon_gain, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();

            }
        });
        baseButton.setId(btnId);
        baseButton.setPadding(0, AppUtil.getSize(10), 0, 0);
        baseButton.setGravity(Gravity.CENTER_HORIZONTAL);
        baseButton.initBtn("GAIN", 10, net.daylong.daylongbase.R.color.color_333, true);
        baseButton.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), R.color.color_fff6bfea);

    }

    @Override
    public void dismiss() {
        super.dismiss();
        svgaImageView.close();
    }

    @Override
    public void initData() {


        Bundle bundle = getArguments();
        if (bundle != null) {

            ArrayList<AwardBean> awardBeans = (ArrayList<AwardBean>) bundle.getSerializable("awardBean");
            if (awardBeans != null) {
                awardRv.setData(awardBeans);
            }
        }
    }
}
