package net.daylong.baselibrary.view.img;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.utils.SVGARange;

import net.daylong.baselibrary.utils.img.ImageLoading;
import net.daylong.baselibrary.utils.ui.layout.ConstraintBuilder;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseSvgaImageView extends SVGAImageView implements SVGACallback {

    public static BaseSvgaImageView create(ViewGroup viewGroup, ConstraintBuilder builder, Integer position, int loops) {
        BaseSvgaImageView myImageView = new BaseSvgaImageView(viewGroup.getContext());
        myImageView.setLayoutParams(builder.buildPayoutParams());
        myImageView.setLoops(loops);
        if (position != null) {
            viewGroup.addView(myImageView, position);
        } else {
            viewGroup.addView(myImageView);
        }
        return myImageView;

    }

    /**

     *
     * @param viewGroup
     * @param builder
     * @return
     */
    public static BaseSvgaImageView create(ViewGroup viewGroup, ConstraintBuilder builder) {

        return create(viewGroup, builder, null, -1);

    }

    public static BaseSvgaImageView create(ViewGroup viewGroup, ConstraintBuilder builder, int loops) {

        return create(viewGroup, builder, null, loops);

    }


    protected SVGAParser svgaParser;


    /**

     *
     * @return
     */
    protected int loopsCount() {
        return -1;
    }

    public BaseSvgaImageView(@NonNull Context context) {
        super(context);
        svgaParser = SVGAParser.Companion.shareParser();
        
        setLoops(loopsCount());
        setCallback(this);
        setClearsAfterDetached(true);
    }


    public void start(String url) {
        boolean b = url.endsWith(".svga");
        if (b) {
            startSvga(url, this);

        } else {
            ImageLoading.displayNoCrop(url, this);
        }

    }


    public void startAssets(String url) {
        startAssetsSvga(url);
    }

    public void startAssets(String url, int start, int end) {
        startAssetsSvga(url, start, end);


    }


    public void close() {
        stopAnimation(true);
        clear();
        setVideoItem(null);
        setImageDrawable(null);
    }

    @Override
    protected void onDetachedFromWindow() {
        close();
        super.onDetachedFromWindow();
    }

    
    @Override
    public void onFinished() {
        if (onAnimListener != null) {
            onAnimListener.end();
        }

    }

    public void startAssetsSvga(String sv) {
        svgaParser.decodeFromAssets(sv, new SVGAParser.ParseCompletion() {
            @Override
            public void onError() {


            }

            @Override
            public void onComplete(SVGAVideoEntity videoItem) {


                setImageDrawable(new SVGADrawable(videoItem));
                startAnimation();

            }
        }, null);

    }

    
    @Override
    public void onPause() {

    }

    
    @Override
    public void onRepeat() {

    }

    /**

     *


     */
    @Override
    public void onStep(int i, double v) {

    }

    /**

     *
     * @param svgaUrl
     * @param svgaImageView
     */
    private void startSvga(String svgaUrl, final SVGAImageView svgaImageView) {
        try {
            svgaParser.decodeFromURL(new URL(svgaUrl), new SVGAParser.ParseCompletion() {
                @Override
                public void onError() {

                }

                @Override
                public void onComplete(SVGAVideoEntity videoItem) {


                    if (svgaImageView != null) {
                        svgaImageView.setImageDrawable(new SVGADrawable(videoItem));
                        svgaImageView.startAnimation();
                    }

                }
            }, null);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void startAssetsSvga(String sv, int start, int end) {
        svgaParser.decodeFromAssets(sv, new SVGAParser.ParseCompletion() {
            @Override
            public void onError() {


            }

            @Override
            public void onComplete(SVGAVideoEntity videoItem) {
                setImageDrawable(new SVGADrawable(videoItem));
                startAnimation();
                startAnimation(new SVGARange(start, end), false);

            }
        }, null);

    }


    private OnAnimListener onAnimListener;

    public void setOnAnimListener(OnAnimListener onAnimListener) {
        this.onAnimListener = onAnimListener;
    }

    public interface OnAnimListener {
        void end();
    }

}
