package com.daylong.arcx.view.check;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.ToastUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.textview.MyTextView;

public class PrivacyCheckBox extends LinearLayout {
    private MyTextView tvStr;
    private  CheckBox checkBox;

    public PrivacyCheckBox(Context context) {
        super(context);
        setId(View.generateViewId());
        setGravity(Gravity.CENTER_VERTICAL);
        setOrientation(HORIZONTAL);
        checkBox = new CheckBox(getContext());
        checkBox.setLayoutParams(new ConstraintBuilder().ww().buildPayoutParams());
        checkBox.setButtonDrawable(getContext().getDrawable(R.drawable.select_privacy));
        addView(checkBox);

        tvStr = MyTextView.create(this, new ConstraintBuilder().ww());
        tvStr.initText(6, R.color.color_78351c, false);
        tvStr.setText(setCheckText());
        tvStr.setMovementMethod(LinkMovementMethod.getInstance());
        tvStr.setHighlightColor(Color.TRANSPARENT);
    }

    public SpannableStringBuilder setCheckText() {

        
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        setText(spannableStringBuilder, " I agree to", "#BCACF5", new ClickableSpan() {
            @Override
            public void onClick(View view) {

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setUnderlineText(false);
            }
        });

        setText(spannableStringBuilder, "ArcX Terms of use", "#FF9A9A", new ClickableSpan() {
            @Override
            public void onClick(View view) {



            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setUnderlineText(false);
            }
        });
        //
        setText(spannableStringBuilder, "and", "#BCACF5", null);

        setText(spannableStringBuilder, "Privacy Palicy", "#FF9A9A", new ClickableSpan() {
            @Override
            public void onClick(View view) {



            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setUnderlineText(false);
            }
        });


        return spannableStringBuilder;
    }

    /**

     *
     * @param spannableStringBuilder


     */
    public void setText(SpannableStringBuilder spannableStringBuilder, String msg, String color, ClickableSpan clickableSpan) {

        int start = spannableStringBuilder.length();
        spannableStringBuilder.append(msg);
        int end = spannableStringBuilder.length();
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor(color));
        float textSize = tvStr.getTextSize();

        AbsoluteSizeSpan abs = new AbsoluteSizeSpan((int) textSize);
        spannableStringBuilder.setSpan(abs, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(foregroundColorSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        if (clickableSpan != null) {
            spannableStringBuilder.setSpan(clickableSpan, start, spannableStringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        }
    }

    public  boolean isCheck(){
        return checkBox.isChecked();
    }
}
