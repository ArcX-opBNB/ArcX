package com.daylong.arcx.user.wallet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.enums.WalletType;
import com.daylong.arcx.view.user.wallet.MyInputFilter;
import com.daylong.arcx.view.user.wallet.MyTextWatcher;
import com.daylong.httplibrary.bean.response.wallet.WalletConfigureResponse;
import com.daylong.httplibrary.model.contract.wallet.WithdrawalContract;
import com.daylong.httplibrary.model.model.wallet.WithdrawalModel;
import com.daylong.httplibrary.model.presenter.wallet.WithdrawalPresenter;

import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

import org.w3c.dom.Text;

import java.io.Serializable;

/**

 */
public class WithdrawalActivity extends BaseMvpActivity<WithdrawalPresenter, WithdrawalModel> implements WithdrawalContract.WithdrawalView {

    private DefaultView titleBg, contentBg;
    private WalletType walletType;

    private WalletConfigureResponse configureInfo;

    public static void start(Context context, double axcPrice, WalletType walletType, WalletConfigureResponse configureResponse) {


        Intent intent = new Intent(context, WithdrawalActivity.class);

        intent.putExtra("axcPrice", axcPrice);
        intent.putExtra("walletType", walletType);
        intent.putExtra("configureInfo", configureResponse);
        context.startActivity(intent);
    }


    @Override
    protected void initView(ViewGroup rootView) {
        initTitle(rootView);

        initContent(rootView);
        super.initView(rootView);


    }

    @Override
    protected Integer getBackBgRegId() {
        return com.daylong.reglinrary.R.drawable.img_back_withdraw;
    }

