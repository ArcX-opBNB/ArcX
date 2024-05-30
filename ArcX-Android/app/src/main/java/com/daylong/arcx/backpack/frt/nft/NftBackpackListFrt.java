package com.daylong.arcx.backpack.frt.nft;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daylong.httplibrary.bean.response.user.LoginUserInfoResponse;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;
import com.daylong.httplibrary.model.contract.user.UserInfoContract;
import com.daylong.httplibrary.model.model.user.UserInfoModel;
import com.daylong.httplibrary.model.presenter.user.UserInfoPresenter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import net.daylong.baselibrary.base.MyViewHolder;
import net.daylong.baselibrary.utils.ui.frt.BaseListFragment;
import net.daylong.baselibrary.view.recycler.BaseRecyclerView;
import net.daylong.baselibrary.view.recycler.GridRecyclerView;

public class NftBackpackListFrt extends BaseListFragment<UserInfoPresenter, UserInfoModel, UserInfoResponse> implements UserInfoContract.UserInfoView {
    @Override
    public BaseQuickAdapter<UserInfoResponse, MyViewHolder> getAdapter() {
        return null;
    }

    @Override
    public void getListUrl() {

    }

    @Override
    public BaseRecyclerView getRecyclerView() {

        GridRecyclerView verticalRecyclerView = new GridRecyclerView(getContext());
        SmartRefreshLayout.LayoutParams layoutParams = new SmartRefreshLayout.LayoutParams(SmartRefreshLayout.LayoutParams.MATCH_PARENT, SmartRefreshLayout.LayoutParams.MATCH_PARENT);
        verticalRecyclerView.setLayoutParams(layoutParams);
        return verticalRecyclerView;
    }
    @NonNull
    @Override
    protected UserInfoPresenter initPresenter() {
        return UserInfoPresenter.newInstance();
    }

    @Override
    public void onUserInfoSuc(LoginUserInfoResponse userInfoResponse) {

    }

    @Override
    public void onUpdateLevelSuc() {

    }

    @Override
    public void onUpdatePasswordSuc() {

    }
}
