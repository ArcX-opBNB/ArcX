package net.daylong.baselibrary;

import android.text.TextUtils;

import com.tencent.bugly.crashreport.CrashReport;

import net.daylong.baselibrary.app.BaseApplication;
import net.daylong.baselibrary.utils.sys.AppUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuglMrg {

    public static void init(BaseApplication context,String buglyId) {
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);


        if (!TextUtils.isEmpty(DeviceIdUtil.getDeviceId())) {
            strategy.setDeviceID(DeviceIdUtil.getDeviceId());
        }



        String packageName = context.getPackageName();

        String processName = getProcessName(android.os.Process.myPid());

        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(context, buglyId, false, strategy);
    }


    public static void setDeviceID() {
        if (!TextUtils.isEmpty(DeviceIdUtil.getDeviceId())) {
            CrashReport.setDeviceId(AppUtil.getContext(), DeviceIdUtil.getDeviceId());
        }

    }

    public static void test() {
        CrashReport.testJavaCrash();
    }

    /**

     *


     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
