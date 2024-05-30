package net.daylong.baselibrary.utils.img;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.XPopupImageLoader;
import com.lxj.xpopup.photoview.PhotoView;

import java.io.File;


public class ImageLoaderShowView implements XPopupImageLoader {



    @Override
    public void loadSnapshot(@NonNull Object uri, @NonNull PhotoView snapshot, @Nullable ImageView srcView) {

    }

    @Override
    public View loadImage(int position, @NonNull Object uri, @NonNull ImageViewerPopupView popupView, @NonNull PhotoView snapshot, @NonNull ProgressBar progressBar) {

        return null;

    }


    @Override
    public File getImageFile(@NonNull Context context, @NonNull Object uri) {
        return null;
    }


}
