package com.daylong.arcx.dialog.store;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.enums.WalletType;
import com.daylong.arcx.view.RechargeNumberView;
import com.daylong.httplibrary.bean.request.UsdTPayRequest;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;
import com.daylong.httplibrary.model.presenter.store.StoreInfoPresenter;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class PropConfirmDialog extends BaseFragmentDialog {

    public static PropConfirmDialog showDialog(BaseActivity userInfoActivity, StoreInfoResponse.PpyIfoDTO.PpyTblnDTO ppyTblnDTO) {
        PropConfirmDialog payConfirmDialog = new PropConfirmDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("pay", ppyTblnDTO);
        payConfirmDialog.setArguments(bundle);
        payConfirmDialog.show(userInfoActivity.getSupportFragmentManager(), payConfirmDialog.toString());
        return payConfirmDialog;
    }


    @Override
    protected ViewGroup getContentLayout() {


        return new ConstraintBuilder(151, 192).center().build(getContext());
    }

    private StoreInfoResponse.PpyIfoDTO.PpyTblnDTO item;

    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);
        Bundle arguments = getArguments();

        if (arguments != null) {
            item = (StoreInfoResponse.PpyIfoDTO.PpyTblnDTO) arguments.getSerializable("pay");

        }


        contentView.setBackgroundResource(com.daylong.reglinrary.R.drawable.img_user_info_bg);

        MyImageView myImageView = MyImageView.create(contentView, new ConstraintBuilder(73, 10).topCenterH().topMargin(9), com.daylong.reglinrary.R.drawable.img_user_title_change_name);


        ConstraintLayout titleContent = new ConstraintBuilder(130, 70).topToBottom(myImageView).topMargin(11).centerH(contentView).build(getContext());

        titleContent.setBackgroundResource(R.drawable.shape_r16_fff);


        MyImageView ivItemIcon = MyImageView.create(titleContent, new ConstraintBuilder(26).topCenterH().topMargin(7));
        ivItemIcon.setImageUrl(item.getPct());

        MyTextView myTextView = MyTextView.create(titleContent, new ConstraintBuilder(0, 0).topToBottom(ivItemIcon).bottomCenterH().leftRightMargin(6).topMargin(6).bottomMargin(4));


        myTextView.initText(item.getDsc(), 6, R.color.color_cc000000, true);
        myTextView.setGravity(Gravity.LEFT);
        titleContent.setId(View.generateViewId());

        contentView.addView(titleContent);


        MyTextView textView = MyTextView.create(contentView, new ConstraintBuilder().ww().topToBottom(titleContent).centerH().topMargin(11));
        textView.initText("You are paying", 8, R.color.color_804949, true);


        RechargeNumberView rechargeNumberView = new RechargeNumberView(getContext());
        rechargeNumberView.setLayoutParams(new ConstraintBuilder(15, 15).topToBottom(textView).centerH().topMargin(6).getParams());
        rechargeNumberView.setCanvasImageStart(new CanvasImageBean(15, 15, WalletType.AXC.getRegId()));
        rechargeNumberView.setCanvasImageNum(new CanvasImageBean(11, 14));
        rechargeNumberView.setCanvasImageDot(new CanvasImageBean(3, 14));

        rechargeNumberView.setNum(item.getAxcAmt());

        contentView.addView(rechargeNumberView);

        BaseButton baseButton = MyBtn.create(contentView, new ConstraintBuilder(80, 28).bottomCenterH().bottomMargin(17), com.daylong.reglinrary.R.drawable.img_btn_user_update, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                if (storeInfoPresenter != null) {
                    storeInfoPresenter.pay(item.create());
                }
                dismiss();

            }
        });
        baseButton.setGravity(Gravity.CENTER);
        baseButton.initBtn("PAY", 10, R.color.color_white, true);
        baseButton.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), R.color.color_fff6bfea);
        MyBtn.create(rootView, new ConstraintBuilder(15).bottomCenterH().bottomMargin(27), com.daylong.reglinrary.R.drawable.img_dialog_colse, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private StoreInfoPresenter storeInfoPresenter;

    public void setStoreInfoPresenter(StoreInfoPresenter storeInfoPresenter) {
        this.storeInfoPresenter = storeInfoPresenter;
    }

    @Override

    public void initView(ConstraintLayout rootView, BaseDialog dialog) {


    }

    @Override
    public void dismiss() {
        storeInfoPresenter = null;
        super.dismiss();
    }

    @Override
    public void initData() {


    }
}
