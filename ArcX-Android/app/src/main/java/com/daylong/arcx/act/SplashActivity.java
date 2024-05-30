package com.daylong.arcx.act;

import com.daylong.arcx.R;
import com.daylong.arcx.enums.WalletType;
import com.daylong.arcx.home.HomeActivity;
import com.daylong.arcx.user.EmailActivity;
import com.daylong.arcx.user.LoginActivity;
import com.daylong.arcx.user.backpack.BackpackActivity;
import com.daylong.arcx.user.wallet.ToExternalActivity;
import com.daylong.arcx.user.wallet.WalletActivity;
import com.daylong.httplibrary.bean.response.AppInfoResponse;
import com.daylong.userlibrary.act.ISplashActivity;
import com.daylong.userlibrary.cache.UserCache;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.gamesocket.mrg.WebSocketMrg;

public class SplashActivity extends ISplashActivity {

    @Override
    protected Integer getLayoutId() {
        return R.layout.act_splash;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    public void onWebSocketMsg(AppInfoResponse socketMsgResponse) {
        WebSocketMrg.getInstance().init(socketMsgResponse.getWsTbln().get(0).getURL());
    }

    @Override
    public void connectSuc() {
        super.connectSuc();


        AppUtil.getMainHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (UserCache.getInstance().isLogin()) {
                    MyLogUtil.e("tag-userid->"+UserCache.getInstance().getUserId());
//                    start(SplashActivity.this, WalletActivity.class);
                    start(SplashActivity.this, HomeActivity.class);

//                    ToExternalActivity.start(SplashActivity.this, 10, WalletType.USDT);

                } else {
                    start(SplashActivity.this, EmailActivity.class);

                }
                finish();

            }
        }, 1000);

    }
}
