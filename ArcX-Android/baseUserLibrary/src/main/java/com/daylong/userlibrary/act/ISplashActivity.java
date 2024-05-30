package com.daylong.userlibrary.act;

import androidx.annotation.NonNull;

import com.daylong.httplibrary.bean.response.AppInfoResponse;
import com.daylong.httplibrary.model.contract.socket.SocketContract;
import com.daylong.httplibrary.model.model.socket.SocketModel;
import com.daylong.httplibrary.model.presenter.socket.SocketPresenter;

import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;

public abstract class ISplashActivity extends BaseMvpActivity<SocketPresenter, SocketModel> implements SocketContract.SocketView {


    @Override
    protected void initData() {
        super.initData();

        mPresenter.getWebSocketInfo();


    }

    @NonNull
    @Override
    protected SocketPresenter initPresenter() {
        return SocketPresenter.newInstance();
    }

    @Override
    public void onWebSocketMsg(AppInfoResponse socketMsgResponse) {


    }
}
