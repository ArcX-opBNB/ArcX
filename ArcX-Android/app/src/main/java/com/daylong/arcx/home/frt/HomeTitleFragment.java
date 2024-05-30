package com.daylong.arcx.home.frt;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.daylong.arcx.R;
import com.daylong.arcx.act.UserInfoActivity;
import com.daylong.arcx.dialog.game.pushcoin.GatherDragonBallRewardDialog;
import com.daylong.arcx.dialog.game.pushcoin.WinDragonBallDialog;
import com.daylong.arcx.dialog.user.AxcHelpDialog;
import com.daylong.arcx.dialog.user.CoinHelpDialog;
import com.daylong.arcx.view.game.GameEnergyProgressView;
import com.daylong.arcx.view.home.banner.HomeBannerView;
import com.daylong.arcx.view.user.EnergyProgressView;
import com.daylong.arcx.view.user.UserBalanceView;
import com.daylong.gamelibrary.meuns.GameCmdType;
import com.daylong.httplibrary.bean.game.dragon.DragonBallRewardBean;
import com.daylong.httplibrary.bean.response.defaults.HomeBannerResponse;
import com.daylong.httplibrary.bean.response.game.charter.CharterDescResponse;
import com.daylong.httplibrary.bean.response.game.charter.UserCharterInfoResponse;
import com.daylong.httplibrary.model.contract.game.CharterContract;
import com.daylong.httplibrary.model.contract.home.HomeContract;
import com.daylong.httplibrary.model.model.home.HomeModel;
import com.daylong.httplibrary.model.presenter.home.HomePresenter;
import com.daylong.userlibrary.cache.UserCache;

import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.utils.JsonUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.act.WebViewActivity;
import net.daylong.baselibrary.utils.ui.frt.BaseMvpFragment;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.gamesocket.listener.UserBalanceCallBack;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.DefaultWebSocketRequest;
import net.daylong.gamesocket.request.user.BalanceRequest;
import net.daylong.gamesocket.strategy.response.WebSocketUserStrategy;

import java.util.List;

public class HomeTitleFragment extends BaseMvpFragment<HomePresenter, HomeModel> implements HomeContract.HomeView, UserBalanceCallBack, CharterContract.CharterView {
    private UserBalanceView userBalanceView;
    private UserBalanceView homeUserAxcBalanceView;
    private MyImageView ivUserIcon;
    private EnergyProgressView gameEnergyProgressView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        initUserIcon();
        userBalanceView = new UserBalanceView(getContext(), ivUserIcon, 2, R.drawable.img_coin, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CoinHelpDialog.showDialog((BaseActivity) getActivity());
            }
        });
        userBalanceView.goneAddIv();
        homeUserAxcBalanceView = new UserBalanceView(getContext(), userBalanceView, 1, R.drawable.img_balance_axc, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AxcHelpDialog.showDialog((BaseActivity) getActivity());

            }
        });
        homeUserAxcBalanceView.goneAddIv();
        gameEnergyProgressView = new EnergyProgressView(getContext(), homeUserAxcBalanceView);


        addView(userBalanceView);
        addView(homeUserAxcBalanceView);
        addView(gameEnergyProgressView);


    }


    public View getLocation() {
        return ivUserIcon;
    }

    @Override
    protected void onEventStart() {
        super.onEventStart();
        WebSocketUserStrategy.getInstance().register(this);
        WebSocketUserStrategy.getInstance().setActivity(getActivity());
        WebSocketMrg.getInstance().sendMsg(new BalanceRequest());
        WebSocketMrg.getInstance().sendMsg(new DefaultWebSocketRequest(GameCmdType.C2S_ENERGY_MSG.getCdm()));

    }

    @Override
    protected void onEventStop() {
        super.onEventStart();
        WebSocketUserStrategy.getInstance().setActivity(null);
        WebSocketUserStrategy.getInstance().remover(this);
    }

    private void initUserIcon() {

        ivUserIcon = MyImageView.create(rootView, new ConstraintBuilder(28).leftTop().leftTopMargin(5, 1));
        ivUserIcon.setImageUrlRound(UserCache.getInstance().getUserInfo().getUserImgUrl());
        ivUserIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserInfoActivity.start(getContext(), UserInfoActivity.class);

//                WebViewActivity.start(getActivity(), "", "https://app.gameshift.dev/consent?transaction=14e32a85-1382-4811-aa48-9ace93db8ced");
//                WinDragonBallDialog.show(999);
//
//                String s = "{\"dgTnTbln\":{\"awdTbln\":[{\"awdAmt\":270,\"awdPct\":\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726331642.png\",\"cmdId\":0,\"cmdTp\":1},{\"awdAmt\":1,\"awdPct\":\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726729535.png\",\"cmdId\":1,\"cmdTp\":5},{\"awdAmt\":3,\"awdPct\":\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726406345.png\",\"cmdId\":0,\"cmdTp\":2}],\"icAwdTbln\":[{\"awdInx\":14,\"cmdTp\":1},{\"awdInx\":1,\"cmdTp\":5},{\"awdInx\":11,\"cmdTp\":2}],\"icTbln\":[\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726583497.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726729535.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726331642.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726406345.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726331642.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726760036.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726331642.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726406345.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726331642.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726729535.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726331642.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726406345.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726331642.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726583497.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726331642.png\",\"http:\\/\\/api.websocket.wonder.net.cn:2023\\/local_media_file_test\\/ARCX\\/back\\/basic\\/img\\/awardImg\\/1710726406345.png\"]},\"dgAwd\":{\"amt\":251269,\"cnbAmt\":7}}";
//
//
//                GatherDragonBallRewardDialog.show(JsonUtil.fromJsonToObject(s, DragonBallRewardBean.class), new BaseDialog.OnDismissListener() {
//                    @Override
//                    public void onDismiss() {
//
//                    }
//                });

            }
        });

    }


    @Override
    protected void initData() {
        super.initData();
        mPresenter.getHomeBanner();


    }


    @NonNull
    @Override
    protected HomePresenter initPresenter() {

        return HomePresenter.newInstance();
    }

    @Override
    public void onHomeBannerMsg(List<HomeBannerResponse> list) {

    }


    @Override
    public void userBalance(long goldNum, long integralNum) {

        if (userBalanceView != null) {
            userBalanceView.setBalance(goldNum < 0 ? 0 : goldNum);
        }
        if (homeUserAxcBalanceView != null) {
            homeUserAxcBalanceView.setBalance(integralNum);
        }

    }

    @Override
    public void userEnergy(int cnAmt, int ttAmt, int cgAmt, int lfTm) {
        gameEnergyProgressView.setEnergy(cnAmt, ttAmt, cgAmt, lfTm);
    }

    @Override
    public void onGameCharterDesc(CharterDescResponse descResponse) {

    }

    @Override
    public void onUserCharterInfo(UserCharterInfoResponse charterInfoResponse) {

    }
}
