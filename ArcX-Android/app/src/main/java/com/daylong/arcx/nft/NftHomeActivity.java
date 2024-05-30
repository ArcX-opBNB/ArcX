package com.daylong.arcx.nft;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.home.frt.GameListFragment;
import com.daylong.arcx.home.frt.HomeTitleFragment;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.view.BaseBackView;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;

public class NftHomeActivity extends BaseActivity {

    private FrameLayout frameTitle;


    public static void start(Context context) {


        Intent intent = new Intent(context, NftHomeActivity.class);

        context.startActivity(intent);
    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);
        rootView.setBackgroundResource(R.drawable.img_email_login_bg);

        initTitle();
        initContent();

    }


    private void initContent() {


        MyImageView.create(rootView, new ConstraintBuilder().mm().height(311).topToBottom(frameTitle).left(), R.drawable.img_nft_home);


    }

    @Override
    protected Integer getBackBgRegId() {
        return R.drawable.img_back_coin_pusher;
    }


    private void initTitle() {


        frameTitle = new FrameLayout(this);

        frameTitle.setId(View.generateViewId());
        frameTitle.setLayoutParams(new ConstraintBuilder().mw().leftTop().topMargin(22).buildPayoutParams());
        addFragment(new HomeTitleFragment(), frameTitle.getId());
        addView(frameTitle);


    }
}
