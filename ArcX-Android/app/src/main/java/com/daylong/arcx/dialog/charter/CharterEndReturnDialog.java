package com.daylong.arcx.dialog.charter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

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
import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.layout.LinearLayoutView;
import net.daylong.baselibrary.view.textview.MyTextView;

/**

 */
public class CharterEndReturnDialog extends BaseMvpFragmentDialog<CharterPresenter, CharterModel> implements CharterContract.CharterView {


    public static void showDialog(FragmentManager fragmentManager, long charterBalance, long returnNum, long totalNum) {

        CharterEndReturnDialog reportDialog = new CharterEndReturnDialog();
        Bundle bundle = new Bundle();
        bundle.putLong("charterBalance", charterBalance);
        bundle.putLong("returnNum", returnNum);
        bundle.putLong("totalNum", totalNum);
        reportDialog.setArguments(bundle);

        if (reportDialog.getDialog() == null || !reportDialog.getDialog().isShowing()) {
            reportDialog.show(fragmentManager, reportDialog.toString());
        }

    }

    //    @Override
    protected ViewGroup getContentLayout() {
        ConstraintLayout build = new ConstraintBuilder(166, 0).wHei().center().build(getContext());
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
        Bundle arguments = getArguments();

        long charterBalance = arguments.getLong("charterBalance");
        long returnNum = arguments.getLong("returnNum");
        long totalNum = arguments.getLong("totalNum");


        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(17));
        myTextView.setId(View.generateViewId());


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




        contentView.addView(itemView);
        contentView.addView(itemView2);
        contentView.addView(itemView3);

        DefaultConfirmDialogBtn defaultConfirmDialogBtn = new DefaultConfirmDialogBtn(getContext(), itemView3.getId(),14);

        defaultConfirmDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        DefaultCancelDialogBtn defaultCancelDialogBtn = new DefaultCancelDialogBtn(getContext(), itemView3.getId(),14);


        defaultCancelDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        contentView.addView(defaultCancelDialogBtn);
        contentView.addView(defaultConfirmDialogBtn);
    }

    private LinearLayoutView getItemView(View view, String key, long num) {


        LinearLayoutView linearLayoutView = new LinearLayoutView(getContext());
        linearLayoutView.setOrientation(LinearLayoutView.HORIZONTAL);
        linearLayoutView.setId(View.generateViewId());
        linearLayoutView.setLayoutParams(new ConstraintBuilder().ww().height(12).left().topToBottom(view).leftMargin(35).topMargin(3).buildPayoutParams());


        MyTextView tvKeyBalance = MyTextView.create(linearLayoutView, new ConstraintBuilder().ww());
        tvKeyBalance.initText(key, 8, R.color.color_434343, true);
        tvKeyBalance.setTextSize(8);
        tvKeyBalance.getPaint().setFakeBoldText(true);


        MyImageView.create(linearLayoutView, new ConstraintBuilder(12).leftMargin(3), R.drawable.img_coin);
        MyTextView tvValur = MyTextView.create(linearLayoutView, new ConstraintBuilder().ww());
        tvValur.initText(StringUtils.numFormatDot(num), 8, R.color.color_434343, true);

        return linearLayoutView;
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
