package net.daylong.baselibrary.app;

import android.content.Context;
import android.os.Environment;

import androidx.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.AppGlideModule;


/**
 * @author

 * @Description
 * @Date 2020/1/3
 * @Version 1.0
 */
@GlideModule
public class GlideCache extends AppGlideModule {
    
    private int size = 1024 * 1024 * 100;

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        super.applyOptions(context, builder);
        
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            
            builder.setDiskCache(new DiskLruCacheFactory(Constant.iMAGE_CACHE_PATH, size));
        }
    }
}
