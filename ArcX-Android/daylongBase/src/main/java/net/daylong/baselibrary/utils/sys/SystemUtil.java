package net.daylong.baselibrary.utils.sys;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import net.daylong.baselibrary.app.AppManager;
import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;

/**
 * @Name:
 * @Description:
 * @Author:
 * @Date: 2016/3/5
 */
public class SystemUtil {

    /**

     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    /**

     *

     */
    public static int getWinWidth() {
        return BaseApplication.getInstance().getContext().getResources().getDisplayMetrics().widthPixels;
    }

    /**

     *

     */
    public static float getWinWidth1PX() {
        return (getWinWidth() * 1.0f) / 188;
    }

    /**

     *

     */
    public static int getWinWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**

     *

     */
    public static int getWinHeight() {
        return BaseApplication.getInstance().getContext().getResources().getDisplayMetrics().heightPixels;
    }


    /**

     *
     * @return
     */
    public static boolean isSdCardUsable() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }


    public static int getViewHeight(float x, float y) {


        int winWidth = getWinWidth();

        float v = winWidth * 1.0f / x;

        return (int) (v * y);


    }

    public static Bitmap decodeBmp(String imgPath, BitmapFactory.Options opts) {
        Bitmap dstBmp = null;
        FileInputStream fis;
        try {
            fis = new FileInputStream(imgPath);
            dstBmp = BitmapFactory.decodeStream(fis, null, opts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
//            ImageLoaderUtil.clearMemCache();
            opts.inSampleSize += 1;
            opts.inPreferredConfig = Bitmap.Config.RGB_565;
            opts.inPurgeable = true;
            opts.inInputShareable = true;
            opts.inJustDecodeBounds = false;
            dstBmp = decodeBmp(imgPath, opts);
        }
        return dstBmp;
    }

    /**

     *

     */
    public static long getTimeLong() {
        return System.currentTimeMillis();
    }

    public static float dp2pxFloat(float value) {
        final float scale = BaseApplication.getInstance().getContext().getResources().getDisplayMetrics().density;
        return (value * scale + 0.5f);
    }

    public static int dp2pxInt(float value) {
        return (int) dp2pxFloat(value);
    }


    /**

     *
     * @return
     */
    public static String getVersionName() {

        Context context = BaseApplication.getInstance().getContext();
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (versionName == null || versionName.length() <= 0) {
            versionName = "";
        }

        return versionName;


    }

    /**

     *
     * @return
     */
    public static int getVersionCode() {

        Context context = BaseApplication.getInstance().getContext();
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            return pi.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;


    }


    /**

     *
     * @return
     */
    public static int getSystemBrightness() {
        int systemBrightness = 0;
        try {
            systemBrightness = Settings.System.getInt(BaseApplication.getAppContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return systemBrightness;
    }

    public static void changeAppBrightness(int brightness, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        if (brightness == -1) {
            lp.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
        } else {
            lp.screenBrightness = (brightness <= 0 ? 1 : brightness) / 255f;
        }
        window.setAttributes(lp);
    }


    /**

     *
     * @param context
     * @return
     */
    public static boolean checkDeviceHasNavigationBar(Context context) {
        boolean hasNavigationBar = false;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;
    }

    /**

     *
     * @return
     */
    public static boolean hasNotchInScreen(Activity activity) {

        
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//            DisplayCutout displayCutout = activity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
//            if (displayCutout != null) {

//                return true;
//            }
//        } else {
        
        String manufacturer = Build.MANUFACTURER;

        if (TextUtils.isEmpty(manufacturer)) {
            return false;
        } else if (manufacturer.equalsIgnoreCase("HUAWEI")) {
            return hasNotchHw(activity);
        } else if (manufacturer.equalsIgnoreCase("xiaomi")) {
            return hasNotchXiaoMi(activity);
        } else if (manufacturer.equalsIgnoreCase("oppo")) {
            return hasNotchOPPO(activity);
        } else if (manufacturer.equalsIgnoreCase("vivo")) {
            return hasNotchVIVO(activity);
        } else {
            return false;
        }
//        }
//        return false;
    }

    /**

     * https://swsdl.vivo.com.cn/appstore/developer/uploadfile/20180328/20180328152252602.pdf
     *
     * @param activity
     * @return
     */
    private static boolean hasNotchVIVO(Activity activity) {
        try {
            Class<?> c = Class.forName("android.util.FtFeature");
            Method get = c.getMethod("isFeatureSupport", int.class);
            return (boolean) (get.invoke(c, 0x20));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**

     * https://open.oppomobile.com/wiki/doc#id=10159
     *
     * @param activity
     * @return
     */
    private static boolean hasNotchOPPO(Activity activity) {
        return activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    /**

     * https://dev.mi.com/console/doc/detail?pId=1293
     *
     * @param activity
     * @return
     */
    private static boolean hasNotchXiaoMi(Activity activity) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("getInt", String.class, int.class);
            return (int) (get.invoke(c, "ro.miui.notch", 0)) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**

     * https://devcenter-test.huawei.com/consumer/cn/devservice/doc/50114
     *
     * @param activity
     * @return
     */
    private static boolean hasNotchHw(Activity activity) {

        try {
            ClassLoader cl = activity.getClassLoader();
            Class HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Method get = HwNotchSizeUtil.getMethod("hasNotchInScreen");
            return (boolean) get.invoke(HwNotchSizeUtil);
        } catch (Exception e) {
            return false;
        }

    }

    public static String getString(int strId, Object... str) {
        try {
            if (AppManager.getInstance().getCurrentActivity() != null) {
                String string = AppManager.getInstance().getCurrentActivity().getResources().getString(strId);
                return String.format(string, str);
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getString(Context context, int strId, Object... str) {
        return String.format(getString(strId), str);
    }

    public static String getString(int strId) {
        String string = "";

        try {
            BaseActivity currentActivity = AppManager.getInstance().getCurrentActivity();
            if (currentActivity != null) {
                string = currentActivity.getResources().getString(strId);
            }
        } catch (Exception e) {
        }
        return string;
    }

    public static String getString(Context context, int strId) {
        return getString(strId);
    }

    public static void vibrator(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        long[] patter = {0, 500,};
        vibrator.vibrate(patter, -1);
    }

    /**

     */
    public static void fullScreen(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        activity.getWindow().
                addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    /**

     *
     * @return
     */
    public static boolean isHorizontal() {

        int winWidth = SystemUtil.getWinWidth();
        int winHeight = SystemUtil.getWinHeight();
        return winHeight - winWidth < 0;


    }


    /**

     *
     * @return
     */
    public static float getWidthProportion() {


        return isHorizontal() ? getWinHeight() * 1.0f / 188 : getWinWidth() * 1.0f / 188;
    }

    /**

     *
     * @return
     */
    public static float getHeightProportion() {
        return getWidthProportion();
    }

    public static int getViewWidth(float width) {
        return (int) (getWidthProportion() * width);
    }

    public static int getViewHeight(float width) {
        return (int) (getHeightProportion() * width);
    }

}


