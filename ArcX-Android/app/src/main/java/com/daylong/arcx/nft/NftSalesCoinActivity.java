package com.daylong.arcx.nft;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.enums.WalletType;
import com.daylong.arcx.view.RechargeNumberView;
import com.daylong.arcx.view.nft.NftSeekBar;
import com.daylong.httplibrary.bean.response.nft.NftExchangeResponse;
import com.daylong.httplibrary.bean.response.nft.NftSalesCoinInfoResponse;
import com.daylong.httplibrary.bean.response.wallet.WalletResponse;
import com.daylong.httplibrary.model.contract.nft.NftSalesCoinContract;
import com.daylong.httplibrary.model.contract.wallet.ToSpendingContract;
import com.daylong.httplibrary.model.model.nft.NftSalesCoinModel;
import com.daylong.httplibrary.model.model.wallet.ToSpendingModel;
import com.daylong.httplibrary.model.presenter.nft.NftSalesCoinPresenter;
import com.daylong.httplibrary.model.presenter.wallet.ToSpendingPresenter;

import net.daylong.baselibrary.bean.CanvasImageBean;
import net.daylong.baselibrary.utils.StringUtils;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.act.BaseMvpActivity;
import net.daylong.baselibrary.utils.ui.act.WebViewActivity;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.DefaultView;
import net.daylong.baselibrary.view.DrawableUtils;
import net.daylong.baselibrary.view.btn.MyBtn;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

/**

 */
public class NftSalesCoinActivity extends BaseMvpActivity<NftSalesCoinPresenter, NftSalesCoinModel> implements NftSalesCoinContract.NftSalesCoinView, NftSeekBar.OnEdittextNumListener {

    private DefaultView titleBg;
    private MyTextView tvNFTId;
    private MyTextView tvPriceVal;
    private MyTextView tvValMax;
    private MyTextView ivBalance;

    private NftSeekBar nftSeekBar;
    private RechargeNumberView rechargeNumberView;

    public static void start(Context context) {


        Intent intent = new Intent(context, NftSalesCoinActivity.class);

        context.startActivity(intent);
    }


    @Override
    protected void initView(ViewGroup rootView) {

        super.initView(rootView);
        initTitle(rootView);

        initContent(rootView);

        mPresenter.getNftSalesCoinInfo();

    }


    @Override
    protected Integer getBackBgRegId() {
        return R.drawable.img_back_sale;
    }

