package com.daylong.arcx.user.invitation;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.httplibrary.bean.response.user.InvitationInfoResponse;
import com.daylong.httplibrary.model.contract.user.InvitationContract;
import com.daylong.httplibrary.model.model.user.InvitationModel;
import com.daylong.httplibrary.model.presenter.user.InvitationPresenter;
import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.textview.MyTextView;

public class InvitationBindActivity extends BaseMvpActivity<InvitationPresenter, InvitationModel> implements InvitationContract.InvitationView {


    @Override
    protected boolean isAddBaseTitle() {
        return true;
    }

    @Override
    protected Integer getTitleName() {
        return R.string.invitation_bind;
    }

    @NonNull
    @Override
    protected InvitationPresenter initPresenter() {
        return InvitationPresenter.newInstance();
    }

    private BaseButton btnBind;

    private EditText tvCode;
    private ConstraintLayout contentView;

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);


        contentView = new ConstraintBuilder(174, 206).centerH().topToBottom(baseTitleView.getId()).build(this);
        contentView.setBackgroundResource(R.drawable.shape_invitation_bg);
        addView(contentView);
        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().topCenterH().topMargin(21));

        ConstraintBuilder constraintBuilder = new ConstraintBuilder(148, 35).topCenterH().topMargin(51);
        tvCode = new EditText(this);
        tvCode.setLayoutParams(constraintBuilder.getParams());
        tvCode.setGravity(Gravity.CENTER_VERTICAL);
        contentView.addView(tvCode);
        tvCode.setPadding(AppUtil.getSize(12), 0, AppUtil.getSize(12), 0);
        tvCode.setBackgroundResource(R.drawable.shape_invitation_et_code_bg);
        tvCode.getPaint().setTextSize(AppUtil.getSize(9));
        tvCode.setTextColor(getColor(R.color.color_434343));
        tvCode.setHintTextColor(getColor(R.color.color_434343));

        tvCode.setMaxLines(1);


        tvCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String string = editable.toString();
                btnBind.setBackgroundResource(TextUtils.isEmpty(string) ? R.drawable.shape_invitation_btn_none_bg : R.drawable.shape_invitation_btn_bg);


            }
        });
        btnBind = BaseButton.create(contentView, new ConstraintBuilder(108, 28).bottomCenterH().bottomMargin(31));

        btnBind.setGravity(Gravity.CENTER);
        btnBind.setBackgroundResource(R.drawable.shape_invitation_btn_none_bg);
        btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = tvCode.getText().toString().trim();

                if (TextUtils.isEmpty(code)) {

                } else {
                    mPresenter.bindInvitation(code);
                }

            }
        });


        mPresenter.getInvitationInfo();

    }


    @Override
    public void onInvitationInfoSuc(InvitationInfoResponse webSocketMsgResponse) {


    }

    @Override
    public void onBindInvitationSuc() {

        finish();

    }
}
