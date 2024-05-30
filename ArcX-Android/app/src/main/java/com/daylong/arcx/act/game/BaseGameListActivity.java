package com.daylong.arcx.act.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import net.daylong.baselibrary.view.btn.MyImgBtn;
public class BaseGameListActivity extends BaseActivity {

    private FrameLayout frameTitle;


    public static void start(Context context, int productType) {

        Intent intent = new Intent(context, BaseGameListActivity.class);
        intent.putExtra("productType", productType);
        context.startActivity(intent);

    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);
        rootView.setBackgroundResource(R.drawable.img_email_login_bg);

        initTitle();
        initContent();

    }

    private GameListFragment gameListFragment;


    private void initContent() {

        int productType = getIntent().getIntExtra("productType", 0);


        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setPadding(AppUtil.getSize(1), 0, 0, 0);
        frameLayout.setId(View.generateViewId());
        frameLayout.setLayoutParams(new ConstraintBuilder(productType == 1 ? 0 : 162, 0).topToBottom(frameTitle).centerH().bottomToTop(baseBackView).buildPayoutParams());
        addView(frameLayout);
        gameListFragment = new GameListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("productType", productType);
        gameListFragment.setArguments(bundle);
        addFragment(gameListFragment, frameLayout.getId());


        MyBtn.create(rootView, new ConstraintBuilder(62, 24).centerV(baseBackView).right(), R.drawable.img_quick, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                gameListFragment.quick();
            }
        });
    }

    @Override
    protected Integer getBackBgRegId() {
        return R.drawable.img_back_coin_pusher;
    }


    @Override
    protected BaseBackView getBaseBackView() {
        if (baseBackView == null) {
            baseBackView = new BaseBackView(this, getBackBgRegId(),isShowBackCoin(),new ConstraintBuilder(133, 24).leftBottom().bottomMargin(30));
            baseBackView.setId(View.generateViewId());
            baseBackView.bringToFront();
        }
        return baseBackView;
    }

    private void initTitle() {


        frameTitle = new FrameLayout(this);

        frameTitle.setId(View.generateViewId());
        frameTitle.setLayoutParams(new ConstraintBuilder().mw().leftTop().topMargin(22).buildPayoutParams());
        addFragment(new HomeTitleFragment(), frameTitle.getId());
        addView(frameTitle);


    }
}
