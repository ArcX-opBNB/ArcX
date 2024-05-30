package com.daylong.arcx.user;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.daylong.httplibrary.model.contract.user.FeedbackContract;
import com.daylong.httplibrary.model.model.user.FeedbackModel;
import com.daylong.httplibrary.model.presenter.user.FeedbackPresenter;
import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.btn.BaseButton;


public class FeedbackActivity extends BaseMvpActivity<FeedbackPresenter, FeedbackModel> implements FeedbackContract.FeedbackView {

    @Override
    protected boolean isAddBaseTitle() {
        return true;
    }

    @Override
    protected Integer getTitleName() {
        return R.string.feedback;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected void initView(ViewGroup rootView) {
        super.initView(rootView);

        DefaultView defaultView = DefaultView.create(rootView, new ConstraintBuilder(0, 0).topToBottom(baseTitleView).bottomCenterH().left());
        defaultView.setBackgroundColor(getColor(net.daylong.daylongbase.R.color.color_f6f6f6));
        initEditText();
        createBtn();
    }

    private EditText editText;

    private void initEditText() {

        editText = new EditText(this);
        editText.setGravity(Gravity.LEFT | Gravity.TOP);
        editText.setBackgroundColor(Color.TRANSPARENT);
        editText.getPaint().setTextSize(AppUtil.getSize(7));
        editText.setTextColor(getColor(R.color.color_434343));
        editText.setPadding(AppUtil.getSize(6), AppUtil.getSize(6), AppUtil.getSize(6), AppUtil.getSize(6));

        editText.setHintTextColor(getColor(R.color.color_434343));
        editText.setLayoutParams(new ConstraintBuilder(172, 100).topToBottom(baseTitleView).centerH().buildPayoutParams());

        addView(editText);


    }

    private void createBtn() {


        BaseButton btnNewAddress = BaseButton.create(rootView, new ConstraintBuilder(163, 28).bottomCenterH().bottomMargin(25));

        btnNewAddress.setGravity(Gravity.CENTER);
        btnNewAddress.setBackgroundResource(R.drawable.shape_r_30_bg_c48);
        btnNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = editText.getText().toString().trim();

                if (TextUtils.isEmpty(trim)) {

                    return;
                }

                mPresenter.postFeedback(trim);
            }
        });


    }


    @NonNull
    @Override
    protected FeedbackPresenter initPresenter() {
        return FeedbackPresenter.newInstance();
    }

    @Override
    public void onFeedback() {


        finish();

    }
}
