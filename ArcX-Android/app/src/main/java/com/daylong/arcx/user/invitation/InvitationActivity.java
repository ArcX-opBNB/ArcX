package com.daylong.arcx.user.invitation;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.response.user.InvitationInfoResponse;
import com.daylong.httplibrary.model.contract.user.InvitationContract;
import com.daylong.httplibrary.model.model.user.InvitationModel;
import com.daylong.httplibrary.model.presenter.user.InvitationPresenter;
import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.textview.MyTextView;

public class InvitationActivity extends BaseMvpActivity<InvitationPresenter, InvitationModel> implements InvitationContract.InvitationView {


    @Override
    protected boolean isAddBaseTitle() {
        return true;
    }

    @Override
    protected Integer getTitleName() {
        return R.string.invitation;
    }

    @NonNull
    @Override
    protected InvitationPresenter initPresenter() {
        return InvitationPresenter.newInstance();
    }


    private MyTextView tvCode;
    private ConstraintLayout contentView;

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getInvitationInfo();
    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);


        contentView = new ConstraintBuilder(174, 206).centerH().topToBottom(baseTitleView.getId()).build(this);
        contentView.setBackgroundResource(R.drawable.shape_invitation_bg);
        addView(contentView);


        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().mm().height(14).leftTop().topMargin(21));
        myTextView.setGravity(Gravity.CENTER);


        tvCode = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(72));
        tvCode.initText("", 17, R.color.color_434343, true);


        BaseButton baseButton = BaseButton.create(rootView, new ConstraintBuilder(45, 13).right().centerV(baseTitleView.getId()).rightMargin(7));

        baseButton.setGravity(Gravity.CENTER);
        baseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InvitationBindActivity.start(InvitationActivity.this, InvitationBindActivity.class);

            }
        });


    }

    private BaseButton btnBind;

    @Override
    public void onInvitationInfoSuc(InvitationInfoResponse webSocketMsgResponse) {
        tvCode.setText(webSocketMsgResponse.getInvoteCode());


        if (webSocketMsgResponse.isBind()) {

            if (btnBind != null) {
                btnBind.setVisibility(View.GONE);
            }
        } else {
            if (btnBind == null) {
                btnBind = BaseButton.create(contentView, new ConstraintBuilder(108, 28).bottomCenterH().bottomMargin(31));

                btnBind.setBackgroundResource(R.drawable.shape_invitation_btn_bg);
                btnBind.setGravity(Gravity.CENTER);
                btnBind.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                    }
                });
            }

        }


    }

    @Override
    public void onBindInvitationSuc() {

    }
}
