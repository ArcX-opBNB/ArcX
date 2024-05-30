package net.daylong.baselibrary.utils.img;


import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import net.daylong.daylongbase.R;

import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.app.Constant;
import net.daylong.baselibrary.transformation.CircleCropTransform;
import net.daylong.baselibrary.utils.sys.AppUtil;
import net.daylong.baselibrary.utils.sys.SystemUtil;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * 2018/8/3

 */
public class ImageLoading {
    /**

     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void displayRoundImage(Context context, String url, ImageView imageView) {

        if (imageView == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {

            RequestOptions mRequestOptions = RequestOptions.circleCropTransform().diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .load(getImagePath(url))
                    .apply(mRequestOptions)
                    .into(imageView);
        }
    }

    /**

     *
     * @param url
     * @param imageView
     */
    public static void displayRoundCircleCropImage( String url, ImageView imageView) {

        if (imageView == null) {
            return;
        }
        if (TextUtils.isEmpty(url)) {
            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {
            CircleCropTransform circleCropTransform = new CircleCropTransform(1, Color.WHITE);

            RequestOptions mRequestOptions = RequestOptions.bitmapTransform(circleCropTransform).diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .load(getImagePath(url))
                    .apply(mRequestOptions)
                    .into(imageView);
        }
    }

    /**

     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void displayRoundImage(Context context, String url, ImageView imageView, int nullRes) {
        if (TextUtils.isEmpty(url)) {
            displayRoundImage(getContextx(), nullRes, imageView);
        } else {

            RequestOptions mRequestOptions = RequestOptions.circleCropTransform().diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .load(getImagePath(url))
                    .apply(mRequestOptions)
                    .into(imageView);
        }
    }

    /**

     *
     * @param url
     * @param imageView
     */
    public static void displayRound(String url, ImageView imageView, int radius) {
        if (TextUtils.isEmpty(url)) {
            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {
            MultiTransformation mation5 = new MultiTransformation(
                    new RoundedCornersTransformation(SystemUtil.dp2pxInt(radius), 0, RoundedCornersTransformation.CornerType.ALL));
            RequestOptions mRequestOptions = RequestOptions.bitmapTransform(mation5).diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .load(getImagePath(url))
                    .apply(mRequestOptions)
                    .into(imageView);
        }
    }

    /**

     *

     * @param imageView
     */
    public static void displayRoundImage(int reg, ImageView imageView) {
        RequestOptions mRequestOptions = RequestOptions.circleCropTransform().diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(getContextx())
                .load(reg)
                .apply(mRequestOptions)
                .into(imageView);

    }

    /**

     *

     * @param imageView
     */
    public static void displayRoundImage(String reg, ImageView imageView, int rounded) {


        RequestOptions mRequestOptions = new RequestOptions().transform(new CenterCrop(), new RoundedCornersTransformation(rounded, 0, RoundedCornersTransformation.CornerType.ALL)).diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(getContextx())
                .load(reg)
                .apply(mRequestOptions)
                .into(imageView);

    }

    /**
     * 0

     *
     * @param url
     * @param imageView
     */
    public static void displayRoundImage(String url, ImageView imageView) {
        displayRoundImage(BaseApplication.getInstance().getContext(), url + Constant.IMG_THUMBNAIL_USER_ICON, imageView);
    }

    /**
     * 0

     *
     * @param url
     * @param imageView
     */
    public static void displayRoundImageAndNullCoin(String url, ImageView imageView, int nullRes) {
        displayRoundImage(BaseApplication.getInstance().getContext(), url + Constant.IMG_THUMBNAIL_USER_ICON, imageView, nullRes);
    }


    /**

     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void displayPhoneRoundImage(Context context, String url, ImageView imageView) {
        if (TextUtils.isEmpty(url)) {
            displayRoundImage(context, R.drawable.ic_placeholder, imageView);
        } else {
            RequestOptions mRequestOptions = RequestOptions.circleCropTransform().diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())

                    .load(url)

                    .apply(mRequestOptions)
                    .transition(withCrossFade())

                    .into(imageView);
        }

    }

    /**

     *
     * @param imagePath
     * @param imageView
     */
    public static void displayRoundedCorners2(String imagePath, ImageView imageView, int rounded) {

        if (TextUtils.isEmpty(imagePath)) {
            displayRoundImage(BaseApplication.getInstance().getContext(), R.drawable.ic_placeholder, imageView);
        } else {
            String url = getImagePath(imagePath);

            Glide.with(BaseApplication.getInstance().getContext()).load(url)
                    .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(rounded, 0, RoundedCornersTransformation.CornerType.BOTTOM_RIGHT)))
                    .transition(withCrossFade())

                    .into(imageView);

        }
    }

