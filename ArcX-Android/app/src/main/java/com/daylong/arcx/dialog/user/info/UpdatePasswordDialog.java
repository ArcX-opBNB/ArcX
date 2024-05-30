package com.daylong.arcx.dialog.user.info;

import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.arcx.R;
import com.daylong.arcx.act.UserInfoActivity;
import com.daylong.arcx.uitls.UserCache;
import com.daylong.httplibrary.bean.request.user.UpdatePasswordRequest;
import com.daylong.httplibrary.bean.request.user.UpdateUserInfoRequest;
import com.daylong.httplibrary.model.contract.user.UpdatePasswordContract;
import com.daylong.httplibrary.model.model.user.UpdatePasswordModel;
import com.daylong.httplibrary.model.presenter.user.UpdatePasswordPresenter;

import net.daylong.baselibrary.app.AppManager;
import net.daylong.baselibrary.base.dialog.BaseDialog;
import net.daylong.baselibrary.dialog.BaseFragmentDialog;
import net.daylong.baselibrary.dialog.BaseMvpFragmentDialog;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.LinearLayoutBuilder;
import net.daylong.baselibrary.view.btn.BaseButton;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class UpdatePasswordDialog extends BaseMvpFragmentDialog<UpdatePasswordPresenter, UpdatePasswordModel> implements UpdatePasswordContract.UpdatePasswordView {


    public static void showDialog(UserInfoActivity userInfoActivity) {
        UpdatePasswordDialog updateNickNameDialog = new UpdatePasswordDialog();
        updateNickNameDialog.show(userInfoActivity.getSupportFragmentManager(), updateNickNameDialog.toString());

    }

    private MyBtn btnSendMsg;

    @Override
    protected ViewGroup getContentLayout() {
        return new ConstraintBuilder(151, 192).center().build(getContext());
    }


    @Override
    public void initView(ViewGroup rootView, ViewGroup contentView, BaseDialog dialog) {
        super.initView(rootView, contentView, dialog);

        contentView.setBackgroundResource(com.daylong.reglinrary.R.drawable.img_user_info_bg);
        Bundle arguments = getArguments();

        if (arguments != null) {
            String string = arguments.getString("email");

        }
        MyImageView.create(contentView, new ConstraintBuilder(73, 10).topCenterH().topMargin(9), R.drawable.img_user_title_password);


        MyTextView myTextView = MyTextView.create(contentView, new ConstraintBuilder().ww().leftTop().leftMargin(12).topMargin(26));
        myTextView.initText("Email", 7, net.daylong.daylongbase.R.color.color_333);

        MyTextView tvEmail = MyTextView.create(contentView, new ConstraintBuilder(140, 22).left().topToBottom(myTextView).leftMargin(7).topMargin(2));
        tvEmail.initText(UserCache.getUserInfo().getEmail(), 7, net.daylong.daylongbase.R.color.color_333);
        tvEmail.setBackgroundResource(R.drawable.shape_r12_1ff);
        tvEmail.setPadding(AppUtil.getSize(5), 0, AppUtil.getSize(5), 0);
        tvEmail.setGravity(Gravity.CENTER_VERTICAL);

        MyTextView tvCode = MyTextView.create(contentView, new ConstraintBuilder().ww().left(myTextView).topToBottom(tvEmail).topMargin(5));

        tvCode.initText("Email verification c", 7, net.daylong.daylongbase.R.color.color_333);
        EditText etCode = createEditText(contentView, new ConstraintBuilder().ww().topToBottom(tvCode).left(tvEmail).topMargin(2), "");
        etCode.setInputType(InputType.TYPE_CLASS_NUMBER);

        btnSendMsg = MyBtn.create(contentView, new ConstraintBuilder().ww().centerV(etCode).right(etCode).rightMargin(4), R.drawable.shape_tr, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {

                mPresenter.getEmailCode(UserCache.getUserInfo().getEmail());
            }
        });

        btnSendMsg.initBtn("Send Code", 7, R.color.color_78351c, true);

        MyTextView tvPassword = MyTextView.create(contentView, new ConstraintBuilder().ww().left(etCode).topToBottom(etCode).topMargin(5));
        tvPassword.initText("New password", 7, net.daylong.daylongbase.R.color.color_333);
        EditText etPassword = createEditText(contentView, new ConstraintBuilder().ww().topToBottom(tvPassword).left(etCode).topMargin(2), "");
        etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        BaseButton baseButton = MyBtn.create(contentView, new ConstraintBuilder(80, 28).bottomCenterH().bottomMargin(17), com.daylong.reglinrary.R.drawable.img_btn_user_update, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {

                String password = etPassword.getText().toString().trim();
                String code = etCode.getText().toString().trim();


                if (!TextUtils.isEmpty(password) && !TextUtils.isEmpty(code)) {
                    mPresenter.updatePassword(new UpdatePasswordRequest(UserCache.getUserInfo().getEmail(), code, password));
                }


            }
        });
        baseButton.setGravity(Gravity.CENTER);
        baseButton.initBtn("SAVE", 10, R.color.color_white, true);
        baseButton.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), R.color.color_fff6bfea);
        MyBtn.create(rootView, new ConstraintBuilder(15).bottomCenterH().bottomMargin(27), com.daylong.reglinrary.R.drawable.img_dialog_colse, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


    }

    private EditText createEditText(ViewGroup contentView, ConstraintBuilder constraintBuilder, String hint) {

        EditText editText = new EditText(getContext());
        editText.setLayoutParams(constraintBuilder.width(140).height(22).buildPayoutParams());
        editText.setBackgroundResource(R.drawable.shape_r12_1ff);
        editText.getPaint().setTextSize(getSize(7));
        editText.setHint(hint);
        editText.setMaxLines(1);
        editText.setSingleLine();
        editText.setTextColor(getContext().getColor(net.daylong.daylongbase.R.color.color_333));
        editText.setHighlightColor(getContext().getColor(R.color.color_a99cda));
        editText.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        editText.setPadding(getSize(4), 0, getSize(4), 0);
        editText.setId(View.generateViewId());
        contentView.addView(editText);
        return editText;


    }

    @Override
    public void initView(ConstraintLayout rootView, BaseDialog dialog) {

    }

    @Override
    public void initData() {

    }

    @NonNull
    @Override
    protected UpdatePasswordPresenter initPresenter() {
        return UpdatePasswordPresenter.newInstance();
    }

    @Override
    public void onUpdatePasswordSuc(Object userInfoResponse) {

        dismiss();

    }

    @Override
    public void onFail(String str) {

    }

    @Override
    public void onEmailCodeSuc() {
        btnSendMsg.setClickable(false);
        btnSendMsg.setEnabled(false);
        time = 60;
        AppUtil.getMainHandler().removeCallbacks(runnable, null);
        AppUtil.getMainHandler().postDelayed(runnable, 0);

    }

    private int time;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            time--;

            if (time > 0) {
                btnSendMsg.setText(String.valueOf(--time));
                AppUtil.getMainHandler().postDelayed(this, 1000);
            } else {
                btnSendMsg.setText("Send Code");
                btnSendMsg.setClickable(true);
                btnSendMsg.setEnabled(true);

            }


        }
    };


}
