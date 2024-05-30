package com.daylong.arcx.view.game.btn;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.view.btn.service.IGameOperateView;
import com.daylong.arcx.R;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;
public class PushCoinBtn extends IGameOperateView {

    private MyTextView tvNun;

    @Override
    protected GameOperateType getGameOperateType() {
        return GameOperateType.PUSH_COIN;
    }

    private MyImageView myImageView;
    private LinearLayout layout;
    private MyTextView tvCharterName;

    private int gameCoin;

    public PushCoinBtn(@NonNull Context context, int gameCoin) {
        super(context);
        this.gameCoin = gameCoin;


        setLayoutParams(new ConstraintBuilder(84, 31).bottomCenterH().bottomMargin(49).horizontalChainStyle().buildPayoutParams());


        layout = new LinearLayout(getContext());
        layout.setLayoutParams(new ConstraintBuilder().ww().centerH().top().topMargin(6).buildPayoutParams());
        layout.setOrientation(LinearLayout.HORIZONTAL);


        myImageView = MyImageView.create(layout, new ConstraintBuilder(13), R.drawable.img_coin);
        myImageView.setId(net.daylong.daylongbase.R.id.base_view_1);

        tvNun = MyTextView.create(layout, new ConstraintBuilder()
                .ww().leftMargin(2));
        tvNun.initText(9, R.color.color_white, true);
        tvNun.setShadowLayer(3, 1, 0, getContext().getColor(R.color.color_c2001da7));
        tvNun.setId(View.generateViewId());
        Typeface monospace = Typeface.create("monospace", Typeface.NORMAL);
        tvNun.setTypeface(monospace);
        setBackgroundResource(R.drawable.img_mch_alert_btn);
        setCoinNum(gameCoin);
        addView(layout);
    }


    public void setCoinNum(int num) {
        tvNun.setTextNumDot(num);
    }

    public void setCoinNum(long num) {
        tvNun.setTextNumDot(num);
    }


    public void setCharterBalance(boolean isCharter, long num) {
        setStatus(isCharter);
        setCoinNum(isCharter ? num : gameCoin);
    }

    public void setStatus(boolean isCharter) {
        ConstraintLayout.LayoutParams layoutParams = (LayoutParams) layout.getLayoutParams();
        layoutParams.topMargin = AppUtil.getSize(isCharter ? 12 : 6);

        layout.requestLayout();

        ViewGroup.LayoutParams layoutParams1 = myImageView.getLayoutParams();
        layoutParams1.width = AppUtil.getSize(11);
        layoutParams1.height = AppUtil.getSize(11);
        myImageView.requestLayout();
        tvNun.setTextSize(8);

        if (isCharter) {
            tvCharterName = MyTextView.create(this, new ConstraintBuilder()
                    .ww().topCenterH().topMargin(3));

            tvCharterName.setShadowLayer(3, 1, 0, getContext().getColor(R.color.color_c2001da7));
            tvCharterName.setId(View.generateViewId());
        } else {
            if (tvCharterName != null) {
                tvCharterName.setVisibility(View.GONE);
            }
        }
    }

}
