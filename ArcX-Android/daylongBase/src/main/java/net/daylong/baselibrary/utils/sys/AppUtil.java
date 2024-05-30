package net.daylong.baselibrary.utils.sys;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.core.content.FileProvider;

import net.daylong.baselibrary.app.AppManager;
import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

public class AppUtil {

    /**

     *
     * @return
     */
    public static Handler getMainHandler() {
        return BaseApplication.getHandler();
    }

    /**

     *
     * @return
     */
    public static int getMainThreadId() {

        return BaseApplication.getMainThreadId();
    }


    public static BaseActivity getCurrentActivity() {
        return AppManager.getInstance().getCurrentActivity();

    }

    /**

     *
     * @return
     */
    public static boolean isRunOnUIThread() {
        int myTid = android.os.Process.myTid();
        if (myTid == getMainThreadId()) {
            return true;
        } else {
            return false;
        }
    }

    /**

     *
     * @param runnable
     */
    public static void runOnUIThread(Runnable runnable) {
        if (isRunOnUIThread()) {
            
            runnable.run();
        } else {
            
            getMainHandler().post(runnable);
        }
    }

    /**

     *
     * @return
     */
    public static Context getContext() {
        return BaseApplication.getAppContext();
    }

    /**

     *
     * @param context
     * @return
     */
    public static boolean isAppRunningForegroud(Context context) {
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context
                        .getSystemService(Context.ACTIVITY_SERVICE);
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager
                        .getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    return false;
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcess : runningAppProcesses) {
                    if (runningAppProcess.processName.equals(context.getPackageName()) &&
                            runningAppProcess.importance == ActivityManager
                                    .RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**

     *
     * @return
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager
                    .getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            MyLogUtil.d("Exception:---" + e);
        }
        return versionName;
    }  /**

     *
     * @return
     */
    public static String getAppVersionName() {

        return getAppVersionName(AppUtil.getContext());
    }

    /**

     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        int versionCode = -1;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager
                    .getPackageInfo(context.getPackageName(), 0);
            versionCode = packageInfo.versionCode;
        } catch (Exception e) {
            MyLogUtil.d("Exception:---" + e);
        }
        return versionCode;
    }


    /**

     *
     * @return
     */
    public static boolean isHasSDCard() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**

     *
     * @return
     */
    public static String getSDCardPath() {
        File sdDir = null;
        if (isHasSDCard()) {
            sdDir = Environment.getExternalStorageDirectory().getAbsoluteFile();
        }
        if (sdDir != null) {
            return sdDir.getPath();
        }
        return "";
    }

    /**

     *
     * @param editText
     */
    public static void showSoftInput(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) AppManager.getInstance().getCurrentActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(editText, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**

     *
     * @param editText
     */
    public static void hideSoftInput(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);


        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken()
                , InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * @param context
     * @param phone

     */
    public static void callPhone(Context context, String phone, boolean immediate) {
        Intent intent;
        if (immediate) {
            intent = new Intent(Intent.ACTION_CALL);
        } else {
            intent = new Intent(Intent.ACTION_DIAL);
        }
        Uri data = Uri.parse("tel:" + phone);
        intent.setData(data);
        context.startActivity(intent);
    }


    public static boolean isServiceRunning(Context mContext, String className) {

        long l = System.currentTimeMillis();

        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager
                .getRunningServices(30);

        if (!(serviceList.size() > 0)) {
            return false;
        }

        for (int i = 0; i < serviceList.size(); i++) {
            String className1 = serviceList.get(i).service.getClassName();

            if (className1.equals(className)) {
                isRunning = true;
                break;
            }
        }

        long l2 = System.currentTimeMillis();
        return isRunning;
    }


    /**


     *

     */
    private static String getDeviceUUID() {
        try {
            String dev = "3883756" +
                    Build.BOARD.length() % 10 +
                    Build.BRAND.length() % 10 +
                    Build.DEVICE.length() % 10 +
                    Build.HARDWARE.length() % 10 +
                    Build.ID.length() % 10 +
                    Build.MODEL.length() % 10 +
                    Build.PRODUCT.length() % 10 +
                    Build.SERIAL.length() % 10;
            return new UUID(dev.hashCode(),
                    Build.SERIAL.hashCode()).toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }


    /**

     *
     * @param size
     * @return
     */
    public static int getSize(float size) {
        return SystemUtil.getViewHeight(size);
    }

    /**

     *
     * @param activity

     */
    public static int getScreenOrient(Activity activity) {
        int orient = activity.getRequestedOrientation();
        if (orient != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE && orient != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            WindowManager windowManager = activity.getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            int screenWidth = display.getWidth();
            int screenHeight = display.getHeight();
            orient = screenWidth < screenHeight ? ActivityInfo.SCREEN_ORIENTATION_PORTRAIT : ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        }
        return orient;
    }


    /**

     *
     * @return
     */
    public static boolean isHorizontal() {
        return getScreenOrient(AppUtil.getCurrentActivity()) == 0;
    }


    /**

     */
    public static void hintInput(Activity activity) {
        try {

            InputMethodManager mInputMethodManager = (InputMethodManager) activity.getSystemService
                    (Context.INPUT_METHOD_SERVICE);
            mInputMethodManager.hideSoftInputFromWindow(activity
                    .getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void installApk( String newApkPath) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        File apkFile = new File(newApkPath);

        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION);

        Uri uri = FileProvider.getUriForFile(getContext(), getContext().getPackageName() + ".fileprovider", apkFile);

        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        BaseApplication.getInstance().startActivity(intent);
        //android.os.Process.killProcess(android.os.Process.myPid());

    }

    public static String getSignatureMD5(Context context) {
        try {
            
            PackageManager packageManager = context.getPackageManager();

            
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);

            
            Signature[] signatures = packageInfo.signatures;

            
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(signatures[0].toByteArray());
            byte[] md5Bytes = md.digest();

            
            StringBuilder sb = new StringBuilder();
            for (byte md5Byte : md5Bytes) {
                sb.append(Integer.toString((md5Byte & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

}
