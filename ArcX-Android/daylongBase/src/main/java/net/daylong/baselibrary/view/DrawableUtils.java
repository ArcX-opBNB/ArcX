package net.daylong.baselibrary.view;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import net.daylong.baselibrary.utils.Utils;
import net.daylong.baselibrary.utils.sys.AppUtil;

public class DrawableUtils {
    public static int getDrawableByName(String drawableName) {
        return Utils.getDrawable(drawableName);
    }


    public static void seLeftDrawable(Button view, int leftCoinId) {
        Drawable drawable = ContextCompat.getDrawable(AppUtil.getContext(), leftCoinId);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            view.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public static void seLeftDrawable(TextView view, int leftCoinId) {
        if (leftCoinId == -1) {
            view.setCompoundDrawables(null, null, null, null);
        } else {
            Drawable drawable = ContextCompat.getDrawable(AppUtil.getContext(), leftCoinId);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                view.setCompoundDrawables(drawable, null, null, null);
            }
        }
    }

    public static void setTopDrawable(TextView view, int leftCoinId, int width, int height) {
        if (leftCoinId == -1) {
            view.setCompoundDrawables(null, null, null, null);
        } else {
            Drawable drawable = ContextCompat.getDrawable(AppUtil.getContext(), leftCoinId);
            if (drawable != null) {
                drawable.setBounds(0, 0, AppUtil.getSize(width), AppUtil.getSize(height));
                view.setCompoundDrawables(null, drawable, null, null);
            }
        }
    }

    public static void seLeftDrawable(TextView view, int leftCoinId, int width, int height) {
        if (leftCoinId == -1) {
            view.setCompoundDrawables(null, null, null, null);
        } else {
            Drawable drawable = ContextCompat.getDrawable(AppUtil.getContext(), leftCoinId);
            if (drawable != null) {
                drawable.setBounds(0, 0, width, height);
                view.setCompoundDrawables(drawable, null, null, null);
            }
        }
    }

    public static void seRightDrawable(TextView view, int rightCoinId) {
        if (rightCoinId == -1) {
            view.setCompoundDrawables(null, null, null, null);
        } else {
            Drawable drawable = ContextCompat.getDrawable(AppUtil.getContext(), rightCoinId);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                view.setCompoundDrawables(null, null, drawable, null);
            }
        }
    }

    public static void setLeftDrawable(TextView view, int size, int rightCoinId) {
        if (rightCoinId == -1) {
            view.setCompoundDrawables(null, null, null, null);
        } else {
            Drawable drawable = ContextCompat.getDrawable(AppUtil.getContext(), rightCoinId);
            if (drawable != null) {
                drawable.setBounds(0, 0, AppUtil.getSize(size), AppUtil.getSize(size));
                view.setCompoundDrawables(drawable, null, null, null);
            }
        }
    }
    public static void setLeftDrawable(TextView view, int w,int h, int rightCoinId) {
        if (rightCoinId == -1) {
            view.setCompoundDrawables(null, null, null, null);
        } else {
            Drawable drawable = ContextCompat.getDrawable(AppUtil.getContext(), rightCoinId);
            if (drawable != null) {
                drawable.setBounds(0, 0, AppUtil.getSize(w), AppUtil.getSize(h));
                view.setCompoundDrawables(drawable, null, null, null);
            }
        }
    }
    public static void setRightDrawable(TextView view, int w,int h, int rightCoinId) {
        if (rightCoinId == -1) {
            view.setCompoundDrawables(null, null, null, null);
        } else {
            Drawable drawable = ContextCompat.getDrawable(AppUtil.getContext(), rightCoinId);
            if (drawable != null) {
                drawable.setBounds(0, 0, AppUtil.getSize(w), AppUtil.getSize(h));
                view.setCompoundDrawables(null, null, drawable,null );
            }
        }
    }


    public static void setBottomDrawable(Button view, int topResId) {
        Drawable drawable = getDrawable(topResId);
        if (drawable != null) {
            setViewDrawables(view, null, null, null, drawable);
        } else {

        }


    }

    public static void setBottomDrawable(TextView view, int topResId) {
        Drawable drawable = getDrawable(topResId);
        if (drawable != null) {
            setViewDrawables(view, null, null, null, drawable);

        } else {

        }

    }


    private static void setViewDrawables(Button button, Drawable left, Drawable top,
                                         Drawable right, Drawable bottom) {
        button.setCompoundDrawables(left, top, right, bottom);
    }

    private static void setViewDrawables(TextView button, Drawable left, Drawable top,
                                         Drawable right, Drawable bottom) {


        button.setCompoundDrawables(left, top, right, bottom);
    }


    private static Drawable getDrawable(int regID) {
        Drawable drawable = ContextCompat.getDrawable(AppUtil.getContext(), regID);
        if (drawable != null) {
            int minimumWidth = drawable.getMinimumWidth();
            int minimumHeight = drawable.getMinimumHeight();

            drawable.setBounds(0, 0, minimumWidth, minimumHeight);

        }
        return drawable;
    }


    public static void closDrawables(TextView textView) {
        textView.setCompoundDrawables(null, null, null, null);

    }

}
