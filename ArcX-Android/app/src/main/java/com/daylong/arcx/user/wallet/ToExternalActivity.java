package com.daylong.arcx.user.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.daylong.arcx.R;
import com.daylong.arcx.act.ScanAddressActivity;
import com.daylong.arcx.dialog.wallet.SelectWalletTypeDialog;
import com.daylong.arcx.enums.WalletType;
import com.daylong.arcx.view.user.wallet.SelectWalletType;
import com.daylong.httplibrary.bean.response.wallet.WalletInfoResponse;
import com.daylong.httplibrary.bean.response.wallet.WalletResponse;
import com.daylong.httplibrary.model.contract.wallet.ToExternalContract;
import com.daylong.httplibrary.model.contract.wallet.WithdrawalContract;
import com.daylong.httplibrary.model.model.wallet.ToExternalModel;
import com.daylong.httplibrary.model.model.wallet.WithdrawalModel;
import com.daylong.httplibrary.model.presenter.wallet.ToExternalPresenter;
import com.daylong.httplibrary.model.presenter.wallet.WithdrawalPresenter;

import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.act.WebViewActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

/**

 */
public class ToExternalActivity extends BaseMvpActivity<ToExternalPresenter, ToExternalModel> implements ToExternalContract.ToExternalView, SelectWalletType.OnItemClickListener {

    private DefaultView titleBg, contentBg;
    private WalletType walletType;
    private EditText etAddress;

    private MyImageView itemIcon;
    private MyTextView tvName;
    private double axcPrice = 0;
    private MyTextView tvBalance;

    public static void start(Context context, WalletInfoResponse walletInfoResponse, WalletType walletType) {


        Intent intent = new Intent(context, ToExternalActivity.class);

        intent.putExtra("balance", walletInfoResponse);
        intent.putExtra("walletType", walletType);
        context.startActivity(intent);
    }

    private WalletInfoResponse walletInfoResponse;

    @Override
    protected void initView(ViewGroup rootView) {
        Intent intent = getIntent();
        walletInfoResponse = (WalletInfoResponse) intent.getSerializableExtra("balance");
        axcPrice = walletInfoResponse.getUsdt();
        walletType = (WalletType) intent.getSerializableExtra("walletType");
        initTitle(rootView);
        initContent(rootView);
        super.initView(rootView);
        rootView.setBackgroundResource(R.drawable.shape_wallet_bg);

    }

    @Override
    protected Integer getBackBgRegId() {
        return R.drawable.img_back_to_ex;
    }

    private void initContent(ViewGroup rootView) {


        contentBg = DefaultView.create(rootView, new ConstraintBuilder(0, 0).topToBottom(titleBg).bottomCenterH());
        contentBg.setBackgroundResource(R.drawable.shape_wallet_bg);


        
        createAddAddr();
        createSudt(etAddress);

    }

