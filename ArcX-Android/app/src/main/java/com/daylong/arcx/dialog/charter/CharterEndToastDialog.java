package com.daylong.arcx.dialog.charter;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.request.operate.GameOperateDefaultRequest;
import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;
import com.daylong.httplibrary.bean.response.game.charter.UserCharterInfoResponse;
import com.daylong.httplibrary.model.contract.game.CharterContract;
import com.daylong.httplibrary.model.model.game.CharterModel;
import com.daylong.httplibrary.model.presenter.game.CharterPresenter;
import com.daylong.arcx.R;
import com.daylong.arcx.view.btn.DefaultCancelDialogBtn;
import com.daylong.arcx.view.btn.DefaultConfirmDialogBtn;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseMvpFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
import net.daylong.gamesocket.mrg.WebSocketMrg;

/**

 */
public class CharterEndToastDialog extends BaseMvpFragmentDialog<CharterPresenter, CharterModel> implements CharterContract.CharterView {


    public static void showDialog(FragmentManager fragmentManager) {

        CharterEndToastDialog reportDialog = new CharterEndToastDialog();
        if (reportDialog.getDialog() == null || !reportDialog.getDialog().isShowing()) {
            reportDialog.show(fragmentManager, reportDialog.toString());
        }

    }

    //    @Override
    protected ViewGroup getContentLayout() {
        ConstraintLayout build = new ConstraintBuilder(166, 121).center().build(getContext());
        build.setBackgroundResource(R.drawable.img_mch_alert);
        build.setPadding(0, 0, 0, AppUtil.getSize(16));
        return build;

    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {

    }


    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);


        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(17));
        myTextView.setId(View.generateViewId());


        MyTextView tvDesc = MyTextView.create(contentView, new ConstraintBuilder().ww().height(30).topToBottom(myTextView));
        tvDesc.setPadding(AppUtil.getSize(10), 0, AppUtil.getSize(10), 0);
        tvDesc.setId(View.generateViewId());

        tvDesc.setGravity(Gravity.CENTER_HORIZONTAL);
        tvDesc.setId(View.generateViewId());
        tvDesc.setVisibility(View.INVISIBLE);
        ConstraintBuilder constraintBuilder = new ConstraintBuilder(23);

        boolean horizontal = AppUtil.isHorizontal();
        if (horizontal) {
            constraintBuilder.topRight();
        } else {
            constraintBuilder.bottomToTop(contentView.getId()).right(contentView.getId()).bottomMargin(15);
        }
        MyImageView myImageView = MyImageView.create(horizontal ? contentView : rootView, constraintBuilder, R.drawable.img_mch_close);

        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        DefaultConfirmDialogBtn defaultConfirmDialogBtn = new DefaultConfirmDialogBtn(getContext(), tvDesc.getId());

        defaultConfirmDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        DefaultCancelDialogBtn defaultCancelDialogBtn = new DefaultCancelDialogBtn(getContext(), tvDesc.getId());


        defaultCancelDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebSocketMrg.getInstance().sendMsg(new GameOperateDefaultRequest(GameOperateType.CHARTER_SETTLEMENT));
                dismiss();

            }
        });

        mPresenter.getUserCharterInfo();

        contentView.addView(defaultCancelDialogBtn);
        contentView.addView(defaultConfirmDialogBtn);
    }

    @Override
    public void initData() {

    }


    @Override
    public void onGameCharterDesc(CharterDescResponse descResponse) {
    }


    @Override
    public void onUserCharterInfo(UserCharterInfoResponse charterInfoResponse) {


    }

    @NonNull
    @Override
    protected CharterPresenter initPresenter() {
        return CharterPresenter.newInstance();
    }


}
