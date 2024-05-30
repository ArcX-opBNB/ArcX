package com.daylong.gamelibrary.view.floa;

import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.utils.ui.layout.cl.BottomLayoutC;
import net.daylong.baselibrary.utils.ui.layout.cl.ConstraintLayoutUtils;
import net.daylong.baselibrary.utils.ui.layout.cl.RightLayoutC;
import net.daylong.baselibrary.view.DrawableUtils;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**

 */
public class FloatingGoldCoinsGroup implements FloatGameNumTextView.OnAnimEndListener {

    
    private LinkedBlockingQueue<FloatGameNumTextView> textViewBlockingQueue;
    private ViewGroup viewGroup;

    private Random random;
    private int coinIcon;
    private ComboNumberView comboNumberView;

    public FloatingGoldCoinsGroup(ViewGroup viewGroup, int coinIcon) {
        this.viewGroup = viewGroup;
        textViewBlockingQueue = new LinkedBlockingQueue<FloatGameNumTextView>();
        this.coinIcon = coinIcon;
        random = new Random();


        comboNumberView = ComboNumberView.create(viewGroup);
    }

    public void addNum(Long num) {
        if (num <= 0) {
            return;
        }

        comboNumberView.setNum(num);
        try {
            if (textViewBlockingQueue.size() > 0) {
                FloatGameNumTextView take = textViewBlockingQueue.take();
                if (take != null) {
                    take.setNum(num);
                }
            } else {
                FloatGameNumTextView textView = createTextView();

                textView.setNum(num);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public FloatGameNumTextView createTextView() {
        FloatGameNumTextView floatGameNumTextView = new FloatGameNumTextView(AppUtil.getContext(), coinIcon);
        floatGameNumTextView.setOnAnimEndListener(this);
        int i = random.nextInt(50) + 8;
        floatGameNumTextView.setLayoutParams(new ConstraintBuilder(14, 19).leftTop().topMarginNotFor(viewGroup.getHeight() - AppUtil.getSize(1)).leftMargin(i).buildPayoutParams());
        viewGroup.addView(floatGameNumTextView);
        return floatGameNumTextView;

    }

    @Override
    public void end(FloatGameNumTextView view) {
        textViewBlockingQueue.add(view);
    }
}
