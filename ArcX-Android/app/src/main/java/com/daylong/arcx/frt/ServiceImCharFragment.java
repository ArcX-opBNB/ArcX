//package com.daylong.arcx.frt;
//
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//
//import com.daylong.httplibrary.bean.response.ServiceMsgResponse;
//import com.daylong.httplibrary.model.contract.setting.ServiceIMContract;
//import com.daylong.httplibrary.model.model.setting.ServiceImModel;
//import com.daylong.httplibrary.model.presenter.setting.ServiceImPresenter;
//
//import net.daylong.baselibrary.utils.KeyboardVisibleEvent;
//import net.daylong.baselibrary.utils.ui.frt.BaseMvpFragment;
//import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
//
//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;
//
//import java.util.Collections;
//import java.util.List;
//
//public class ServiceImCharFragment extends BaseMvpFragment<ServiceImPresenter, ServiceImModel> implements ServiceIMContract.ServiceImView, WebSocketMrg.OnMsgListener, ImChatRv.OnLoadMsg {
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }
//
//
//    private long lastId = 0;
//
//
//    @NonNull
//    @Override
//    protected ServiceImPresenter initPresenter() {
//        return ServiceImPresenter.newInstance();
//    }
//
//
//    @Override
//    public void onServiceMsg(List<ServiceMsgResponse> ServiceMsgResponses) {
//
//        if (ServiceMsgResponses.size() == 0) {
//            imChatRv.finishRefresh();
//            return;
//        }

//        boolean isOneLoad = lastId == 0;
//        Collections.reverse(ServiceMsgResponses);
//        if (ServiceMsgResponses.size() > 0) {
//            lastId = ServiceMsgResponses.get(0).getCtId();
//        }
//
//        for (ServiceMsgResponse ServiceMsgResponse : ServiceMsgResponses) {
//            if (isOneLoad) {
//                imChatRv.addMsg(ImMsgInfoBean.create(ServiceMsgResponse));
//
//            } else {
//                imChatRv.update(ImMsgInfoBean.create(ServiceMsgResponse));
//
//            }
//        }
//
//    }
//
//    @Override
//    public void onMsg(ServiceMsgResponse msgBean) {
//
//        imChatRv.addMsg(ImMsgInfoBean.create(msgBean));
//    }
//
//    private ImChatRv imChatRv;
//
//    private int msgId = 0;
//
//    @Override
//    protected void initView(View view, Bundle savedInstanceState) {
//        super.initView(view, savedInstanceState);
//
//
//        imChatRv = new ImChatRv(getContext());
//
//        imChatRv.setLayoutParams(new ConstraintBuilder(0, 0).mm0().topMargin(36).bottomMargin(36).buildPayoutParams());
////        imChatRv.setStackFromEnd(true);
//        addView(imChatRv);
//        createInput();
//        mPresenter.getServiceMsg(msgId);
//
//        mPresenter.msgRead();
//        WebSocketMrg.getInstance().setOnMsgListener(this);
//        imChatRv.setOnLoadMsg(this);
//    }
//
//
//    private ImServiceInputMsgView momentsInputView;
//
//    private void createInput() {
//
//        momentsInputView = ImServiceInputMsgView.create(rootView);

//        momentsInputView.setOnSendActionListener(new InputEditTextView.OnSendActionListener() {
//            @Override
//            public void sendMsg(CommentResponse o) {
//
//                mPresenter.sendMsg(o.getComment());
//
//            }
//        });
//    }
//

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(KeyboardVisibleEvent event) {
//        momentsInputView.setInput(event);
//    }
//
//    @Override
//    public void onNewMsg(ServiceMsgResponse ServiceMsgResponse) {
//        mPresenter.msgRead();
//        imChatRv.addMsg(ImMsgInfoBean.create(ServiceMsgResponse));
//    }
//
//    @Override
//    public void onDestroyView() {
//        WebSocketMrg.getInstance().setOnMsgListener(null);
//        super.onDestroyView();
//    }
//
//    @Override
//    public void onLoad() {
//        mPresenter.getServiceMsg(lastId);
//    }
//}
