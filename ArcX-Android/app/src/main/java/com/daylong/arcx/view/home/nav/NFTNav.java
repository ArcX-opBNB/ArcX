package com.daylong.arcx.view.home.nav;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.arcx.R;
import com.daylong.arcx.home.HomeActivity;
import com.daylong.arcx.nft.NftHomeActivity;
import com.daylong.arcx.nft.NftSalesCoinActivity;

import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

public class NFTNav extends BaseHomeNav {



    public NFTNav(@NonNull Context context, View toView) {
        super(context, toView);
    }

    @Override
    protected Integer getBgRegId() {
        return R.drawable.img_home_nav_nft;
    }

    @Override
    protected String getSignSvga() {
        return "nft_sign.svga";
    }



    @Override
    protected ConstraintBuilder getSignConstraintBuilder() {
        return new ConstraintBuilder(42, 36).topRight().topRightMargin(37, 14);
    }

    @Override
    protected ConstraintBuilder getViewConstraintBuilder() {
        return new ConstraintBuilder(108, 117).leftTop().leftTopMargin(5, 43);
    }

    @Override
    protected void click() {
        NftHomeActivity.start(getContext());
    }
}