    private void createSudt(View toView) {


//        Amount/
        MyTextView tvAmount = MyTextView.create(rootView, new ConstraintBuilder().ww().left().leftMargin(8).topToBottom(toView).topMargin(4));
        tvAmount.initText("Amount", 8, net.daylong.daylongbase.R.color.color_333, true);


        EditText editText = new EditText(this);
        editText.setId(View.generateViewId());
        editText.setLayoutParams(new ConstraintBuilder(172, 22).topToBottom(tvAmount).centerH(contentBg).topMargin(2).buildPayoutParams());
        editText.setBackgroundResource(R.drawable.shape_r8_fff);
        editText.setSingleLine();
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setTextColor(getColor(net.daylong.daylongbase.R.color.color_333));
        editText.setHintTextColor(getColor(net.daylong.daylongbase.R.color.color_999999));
        editText.getPaint().setTextSize(getSize(7));
        editText.setHint("");
        editText.setPadding(getSize(5), 0, getSize(100), 0);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String str = editable.toString();
                if (!TextUtils.isEmpty(str) && StringUtils.isNumber(str)) {
                    if (Integer.parseInt(str) > axcPrice) {
                        editText.setText(String.valueOf((int) axcPrice));
                        editText.setSelection(editText.getText().length());

                    }
                }
            }
        });

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

        MyTextView tvEUsdt = MyTextView.create(rootView, new ConstraintBuilder().ww().rightToLeftById(myBtn.getId()).centerV(editText).rightMargin(2));
        tvEUsdt.initText("USDT", 8, net.daylong.daylongbase.R.color.color_333, true);


        tvBalance = MyTextView.create(rootView, new ConstraintBuilder().ww().left().leftMargin(8).topToBottom(editText).topMargin(6));
        tvBalance.initText("Balance：" + axcPrice + walletType.getName(), 8, net.daylong.daylongbase.R.color.color_333, true);


        MyTextView myTextView = MyTextView.create(rootView, new ConstraintBuilder(172, 0).wHei().topToBottom(tvBalance).topMargin(2).centerH());
        myTextView.setPadding(AppUtil.getSize(6), AppUtil.getSize(6), AppUtil.getSize(6), AppUtil.getSize(6));
        myTextView.setBackgroundResource(R.drawable.shape_r8_fff);
        String xx = "The network you have selected is <font color='red'>Solana</font>. Please ensure that the withdrawal address supports the <font color='red'>Solana</font> network. <font color='red'>You will lose your assets</font> if the chosen platform does not support retrievals.";
        myTextView.initText(5, net.daylong.daylongbase.R.color.color_666, false);
        myTextView.setText(Html.fromHtml(xx));


        
        DefaultView networkBg = DefaultView.create(rootView, new ConstraintBuilder(172, 50).topMargin(8).topToBottom(myTextView).centerH());
        networkBg.setBackgroundResource(R.drawable.shape_r8_fff);

        MyTextView tvNetwork = MyTextView.create(rootView, new ConstraintBuilder().ww().leftTop(networkBg).leftTopMargin(5, 6));
        tvNetwork.initText("Network", 7, net.daylong.daylongbase.R.color.color_333, true);
        MyTextView tvSolana = MyTextView.create(rootView, new ConstraintBuilder().ww().right(networkBg).centerV(tvNetwork).rightMargin(5));
        tvSolana.initText("Solana", 6, net.daylong.daylongbase.R.color.color_ff666666, true);


        MyTextView tvNetwordFee = MyTextView.create(rootView, new ConstraintBuilder().ww().leftTopToBottom(tvNetwork).topMargin(6));
        tvNetwordFee.initText("Netword fee", 7, net.daylong.daylongbase.R.color.color_333, true);
        MyTextView tvNetwordFeeUdt = MyTextView.create(rootView, new ConstraintBuilder().ww().right(networkBg).centerV(tvNetwordFee).rightMargin(5));
        tvNetwordFeeUdt.initText("Solana Gas", 6, net.daylong.daylongbase.R.color.color_ff666666, true);


        MyTextView tvMaximum = MyTextView.create(rootView, new ConstraintBuilder().ww().leftTopToBottom(tvNetwordFee).topMargin(6));
        tvMaximum.initText("Maximum withdraw", 7, net.daylong.daylongbase.R.color.color_333, true);
        MyTextView tvUsdt = MyTextView.create(rootView, new ConstraintBuilder().ww().right(networkBg).centerV(tvMaximum).rightMargin(5));
        tvUsdt.initText(walletType.getExchangeRate(), 6, net.daylong.daylongbase.R.color.color_ff666666, true);


        MyBtn btnConfirm = MyBtn.create(rootView, new ConstraintBuilder(80, 30).rightMargin(5).topToBottom(networkBg).topMargin(6).centerH(), com.daylong.reglinrary.R.drawable.img_btn_user_update, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                String trim = editText.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                if (TextUtils.isEmpty(trim) && Integer.parseInt(trim) > 0 && TextUtils.isEmpty(address)) {
                    return;
                }
                int i = Integer.parseInt(trim);
                mPresenter.postToExternal(walletType.getId(), i, address);
            }
        });
        btnConfirm.setGravity(Gravity.CENTER);
        btnConfirm.initBtn("CONFIRM", 10, R.color.color_white, true);
        btnConfirm.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), getColor(R.color.color_fff6bfea));

    }

    private void createAddAddr() {


//        Amount/
        MyTextView tvAmount = MyTextView.create(rootView, new ConstraintBuilder().ww().leftTop(contentBg).leftTopMargin(8, 5));
        tvAmount.initText("To address", 8, net.daylong.daylongbase.R.color.color_333, true);


        etAddress = new EditText(this);
        etAddress.setId(View.generateViewId());
        etAddress.setLayoutParams(new ConstraintBuilder(172, 24).topToBottom(tvAmount).centerH(contentBg).topMargin(4).buildPayoutParams());
        etAddress.setBackgroundResource(R.drawable.shape_r8_fff);
        etAddress.setSingleLine();
        etAddress.setTextColor(getColor(net.daylong.daylongbase.R.color.color_333));
        etAddress.setHintTextColor(getColor(net.daylong.daylongbase.R.color.color_999999));
        etAddress.getPaint().setTextSize(getSize(7));
        etAddress.setPadding(getSize(5), 0, AppUtil.getSize(24), 0);

        rootView.addView(etAddress);
        MyBtn btnScan = MyBtn.create(rootView, new ConstraintBuilder(15).rightMargin(5).right(etAddress).centerV(etAddress), R.drawable.img_btn_scan, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {
                ScanAddressActivity.start(ToExternalActivity.this);
            }
        });

    }

    private void initTitle(ViewGroup rootView) {


        titleBg = DefaultView.create(rootView, new ConstraintBuilder(0, 114).topCenterH());
        titleBg.setBackgroundColor(Color.parseColor("#ffcbb6fc"));

        DefaultView itemBg = DefaultView.create(rootView, new ConstraintBuilder(172, 63).topCenterH().topMargin(38));
        itemBg.setBackgroundResource(R.drawable.shape_r16_fff);
        itemBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        DefaultView typeItemBg = DefaultView.create(rootView, new ConstraintBuilder(160, 28).bottomCenterH(itemBg).bottomMargin(8));
        typeItemBg.setBackgroundResource(R.drawable.shape_bg_r8_7f8);
        typeItemBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectWalletTypeDialog.show(ToExternalActivity.this, ToExternalActivity.this);
            }
        });

        itemIcon = MyImageView.create(rootView, new ConstraintBuilder(18).leftCenterV(typeItemBg).leftMargin(6), walletType.getRegId());
        itemIcon.setPadding(getSize(1), getSize(1), getSize(1), getSize(1));
        itemIcon.setBackgroundResource(R.drawable.shape_oval_000);


        tvName = MyTextView.create(rootView, new ConstraintBuilder().ww().leftToRightById(itemIcon).centerV(itemIcon).leftMargin(3));
        tvName.initText(walletType.getName(), 7, net.daylong.daylongbase.R.color.color_333, false);

        MyTextView toSend = MyTextView.create(rootView, new ConstraintBuilder().ww().topCenterH(itemBg).topMargin(8));
        toSend.initText("SEND TO", 7, net.daylong.daylongbase.R.color.color_333, false);


    }

    @NonNull
    @Override
    protected ToExternalPresenter initPresenter() {
        return ToExternalPresenter.newInstance();
    }


    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            etAddress.setText(data.getStringExtra("address"));

        }
    }

    @Override
    public void onToExternalSuc(WalletResponse walletResponse) {
        WebViewActivity.start(this, "", walletResponse.getUrl());

        ToastUtil.show(getString(R.string.str_success));
        finish();
    }

    @Override
    public void click(WalletType walletType) {
        this.walletType = walletType;
        itemIcon.setImageReg(walletType.getRegId());
        tvName.setText(walletType.getName());
        if (walletType == WalletType.AXC) {
            axcPrice = walletInfoResponse.getAxc();
        } else if (walletType == WalletType.USDT) {
            axcPrice = walletInfoResponse.getUsdt();
        } else if (walletType == WalletType.SOLANA) {
            axcPrice = walletInfoResponse.getSol();
        }
        tvBalance.initText("Balance：" + axcPrice + walletType.getName(), 8, net.daylong.daylongbase.R.color.color_333, true);

    }
}
