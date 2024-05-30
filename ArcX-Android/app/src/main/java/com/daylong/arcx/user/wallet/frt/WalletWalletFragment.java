package com.daylong.arcx.user.wallet.frt;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.wallet.ScanAddressDialog;
import com.daylong.arcx.enums.WalletType;
import com.daylong.arcx.user.wallet.ToExternalActivity;
import com.daylong.arcx.user.wallet.ToSpendingActivity;
import com.daylong.arcx.view.user.wallet.WalletWalletItemLayout;
import com.daylong.httplibrary.bean.response.wallet.WalletInfoResponse;
import com.daylong.httplibrary.model.contract.wallet.WalletInfoContract;
import com.daylong.httplibrary.model.model.wallet.WalletInfoModel;
import com.daylong.httplibrary.model.presenter.wallet.WalletInfoPresenter;
import com.daylong.userlibrary.cache.UserCache;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.frt.BaseMvpFragment;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class WalletWalletFragment extends BaseMvpFragment<WalletInfoPresenter, WalletInfoModel> implements WalletInfoContract.WalletInfoView {
    private DefaultView defaultView;
    private MyTextView tvWalletAddress, tvPrice;
    private WalletWalletItemLayout itemAxc;
    private WalletWalletItemLayout itemUSDT;
    private WalletWalletItemLayout itemSOL;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);


        defaultView = DefaultView.create(rootView, new ConstraintBuilder(0, 155).topCenterH());
        defaultView.setBackgroundColor(getContext().getColor(net.daylong.daylongbase.R.color.color_ffcbb6fc));


        tvPrice = MyTextView.create(rootView, new ConstraintBuilder().ww().topCenterH(defaultView).topMargin(68));
        tvPrice.initText(13, net.daylong.daylongbase.R.color.color_333, true);


        tvWalletAddress = MyTextView.create(rootView, new ConstraintBuilder().ww().topToBottom(tvPrice).centerH().topMargin(2));
        tvWalletAddress.initText(6, net.daylong.daylongbase.R.color.color_aca7b7, false);
        tvWalletAddress.setBackgroundResource(R.drawable.shape_bg_r14_8000);
        tvWalletAddress.setPadding(AppUtil.getSize(6), getSize(2), getSize(6), getSize(3));


        MyTextView myTextView = MyTextView.create(rootView, new ConstraintBuilder().ww().leftBottom(defaultView).leftMargin(21).bottomMargin(2));
        myTextView.initText("Receive", 7, net.daylong.daylongbase.R.color.color_333, true);
        MyBtn ivReceive = MyBtn.create(rootView, new ConstraintBuilder(22).bottomToTop(myTextView).centerH(myTextView), R.drawable.img_btn_receive, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                if (descResponse != null) {
                    ScanAddressDialog.show((BaseActivity) getActivity(), descResponse.getWlAds());
                }
            }
        });


        DefaultView bgSp = DefaultView.create(rootView, new ConstraintBuilder(74, 22).leftToRightById(ivReceive).centerV(ivReceive).leftMargin(13));
        bgSp.setBackgroundResource(R.drawable.img_bg_w);

        MyBtn ivSpending = MyBtn.create(rootView, new ConstraintBuilder(15).left(bgSp).centerV(bgSp).leftMargin(8), R.drawable.img_to_spending, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                if (descResponse != null) {
                    ToSpendingActivity.start(getContext(), descResponse.getAxc(), WalletType.AXC);
                }

            }
        });

        MyBtn ivEx = MyBtn.create(rootView, new ConstraintBuilder(15).right(bgSp).centerV(bgSp).rightMargin(8), R.drawable.img_to_external, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                if(descResponse!=null){
                    ToExternalActivity.start(getActivity(), descResponse, WalletType.USDT);
                }
            }
        });
        MyTextView tvToSp = MyTextView.create(rootView, new ConstraintBuilder().ww().leftToRightById(myTextView).bottom(myTextView).leftMargin(7));
        tvToSp.initText("To Spending", 7, net.daylong.daylongbase.R.color.color_333, true);

        MyTextView tvToEx = MyTextView.create(rootView, new ConstraintBuilder().ww().leftToRightById(tvToSp).bottom(myTextView).leftMargin(9));
        tvToEx.initText("To external", 7, net.daylong.daylongbase.R.color.color_333, true);

        MyTextView tvTrade = MyTextView.create(rootView, new ConstraintBuilder().ww().leftToRightById(tvToEx).bottom(tvToEx).leftMargin(10));
        tvTrade.initText("Trade", 7, net.daylong.daylongbase.R.color.color_333, true);

        MyImageView ivTrade = MyImageView.create(rootView, new ConstraintBuilder(22).bottomToTop(tvTrade).centerH(tvTrade), R.drawable.img_twallet_rade);


        createWallet();
