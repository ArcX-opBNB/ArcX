package com.daylong.arcx.view.user.wallet;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import com.daylong.httplibrary.bean.response.wallet.WalletConfigureResponse;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MyTextWatcher implements TextWatcher {
    final int MAX_DECIMAL_PLACES = 2;

    private WalletConfigureResponse configureInfo;
    private int id;
    private EditText editText;

    private double price;
    private String previousText;

    public MyTextWatcher(WalletConfigureResponse configureInfo, int id, EditText editText, double price) {
        this.configureInfo = configureInfo;
        this.id = id;
        this.editText = editText;
        this.price = price;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {
        previousText = s.toString();
    }

    @Override
    public void onTextChanged(CharSequence s, int i, int i1, int i2) {
        String text = s.toString();
        if (text.contains(".")) {
            int index = text.indexOf(".");
            if (index + 3 < text.length()) {
                text = text.substring(0, index + 3);
                editText.setText(text);
                editText.setSelection(editText.getText().length());
            }
        }

//        if (StringUtils.isNubAndDot(text)) {
//            int num = (int) (Double.parseDouble(text) * 100);
//            int minInput = configureInfo.getMaxInput(id,price);

//            if (num > minInput) {
//                editText.setText(String.valueOf((int) minInput));
//                editText.setSelection(editText.getText().length());
//
//            }
//
//
//        } else {

//
//
//        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