    private void initContent(ViewGroup rootView) {


        DefaultView contentBg = DefaultView.create(rootView, new ConstraintBuilder(0, 0).topToBottom(titleBg).bottomCenterH());
        contentBg.setBackgroundResource(R.drawable.shape_wallet_bg);


        DefaultView networkBg = DefaultView.create(rootView, new ConstraintBuilder(172, 50).topMargin(5).top(contentBg).centerH());
        networkBg.setBackgroundResource(R.drawable.shape_r8_fff);

        MyTextView tvNetwork = MyTextView.create(rootView, new ConstraintBuilder().ww().leftTop(networkBg).leftTopMargin(5, 6));
        tvNetwork.initText("Coin Vending NFT", 7, net.daylong.daylongbase.R.color.color_333, false);
        tvNFTId = MyTextView.create(rootView, new ConstraintBuilder().ww().right(networkBg).centerV(tvNetwork).rightMargin(5));
        tvNFTId.initText(7, net.daylong.daylongbase.R.color.color_333, false);

        MyTextView tvNetwordFee = MyTextView.create(rootView, new ConstraintBuilder().ww().left(tvNetwork).topToBottom(tvNetwork).topMargin(6));
        tvNetwordFee.initText("Price", 7, net.daylong.daylongbase.R.color.color_e09927, false);

        tvPriceVal = MyTextView.create(rootView, new ConstraintBuilder().ww().right(networkBg).centerV(tvNetwordFee).rightMargin(5));
        tvPriceVal.initText(6, net.daylong.daylongbase.R.color.color_ff666666, false);


        MyTextView tvMaximum = MyTextView.create(rootView, new ConstraintBuilder().ww().leftBottom(networkBg).leftBottomMargin(5, 6));
        tvMaximum.initText("Max Volume", 7, net.daylong.daylongbase.R.color.color_333, true);
        tvValMax = MyTextView.create(rootView, new ConstraintBuilder().ww().right(networkBg).centerV(tvMaximum).rightMargin(5));
        tvValMax.initText(6, net.daylong.daylongbase.R.color.color_ff6d3b, true);


        MyTextView textView = MyTextView.create(rootView, new ConstraintBuilder().ww().topToBottom(networkBg).centerH().topMargin(13).buildPayoutParams());
        textView.initText("You will get", 10, net.daylong.daylongbase.R.color.color_333, true);


        rechargeNumberView = new RechargeNumberView(this);
        rechargeNumberView.setId(View.generateViewId());
        rechargeNumberView.setLayoutParams(new ConstraintBuilder(15).topToBottom(textView).centerH().topMargin(8).buildPayoutParams());
        rechargeNumberView.setCanvasImageStart(new CanvasImageBean(15, 15, R.drawable.img_coin));
        addView(rechargeNumberView);
        MyBtn btnConfirm = MyBtn.create(rootView, new ConstraintBuilder(80, 30).topToBottom(rechargeNumberView).topMargin(25).centerH(), com.daylong.reglinrary.R.drawable.img_btn_user_update, new MyBtn.OnImageClickListener() {
            @Override
            public void onClick(View view) {

                if (num > 0 && infoResponse != null) {
                    mPresenter.exchangeCoin(infoResponse.getNftCd(), num, infoResponse.getUsdtExc());
                }


            }
        });
        btnConfirm.setGravity(Gravity.CENTER);
        btnConfirm.initBtn("PAY", 10, R.color.color_white, true);
        btnConfirm.setShadowLayer(AppUtil.getSize(3), 0, AppUtil.getSize(1), getColor(R.color.color_fff6bfea));

    }

    private void initTitle(ViewGroup rootView) {


        titleBg = DefaultView.create(rootView, new ConstraintBuilder(0, 151).topCenterH());
        titleBg.setBackgroundColor(Color.parseColor("#ffcbb6fc"));


        DefaultView itemBg = DefaultView.create(rootView, new ConstraintBuilder(172, 94).topCenterH().topMargin(44));
        itemBg.setBackgroundResource(R.drawable.img_bg_nft_coin_);


        MyTextView tvFrom = MyTextView.create(rootView, new ConstraintBuilder().ww().leftTop(itemBg).leftTopMargin(8, 6));
        tvFrom.initText("Balance", 8, R.color.color_white, false);


        ivBalance = MyTextView.create(rootView, new ConstraintBuilder().ww().centerV(tvFrom).right(itemBg).rightMargin(10));
        ivBalance.initText(8, R.color.color_white, true);
        ivBalance.setCompoundDrawablePadding(AppUtil.getSize(2));
        DrawableUtils.setLeftDrawable(ivBalance, 10, R.drawable.img_usdt);


        nftSeekBar = new NftSeekBar(this, ivBalance);
        nftSeekBar.setOnEdittextNumListener(this);
        addView(nftSeekBar);

    }

    @NonNull
    @Override
    protected NftSalesCoinPresenter initPresenter() {
        return NftSalesCoinPresenter.newInstance();
    }


    private NftSalesCoinInfoResponse infoResponse;

    @Override
    public void onNftSalesCoinInfo(NftSalesCoinInfoResponse infoResponse) {
        this.infoResponse = infoResponse;
        ivBalance.setText(infoResponse.getUsdtBl() + "");
        tvNFTId.setText(infoResponse.getNftCd());
        tvPriceVal.setText(infoResponse.getUsdtToCoin());
        tvValMax.setNum(infoResponse.getMaxVl());
        nftSeekBar.setData(infoResponse);
    }

    @Override
    public void onExchangeCoin(NftExchangeResponse exchangeResponse) {

        ToastUtil.show("Successfully");

    }

    private long num;

    @Override
    public void onNum(int num, long coin) {
        this.num = num;
        rechargeNumberView.setVisibility(num > 0 ? View.VISIBLE : View.INVISIBLE);
        rechargeNumberView.setNum(coin);
    }
}
