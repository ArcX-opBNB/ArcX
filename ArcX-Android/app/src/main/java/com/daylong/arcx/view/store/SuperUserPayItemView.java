package com.daylong.arcx.view.store;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;

import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;

import net.daylong.baselibrary.utils.ui.layout.LinearLayoutBuilder;
import net.daylong.baselibrary.view.img.MyImageView;

public class SuperUserPayItemView extends MyImageView {
    public SuperUserPayItemView(@NonNull Context context) {
        super(context);
        setLayoutParams(new LinearLayoutBuilder(172, 59).bottomMargin(8).buildPayoutParams());
        setVisibility(View.GONE);
        setScaleType(ScaleType.CENTER_CROP);
    }

    private StoreInfoResponse.SpPlyIfoDTO spPlyIfoDTO;

    public StoreInfoResponse.SpPlyIfoDTO getSpPlyIfoDTO() {
        return spPlyIfoDTO;
    }

    public void setData(StoreInfoResponse.SpPlyIfoDTO spPlyIfoDTO) {
        this.spPlyIfoDTO = spPlyIfoDTO;
        if (spPlyIfoDTO != null) {
            setData(spPlyIfoDTO.getPct());
        }
        setVisibility(spPlyIfoDTO == null ? View.GONE : View.VISIBLE);

    }

    public void setData(String msg) {
        boolean empty = TextUtils.isEmpty(msg);
        setVisibility(empty ? View.GONE : View.VISIBLE);

        if (!empty) {
            setImageUrl(msg);
        }

    }


}
