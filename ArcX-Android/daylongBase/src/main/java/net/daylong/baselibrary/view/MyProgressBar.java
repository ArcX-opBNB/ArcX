package net.daylong.baselibrary.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutView;
import net.daylong.baselibrary.view.textview.BaseTextView;
import net.daylong.baselibrary.view.textview.MyTextView;

public class MyProgressBar extends ConstraintLayoutView {
    private static final int MAX_PROGRESS = 100;
    private ProgressBar progressBar;
    private MyTextView baseTextView;


    public static MyProgressBar create(ViewGroup viewGroup, ConstraintBuilder constraintBuilder, Integer progressDrawable, boolean isShowTextViewProgress, Float textSize, Integer textColorId) {
        MyProgressBar iProgressBar = new MyProgressBar(viewGroup.getContext(), progressDrawable, isShowTextViewProgress, textSize, textColorId);
        iProgressBar.setLayoutParams(constraintBuilder.buildPayoutParams());
        viewGroup.addView(iProgressBar);
        return iProgressBar;
    }

    public static MyProgressBar create(ViewGroup viewGroup, ConstraintBuilder constraintBuilder, Integer progressDrawable) {
        return create(viewGroup, constraintBuilder, progressDrawable, false, null, null);
    }

    public MyProgressBar(@NonNull Context context, Integer progressDrawable, boolean isShowTextViewProgress, Float textSize, Integer textColorId) {
        super(context);


        progressBar = new ProgressBar(getContext(), null, android.R.attr.progressBarStyleHorizontal);
        LayoutParams layoutParams = new ConstraintBuilder().mm().leftTop().buildPayoutParams();
        progressBar.setLayoutParams(layoutParams);
        progressBar.setId(View.generateViewId());

        progressBar.setMax(MAX_PROGRESS);
        addView(progressBar);

        if (isShowTextViewProgress) {
            createTextProgress(textSize, textColorId);
        }
        setId(View.generateViewId());
        if (progressDrawable != null) {
            setProgressRegId(progressDrawable);
        }
    }

    public void setProgressRegId(Integer progressDrawable) {
        if (progressDrawable != null) {
            progressBar.setProgressDrawable(ContextCompat.getDrawable(getContext(), progressDrawable));
        }
    }

    public void setMaxProgress(int maxProgress) {
        progressBar.setMax(maxProgress);
    }

    private void createTextProgress(Float textSize, Integer textColorId) {
        baseTextView = MyTextView.create(this, new ConstraintBuilder().ww().center());
        baseTextView.setTextSize(textSize);
        baseTextView.setGravity(Gravity.CENTER);
        baseTextView.setTextColor(getContext().getColor(textColorId));
    }

    public MyTextView getPDText() {
        return baseTextView;
    }


    public void setProgress(int progress) {
        if (baseTextView != null) {
            baseTextView.setText(String.valueOf(progress));
        }
        progressBar.setProgress(progress);
    }

    public void setProgress(int progress, String str) {
        if (baseTextView != null) {
            baseTextView.setText(str);
        }
        progressBar.setProgress(progress);
    }

}