//        createNft();
        mPresenter.getWalletInfo();


        String walletPath = UserCache.getInstance().getWalletPath();

        if (!TextUtils.isEmpty(walletPath)){
            tvWalletAddress.setText(walletPath);
        }

    }

    @Override
    public void onFragmentEnter() {
        super.onFragmentEnter();

        mPresenter.getWalletInfo();
    }

    @NonNull
    @Override
    protected WalletInfoPresenter initPresenter() {
        return WalletInfoPresenter.newInstance();
    }

    private void createNft() {
        MyImageView ivContentNftBg = MyImageView.create(ListConteView, new ConstraintBuilder(172, 78).topCenterH().topMargin(145), R.drawable.img_bg_spending_content_nft);
        MyTextView tvTitle = MyTextView.create(ListConteView, new ConstraintBuilder().ww().leftTop(ivContentNftBg).leftTopMargin(6, 7));
        tvTitle.initText("NFT", 8, R.color.color_white, false);


//        WalletWalletItemLayout itemAxc = WalletWalletItemLayout.create(ListConteView, ivContentNftBg, tvTitle, WalletType.AXC);
//
//        itemAxc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                WithdrawalActivity.start(getContext(), itemAxc.getBalance(), WalletType.AXC);
//            }
//        });
//        ConstraintLayoutView.LayoutParams layoutParams = (ConstraintLayoutView.LayoutParams) itemAxc.getLayoutParams();
//        layoutParams.topMargin = AppUtil.getSize(4);
//        WalletWalletItemLayout itemUSDT = WalletWalletItemLayout.create(ListConteView, itemAxc, itemAxc, WalletType.USDT);


    }

    private ConstraintLayout ListConteView;

    private void createWallet() {


        ScrollView scrollView = new ScrollView(getContext());

        scrollView.setLayoutParams(new ConstraintBuilder(0, 0).topToBottom(defaultView).bottomCenterH().buildPayoutParams());
        scrollView.setPadding(0, 0, 0, AppUtil.getSize(54));
        scrollView.setBackgroundResource(R.drawable.shape_wallet_bg);

        ListConteView = new ConstraintBuilder().mw().topMargin(10).build(getContext());

        scrollView.addView(ListConteView);

        addView(scrollView);

        MyImageView ivContentBg = MyImageView.create(ListConteView, new ConstraintBuilder(172, 107).topCenterH(), R.drawable.img_bg_spending_content);
        MyImageView ivIcon = MyImageView.create(ListConteView, new ConstraintBuilder(13).leftTop(ivContentBg).leftTopMargin(6, 3), R.drawable.img_icon_wallet);
        MyTextView tvTitle = MyTextView.create(ListConteView, new ConstraintBuilder().ww().leftToRightById(ivIcon).centerV(ivIcon).leftMargin(3));
        tvTitle.initText("Spending account", 8, R.color.color_white, false);


        itemAxc = WalletWalletItemLayout.createToEx(ListConteView, ivContentBg, ivIcon, WalletType.AXC, true);


        ConstraintLayoutView.LayoutParams layoutParams = (ConstraintLayoutView.LayoutParams) itemAxc.getLayoutParams();
        layoutParams.topMargin = AppUtil.getSize(4);

        itemUSDT = WalletWalletItemLayout.createToEx(ListConteView, itemAxc, itemAxc, WalletType.USDT, true);
        itemSOL = WalletWalletItemLayout.createToEx(ListConteView, ivContentBg, itemUSDT, WalletType.SOLANA, false);
        itemSOL.goneLine();


    }


    private WalletInfoResponse descResponse;

    @Override
    public void onWalletInfo(WalletInfoResponse descResponse) {
        this.descResponse = descResponse;
        UserCache.getInstance().setWalletPath(descResponse.getWlAds());
        tvWalletAddress.setText(descResponse.getWlAds());

        tvPrice.setText(descResponse.getCount());
        itemAxc.setNum(descResponse.getAxc());
        itemUSDT.setNum(descResponse.getUsdt());
        itemSOL.setNum(descResponse.getSol());
    }
}
