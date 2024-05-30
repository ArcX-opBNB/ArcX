package net.daylong.baselibrary.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import net.daylong.baselibrary.utils.MyLogUtil;
import net.daylong.baselibrary.utils.ui.act.BaseActivity;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

public class AppManager {

    private static Stack<Activity> sActivityStack;
    private static AppManager sAppManager;

    /**

     */
    private AppManager() {
    }

    /**

     *
     * @return
     */
    public static AppManager getInstance() {
        if (sAppManager == null) {
            synchronized (AppManager.class) {
                if (sAppManager == null) {
                    sAppManager = new AppManager();
                }
            }
        }
        return sAppManager;
    }

    /**

     */
    public void addActivity(Activity activity) {
        if (sActivityStack == null) {
            sActivityStack = new Stack<>();
        }
        sActivityStack.add(activity);
    }

    /**

     */
    public BaseActivity getCurrentActivity() {
        try {
            if (sActivityStack != null) {
                return (BaseActivity) sActivityStack.lastElement();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**

     */
    public Activity getLastActivity() {
        if (sActivityStack != null) {
            return sActivityStack.get(sActivityStack.size() - 2);
        }
        return null;
    }


    public Activity getFirstActivity() {

        if (sActivityStack != null) {

            return sActivityStack.firstElement();
        }

        return null;

    }

    /**

     *

     */
    public boolean isActivityTop(Class cls, Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        String name = null;
        if (manager != null) {
            name = manager
                    .getRunningTasks(1).get(0).topActivity.getClassName();

            return name.equals(cls.getName());
        } else {
            return false;
        }
    }

    /**

     */
    public void finishActivity(Activity activity) {
        if (activity != null && sActivityStack != null) {
            sActivityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**

     */
    public void finishActivity() {
        finishActivity(sActivityStack.lastElement());
    }

    /**

     */
    public void finishActivity(Class<?> cls) {
        for (int i = 0; i < sActivityStack.size(); i++) {
            if (sActivityStack.get(i).getClass().equals(cls)) {
                finishActivity(sActivityStack.get(i));
            }
        }
    }

    /**

     */
    public void finishAllActivityExcept(Class<?> cls) {
        for (int i = 0; i < sActivityStack.size(); i++) {
            if (null != sActivityStack.get(i)) {
                if (!sActivityStack.get(i).getClass().equals(cls)) {
                    sActivityStack.get(i).finish();
                }
            }
        }
    }

    /**

     */
    public void finishAllActivityExcept(List<Class<?>> clsList) {
        for (int i = 0; i < sActivityStack.size(); i++) {
            if (null != sActivityStack.get(i)) {
                boolean isFinish = true;
                for (int j = 0; j < clsList.size(); j++) {
                    if (sActivityStack.get(i).getClass().equals(clsList.get(j))) {
                        isFinish = false;
                        break;
                    }
                }
                if (isFinish) {
                    sActivityStack.get(i).finish();
                }
            }
        }
    }

    /**

     */
    public void finishAllActivity() {
        for (int i = 0; i < sActivityStack.size(); i++) {
            if (null != sActivityStack.get(i)) {
                sActivityStack.get(i).finish();
            }
        }
        sActivityStack.clear();
    }

    /**

     *
     * @param cls
     */
    public void returnToActivity(Class<?> cls) {
        while (sActivityStack.size() != 0)
            if (sActivityStack.peek().getClass() == cls) {
                break;
            } else {
                finishActivity(sActivityStack.peek());
            }
    }

    /**

     */
    public void returnToHome() {

        try {
            Class<?> aClass = Class.forName("com.daylong.arcx.user.EmailActivity");

            Intent intent = new Intent(BaseApplication.getAppContext(), aClass);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            BaseApplication.getAppContext().startActivity(intent);

            finishAllActivityExcept(aClass);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    /**

     *
     * @param cls
     * @return
     */
    public boolean isOpenActivity(Class<?> cls) {
        if (sActivityStack != null) {
            for (int i = 0, size = sActivityStack.size(); i < size; i++) {
                if (cls == sActivityStack.get(i).getClass()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**

     *


     */
    public void exitApp(Context context, boolean isBackground) {
        finishAllActivity();
        
        if (!isBackground) {
            try {
                ActivityManager activityManager = (ActivityManager) context
                        .getSystemService(Context.ACTIVITY_SERVICE);

                activityManager.killBackgroundProcesses(context.getPackageName());
                System.exit(0);
            } catch (Exception e) {
                MyLogUtil.e(e);
            } finally {

            }
        }
    }

    /**

     */
    public void exitApp() {


    }


    /*

     * */
    private boolean isWifiProxy() {

        String proxyAddress = System.getProperty("http.proxyHost");
        String portStr = System.getProperty("http.proxyPort");
        int proxyPort = Integer.parseInt((portStr != null ? portStr : "-1"));

        return (!TextUtils.isEmpty(proxyAddress)) && (proxyPort != -1);
    }


    private static boolean isVpnUsed() {
        try {
            Enumeration<NetworkInterface> niList = NetworkInterface.getNetworkInterfaces();
            if (niList != null) {
                for (NetworkInterface intf : Collections.list(niList)) {
                    if (!intf.isUp() || intf.getInterfaceAddresses().size() == 0) {
                        continue;
                    }
                    MyLogUtil.e("ceat-->visVpnUsed() NetworkInterface Name: " + intf.getName());
                    if ("tun0".equals(intf.getName()) || "ppp0".equals(intf.getName())) {
                        return true; // The VPN is up
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return false;
    }

}