    /**

     *
     * @param url
     * @param imageView
     */
    public static void displayPhoneImage(String url, ImageView imageView) {
        if (TextUtils.isEmpty(url)) {
            displayRoundImage(AppUtil.getContext(), R.drawable.ic_placeholder, imageView);
        } else {
            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);

            Glide.with(getContextx())
                    .load(url)
                    .transition(withCrossFade())

                    .apply(options)
                    .into(imageView);
        }

    }

    /**

     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void displayRoundImage(Context context, int url, ImageView imageView) {

        RequestOptions mRequestOptions = RequestOptions.circleCropTransform().diskCacheStrategy(DiskCacheStrategy.ALL);
//
        Glide.with(getContextx())
                .load(url)
                .apply(mRequestOptions)
                .transition(withCrossFade())

                .into(imageView);
    }

    /**

     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void displayRoundR8Image(Context context, int url, ImageView imageView) {

        RequestOptions mRequestOptions = RequestOptions.circleCropTransform().diskCacheStrategy(DiskCacheStrategy.ALL);
//
        Glide.with(getContextx())
                .load(url)
                .apply(mRequestOptions)
                .transition(withCrossFade())

                .into(imageView);
    }


    public static void displayRoundTOP(String imagePath, ImageView imageView) {
        displayRoundedCorners(imagePath, imageView, 15);

    }


    @SuppressLint("CheckResult")
    public static void displayBlurTrans(Context context, String url, ImageView imageView) {
        if (TextUtils.isEmpty(url)) {
            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {
            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
            String imagePath = getImagePath(url);
            options.transform(new BlurTransformation(23, 4));
            Glide.with(getContextx())
                    .load(imagePath)
                    .transition(withCrossFade())

                    .apply(options)
                    .into(imageView);
        }

    }

    /**

     *
     * @param context
     * @param imagePath
     * @param imageView
     */
    public static void display(Context context, String imagePath, ImageView imageView) {
        if (TextUtils.isEmpty(imagePath)) {

            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {
            String url = getImagePath(imagePath);
            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .asBitmap().centerCrop()
                    .load(url)
                    .apply(options)
                    .into(imageView);
        }
    }


    public static RoundedCornersTransformation.CornerType getR(int count, int index) {


        if (count == 1) {
            return RoundedCornersTransformation.CornerType.ALL;
        } else if (count == 2) {
            if (index == 0) {
                return RoundedCornersTransformation.CornerType.LEFT;
            } else {
                return RoundedCornersTransformation.CornerType.RIGHT;
            }
        } else if (count == 3) {
            if (index == 0) {
                return RoundedCornersTransformation.CornerType.LEFT;
            } else if (index == 2) {
                return RoundedCornersTransformation.CornerType.RIGHT;

            } else {
                return null;
            }

        } else if (count == 4) {
            if (index == 0) {
                return RoundedCornersTransformation.CornerType.TOP_LEFT;
            } else if (index == 1) {
                return RoundedCornersTransformation.CornerType.TOP_RIGHT;

            } else if (index == 2) {
                return RoundedCornersTransformation.CornerType.BOTTOM_LEFT;

            } else if (index == 3) {
                return RoundedCornersTransformation.CornerType.BOTTOM_RIGHT;

            }

        } else if (count == 5) {
            if (index == 0) {
                return RoundedCornersTransformation.CornerType.LEFT;
            } else if (index == 1) {
                return null;
            } else if (index == 2) {
                return RoundedCornersTransformation.CornerType.RIGHT;

            } else if (index == 3) {
                return RoundedCornersTransformation.CornerType.LEFT;

            } else if (index == 4) {
                return RoundedCornersTransformation.CornerType.RIGHT;

            }
        } else if (count == 6) {
            if (index == 0) {
                return RoundedCornersTransformation.CornerType.TOP_LEFT;
            } else if (index == 1) {
                return null;
            } else if (index == 2) {
                return RoundedCornersTransformation.CornerType.TOP_RIGHT;

            } else if (index == 3) {
                return RoundedCornersTransformation.CornerType.BOTTOM_LEFT;

            } else if (index == 4) {
                return null;
            } else if (index == 5) {
                return RoundedCornersTransformation.CornerType.BOTTOM_RIGHT;

            }
        } else if (count == 7) {
            if (index == 0) {
                return RoundedCornersTransformation.CornerType.TOP_LEFT;
            } else if (index == 1) {
                return null;
            } else if (index == 2) {
                return RoundedCornersTransformation.CornerType.TOP_RIGHT;

            } else if (index == 3) {
                return RoundedCornersTransformation.CornerType.BOTTOM_LEFT;

            } else if (index == 4) {
                return null;
            } else if (index == 5) {
                return RoundedCornersTransformation.CornerType.BOTTOM_RIGHT;

            } else if (index == 6) {
                return RoundedCornersTransformation.CornerType.ALL;

            }
        } else if (count == 8) {
            if (index == 0) {
                return RoundedCornersTransformation.CornerType.LEFT;
            } else if (index == 1) {
                return null;
            } else if (index == 2) {
                return RoundedCornersTransformation.CornerType.RIGHT;

            } else if (index == 3) {
                return RoundedCornersTransformation.CornerType.LEFT;

            } else if (index == 4) {
                return null;
            } else if (index == 5) {
                return RoundedCornersTransformation.CornerType.RIGHT;

            } else if (index == 6) {
                return RoundedCornersTransformation.CornerType.LEFT;
            } else if (index == 7) {
                return RoundedCornersTransformation.CornerType.RIGHT;

            }
        } else if (count == 9) {
            if (index == 0) {
                return RoundedCornersTransformation.CornerType.TOP_LEFT;
            } else if (index == 1) {
                return null;
            } else if (index == 2) {
                return RoundedCornersTransformation.CornerType.TOP_RIGHT;

            } else if (index == 3) {
                return null;

            } else if (index == 4) {
                return null;
            } else if (index == 5) {
                return null;

            } else if (index == 6) {
                return RoundedCornersTransformation.CornerType.BOTTOM_LEFT;
            } else if (index == 7) {
                return null;

            } else if (index == 8) {
                return RoundedCornersTransformation.CornerType.BOTTOM_RIGHT;

            }
        }
        return null;

    }

    public static void displayR(String imagePath, ImageView imageView, int count, int index) {

        if (TextUtils.isEmpty(imagePath)) {

            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {
            String url = getImagePath(imagePath);


            RoundedCornersTransformation.CornerType r = getR(count, index);

            RequestOptions options;
            if (r != null) {
                options = new RequestOptions().transform(new CenterCrop(), new RoundedCornersTransformation(SystemUtil.dp2pxInt(8), 0, r), new RoundedCornersTransformation(SystemUtil.dp2pxInt(4), 0, RoundedCornersTransformation.CornerType.ALL)).diskCacheStrategy(DiskCacheStrategy.ALL);

            } else {
                options = new RequestOptions().transform(new CenterCrop(), new RoundedCornersTransformation(SystemUtil.dp2pxInt(4), 0, RoundedCornersTransformation.CornerType.ALL)).diskCacheStrategy(DiskCacheStrategy.ALL);

            }


            Glide.with(getContextx())
                    .asBitmap().centerCrop()

                    .load(url)
                    .apply(options)
                    .into(imageView);
        }
    }

    public static void displayFillet(String imagePath, ImageView imageView, int radius) {

        if (TextUtils.isEmpty(imagePath)) {

            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {
            String url = getImagePath(imagePath);
            RequestOptions options = new RequestOptions().transform(new CenterCrop(), new RoundedCornersTransformation(SystemUtil.dp2pxInt(radius), 0, RoundedCornersTransformation.CornerType.ALL)).diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .asBitmap().centerCrop()
                    .load(url)
                    .apply(options)
                    .into(imageView);
        }
    }

    /**

     *
     * @param imagePath
     * @param imageView
     */
    public static void displayNoCrop(String imagePath, ImageView imageView) {
        if (TextUtils.isEmpty(imagePath)) {

            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {

            boolean gif = isGif(imagePath);

            if (gif) {
                displayGif(imagePath, imageView);
            } else {
                String url = getImagePath(imagePath);
                RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
                Glide.with(getContextx())
                        .load(url)
                        .apply(options)
                        .into(imageView);
            }
        }
    }

    /**

     *
     * @param imagePath
     * @param imageView
     */
    public static void displayBehaviorThumbnail(String imagePath, ImageView imageView, int count) {
        if (TextUtils.isEmpty(imagePath)) {

            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {


            String url = getImagePath(imagePath);
            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .load(getBehaviorImagePath(getImagePath(imagePath), count))
                    .apply(options)
                    .into(imageView);
        }
    }


    /**

     *
     * @param imagePath
     * @param imageView
     */
    public static void displayBehavior(String imagePath, ImageView imageView) {
        if (TextUtils.isEmpty(imagePath)) {

            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {
            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .load(getBehaviorImagePath(getImagePath(imagePath)))
                    .thumbnail(0.1f)
                    .apply(options)
                    .into(imageView);
        }
    }

    /**

     *
     * @param
     * @param imageView
     */
    public static void displayNoCrop(int red, ImageView imageView) {

        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(getContextx())
                .load(red)
                .apply(options)
                .into(imageView);
    }

    /**

     *
     * @param imagePath
     * @param imageView
     */
    public static void displayNoCropNoPlaceholder(String imagePath, ImageView imageView) {
        if (TextUtils.isEmpty(imagePath)) {

            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {
            String url = getImagePath(imagePath);
            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .load(url)
                    .apply(options)
                    .into(imageView);
        }
    }


    public static void display(String imagePath, ImageView imageView) {
        display(BaseApplication.getInstance().getContext(), imagePath, imageView);
    }

    public static void displaySd(String imagePath, ImageView imageView) {
        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(getContextx())
                .load(imagePath)
                .transition(withCrossFade())

                .apply(options)
                .into(imageView);
    }

    /**

     *
     * @param context
     * @param resId
     * @param imageView
     */
    public static void display(Context context, int resId, ImageView imageView) {


        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(getContextx())

                .load(resId)
                .transition(withCrossFade())
                .apply(options)
                .into(imageView);

    }

    /**

     *
     * @param resId
     * @param imageView
     */
    public static void display(int resId, ImageView imageView) {


        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(BaseApplication.getInstance().getContext())
                .asBitmap().centerCrop()
                .load(resId)
                .apply(options)
                .into(imageView);

    }

    /**

     *
     * @param imageView
     */
    public static void displayBlackWhite(String url, ImageView imageView) {


        if (TextUtils.isEmpty(url)) {
            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {

            RequestOptions mRequestOptions = new RequestOptions().transform(new CircleCrop(), new GrayscaleTransformation()).diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .load(getImagePath(url))
                    .apply(mRequestOptions)
                    .into(imageView);
        }

    }

    public static void displayBlackWhite(int ImageUrl, ImageView imageView) {


        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).transform(new GrayscaleTransformation());
        RequestOptions.bitmapTransform(new GrayscaleTransformation());
        Glide.with(BaseApplication.getInstance().getContext())
                .asBitmap().centerCrop()
                .load(ImageUrl)
                .apply(options)
                .into(imageView);

    }


    public static void displayGif(Context context, String imagePath, ImageView imageView) {
        RequestBuilder<GifDrawable> request = Glide.with(getContextx()).asGif()
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model,
                                                   Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        resource.startFromFirstFrame();
                        resource.setLoopCount(1);
                        resource.stop();
                        return false;
                    }
                });
        request.load(imagePath)
                .transition(withCrossFade())

                .into(imageView);

    }

    public static void displayGif(int imagePath, ImageView imageView) {
        RequestBuilder<GifDrawable> request = Glide.with(getContextx()).asGif();
        request.load(imagePath)
                .into(imageView);

    }

    public static void displayGif(String imagePath, ImageView imageView) {
        RequestBuilder<GifDrawable> request = Glide.with(getContextx()).asGif();

        request.load(imagePath)
                .into(imageView);

    }

    public static void displayGif2(String imagePath, ImageView imageView) {
        RequestBuilder<GifDrawable> request = Glide.with(getContextx()).asGif()
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model,
                                                   Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        resource.startFromFirstFrame();
                        resource.setLoopCount(1);
                        resource.stop();
                        return false;
                    }
                });
        request.load(imagePath)
                .transition(withCrossFade())
                .into(imageView);

    }


    public static void displayGif2(int imagePath, ImageView imageView) {
        RequestBuilder<GifDrawable> request = Glide.with(getContextx()).asGif()
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model,
                                                   Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        try {
                            int duration = 0;
                            if (resource != null) {
                                
                                Drawable.ConstantState state = resource.getConstantState();
                                resource.startFromFirstFrame();
                                resource.setLoopCount(1);
                                resource.stop();

                                if (state != null) {
                                    
                                    Object gifFrameLoader = null;

                                    gifFrameLoader = GlideGifUtil.getValue(state, "frameLoader");

                                    if (gifFrameLoader != null) {
                                        Object decoder = GlideGifUtil.getValue(gifFrameLoader, "gifDecoder");
                                        if (decoder instanceof GifDecoder) {
                                            for (int i = 0; i < resource.getFrameCount(); i++) {
                                                duration += ((GifDecoder) decoder).getDelay(i);
                                            }
                                        }
                                    }
                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                });
        request.load(imagePath)
                .transition(withCrossFade())
                .into(imageView);

    }

    public static void displayGif2(int imagePath, ImageView imageView, OnGiftListener onGiftListener) {
        RequestBuilder<GifDrawable> request = Glide.with(getContextx()).asGif()
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model,
                                                   Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        try {
                            int duration = 0;
                            if (resource != null) {
                                
                                Drawable.ConstantState state = resource.getConstantState();
                                resource.startFromFirstFrame();
                                resource.setLoopCount(1);
                                resource.stop();

                                if (state != null) {
                                    
                                    Object gifFrameLoader = null;

                                    gifFrameLoader = GlideGifUtil.getValue(state, "frameLoader");

                                    if (gifFrameLoader != null) {
                                        Object decoder = GlideGifUtil.getValue(gifFrameLoader, "gifDecoder");
                                        if (decoder instanceof GifDecoder) {
                                            for (int i = 0; i < resource.getFrameCount(); i++) {
                                                duration += ((GifDecoder) decoder).getDelay(i);
                                            }
                                        }
                                    }
                                }

                                onGiftListener.stop(duration);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                });
        request.load(imagePath)
                .transition(withCrossFade())
                .into(imageView);

    }

    public static void displayGifOne(int imagePath, ImageView imageView) {
        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);

        RequestBuilder<GifDrawable> request = Glide.with(getContextx()).asGif()
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model,
                                                   Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {

                        resource.startFromFirstFrame();
                        resource.setLoopCount(1);
                        resource.stop();


                        return false;
                    }
                });

        request.load(imagePath)
                .apply(options)
                .transition(withCrossFade())
                .into(imageView);

    }


    /**

     *
     * @param imagePath
     * @param imageView
     */
    public static void displayRoundedCorners(String imagePath, ImageView imageView, int rounded) {

        if (TextUtils.isEmpty(imagePath)) {
            displayRoundImage(BaseApplication.getInstance().getContext(), R.drawable.ic_placeholder, imageView);
        } else {
            String url = getImagePath(imagePath);
            Glide.with(BaseApplication.getInstance().getContext()).load(url)
                    .transition(withCrossFade())
                    .apply(RequestOptions.bitmapTransform(new GlideRoundTransform(BaseApplication.getInstance().getContext(), rounded)))
                    .into(imageView);
        }
    }

    /**

     *
     * @param url
     * @param imageView
     */
    public static void displayBlurTrans(String url, ImageView imageView) {
        if (TextUtils.isEmpty(url)) {
            displayRoundImage(BaseApplication.getInstance().getContext(), R.drawable.ic_placeholder, imageView);
        } else {
            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
            String imagePath = getImagePath(url);
            options.transform(new BlurTransformation(23, 4));
            Glide.with(BaseApplication.getInstance().getContext())

                    .load(imagePath)
                    .transition(withCrossFade())

                    .apply(options)
                    .into(imageView);
        }

    }

    /**

     *
     * @param url
     * @param imageView
     */
    public static void displayBlurTrans(String url, ImageView imageView, int radius, int sampling) {
        if (TextUtils.isEmpty(url)) {
            displayRoundImage(BaseApplication.getInstance().getContext(), R.drawable.ic_placeholder, imageView);
        } else {
            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
            String imagePath = getImagePath(url);
            options.transform(new BlurTransformation(radius, sampling));
            Glide.with(BaseApplication.getInstance().getContext())

                    .load(imagePath)
                    .transition(withCrossFade())

                    .apply(options)
                    .into(imageView);
        }

    }

    /**

     *
     * @param imageView
     */
    public static void displayBlurTrans(int img, ImageView imageView) {

        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);

        options.transform(new BlurTransformation(24, 10));
        Glide.with(BaseApplication.getInstance().getContext())
                .load(img)
                .apply(options)
                .transition(withCrossFade())
                .into(imageView);
    }


    public static String getImagePath(String path) {

        boolean http = path.startsWith("http");

        if (http) {
            return path;
        } else {

            path = "https://media.Wonder.net.cn" + path;
            return path;
        }
    }


    public static Context getContextx() {
        return BaseApplication.getInstance().getContext();
    }

    public static void displayNoble(String imagePath, ImageView imageView) {

        if (TextUtils.isEmpty(imagePath)) {

            displayRoundImage(getContextx(), R.drawable.ic_placeholder, imageView);
        } else {
            String url = getImagePath(imagePath);
            RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(getContextx())
                    .load(url)
                    .apply(options)
                    .into(imageView);
        }

    }

    /**

     *
     * @param url
     * @param imageView
     */
    public static void displayPhoneImageUrl(ImageView imageView, Uri url) {

        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(getContextx())
                .load(url)
                .transition(withCrossFade())
                .apply(options)
                .into(imageView);

    }

    public static String getNationImg(String nation) {
        if (TextUtils.isEmpty(nation)) {
            return nation;
        }
        return "https://media.daylong.net.cn/Flags/" + nation + ".png" + Constant.IMG_THUMBNAIL_FLAG_ICON;
    }


    public interface OnGiftListener {
        void stop(int time);
    }


    public static String getBehaviorImagePath(String url) {
        return url + Constant.IMG_THUMBNAIL_HEIGHT + SystemUtil.getWinWidth();
    }

    public static String getBehaviorImagePath(String url, int size) {
        return url + Constant.IMG_THUMBNAIL_HEIGHT + size;
    }

    /**

     *
     * @param url

     * @return
     */
    public static String getBehaviorThumbnail(String url, int imgCount) {
        return getBehaviorImagePath(url, getBehaviorImageViewSize(imgCount));
    }

    private static int getBehaviorImageViewSize(int imgCount) {
        return (int) ((SystemUtil.getWinWidth() - (SystemUtil.dp2pxInt(2) * imgCount - 1)) * 1.0f / imgCount);
    }


    public static boolean isGif(String path) {

        return !TextUtils.isEmpty(path) && path.endsWith(".gif");

    }

    /**

     */
    public static void clearImageMemoryCache(final Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Glide.get(context).clearMemory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
