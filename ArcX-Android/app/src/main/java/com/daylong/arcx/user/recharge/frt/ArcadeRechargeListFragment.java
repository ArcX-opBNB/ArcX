package com.daylong.arcx.user.recharge.frt;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.daylong.gamelibrary.request.charter.CharterGameRequest;
import com.daylong.httplibrary.bean.request.PayRequest;
import com.daylong.httplibrary.bean.response.user.RechargeResponse;
import com.daylong.httplibrary.model.contract.user.RechargeContract;
import com.daylong.httplibrary.model.model.user.RechargeModel;
import com.daylong.httplibrary.model.presenter.user.RechargePresenter;
import com.daylong.arcx.dialog.PayDialog;
import com.daylong.arcx.pay.PayListener;
import com.daylong.arcx.pay.mrg.PayListenerMrg;
import com.daylong.arcx.user.recharge.adapter.ArcadeRechargeAdapter;
import com.daylong.arcx.view.user.pay.SelectPayLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.frt.BaseListFragment;
import net.daylong.baselibrary.view.recycler.BaseRecyclerView;
import net.daylong.baselibrary.view.recycler.GridRecyclerView;
import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.user.BalanceRequest;

public class ArcadeRechargeListFragment extends BaseListFragment<RechargePresenter, RechargeModel, RechargeResponse.GoldListDTO> implements RechargeContract.RechargeView {

    @Override
    public BaseQuickAdapter<RechargeResponse.GoldListDTO, MyViewHolder> getAdapter() {
        return new ArcadeRechargeAdapter();

    }


    @Override
    public void getListUrl() {


        mPresenter.getRechargeInfo();
    }

    @Override
    public BaseRecyclerView getRecyclerView() {

        GridRecyclerView verticalRecyclerView = new GridRecyclerView(getContext());
        SmartRefreshLayout.LayoutParams layoutParams = new SmartRefreshLayout.LayoutParams(SmartRefreshLayout.LayoutParams.MATCH_PARENT, SmartRefreshLayout.LayoutParams.MATCH_PARENT);
        verticalRecyclerView.setLayoutParams(layoutParams);
        verticalRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return verticalRecyclerView;
    }


    private SelectPayLayout selectPayLayout;
    private RechargeResponse.GoldListDTO goldListDTO;



    @Override
    protected void initData() {
        super.initData();


        baseQuickAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {

                if (selectPayLayout == null) {
                    selectPayLayout = new SelectPayLayout(getContext());
                }

                goldListDTO = baseQuickAdapter.getData().get(position);
                selectPayLayout.show(goldListDTO);
                ((ArcadeRechargeAdapter) baseQuickAdapter).setSelectPosition(position);

                PayDialog.show((BaseActivity) getActivity(), goldListDTO.playBalance());
            }
        });
    }


    @NonNull
    @Override
    protected RechargePresenter initPresenter() {
        return RechargePresenter.newInstance();
    }

    @Override
    public void onRechargeInfo(RechargeResponse data) {
        baseQuickAdapter.setList(data.getGoldList());
    }


}
