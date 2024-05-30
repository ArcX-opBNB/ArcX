package com.daylong.arcx.home.frt;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.daylong.arcx.game.ArcadeMachineActivity;
import com.daylong.arcx.game.BallGameActivity;
import com.daylong.arcx.game.DollGameActivity;
import com.daylong.arcx.game.PushCoinGameActivity;
import com.daylong.arcx.home.adapter.GameClawProductAdapter;
import com.daylong.arcx.home.adapter.GameProductAdapter;
import com.daylong.httplibrary.bean.response.game.GameInfoResponse;
import com.daylong.httplibrary.bean.response.game.GameItemInfoResponse;
import com.daylong.httplibrary.model.contract.game.GameProductContract;
import com.daylong.httplibrary.model.model.game.GameProductModel;
import com.daylong.httplibrary.model.presenter.game.GameProductPresenter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.ui.frt.BaseListFragment;
import net.daylong.baselibrary.view.recycler.BaseRecyclerView;
import net.daylong.baselibrary.view.recycler.GridRecyclerView;
import net.daylong.baselibrary.view.recycler.VerticalRecyclerView;

import java.util.List;

public class GameListFragment extends BaseListFragment<GameProductPresenter, GameProductModel, GameItemInfoResponse> implements GameProductContract.GameProductView {

    private int productType;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null) {

            productType = arguments.getInt("productType", 0);
        }
        super.initView(view, savedInstanceState);


        baseQuickAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {

                GameItemInfoResponse gameItemInfoResponse = baseQuickAdapter.getData().get(position);
                mPresenter.getUserGame(gameItemInfoResponse.getProductId());


            }
        });

    }


    @Override
    public void onGameProductBannerMsg(List<GameItemInfoResponse> list) {
        baseQuickAdapter.setList(list);

    }

    @Override
    public void onGameInfo(GameInfoResponse gameInfoResponse) {

        Integer productType = gameInfoResponse.getProductType();

        if (productType == 1) {
            PushCoinGameActivity.start(getContext(), PushCoinGameActivity.class, gameInfoResponse);
        } else if (productType == 2) {
            DollGameActivity.start(getContext(), DollGameActivity.class, gameInfoResponse);
        } else {
            BallGameActivity.start(getContext(), BallGameActivity.class, gameInfoResponse);
        }

    }


    @Override
    public BaseQuickAdapter<GameItemInfoResponse, MyViewHolder> getAdapter() {
        if (productType == 1) {
            baseQuickAdapter = new GameProductAdapter();
        } else  {
            baseQuickAdapter = new GameClawProductAdapter();
        }


        return baseQuickAdapter;

    }

    @Override
    public void getListUrl() {
        mPresenter.getGameProductBanner(productType, page);

    }

    @Override
    public BaseRecyclerView getRecyclerView() {
        BaseRecyclerView baseRecyclerView;
        if (productType == 1) {
            baseRecyclerView = new GridRecyclerView(getContext());

        } else {
            baseRecyclerView = new VerticalRecyclerView(getContext());
        }
        SmartRefreshLayout.LayoutParams layoutParams = new SmartRefreshLayout.LayoutParams(SmartRefreshLayout.LayoutParams.MATCH_PARENT, SmartRefreshLayout.LayoutParams.MATCH_PARENT);
        baseRecyclerView.setLayoutParams(layoutParams);

        return baseRecyclerView;
    }


    public  void quick(){
        mPresenter.getQuickGame(productType);
    }

    @NonNull
    @Override
    protected GameProductPresenter initPresenter() {
        return GameProductPresenter.newInstance();
    }
}
