package net.daylong.baselibrary.utils;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

public class TextHtmlUtils {


    public static void setTextColor(SpannableStringBuilder spannableStringBuilder, int start, int end, String color) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor(color));
        spannableStringBuilder.setSpan(foregroundColorSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
}
