package com.daylong.arcx.dialog.charter;

import android.os.Bundle;
import android.view.Gravity;
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
import com.daylong.arcx.enums.CharterType;
import com.daylong.arcx.view.btn.CharterPayBtn;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseMvpFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

import java.util.List;

public class CharterDialog extends BaseMvpFragmentDialog<CharterPresenter, CharterModel> implements CharterContract.CharterView, CharterPayBtn.OnCharterPayListener {


    public static void showDialog(FragmentManager fragmentManager, CharterDescResponse descResponse, boolean isCharter) {

        CharterDialog reportDialog = new CharterDialog();
        if (descResponse != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("desc", descResponse);
            bundle.putSerializable("isCharter", isCharter);
            reportDialog.setArguments(bundle);
        }

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

    private CharterDescResponse desc;
    private CharterPayBtn charterPayBtn1;
    private CharterPayBtn charterPayBtn2;
    private boolean isCharter;

    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);
        Bundle arguments = getArguments();
        if (arguments != null) {
            desc = (CharterDescResponse) arguments.getSerializable("desc");
            isCharter = arguments.getBoolean("isCharter", false);
        }

        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(17));
        myTextView.setId(View.generateViewId());


        MyTextView tvDesc = MyTextView.create(contentView, new ConstraintBuilder().ww().topToBottom(myTextView).topMargin(6));
        tvDesc.setPadding(AppUtil.getSize(10), 0, AppUtil.getSize(10), 0);
        tvDesc.setId(View.generateViewId());
        tvDesc.initText(desc.getDesc(), 9, R.color.color_434343, true);
        tvDesc.setGravity(Gravity.CENTER_HORIZONTAL);
        tvDesc.setId(View.generateViewId());
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


        if (!isCharter) {

            List<CharterDescResponse.CommodityListDTO> commodityList = desc.getCommodityList();

            if (commodityList != null) {


                charterPayBtn1 = new CharterPayBtn((BaseActivity) getActivity(), CharterType.CHARTER_348, tvDesc.getId());
                charterPayBtn1.setCommodityListDTO(commodityList.get(0));
                contentView.addView(charterPayBtn1);
                charterPayBtn1.setOnCharterPayListener(this);

                charterPayBtn2 = new CharterPayBtn((BaseActivity) getActivity(), CharterType.CHARTER_618, tvDesc.getId());
                charterPayBtn2.setCommodityListDTO(commodityList.get(1));
                contentView.addView(charterPayBtn2);
                charterPayBtn1.setOnCharterPayListener(this);
                charterPayBtn2.setOnCharterPayListener(this);
            }
        }
        mPresenter.getUserCharterInfo();

    }

    @Override
    public void initData() {

    }


    @Override
    public void onGameCharterDesc(CharterDescResponse descResponse) {
    }


    @Override
    public void onUserCharterInfo(UserCharterInfoResponse charterInfoResponse) {

        charterPayBtn1.setCharterInfoResponse(charterInfoResponse);
        charterPayBtn2.setCharterInfoResponse(charterInfoResponse);
    }

    @NonNull
    @Override
    protected CharterPresenter initPresenter() {
        return CharterPresenter.newInstance();
    }


    @Override
    public void onPaySuc() {
        dismiss();

    }
}
