package net.daylong.baselibrary.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import net.daylong.baselibrary.utils.img.ImageLoading;
import net.daylong.baselibrary.utils.sys.AppUtil;

public abstract   class BaseImageView extends ImageView {


    public BaseImageView(@NonNull Context context) {
        super(context);
        setBackgroundColor(Color.TRANSPARENT);
    }

    public void setImageReg(int regId) {
        ImageLoading.displayNoCrop(regId, this);
    }

    public void setImageRegCrop(int regId) {
        ImageLoading.display(regId, this);
    }

    public void setImage(Object path) {
        if (path instanceof String) {
            ImageLoading.displayPhoneImage((String) path, this);

        } else {
            ImageLoading.displayPhoneImageUrl(this, (Uri) path);

        }

    }


    public void setGameUserImg(String path) {
        ImageLoading.display(getContext(), path, this);
    }

    public void setImageUrl(String path) {
        setBackgroundColor(Color.TRANSPARENT);
        ImageLoading.displayNoCrop(path, this);
    }

    public void setImageUrlNot(String path) {
        ImageLoading.displayNoCrop(path, this);
    }

    public void setImageUrlBg(String path) {
        ImageLoading.displayNoCrop(path, this);
    }

    public void setImageUrlRound(String url) {
        ImageLoading.displayRoundImage(url, this);
    }

    public void setImageUrlRound(String url, int roundSize) {
        ImageLoading.displayRoundedCorners(url, this, AppUtil.getSize(roundSize));
    }
}
