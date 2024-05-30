package com.daylong.arcx.view.nft;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.daylong.arcx.R;
import com.daylong.httplibrary.bean.response.nft.NftSalesCoinInfoResponse;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class NftSeekBar extends ConstraintLayoutView implements SeekBar.OnSeekBarChangeListener, TextWatcher {
    private MyTextView tvMini, tvMax;
    private SeekBar seekBar;
    private EditText etCount;

    public NftSeekBar(@NonNull Context context, View view) {
        super(context);
        setLayoutParams(new ConstraintBuilder().mm().height(55).topToBottom(view).left().topMargin(14).buildPayoutParams());

        etCount = new EditText(getContext());
        etCount.setSingleLine();
        etCount.setId(View.generateViewId());
        etCount.setLayoutParams(new ConstraintBuilder(149, 28).top().centerH().buildPayoutParams());
        etCount.setBackgroundResource(com.daylong.reglinrary.R.drawable.bj_shape_r12_c_fff);
        etCount.setInputType(InputType.TYPE_CLASS_NUMBER);
        etCount.setPadding(AppUtil.getSize(6), 0, AppUtil.getSize(6), 0);
        etCount.setHintTextColor(Color.parseColor("#ffd9d9d9"));
        etCount.setHint("Pay USDT Amount");
        etCount.addTextChangedListener(this);
        addView(etCount);


        tvMini = MyTextView.create(this, new ConstraintBuilder().ww().leftBottom().leftMargin(17));
        tvMini.initText(6, net.daylong.daylongbase.R.color.color_ff666666, false);
        tvMax = MyTextView.create(this, new ConstraintBuilder().ww().rightBottom().rightMargin(17));
        tvMax.initText(6, net.daylong.daylongbase.R.color.color_ff666666, false);

        seekBar = new SeekBar(getContext());
        LayoutParams layoutParams = new ConstraintBuilder(136, 10).centerH().topToBottom(etCount).topMargin(5).buildPayoutParams();
        seekBar.setLayoutParams(layoutParams);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.seek_bar_bg));
        seekBar.setThumb(ContextCompat.getDrawable(getContext(), R.drawable.bg_bar_thumb));
        seekBar.setSplitTrack(false);
        addView(seekBar);

    }


    private NftSalesCoinInfoResponse infoResponse;


    private boolean isTouch;

    public void setData(NftSalesCoinInfoResponse infoResponse) {
        this.infoResponse = infoResponse;
        tvMini.setNum(0);
        tvMax.setNum(infoResponse.getUserBalanceInt());
        seekBar.setMax(infoResponse.getUserMax());


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        MyLogUtil.e("RAG--onProgressChanged>");

        if (!isTouch) {
            return;
        }
        if (progress <= 0) {
            etCount.setHint("Pay USDT Amount");
        } else {
            etCount.setText(String.valueOf(progress));
        }
        if (onEdittextNumListener != null) {
            onEdittextNumListener.onNum(progress,infoResponse.getEditCoin(progress));

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        MyLogUtil.e("RAG--onStartTrackingTouch>");
        isTouch = true;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        MyLogUtil.e("RAG--onStopTrackingTouch>");
        isTouch = false;
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        MyLogUtil.e("RAG--beforeTextChanged->" + charSequence.toString());
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        MyLogUtil.e("RAG--onTextChanged->" + charSequence.toString());

        if (isTouch) {
            return;
        }
        String trim = charSequence.toString().trim();
        if (TextUtils.isEmpty(trim)) {
            return;
        }


        int num = Integer.parseInt(trim);

        if (num <= 0) {

            etCount.setHint("Pay USDT Amount");

        } else {
            if (num > infoResponse.getUserMax()) {
                num = infoResponse.getUserMax();
                etCount.setText(infoResponse.getUserMax() + "");
            }
        }
        seekBar.setProgress(num);
        if (onEdittextNumListener != null) {
            onEdittextNumListener.onNum(num,infoResponse.getEditCoin(num));
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        MyLogUtil.e("RAG--afterTextChanged->" + editable.toString().trim());

    }

    private OnEdittextNumListener onEdittextNumListener;

    public void setOnEdittextNumListener(OnEdittextNumListener onEdittextNumListener) {
        this.onEdittextNumListener = onEdittextNumListener;
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }

    public interface OnEdittextNumListener {

        void onNum(int num, long coin);
    }

}
