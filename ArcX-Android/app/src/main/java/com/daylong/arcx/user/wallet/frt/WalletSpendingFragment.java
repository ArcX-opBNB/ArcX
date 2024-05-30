package com.daylong.arcx.user.wallet.frt;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.enums.WalletType;
import com.daylong.arcx.user.wallet.WithdrawalActivity;
import com.daylong.arcx.view.user.wallet.WalletWalletItemLayout;
import com.daylong.httplibrary.bean.response.wallet.WalletConfigureResponse;
import com.daylong.httplibrary.bean.response.wallet.WalletInfoResponse;
import com.daylong.httplibrary.model.contract.wallet.GameWalletInfoContract;
import com.daylong.httplibrary.model.contract.wallet.WalletInfoContract;
import com.daylong.httplibrary.model.model.wallet.GameWalletInfoModel;
import com.daylong.httplibrary.model.model.wallet.WalletInfoModel;
import com.daylong.httplibrary.model.presenter.wallet.GameWalletInfoPresenter;
import com.daylong.httplibrary.model.presenter.wallet.WalletInfoPresenter;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.frt.BaseMvpFragment;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class WalletSpendingFragment extends BaseMvpFragment<GameWalletInfoPresenter, GameWalletInfoModel> implements GameWalletInfoContract.GameWalletInfoView {
    private WalletWalletItemLayout itemAxc;
    private WalletWalletItemLayout itemUSDT;
    private WalletWalletItemLayout itemSOL;

    @Override
    public void onFragmentEnter() {
        super.onFragmentEnter();

        mPresenter.getGameWalletInfo();
        mPresenter.getConfigureInfo();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);

        view.setBackgroundResource(R.drawable.shape_wallet_bg);

        MyImageView ivContentBg = MyImageView.create(rootView, new ConstraintBuilder(172, 107).topCenterH().topMargin(71), R.drawable.img_bg_spending_content);
        MyImageView ivIcon = MyImageView.create(rootView, new ConstraintBuilder(13).leftTop(ivContentBg).leftTopMargin(6, 6), R.drawable.img_icon_wallet);

        MyTextView tvTitle = MyTextView.create(rootView, new ConstraintBuilder().ww().leftToRightById(ivIcon).centerV(ivIcon).leftMargin(3));
        tvTitle.initText("Spending account", 8, R.color.color_white, false);


        itemAxc = WalletWalletItemLayout.create(rootView, ivContentBg, ivIcon, WalletType.AXC, true);

        ConstraintLayoutView.LayoutParams layoutParams = (ConstraintLayoutView.LayoutParams) itemAxc.getLayoutParams();
        layoutParams.topMargin = AppUtil.getSize(4);


        itemUSDT = WalletWalletItemLayout.create(rootView, itemAxc, itemAxc, WalletType.USDT, true);
        itemSOL = WalletWalletItemLayout.create(rootView, ivContentBg, itemUSDT, WalletType.SOLANA, false);
        itemSOL.goneLine();
        mPresenter.getGameWalletInfo();
        mPresenter.getConfigureInfo();
    }

    @NonNull
    @Override
    protected GameWalletInfoPresenter initPresenter() {
        return GameWalletInfoPresenter.newInstance();
    }


    @Override
    public void onGameWalletInfo(WalletInfoResponse descResponse) {
        itemAxc.setNum(descResponse.getAxc());
        itemUSDT.setNum(descResponse.getUsdt());
        itemSOL.setNum(descResponse.getSol());
    }

    @Override
    public void onWalletConfigureInfo(WalletConfigureResponse descResponse) {
        itemAxc.setConfigureInfo(descResponse);
        itemUSDT.setConfigureInfo(descResponse);
        itemSOL.setConfigureInfo(descResponse);
    }
}
