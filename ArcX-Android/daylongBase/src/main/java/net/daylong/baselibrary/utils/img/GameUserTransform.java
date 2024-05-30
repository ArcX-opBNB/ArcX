package net.daylong.baselibrary.utils.img;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class GameUserTransform extends BitmapTransformation {
    private static final String ID = "net.daylong.baselibrary.utils.img.GameUserTransform";
    private static final byte[] ID_BYTES = ID.getBytes(StandardCharsets.UTF_8);
    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {

        return Bitmap.createBitmap(toTransform, 0, 0, outWidth, outHeight);
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof GameUserTransform;
    }
    @Override
    public int hashCode() {
        return ID.hashCode();
    }

}
