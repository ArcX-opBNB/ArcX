package com.daylong.arcx.dialog.store;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.daylong.arcx.R;
import com.daylong.arcx.callback.OnPayItemClickListener;
import com.daylong.arcx.dialog.DefaultDialog;
import com.daylong.arcx.view.store.RechargeGroupView;
import com.daylong.arcx.view.user.UserBalanceView;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.UsdTPayRequest;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;
import com.daylong.httplibrary.model.contract.store.StoreInfoContract;
import com.daylong.httplibrary.model.model.store.StoreInfoModel;
import com.daylong.httplibrary.model.presenter.store.StoreInfoPresenter;
import com.daylong.userlibrary.cache.UserCache;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseMvpFragmentDialog;
import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.view.BaseBackView;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.gamesocket.listener.UserBalanceCallBack;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.user.BalanceRequest;
import net.daylong.gamesocket.strategy.response.WebSocketUserStrategy;

public class StoreDialog extends BaseMvpFragmentDialog<StoreInfoPresenter, StoreInfoModel> implements StoreInfoContract.StoreInfoView, UserBalanceCallBack, View.OnClickListener, OnPayItemClickListener {
    private UserBalanceView userBalanceView;
    private MyImageView ivUserIcon;
    private UserBalanceView homeUserAxcBalanceView;
    private MyImageView myImageView;
    private RechargeGroupView rechargeGroupView;

    @Override
    protected boolean isWinDismiss() {
        return false;
    }

    public static void showDialog(FragmentManager fragmentManager) {

        StoreDialog reportDialog = new StoreDialog();
        if (reportDialog.getDialog() == null || !reportDialog.getDialog().isShowing()) {
            reportDialog.show(fragmentManager, reportDialog.toString());
        }

    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {
        rootView.setBackgroundResource(R.drawable.img_store_bg);
        initBg();
        mPresenter.getStoreInfo();
        WebSocketUserStrategy.getInstance().register(this);
        initTitle();


        rechargeGroupView = new RechargeGroupView(getContext(), myImageView);
        rechargeGroupView.setOnTimeClickList(this);
        rechargeGroupView.setOnPayItemClickListener(this);
        addView(rechargeGroupView);


        backView();
        WebSocketUserStrategy.getInstance().register(this);
        WebSocketMrg.getInstance().sendMsg(new BalanceRequest());
    }


    private void backView() {


        BaseBackView baseBackView = new BaseBackView((BaseActivity) getActivity(), R.drawable.img_back_store, true);

        baseBackView.setOnBackClickListener(new BaseBackView.OnBackClickListener() {
            @Override
            public void onClick() {
                dismiss();
            }
        });
        baseBackView.setId(View.generateViewId());
        addView(baseBackView);

    }

    private void initBg() {

        myImageView = MyImageView.create(rootView, new ConstraintBuilder(0, 53).topCenterH(), DrawableUtils.getDrawableByName("img_store_title_bg"));


    }

    private void initTitle() {

        ivUserIcon = MyImageView.create(rootView, new ConstraintBuilder(20).leftTop().leftTopMargin(5, 24));
        ivUserIcon.setImageUrlRound(UserCache.getInstance().getUserInfo().getUserImgUrl());

        userBalanceView = new UserBalanceView(getContext(), ivUserIcon, 14, R.drawable.img_coin, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        homeUserAxcBalanceView = new UserBalanceView(getContext(), userBalanceView, 4, com.daylong.reglinrary.R.drawable.img_axc, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        addView(userBalanceView);
        addView(homeUserAxcBalanceView);


    }


    @Override
    public void initData() {

    }

    @NonNull
    @Override
    protected StoreInfoPresenter initPresenter() {
        return StoreInfoPresenter.newInstance();
    }

    @Override
    public void onStoreInfoSuc(StoreInfoResponse storeInfoResponse) {
        rechargeGroupView.setData(storeInfoResponse);

    }

    @Override
    public void onRePropSuc() {
        mPresenter.getStoreInfo();
    }

    @Override
    public void onPaySuc(AwardBean awardBean) {
        WebSocketMrg.getInstance().sendMsg(new BalanceRequest());
        ToastUtil.show("Pay Successfully");
    }


    @Override
    public void dismiss() {
        super.dismiss();
        WebSocketUserStrategy.getInstance().remover(this);
    }

    @Override
    public void userBalance(long goldNum, long integralNum) {


        if (userBalanceView != null) {
            userBalanceView.setBalance(goldNum);
        }
        if (homeUserAxcBalanceView != null) {
            homeUserAxcBalanceView.setBalance(integralNum);
        }
    }

    @Override
    public void userEnergy(int cnAmt, int ttAmt, int cgAmt, int lfTm) {

    }

    @Override
    public void onClick(View view) {
        mPresenter.reProp();
    }

    private CoinConfirmDialog payConfirmDialog;
    private PropConfirmDialog propConfirmDialog;
    private SpConfirmDialog spConfirmDialog;


    @Override
    public void onItemSpClick(StoreInfoResponse.SpPlyIfoDTO spPlyIfoDTO) {
        spConfirmDialog = SpConfirmDialog.showDialog((BaseActivity) getActivity(), spPlyIfoDTO);
        spConfirmDialog.setStoreInfoPresenter(mPresenter);
    }

    @Override
    public void onItemCoinClick(StoreInfoResponse.CnTblnDTO tblnDTO) {

        payConfirmDialog = CoinConfirmDialog.showDialog((BaseActivity) getActivity(), tblnDTO);
        payConfirmDialog.setStoreInfoPresenter(mPresenter);
    }

    @Override
    public void onItemPropClick(StoreInfoResponse.PpyIfoDTO.PpyTblnDTO ppyTblnDTO) {
        propConfirmDialog = PropConfirmDialog.showDialog((BaseActivity) getActivity(), ppyTblnDTO);
        propConfirmDialog.setStoreInfoPresenter(mPresenter);
    }
}
