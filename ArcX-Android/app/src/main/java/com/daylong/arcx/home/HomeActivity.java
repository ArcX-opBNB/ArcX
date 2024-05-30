package com.daylong.arcx.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.daylong.arcx.R;
import com.daylong.arcx.dialog.game.pushcoin.WinDragonBallDialog;
import com.daylong.arcx.home.frt.GameListFragment;
import com.daylong.arcx.home.frt.HomeTitleFragment;
import com.daylong.arcx.nft.NftSalesCoinActivity;
import com.daylong.arcx.user.wallet.WalletActivity;
import com.daylong.arcx.view.AwardItemView;
import com.daylong.arcx.view.home.HomeTabGroupView;
import com.daylong.arcx.view.home.nav.BallNav;
import com.daylong.arcx.view.home.nav.BaseHomeNav;
import com.daylong.arcx.view.home.nav.ClawNav;
import com.daylong.arcx.view.home.nav.MissionNav;
import com.daylong.arcx.view.home.nav.NFTNav;
import com.daylong.arcx.view.home.nav.PusherNav;
import com.daylong.arcx.view.home.nav.bottom.HomeBottomNavGroupView;
import com.daylong.basecache.GameCache;
import com.daylong.gamelibrary.meuns.GameCmdType;
import com.daylong.gamelibrary.view.floa.FloatGameNumTextView;
import com.daylong.httplibrary.bean.AwardBean;

import net.daylong.baselibrary.app.AppManager;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.sys.SystemUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.frt.BaseFragment;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.DefaultWebSocketRequest;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    private FrameLayout frameTitle;

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);

        rootView.setBackgroundResource(R.drawable.img_home_bg);

        createContentNav();


        GameCache.setGameCmd(-1);
        initTitle();

        MyBtn myBtn = MyBtn.create(rootView, new ConstraintBuilder(28).topRight().topRightMargin(48, 5), R.drawable.img_btn_wallet, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                WalletActivity.start(HomeActivity.this, WalletActivity.class);
            }
        });

        MyImageView.create(rootView, new ConstraintBuilder(28).topToBottom(myBtn).topMargin(2).right(myBtn),R.drawable.img_airdrop);

    }

    WinDragonBallDialog winDragonBallDialog;

    private void createContentNav() {


        NFTNav nftNav = new NFTNav(this, null);
        addView(nftNav);

        PusherNav pusherNav = new PusherNav(this, nftNav);
        addView(pusherNav);

        ClawNav clawNav = new ClawNav(this, nftNav);
        addView(clawNav);
//
        BallNav ballNav = new BallNav(this, pusherNav);
        addView(ballNav);

        MissionNav missionNav = new MissionNav(this, clawNav);
        addView(missionNav);


        MyImageView.create(rootView, new ConstraintBuilder().mm().height(50).leftBottom(), R.drawable.img_bg_home_nav);
        HomeBottomNavGroupView homeBottomNavGroupView = new HomeBottomNavGroupView(this);

        addView(homeBottomNavGroupView);



    }

    private HomeTitleFragment homeTitleFragment;

    private void initTitle() {


        frameTitle = new FrameLayout(this);

        frameTitle.setId(View.generateViewId());
        frameTitle.setLayoutParams(new ConstraintBuilder().mw().leftTop().topMargin(22).buildPayoutParams());
        homeTitleFragment = new HomeTitleFragment();
        addFragment(homeTitleFragment, frameTitle.getId());
        addView(frameTitle);


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        WebSocketMrg.getInstance().sendMsg(new DefaultWebSocketRequest(GameCmdType.C2S_ENERGY_MSG.getCdm()));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        AppManager.getInstance().exitApp(this, false);
        WebSocketMrg.getInstance().exit();
    }
}
