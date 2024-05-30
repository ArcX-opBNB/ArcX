package com.daylong.gamelibrary.view.btn;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.daylong.gamelibrary.meuns.GameOperateType;
import com.daylong.gamelibrary.view.btn.service.IGameOperateView;

import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;
import net.daylong.baselibrary.view.img.MyImageView;
import net.daylong.baselibrary.view.textview.MyTextView;

public abstract class ICharterPushCoinBtn extends IGameOperateView {

    private MyTextView tvNun;

    @Override
    protected GameOperateType getGameOperateType() {
        return GameOperateType.PUSH_COIN;
    }

    private MyImageView myImageView;
    private LinearLayout layout;
    private MyTextView tvCharterName;


    public ICharterPushCoinBtn(@NonNull Context context, int btnReg, String charterTitle, int charterTitleColor, int shadowColor, int icon, int coinColor) {
        super(context);

        setVisibility(View.GONE);
        setLayoutParams(new ConstraintBuilder(84, 31).bottomCenterH().bottomMargin(AppUtil.isHorizontal() ? 25 : 50).horizontalChainStyle().buildPayoutParams());
        tvCharterName = MyTextView.create(this, new ConstraintBuilder()
                .ww().topCenterH().topMargin(3));
        tvCharterName.initText(charterTitle, 7, charterTitleColor, true);
        tvCharterName.setShadowLayer(3, 1, 0, getContext().getColor(shadowColor));
        tvCharterName.setId(View.generateViewId());


        layout = new LinearLayout(getContext());
        layout.setLayoutParams(new ConstraintBuilder().ww().centerH().top().topMargin(12).buildPayoutParams());
        layout.setOrientation(LinearLayout.HORIZONTAL);


        myImageView = MyImageView.create(layout, new ConstraintBuilder(11), icon);
        myImageView.setId(net.daylong.daylongbase.R.id.base_view_1);

        tvNun = MyTextView.create(layout, new ConstraintBuilder()
                .ww().leftMargin(2));
        tvNun.initText(8, coinColor, true);
        tvNun.setShadowLayer(3, 1, 0, getContext().getColor(shadowColor));
        tvNun.setId(View.generateViewId());
        Typeface monospace = Typeface.create("monospace", Typeface.NORMAL);
        tvNun.setTypeface(monospace);
        setBackgroundResource(btnReg);
        addView(layout);
    }


    public void setCoinNum(long num) {
        tvNun.setTextNumDot(num);
    }

    public void setCharterBalance(boolean isCharter, long num) {

        setCoinNum(num);
        setVisibility(isCharter ? View.VISIBLE : View.GONE);
    }

}
