package com.daylong.arcx.act;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.user.info.UpdateGenderDialog;
import com.daylong.arcx.dialog.user.info.UpdateLevelDialog;
import com.daylong.arcx.dialog.user.info.UpdateNickNameDialog;
import com.daylong.arcx.home.frt.HomeTitleFragment;
import com.daylong.arcx.view.user.UserAttributeRv;
import com.daylong.arcx.view.user.UserBalanceView;
import com.daylong.arcx.view.user.userinfo.HexagonView;
import com.daylong.httplibrary.bean.request.user.UpdateUserInfoRequest;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.model.contract.user.UpdateUserInfoContract;
import com.daylong.httplibrary.model.contract.user.UserInfoContract;
import com.daylong.httplibrary.model.model.user.UserInfoModel;
import com.daylong.httplibrary.model.presenter.user.UpdateUserInfoPresenter;
import com.daylong.httplibrary.model.presenter.user.UserInfoPresenter;
import com.daylong.userlibrary.cache.UserCache;

import net.daylong.baselibrary.app.AppManager;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
import net.daylong.gamesocket.listener.UserBalanceCallBack;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.user.BalanceRequest;
import net.daylong.gamesocket.strategy.response.WebSocketUserStrategy;

public class UserInfoActivity extends BaseMvpActivity<UserInfoPresenter, UserInfoModel> implements UserBalanceCallBack, UserInfoContract.UserInfoView, UpdateUserInfoContract.UpdateUserInfoView {

    private UserBalanceView userBalanceView;
    private UserBalanceView homeUserAxcBalanceView;
    private MyImageView ivUserIcon;
    private MyTextView tvValName;
    private MyImageView ivGender;
    private DefaultView defaultViewBg;

    @Override
    protected Integer getBackBgRegId() {
        return R.drawable.img_back_mine;
    }

    private UserAttributeRv userAttributeRv;
    private ConstraintLayout contentViewLayout;


    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);


        rootView.setBackgroundResource(R.drawable.img_bg_user_info);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ConstraintBuilder().mm().leftTop().buildPayoutParams());
        scrollView.setBackgroundResource(R.drawable.shape_wallet_bg);


        contentViewLayout = new ConstraintBuilder().mw().build(this);

        scrollView.addView(contentViewLayout);

        addView(scrollView);


        initTitle();


        userAttributeRv = new UserAttributeRv(this, defaultViewBg, baseBackView);
        contentViewLayout.addView(userAttributeRv);
        userAttributeRv.setOnItemClickListener(new UserAttributeRv.OnItemClickListener() {
            @Override
            public void click(LoginUserInfoResponse.AtbTblnDTO item) {
                UpdateLevelDialog.ShowDialog(UserInfoActivity.this, item);
            }
        });
    }


    private void initTitle() {
        initUserIcon();

        MyBtn.create(contentViewLayout, new ConstraintBuilder(16, 14).centerV(ivUserIcon).right().rightMargin(3), R.drawable.img_mine_settings, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {

                SettingDialog.showDialog(UserInfoActivity.this);
            }
        });

        userBalanceView = new UserBalanceView(this, ivUserIcon, 2, R.drawable.img_coin);
        homeUserAxcBalanceView = new UserBalanceView(this, userBalanceView, 1, com.daylong.reglinrary.R.drawable.img_axc);
        contentViewLayout.addView(userBalanceView);
        contentViewLayout.addView(homeUserAxcBalanceView);


        defaultViewBg = DefaultView.create(contentViewLayout, new ConstraintBuilder(84, 44).topToBottom(ivUserIcon).topMargin(20).left().leftMargin(11));
        defaultViewBg.setBackgroundResource(R.drawable.shape_user_info_bg);


        MyTextView tvTabName = MyTextView.create(contentViewLayout, new ConstraintBuilder().ww().height(10).leftTop(defaultViewBg).leftTopMargin(8, 6));
        tvTabName.setGravity(Gravity.CENTER_VERTICAL);
        tvTabName.initText(getString(R.string.user_info_nickname), 7, R.color.color_white);

        hexagonView = new HexagonView(this);

        hexagonView.setLayoutParams(new ConstraintBuilder().ww().topRight().topMargin(45).rightMargin(9).buildPayoutParams());
        contentViewLayout.addView(hexagonView);


        tvValName = MyTextView.create(contentViewLayout, new ConstraintBuilder().ww().height(10).centerV(tvTabName).right(defaultViewBg).rightMargin(9));
        tvValName.setGravity(Gravity.CENTER_VERTICAL);
        tvValName.initText(7, R.color.color_white, false);
        tvValName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (updateUserInfoRequest != null) {
                    UpdateNickNameDialog.ShowDialog(UserInfoActivity.this, updateUserInfoRequest);
                }
            }
        });

        ivGender = MyImageView.create(contentViewLayout, new ConstraintBuilder(15).rightTopToBottom(tvValName).topMargin(7));
        ivGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (updateUserInfoRequest != null) {
                    UpdateGenderDialog.ShowDialog(UserInfoActivity.this, updateUserInfoRequest);
                }
            }
        });
        MyTextView tvTabGender = MyTextView.create(contentViewLayout, new ConstraintBuilder().ww().centerV(ivGender).left(tvTabName));
        tvTabGender.setGravity(Gravity.CENTER_VERTICAL);
        tvTabGender.initText(getString(R.string.user_info_gender), 7, R.color.color_white);

    }


    private void initUserIcon() {
        ivUserIcon = MyImageView.create(contentViewLayout, new ConstraintBuilder(28).leftTop().leftTopMargin(5, 22));
        ivUserIcon.setImageUrlRound(UserCache.getInstance().getUserInfo().getUserImgUrl());
    }


    @Override
    protected void initData() {
        super.initData();
        WebSocketUserStrategy.getInstance().setActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        WebSocketUserStrategy.getInstance().register(this);
        WebSocketMrg.getInstance().sendMsg(new BalanceRequest());
        mPresenter.getUserInfo();
    }


    @Override
    protected void onPause() {
        super.onPause();
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

    private UpdateUserInfoPresenter updateUserInfoPresenter;

    @NonNull
    @Override
    protected UserInfoPresenter initPresenter() {
        updateUserInfoPresenter = new UpdateUserInfoPresenter();
        updateUserInfoPresenter.attachMV(updateUserInfoPresenter.getModel(), this);
        return UserInfoPresenter.newInstance();
    }

    private UpdateUserInfoRequest updateUserInfoRequest;

    private HexagonView hexagonView;

    @Override
    public void onUserInfoSuc(LoginUserInfoResponse userInfoResponse) {
        updateUserInfoRequest = userInfoResponse.getUpdateInfo();
        tvValName.setText(userInfoResponse.getUserName());
        userAttributeRv.setData(userInfoResponse.getAtbTbln());
        ivGender.setImageReg(userInfoResponse.getSexRegId());
        hexagonView.update(userInfoResponse.getAttributeList());
    }

    @Override
    public void onUpdateLevelSuc() {
        mPresenter.getUserInfo();
    }

    @Override
    public void onUpdatePasswordSuc() {

    }

    public void updateUserInfo(UpdateUserInfoRequest info) {
        updateUserInfoPresenter.updateUserInfo(info);

    }

    @Override
    public void onUpdateUserInfoSuc() {

        mPresenter.getUserInfo();
    }

    public void updateLevel(Integer atbTp) {

        mPresenter.updateLevel(atbTp);
    }
}