    private void initContent(ViewGroup rootView) {


        Intent intent = getIntent();
        double axcPrice = intent.getDoubleExtra("axcPrice", 0.0);
        walletType = (WalletType) intent.getSerializableExtra("walletType");
        configureInfo = (WalletConfigureResponse) intent.getSerializableExtra("configureInfo");

        contentBg = DefaultView.create(rootView, new ConstraintBuilder(0, 0).topToBottom(titleBg).bottomCenterH());
        contentBg.setBackgroundResource(R.drawable.shape_wallet_bg);

        MyTextView tvAsset = MyTextView.create(rootView, new ConstraintBuilder().ww().leftTop(contentBg).leftTopMargin(8, 11));
        tvAsset.initText("Asset", 8, net.daylong.daylongbase.R.color.color_333, true);

        
        DefaultView typeItemBg = DefaultView.create(rootView, new ConstraintBuilder(172, 22).topMargin(4).topToBottom(tvAsset).centerH());
        typeItemBg.setBackgroundResource(R.drawable.shape_r8_fff);
        MyImageView itemIcon = MyImageView.create(rootView, new ConstraintBuilder(18).leftCenterV(typeItemBg).leftMargin(5), walletType.getRegId());
        itemIcon.setPadding(getSize(1), getSize(1), getSize(1), getSize(1));
        itemIcon.setBackgroundResource(R.drawable.shape_oval_000);
        MyTextView tvName = MyTextView.create(rootView, new ConstraintBuilder().ww().leftToRightById(itemIcon).centerV(itemIcon).leftMargin(2));
        tvName.initText(walletType.getName(), 8, net.daylong.daylongbase.R.color.color_333, false);


//        Amount/
        MyTextView tvAmount = MyTextView.create(rootView, new ConstraintBuilder().ww().left(tvAsset).topToBottom(typeItemBg).topMargin(8));
        tvAmount.initText("Amount", 8, net.daylong.daylongbase.R.color.color_333, true);

        MyTextView tvPrice = MyTextView.create(rootView, new ConstraintBuilder().ww().right(typeItemBg).rightMargin(2).centerV(tvAmount));
        tvPrice.initText("Balance : " + axcPrice, 8, net.daylong.daylongbase.R.color.color_666, true);

        EditText editText = new EditText(this);
        editText.setId(View.generateViewId());
        editText.setLayoutParams(new ConstraintBuilder(172, 22).topToBottom(tvAmount).centerH(contentBg).topMargin(2).buildPayoutParams());
        editText.setBackgroundResource(R.drawable.shape_r8_fff);
        editText.setSingleLine();
        editText.setInputType(configureInfo.getInputType(walletType.getId()));
        editText.setTextColor(getColor(net.daylong.daylongbase.R.color.color_333));
        editText.setHintTextColor(getColor(net.daylong.daylongbase.R.color.color_999999));
        editText.getPaint().setTextSize(getSize(7));
        editText.setHint("Please enter");
        editText.setPadding(getSize(5), 0, getSize(100), 0);
        editText.addTextChangedListener(new MyTextWatcher(configureInfo, walletType.getId(), editText, axcPrice));

        rootView.addView(editText);
        MyBtn myBtn = MyBtn.create(rootView, new ConstraintBuilder().ww().height(22).rightMargin(5).right(editText).centerV(editText), R.drawable.shape_tr, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(String.valueOf(((int) axcPrice)));
                editText.setSelection(editText.getText().length());
            }
        });
        myBtn.setGravity(Gravity.CENTER_VERTICAL);
        myBtn.initBtn("ALL", 7, R.color.color_ff6d3b, true);


        
        DefaultView networkBg = DefaultView.create(rootView, new ConstraintBuilder(172, 50).topMargin(5).topToBottom(editText).centerH());
        networkBg.setBackgroundResource(R.drawable.shape_r8_fff);

        MyTextView tvNetwork = MyTextView.create(rootView, new ConstraintBuilder().ww().leftTop(networkBg).leftTopMargin(5, 6));
        tvNetwork.initText("Network", 7, net.daylong.daylongbase.R.color.color_333, true);
        MyTextView tvSolana = MyTextView.create(rootView, new ConstraintBuilder().ww().right(networkBg).centerV(tvNetwork).rightMargin(5));
        tvSolana.initText("Solana", 6, net.daylong.daylongbase.R.color.color_ff666666, true);


        MyTextView tvNetwordFee = MyTextView.create(rootView, new ConstraintBuilder().ww().left(tvNetwork).topToBottom(tvNetwork).topMargin(6));
        tvNetwordFee.initText("Netword fee", 7, net.daylong.daylongbase.R.color.color_333, true);
        MyTextView tvNetwordFeeValue = MyTextView.create(rootView, new ConstraintBuilder().ww().right(networkBg).centerV(tvNetwordFee).rightMargin(5));
        tvNetwordFeeValue.initText(configureInfo.getNetworkFee(walletType.getId()), 6, net.daylong.daylongbase.R.color.color_ff666666, true);


        MyTextView tvMaximum = MyTextView.create(rootView, new ConstraintBuilder().ww().leftBottom(networkBg).leftBottomMargin(5, 6));
        tvMaximum.initText("Maximum withdraw", 7, net.daylong.daylongbase.R.color.color_333, true);
        MyTextView tvUsdt = MyTextView.create(rootView, new ConstraintBuilder().ww().right(networkBg).centerV(tvMaximum).rightMargin(5));
        tvUsdt.initText(configureInfo.getMaxInfo(walletType.getId()), 6, net.daylong.daylongbase.R.color.color_ff666666, true);


        MyTextView tvAvailable = MyTextView.create(rootView, new ConstraintBuilder().ww().left(networkBg).topToBottom(networkBg).topMargin(8));
        tvAvailable.initText("Available：0 SOL", 7, net.daylong.daylongbase.R.color.color_333, true);
        tvAvailable.setVisibility(View.INVISIBLE);
        MyBtn btnConfirm = MyBtn.create(rootView, new ConstraintBuilder(80, 30).rightMargin(5).topToBottom(tvAvailable).topMargin(18).centerH(), com.daylong.reglinrary.R.drawable.img_btn_user_update, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                String trim = editText.getText().toString().trim();

                if (TextUtils.isEmpty(trim) && Integer.parseInt(trim) > 0) {
                    return;
                }
                if (StringUtils.isNubAndDot(trim)) {
                    mPresenter.postWithdrawal(walletType.getId(), Double.parseDouble(trim));

                }
            }
        });
        btnConfirm.setGravity(Gravity.CENTER);
        btnConfirm.initBtn("CONFIRM", 10, R.color.color_white, true);
        btnConfirm.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), getColor(R.color.color_fff6bfea));

    }

    private void initTitle(ViewGroup rootView) {


        titleBg = DefaultView.create(rootView, new ConstraintBuilder(0, 129).topCenterH());
        titleBg.setBackgroundColor(Color.parseColor("#ffcbb6fc"));


        DefaultView itemBg = DefaultView.create(rootView, new ConstraintBuilder(172, 78).topCenterH().topMargin(38));
        itemBg.setBackgroundResource(R.drawable.shape_r16_fff);


        MyTextView tvFrom = MyTextView.create(rootView, new ConstraintBuilder().ww().leftTop(itemBg).leftTopMargin(10, 11));
        tvFrom.initText("From", 8, net.daylong.daylongbase.R.color.color_333, true);

        MyTextView tvSpending = MyTextView.create(rootView, new ConstraintBuilder().ww().centerV(tvFrom).right(itemBg).rightMargin(10));
        tvSpending.initText("Spending", 8, net.daylong.daylongbase.R.color.color_666, false);

        DefaultView fromLine = DefaultView.create(rootView, new ConstraintBuilder(150, 1).left(tvFrom).topToBottom(tvFrom).topMargin(13).centerH());
        fromLine.setBackgroundColor(Color.parseColor("#ffebeafe"));

//
        MyTextView tvTo = MyTextView.create(rootView, new ConstraintBuilder().ww().left(tvFrom).topToBottom(fromLine).topMargin(13));
        tvTo.initText("To", 8, net.daylong.daylongbase.R.color.color_333, true);
//
        MyTextView tvWallet = MyTextView.create(rootView, new ConstraintBuilder().ww().centerV(tvTo).right(itemBg).rightMargin(10));
        tvWallet.initText("Wallet", 8, net.daylong.daylongbase.R.color.color_666, false);


    }

    @NonNull
    @Override
    protected WithdrawalPresenter initPresenter() {
        return WithdrawalPresenter.newInstance();
    }

    @Override
    public void onWithdrawalSuc() {
        ToastUtil.show(getString(R.string.str_success));

    }
}
